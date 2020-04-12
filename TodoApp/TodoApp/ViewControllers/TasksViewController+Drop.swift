//
//  TasksViewController+Drop.swift
//  TodoApp
//
//  Created by delma on 2020/04/12.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

extension TasksViewController: UITableViewDropDelegate {
    
    func tableView(_ tableView: UITableView, canHandle session: UIDropSession) -> Bool {
        return category!.canHandle(session)
    }
    
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
               
               coordinator.session.loadObjects(ofClass: NSString.self) { items in
                   let stringItems = items as! [Contents]
                   
                   var indexPaths = [IndexPath]()
                   for (index, item) in stringItems.enumerated() {
                       let indexPath = IndexPath(row: destinationIndexPath.row + index, section: destinationIndexPath.section)
                       self.category?.addItem(item, at: indexPath.row)
                       indexPaths.append(indexPath)
                   }

                   tableView.insertRows(at: indexPaths, with: .automatic)
               }
    }
    
    
}
