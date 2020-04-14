//
//  TasksManageable.swift
//  TodoApp
//
//  Created by delma on 2020/04/14.
//  Copyright © 2020 delma. All rights reserved.
//

import Foundation

protocol TasksManageable {
    func removeTask()
    func addTask()
    func editTask()
    func getTasksCount() -> Int
}
