//
//  Tasks.swift
//  TodoApp
//
//  Created by delma on 2020/04/08.
//  Copyright © 2020 delma. All rights reserved.
//

import Foundation

struct Tasks: Codable {
    var categoryName: String
    var categoryId: Int
    var content: [Contents]
    
    struct Contents: Codable {
        var taskId: Int
        var title: String
        var content: String
        var username: String
        var priority: Int
    }
}
