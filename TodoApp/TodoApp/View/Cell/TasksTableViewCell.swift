//
//  TasksTableViewCell.swift
//  TodoApp
//
//  Created by delma on 2020/04/06.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class TasksTableViewCell: UITableViewCell {
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: .default, reuseIdentifier: "TasksTableViewCell")
        self.contentView.addSubview(stackWithButton)
        setConstraints()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.contentView.addSubview(stackWithButton)
        setConstraints()
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
    }
    
    private var taskTitle: UILabel = {
        let label = UILabel()
        label.textColor = .black
        label.font = UIFont.boldSystemFont(ofSize: 18)
        return label
    }()
    
    private var taskContents: UILabel = {
        let label = UILabel()
        label.textColor = .black
        label.font = UIFont.systemFont(ofSize: 16)
        return label
    }()
    
    private var authorLabel: UILabel = {
        let label = UILabel()
        label.textColor = .gray
        label.font = UIFont.systemFont(ofSize: 12)
        return label
    }()
    
    lazy var labelsStack: UIStackView = {
        let stackView = UIStackView()
        stackView.axis = .vertical
        stackView.alignment = .fill
        stackView.spacing = 3
        stackView.distribution = .fillProportionally
        
        stackView.addArrangedSubview(taskTitle)
        stackView.addArrangedSubview(taskContents)
        stackView.addArrangedSubview(authorLabel)
        return stackView
    }()
    
    private var dragButton: UIButton = {
        let button = UIButton()
        button.setImage(UIImage(systemName: "equal.square"), for: .normal)
        button.tintColor = .gray
        return button
    }()
    
    lazy var stackWithButton: UIStackView = {
       let stackView = UIStackView()
        stackView.axis = .horizontal
        stackView.alignment = .center
        stackView.spacing = 3
        stackView.distribution = .fillProportionally
        
        stackView.addArrangedSubview(dragButton)
        stackView.addArrangedSubview(labelsStack)
        return stackView
    }()
    
    func setConstraints() {
        stackWithButton.translatesAutoresizingMaskIntoConstraints = false
        stackWithButton.topAnchor.constraint(equalTo: self.contentView.topAnchor, constant: 15).isActive = true
        stackWithButton.leadingAnchor.constraint(equalTo: self.contentView.leadingAnchor, constant: 0).isActive = true
        stackWithButton.trailingAnchor.constraint(equalTo: self.contentView.trailingAnchor, constant: 0).isActive = true
        stackWithButton.heightAnchor.constraint(equalTo: self.contentView.heightAnchor, constant: -30).isActive = true
        stackWithButton.widthAnchor.constraint(equalTo: self.contentView.widthAnchor, constant: 0).isActive = true
    }
    
    func configure(title: String, contents: String, author: String) {
        taskTitle.text = title
        taskContents.text = contents
        authorLabel.text = author
    }
   
}
