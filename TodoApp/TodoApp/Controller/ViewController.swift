//
//  ViewController.swift
//  TodoApp
//
//  Created by delma on 2020/04/06.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet var navigationBar: UINavigationBar!
    let firstViewController = TasksViewController()
    let secondViewController = TasksViewController()
    let thirdViewController = TasksViewController()
    
    var firstView: UIView?
    var secondView: UIView?
    var thirdView: UIView?
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.addChild(firstViewController)
//        self.addChild(secondViewController)
//        self.addChild(thirdViewController)
//        thirdViewController.setTitle(title: "할 일")
        
        firstView = firstViewController.view
        self.view.addSubview(firstView!)
//        secondView = secondViewController.view
//        thirdView = thirdViewController.view
        
        setConstraints()
        firstViewController.setTitle(title: "할 일")
    }

    func setConstraints() {
        firstView?.translatesAutoresizingMaskIntoConstraints = false
        firstView?.topAnchor.constraint(equalTo: navigationBar.bottomAnchor, constant: 0).isActive = true
        firstView?.leadingAnchor.constraint(equalTo: self.view.leadingAnchor, constant: 0).isActive = true
        firstView?.bottomAnchor.constraint(equalTo: self.view.bottomAnchor, constant: 0).isActive = true
        firstView?.widthAnchor.constraint(equalTo: self.view.widthAnchor, multiplier: 0.3, constant: -30).isActive = true
    }
    

}

