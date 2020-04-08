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

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 2
    }

    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: TasksTableViewDataSource.identifier, for: indexPath) as! TasksTableViewCell
        cell.configure(title: "입력 화면 만들기", contents: "할거 많음 짱 많음ㅋ", author: "아오스 델마")
        return cell
    }

    func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        return true
    }
    
    func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            //해당 셀 데이터 삭제 기능 들어갈곳
        }
    }

}
