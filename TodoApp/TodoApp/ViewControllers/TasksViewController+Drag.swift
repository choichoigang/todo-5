//
//  TasksTableViewController+Drag.swift
//  TodoApp
//
//  Created by delma on 2020/04/12.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

extension TasksViewController: UITableViewDragDelegate {
    func tableView(_ tableView: UITableView, itemsForBeginning session: UIDragSession, at indexPath: IndexPath) -> [UIDragItem] {
        let itemProvider = NSItemProvider()
        
        let dragItem = UIDragItem(itemProvider: itemProvider)
        dragItem.localObject = DragItem(dataSource: tasksDataSource, indexPath: indexPath, tableView: tableView as! TasksTableView)
        
        return [dragItem]
    }
}
