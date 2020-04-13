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
        let tasks = tasksDataSource.tasks
  
//        dragItem.localObject = Contents(title: tasks[indexPath.row].title , content: tasks[indexPath.row].content, userName: tasks[indexPath.row].userName, priority: nil, id: tasks[indexPath.row].id)
        
        return [dragItem]
    }
}
