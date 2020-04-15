//
//  NewCardViewController.swift
//  TodoApp
//
//  Created by delma on 2020/04/08.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class NewCardViewController: UIViewController, NewCardViewDelegate {
 
    let newCardView = NewCardView()
    let networkManager = NetworkManager()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.view.addSubview(newCardView)
        configureConstraint()
        configure()
        newCardView.delegate = self
    }
    
    private func configure() {
        self.view.backgroundColor = .white
    }
    
    private func configureConstraint() {
        newCardView.translatesAutoresizingMaskIntoConstraints = false
        newCardView.topAnchor.constraint(equalTo: self.view.topAnchor, constant: 8).isActive = true
        newCardView.leadingAnchor.constraint(equalTo: self.view.leadingAnchor, constant: 8).isActive = true
        newCardView.trailingAnchor.constraint(equalTo: self.view.trailingAnchor, constant: -8).isActive = true
        newCardView.bottomAnchor.constraint(equalTo: self.view.bottomAnchor, constant: 8).isActive = true
    }

    func dismissNewCardView() {
        self.dismiss(animated: true)
     }
    
    func addNewCard(content: Contents){
        requestEncodedData(content: content)
        self.dismiss(animated: true)
    }
     
    func requestEncodedData(content: Contents) {
        let encoder = JSONEncoder()
        var data: Data?
        do {
            data = try encoder.encode(content)
            networkManager.getResource(url: EndPoints.AddOneTask!, methodType: .post, dataType: RequestBody.self, body: data) { _ in
                NotificationCenter.default.post(name: .addNewCard, object: nil, userInfo: ["categoryNumber":content.categoryNum])
            }
        } catch {
            print("failure encode")
        }
    }
    
   
    
}
