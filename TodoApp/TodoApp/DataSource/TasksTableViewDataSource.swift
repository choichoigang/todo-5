//
//  TasksTableViewDataSource.swift
//  TodoApp
//
//  Created by delma on 2020/04/06.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class TasksTableViewDataSource: NSObject, UITableViewDataSource {

    static let identifier = "tasksCell"
    var mockData = [(title: "1", contents: "aaaaa", author: "nnn"),
    (title: "2", contents: "wwww", author: "nnn"),
    (title: "3", contents: "qqqq", author: "nnn"),
    (title: "4", contents: "ssss", author: "nnn"),
    (title: "5", contents: "dddd", author: "nnn"),
    (title: "6", contents: "ffff", author: "nnn"),
    (title: "7", contents: "ccccc", author: "nnn"),
    (title: "8", contents: "xxxx", author: "nnn"),
    (title: "9", contents: "zzzz", author: "nnn"),
    (title: "10", contents: "vvvvv", author: "nnn"),]

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return mockData.count
    }

    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: TasksTableViewDataSource.identifier, for: indexPath) as! TasksTableViewCell
        cell.configure(title: mockData[indexPath.row].title, contents: mockData[indexPath.row].contents ,author: mockData[indexPath.row].author)
        return cell
    }

    func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        return true
    }
    
    func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            //해당 셀 데이터 삭제 기능 들어갈곳
            mockData.remove(at: indexPath.row)
            tableView.deleteRows(at: [indexPath], with: .automatic)
            tableView.endUpdates()
        }
    }

}
