//
//  Activity.swift
//  TodoApp
//
//  Created by delma on 2020/04/16.
//  Copyright © 2020 delma. All rights reserved.
//

import Foundation

struct Activity: Codable {
    var userName: String
    var target: String
    var action: String
    var categoryFrom: String?
    var categoryTo: String?
    var createdTime: String
    var targetTitle: String
}
