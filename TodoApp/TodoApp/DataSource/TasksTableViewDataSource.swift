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
    private var category: Category
    let categoryID: Int
    var taskID: Int?
    var tasks: [Contents] {
        didSet {
            NotificationCenter.default.post(name: .updateCount , object: tasks, userInfo: ["updateInfo":(count: tasks.count, categoryID: categoryID, taskID: taskID)])
        }
    }
    
    init(categoryID: Int, category: Category) {
        self.categoryID = categoryID
        self.category = category
        self.tasks = category.task.filter { !$0.deleted! }
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return tasks.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: TasksTableViewDataSource.identifier, for: indexPath) as! TasksTableViewCell
        cell.configure(title: tasks[indexPath.row].title , contents: tasks[indexPath.row].content ,author: tasks[indexPath.row].author, taskId: tasks[indexPath.row].id!)
        return cell
    }
    
    func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        return true
    }
    
    func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            tableView.beginUpdates()
            taskID = tasks[indexPath.row].id
            tasks.remove(at: indexPath.row)
            tableView.deleteRows(at: [indexPath], with: .automatic)
            tableView.endUpdates()
        }
    }
   
}
