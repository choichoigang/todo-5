//
//  TasksTableView.swift
//  TodoApp
//
//  Created by delma on 2020/04/06.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class TasksTableView: UITableView {

    let tasksDataSource = TasksTableViewDataSource()
    let tasksDelegate = TasksTableViewDelegate()
    
    override init(frame: CGRect, style: UITableView.Style) {
        super.init(frame: frame, style: .plain)
        self.dataSource = tasksDataSource
        self.delegate = tasksDelegate
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.dataSource = tasksDataSource
        self.delegate = tasksDelegate
    }

}
