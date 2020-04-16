//
//  ActivityTableViewSource.swift
//  TodoApp
//
//  Created by delma on 2020/04/16.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class ActivityTableViewDataSource: NSObject, UITableViewDataSource {
    static let identifier = "activityCell"

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 0
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: ActivityTableViewDataSource.identifier, for: indexPath) as! ActivityTableViewCell
        
        return cell
    }
    

}
