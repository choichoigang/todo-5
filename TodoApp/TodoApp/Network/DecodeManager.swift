//
//  DecodeManager.swift
//  TodoApp
//
//  Created by delma on 2020/04/10.
//  Copyright © 2020 delma. All rights reserved.
//

import Foundation

class DecodeManager {
    func decode(data: Data, completion: @escaping (Result<Any, NetworkErrorCase>) -> Void) {
        let decoder = JSONDecoder()
        guard let anyData = try? decoder.decode(AllData.self, from: data) else { completion(.failure(.DecodeError)); return }
        completion(.success(anyData))
    }
}
