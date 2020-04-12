//
//  TasksViewController.swift
//  TodoApp
//
//  Created by delma on 2020/04/06.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class TasksViewController: UIViewController, TitleViewDelegate {
    let titleView = TitleView()
    let tableView = TasksTableView()
    
    var tasksDataSource: TasksTableViewDataSource!
    var tasksDelegate = TasksTableViewDelegate()
    
    let childID: Int
    
    var category: Category? {
        didSet {
            configureData()
            configureDataSource()
        }
    }
    
    init(childID: Int, nibName nibNameOrNil: String?, bundle nibBundleOrNil: Bundle?) {
        self.childID = childID
        super.init(nibName: nibNameOrNil, bundle: nibBundleOrNil)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        titleView.delegate = self
        tableView.delegate = tasksDelegate
        tableView.dragInteractionEnabled = true
        tableView.dragDelegate = self as? UITableViewDragDelegate
        tableView.dropDelegate = self as? UITableViewDropDelegate
        
        self.view.addSubview(titleView)
        self.view.addSubview(tableView)
        self.tableView.register(TasksTableViewCell.self, forCellReuseIdentifier: "tasksCell")
        setConstraints()
    }
    
    func setConstraints() {
        titleView.translatesAutoresizingMaskIntoConstraints = false
        titleView.topAnchor.constraint(equalTo: self.view.topAnchor, constant: 0).isActive = true
        titleView.leadingAnchor.constraint(equalTo: self.view.leadingAnchor, constant: 0).isActive = true
        titleView.widthAnchor.constraint(equalTo: self.view.widthAnchor, constant: 0).isActive = true
        titleView.heightAnchor.constraint(equalToConstant: 50).isActive = true
        
        tableView.translatesAutoresizingMaskIntoConstraints = false
        tableView.topAnchor.constraint(equalTo: titleView.bottomAnchor, constant: 0).isActive = true
        tableView.leadingAnchor.constraint(equalTo: self.view.leadingAnchor, constant: 0).isActive = true
        tableView.trailingAnchor.constraint(equalTo: self.view.trailingAnchor, constant: 0).isActive = true
        tableView.bottomAnchor.constraint(equalTo: self.view.bottomAnchor, constant: 0).isActive = true
    }
    
    func configureData() {
        guard let category = category else { return }
        titleView.setTasksCount(count: category.tasks.count)
        titleView.setTitle(title: category.name)
    }
    
    func configureDataSource() {
        guard let category = category else { return }

            tasksDataSource = TasksTableViewDataSource(tasksID: childID, tasks: category.tasks)
                       tableView.dataSource = tasksDataSource
                       tableView.reloadData()
        
    }
    
    func popNewCardView() {
        let newCardViewController = NewCardViewController()
        self.present(newCardViewController, animated: true, completion: nil)
    }
}

