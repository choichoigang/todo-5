//
//  Tasks.swift
//  TodoApp
//
//  Created by delma on 2020/04/08.
//  Copyright © 2020 delma. All rights reserved.
//

import Foundation

struct Tasks: Codable {
    var status: Bool
    var data: [Contents]
    
    struct Contents: Codable {
        var title: String
        var content: String
        var userName: String
        var priority: String
    }
}
