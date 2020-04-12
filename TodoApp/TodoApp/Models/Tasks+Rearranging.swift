//
//  Tasks+Rearranging.swift
//  TodoApp
//
//  Created by delma on 2020/04/12.
//  Copyright © 2020 delma. All rights reserved.
//

import Foundation

extension Category {
    
     mutating func moveItem(at sourceIndex: Int, to destinationIndex: Int) {
           guard sourceIndex != destinationIndex else { return }
           
           let task = tasks[sourceIndex]
           tasks.remove(at: sourceIndex)
           tasks.insert(task, at: destinationIndex)
       }
    
    mutating func addItem(_ contents: Contents, at index: Int) {
           tasks.insert(contents, at: index)
       }
}
