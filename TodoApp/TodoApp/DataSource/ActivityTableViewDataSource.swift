//
//  ActivityTableViewDataSource.swift
//  TodoApp
//
//  Created by delma on 2020/04/16.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class ActivityTableViewDataSource: NSObject, UITableViewDataSource {
    static let identifier = "activityCell"
    var activities: [Activity]
    
    init(activities: [Activity]) {
        self.activities = activities
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return activities.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: ActivityTableViewDataSource.identifier, for: indexPath) as! ActivityTableViewCell
        let activitySentence = makeActivitySentence(indexPath: indexPath)
        let timeSentence = makeActivityTimeSentence(timeString: activities[indexPath.row].createdTime)
        cell.configureData(activitySentence: activitySentence, time: timeSentence)
        return cell
    }
    
    func makeActivitySentence(indexPath: IndexPath) -> String {
        let activity = activities[indexPath.row]
        var activitySentence = "@\(activity.userName)이(가) \(activity.targetTitle)을(를)"
        if let categoryFrom = activity.categoryFrom, let categoryTo = activity.categoryTo {
            activitySentence += "\(categoryFrom)에서 \(categoryTo)로 이동하였습니다."
        }else {
            activitySentence += " \(activity.action) 하였습니다. "
        }
        return activitySentence
    }
    
    func makeActivityTimeSentence(timeString: String) -> String {
        let activityDate = stringToDate(timeString: timeString)
        let timeSentence = compare(activityDate: activityDate!)
        return timeSentence
    }
    
    func stringToDate(timeString: String) -> Date? {
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "yyyy-MM-dd HH:mm:ss"
        dateFormatter.locale = Locale(identifier: "ko_KR")
        guard let date: Date = dateFormatter.date(from: timeString) else { return nil }
        return date
    }
    
    func compare(activityDate: Date) -> String {
        var activitySentence = ""
        let calendar = NSCalendar.current
        let writtenDate = calendar.dateComponents([.year, .month, .day, .hour, .minute], from: activityDate)
        let now = Date()
        let nowDate = calendar.dateComponents([.year, .month, .day, .hour, .minute], from: now)
        
        let minuteCompare = (60 - writtenDate.minute! + nowDate.minute!).magnitude
        let hourCompare = (24 - writtenDate.hour! + nowDate.hour!).magnitude
        let dayCompare = (nowDate.day! - writtenDate.day!)
        
        if writtenDate.year! == nowDate.year!, writtenDate.month! == nowDate.month!, writtenDate.day! + 3 < nowDate.day! {
            activitySentence = "\(activityDate)"
        }else if writtenDate.year! == nowDate.year!, writtenDate.month! == nowDate.month!, dayCompare < 3, dayCompare > 0 {
            activitySentence = "\(dayCompare)일 전"
        }else if writtenDate.day! == nowDate.day!, writtenDate.hour! == nowDate.hour!, writtenDate.minute! == nowDate.minute! {
            activitySentence = "1분 미만 전"
        }else if writtenDate.day! == nowDate.day!, minuteCompare < 60 {
            activitySentence = "\(minuteCompare) 분 전"
        }else if writtenDate.day! == nowDate.day!, minuteCompare > 60 {
            activitySentence = "\(hourCompare) 시간 전"
        }
        
        return activitySentence
    }
    
}
