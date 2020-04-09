//
//  NetworkManager.swift
//  TodoApp
//
//  Created by delma on 2020/04/09.
//  Copyright © 2020 delma. All rights reserved.
//

import Foundation

enum NetworkErrorCase: Error {
    case InvalidURL
    case DecodeError
}

enum HTTPMethod: String {
    case get = "GET"
    case post = "POST"
    case put = "PUT"
    case delete = "DELETE"
}

struct NetworkManager {
    enum EndPoints {
        static let AllData = NSURL(string: "")
    }
    
    func getResource(url: URL, methodType: HTTPMethod, body: Data? = nil, completion: @escaping(Result<Any, NetworkErrorCase>) -> Void) {
        
        var request = URLRequest(url: url)
        request.httpMethod = methodType.rawValue
        request.setValue("application/json", forHTTPHeaderField: "Content-Type")
        request.httpBody = body
        
        URLSession.shared.dataTask(with: request) { (data, response, error) in
            guard let data = data, error == nil else {
                if let error = error as NSError?, error.domain == NSURLErrorDomain { completion(.failure(.InvalidURL)) }
                return
            }
            completion(.success(data))
        }.resume()
    }
}
