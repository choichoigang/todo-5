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
    var category: Category
    let tasksID: Int
    var tasks: [Contents] {
        didSet {
            NotificationCenter.default.post(name: .updateCount , object: tasks, userInfo: ["updateInfo":(count: tasks.count, tasksID: tasksID)])
        }
    }
    
    init(tasksID: Int, category: Category) {
        self.tasksID = tasksID
        self.category = category
        self.tasks = category.tasks
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return tasks.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: TasksTableViewDataSource.identifier, for: indexPath) as! TasksTableViewCell
        cell.configure(title: tasks[indexPath.row].title , contents: tasks[indexPath.row].content ,author: tasks[indexPath.row].userName)
        return cell
    }
    
    func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        return true
    }
    
    func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            tableView.beginUpdates()
            tasks.remove(at: indexPath.row)
            tableView.deleteRows(at: [indexPath], with: .automatic)
            tableView.endUpdates()
        }
    }
   
}
