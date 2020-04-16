//
//  ActivityViewController.swift
//  TodoApp
//
//  Created by delma on 2020/04/16.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class ActivityViewController: UIViewController {

    let tableView = ActivityTableView()
    var activityDataSource = ActivityTableViewDataSource()
    var activityDelegate = ActivityTableViewDelegate()
    let networkManager = NetworkManager()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        configureDelegates()
        configureSubviews()
        configureConstraints()
        requestActivities()
    }
    
    private func configureDelegates() {
        tableView.delegate = activityDelegate
        tableView.dataSource = activityDataSource
    }
    
    private func configureSubviews() {
        self.view.addSubview(tableView)
        self.tableView.register(ActivityTableViewCell.self, forCellReuseIdentifier: "activityCell")
    }

    private func configureConstraints() {
        tableView.translatesAutoresizingMaskIntoConstraints = false
        tableView.topAnchor.constraint(equalTo: self.view.topAnchor, constant: 0).isActive = true
        tableView.leadingAnchor.constraint(equalTo: self.view.leadingAnchor, constant: 0).isActive = true
        tableView.trailingAnchor.constraint(equalTo: self.view.trailingAnchor, constant: 0).isActive = true
        tableView.bottomAnchor.constraint(equalTo: self.view.bottomAnchor, constant: 0).isActive = true
    }
    
    private func requestActivities() {
        networkManager.getResource(url: EndPoints.Activities!, methodType: .get, dataType: [Activity].self) { result in
        }
    }
}
