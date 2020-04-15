//
//  TasksTableViewDelegate.swift
//  TodoApp
//
//  Created by delma on 2020/04/06.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class TasksTableViewDelegate: NSObject, UITableViewDelegate {
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return UITableView.automaticDimension
    }
    
    func tableView(_ tableView: UITableView, contextMenuConfigurationForRowAt indexPath: IndexPath, point: CGPoint) -> UIContextMenuConfiguration? {
        let move = UIAction(title: "move to done") { _ in
            // done으로 이동
        }
        
        let edit = UIAction(title: "edit...") { action in
            // edit 카드 띄움
        }
        
        let delete = UIAction(title: "delete", attributes: [.destructive]) { action in
            let dataSource = tableView.dataSource as! TasksTableViewDataSource
            let delay = 0.4
            DispatchQueue.main.asyncAfter(deadline: .now() + delay) {
                dataSource.taskID = dataSource.tasks[indexPath.row].id
                dataSource.tasks.remove(at: indexPath.row)
                tableView.reloadData()
            }
        }
        
        return UIContextMenuConfiguration(identifier: indexPath as NSCopying,
                                          previewProvider: nil) { _ in
                                            UIMenu(title: "", children: [move, edit, delete])
        }
    }
    
}
