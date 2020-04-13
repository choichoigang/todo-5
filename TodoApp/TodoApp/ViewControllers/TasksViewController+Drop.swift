//
//  TasksViewController+Drop.swift
//  TodoApp
//
//  Created by delma on 2020/04/12.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

extension TasksViewController: UITableViewDropDelegate {
    
    func tableView(_ tableView: UITableView, dropSessionDidUpdate session: UIDropSession, withDestinationIndexPath destinationIndexPath: IndexPath?) -> UITableViewDropProposal {
        if tableView.hasActiveDrag {
            if session.items.count > 1 {
                return UITableViewDropProposal(operation: .cancel)
            } else {
                return UITableViewDropProposal(operation: .move, intent: .insertAtDestinationIndexPath)
            }
        } else {
            return UITableViewDropProposal(operation: .copy, intent: .insertAtDestinationIndexPath)
        }
    }
    
    func tableView(_ tableView: UITableView, performDropWith coordinator: UITableViewDropCoordinator) {
         let destinationIndexPath: IndexPath
               
               if let indexPath = coordinator.destinationIndexPath {
                   destinationIndexPath = indexPath
               } else {
                   let section = tableView.numberOfSections - 1
                   let row = tableView.numberOfRows(inSection: section)
                   destinationIndexPath = IndexPath(row: row, section: section)
               }
        
        
        let dragItem = coordinator.items.first!.dragItem
        let item = dragItem.localObject as! Contents
        self.tasksDataSource.tasks.insert(item, at: coordinator.destinationIndexPath!.row)
//        self.tasksDataSource.tasks.remove(at: item.priority!)
        tableView.insertRows(at: [coordinator.destinationIndexPath!], with: .automatic)
    }
    
    
}
