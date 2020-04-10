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
    
    private var firstView: UIView?
    private var secondView: UIView?
    private var thirdView: UIView?
    
    let networkManager = NetworkManager()
    private var tasks: Tasks?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        addChild()
        configureViews()
        addSubViews()
        setConstraints()
        
        requestAllData()
    }
    
    func addChild() {
        self.addChild(firstViewController)
        self.addChild(secondViewController)
        self.addChild(thirdViewController)
    }
    
    func configureViews() {
        firstView = firstViewController.view
        secondView = secondViewController.view
        thirdView = thirdViewController.view
    }
    
    func addSubViews() {
        self.view.addSubview(firstView!)
        self.view.addSubview(secondView!)
        self.view.addSubview(thirdView!)
        
    }
    
    func setConstraints() {
        firstView?.translatesAutoresizingMaskIntoConstraints = false
        firstView?.topAnchor.constraint(equalTo: navigationBar.bottomAnchor, constant: 0).isActive = true
        firstView?.leadingAnchor.constraint(equalTo: self.view.leadingAnchor, constant: 0).isActive = true
        firstView?.bottomAnchor.constraint(equalTo: self.view.bottomAnchor, constant: 0).isActive = true
        firstView?.widthAnchor.constraint(equalTo: self.view.widthAnchor, multiplier: 0.33, constant: 0).isActive = true
        
        secondView?.translatesAutoresizingMaskIntoConstraints = false
        secondView?.topAnchor.constraint(equalTo: navigationBar.bottomAnchor, constant: 0).isActive = true
        secondView?.centerXAnchor.constraint(equalTo: self.view.centerXAnchor, constant: 0).isActive = true
        secondView?.bottomAnchor.constraint(equalTo: self.view.bottomAnchor, constant: 0).isActive = true
        secondView?.widthAnchor.constraint(equalTo: self.view.widthAnchor, multiplier: 0.33, constant: 0).isActive = true
        
        thirdView?.translatesAutoresizingMaskIntoConstraints = false
        thirdView?.topAnchor.constraint(equalTo: navigationBar.bottomAnchor, constant: 0).isActive = true
        thirdView?.trailingAnchor.constraint(equalTo: self.view.trailingAnchor, constant: 0).isActive = true
        thirdView?.bottomAnchor.constraint(equalTo: self.view.bottomAnchor, constant: 0).isActive = true
        thirdView?.widthAnchor.constraint(equalTo: self.view.widthAnchor, multiplier: 0.33, constant: 0).isActive = true
    }
    
    func requestAllData() {
        networkManager.getResource(url: NetworkManager.EndPoints.AllData!, methodType: .get) { result in
            switch result {
            case .success(let anyData):
                self.tasks = anyData as? Tasks
                guard let allData = self.tasks else { return }
                DispatchQueue.main.async {
                    self.firstViewController.category = allData.data[0]
                    self.secondViewController.category = allData.data[1]
                    self.thirdViewController.category = allData.data[2]
                }
            case .failure(let error):
                //네트워크 오류 알림 알럿창 생성
                print(error.localizedDescription)
            }
        }
    }
    
    
}

