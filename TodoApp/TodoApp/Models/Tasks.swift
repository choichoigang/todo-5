//
//  Tasks.swift
//  TodoApp
//
//  Created by delma on 2020/04/10.
//  Copyright © 2020 delma. All rights reserved.
//

import Foundation

struct Tasks: Codable {
    var status: Bool
    var data: [Category]
}

struct Category: Codable {
       var id: Int
       var name: String
       var tasks: [Contents]
}

struct Contents: Codable {
    var title: String
    var content: String
    var userName: String
    var priority: Int
    var id: Int
}
