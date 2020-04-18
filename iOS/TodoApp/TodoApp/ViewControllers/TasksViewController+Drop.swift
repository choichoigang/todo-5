//
//  TasksViewController+Drop.swift
//  TodoApp
//
//  Created by delma on 2020/04/12.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

extension TasksViewController: UITableViewDropDelegate {
    
    func tableView(_ tableView: UITableView, performDropWith coordinator: UITableViewDropCoordinator) {
        let destinationIndexPath: IndexPath
        
        if let indexPath = coordinator.destinationIndexPath {
            destinationIndexPath = indexPath
        } else {
            let section = tableView.numberOfSections - 1
            let row = tableView.numberOfRows(inSection: section)
            destinationIndexPath = IndexPath(row: row, section: section)
        }
        
        let item = coordinator.items.first!
        let dragItem = item.dragItem.localObject as! DragItem
        let data = dragItem.dataSource
        
        let index = dragItem.indexPath.row
        guard let taskDataSource = tableView.dataSource as? TasksTableViewDataSource else { return }
        taskDataSource.taskID = dragItem.taskId
        
        self.tasksDataSource.tasks.insert(data.tasks[index], at: destinationIndexPath.row)
        
        
        data.tasks.remove(at: index)
        dragItem.tableView.deleteRows(at: [dragItem.indexPath], with: .automatic)
        tableView.insertRows(at: [destinationIndexPath], with: .automatic)
        let moveItem = MoveItem(categoryFrom: data.categoryID, categoryTo: taskDataSource.categoryID, priority: destinationIndexPath.row + 1)
        NotificationCenter.default.post(name: .move, object: moveItem, userInfo: ["moveInfo": (moveItemId: dragItem.taskId, isMoveToDone: false)])
        
    }
    
    
}
