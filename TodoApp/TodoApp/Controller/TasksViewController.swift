//
//  TasksViewController.swift
//  TodoApp
//
//  Created by delma on 2020/04/06.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class TasksViewController: UIViewController {

    let titleView = TitleView()
    let tableView = TasksTableView()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.view.addSubview(titleView)
        self.view.addSubview(tableView)
        self.tableView.register(TasksTableViewCell.self, forCellReuseIdentifier: "tasksCell")
        setConstraints()
    }
    
    func setConstraints() {
        titleView.translatesAutoresizingMaskIntoConstraints = false
        titleView.topAnchor.constraint(equalTo: self.view.topAnchor, constant: 0).isActive = true
        titleView.leadingAnchor.constraint(equalTo: self.view.leadingAnchor, constant: 0).isActive = true
        titleView.widthAnchor.constraint(equalTo: self.view.widthAnchor, constant: 0).isActive = true
        titleView.heightAnchor.constraint(equalToConstant: 50).isActive = true
        
        tableView.translatesAutoresizingMaskIntoConstraints = false
        tableView.topAnchor.constraint(equalTo: titleView.bottomAnchor, constant: 0).isActive = true
        tableView.leadingAnchor.constraint(equalTo: self.view.leadingAnchor, constant: 0).isActive = true
        tableView.trailingAnchor.constraint(equalTo: self.view.trailingAnchor, constant: 0).isActive = true
        tableView.bottomAnchor.constraint(equalTo: self.view.bottomAnchor, constant: 0).isActive = true
    }

    func configureTasksCount(count: Int) {
        titleView.setTasksCount(count: count)
    }
    
    func configureTitle(title: String) {
        titleView.setTitle(title: title)
    }
    
}
