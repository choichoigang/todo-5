//
//  TasksTableViewCell.swift
//  TodoApp
//
//  Created by delma on 2020/04/06.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class TasksTableViewCell: UITableViewCell {
    
    var taskId: Int?
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: .default, reuseIdentifier: "TasksTableViewCell")
        addSubViews()
        setConstraints()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        addSubViews()
        setConstraints()
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
    }
    
    private var dragButton: UIButton = {
        let button = UIButton()
        button.setImage(UIImage(systemName: "text.justify"), for: .normal)
        button.tintColor = .gray
        return button
    }()
    
    private var taskTitle: UILabel = {
        let label = UILabel()
        label.textColor = .black
        label.font = UIFont.boldSystemFont(ofSize: 16)
        label.textAlignment = .left
        return label
    }()
    
    private var taskContents: UILabel = {
        let label = UILabel()
        label.textColor = .black
        label.font = UIFont.systemFont(ofSize: 14)
        label.textAlignment = .left
        label.numberOfLines = 3
        label.lineBreakMode = .byWordWrapping
        label.sizeToFit()
        return label
    }()
    
    private var authorLabel: UILabel = {
        let label = UILabel()
        label.textColor = #colorLiteral(red: 0.3450980392, green: 0.5137254902, blue: 0.4274509804, alpha: 1)
        label.font = UIFont.systemFont(ofSize: 12)
        label.textAlignment = .left
        return label
    }()
    
    func addSubViews() {
        self.contentView.addSubview(dragButton)
        self.contentView.addSubview(taskTitle)
        self.contentView.addSubview(taskContents)
        self.contentView.addSubview(authorLabel)
    }
    
    func setConstraints() {
        dragButton.translatesAutoresizingMaskIntoConstraints = false
        dragButton.centerYAnchor.constraint(equalTo: self.contentView.centerYAnchor, constant: 0).isActive = true
        dragButton.leadingAnchor.constraint(equalTo: self.contentView.leadingAnchor, constant: 8).isActive = true
        dragButton.widthAnchor.constraint(equalToConstant: 40).isActive = true
        
        taskTitle.translatesAutoresizingMaskIntoConstraints = false
        taskTitle.topAnchor.constraint(equalTo: self.contentView.topAnchor, constant: 8).isActive = true
        taskTitle.leadingAnchor.constraint(equalTo: dragButton.trailingAnchor, constant: 8).isActive = true
        taskTitle.trailingAnchor.constraint(equalTo: self.contentView.trailingAnchor, constant: -8).isActive = true
        
        taskContents.translatesAutoresizingMaskIntoConstraints = false
        taskContents.topAnchor.constraint(equalTo: taskTitle.bottomAnchor, constant: 1).isActive = true
        taskContents.leadingAnchor.constraint(equalTo: taskTitle.leadingAnchor, constant: 0).isActive = true
        taskContents.trailingAnchor.constraint(equalTo: self.contentView.trailingAnchor, constant: -8).isActive = true
        
        authorLabel.translatesAutoresizingMaskIntoConstraints = false
        authorLabel.topAnchor.constraint(equalTo: taskContents.bottomAnchor, constant: 1).isActive = true
        authorLabel.leadingAnchor.constraint(equalTo: taskContents.leadingAnchor, constant: 0).isActive = true
        authorLabel.trailingAnchor.constraint(equalTo: self.contentView.trailingAnchor, constant: -8).isActive = true
        authorLabel.bottomAnchor.constraint(equalTo: self.contentView.bottomAnchor, constant: -8).isActive = true
        
    }
    
    func configure(title: String, contents: String, author: String, taskId: Int) {
        taskTitle.text = title
        taskContents.text = contents
        authorLabel.text = author
        self.taskId = taskId
    }
   
}
