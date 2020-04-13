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
                
        let item = coordinator.items.first!.dragItem.localObject as! DragItem
        let data = item.dataSource
        let index = item.indexPath.row
        self.tasksDataSource.tasks.insert(data.tasks[index], at: coordinator.destinationIndexPath!.row)
        
        data.tasks.remove(at: index)
        item.tableView.deleteRows(at: [item.indexPath], with: .automatic)
        
        tableView.insertRows(at: [coordinator.destinationIndexPath!], with: .automatic)
    }
    
    
}
