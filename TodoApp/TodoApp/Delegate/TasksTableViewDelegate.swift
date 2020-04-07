//
//  TasksTableViewDelegate.swift
//  TodoApp
//
//  Created by delma on 2020/04/06.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class TasksTableViewDelegate: NSObject, UITableViewDelegate {

    func tableView(_ tableView: UITableView, estimatedHeightForRowAt indexPath: IndexPath) -> CGFloat {
        return 45.0
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return UITableView.automaticDimension
    }
    
}
