//
//  Tasks+Dragging.swift
//  TodoApp
//
//  Created by delma on 2020/04/12.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit
import MobileCoreServices

extension Category {
    func canHandle(_ session: UIDropSession) -> Bool {
        return session.canLoadObjects(ofClass: NSString.self)
    }
    
    func dragItems(for indexPath: IndexPath) -> [UIDragItem] {
        let task = tasks[indexPath.row]
        let encoder = JSONEncoder()
        let data = try? encoder.encode(task)
        
        let itemProvider = NSItemProvider()
        
        itemProvider.registerDataRepresentation(forTypeIdentifier: kUTTypePlainText as String, visibility: .all) { completion in
            completion(data, nil)
            return nil
        }
        
        return [
            UIDragItem(itemProvider: itemProvider)
        ]
    }
}
