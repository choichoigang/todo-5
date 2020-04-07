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
        self.addSubview(labelsStack)
        setConstraints()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.addSubview(labelsStack)
        setConstraints()
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
    }
    
    private var taskTitle: UILabel = {
        let label = UILabel()
        label.textColor = .black
        label.font = UIFont.systemFont(ofSize: 18)
        label.text = "UI 만들기"
        return label
    }()
    
    private var taskContents: UILabel = {
        let label = UILabel()
        label.textColor = .black
        label.font = UIFont.systemFont(ofSize: 16)
        label.text = "1. 컨스트레인트 설정"
        return label
    }()
    
    private var author: UILabel = {
        let label = UILabel()
        label.textColor = .gray
        label.font = UIFont.systemFont(ofSize: 12)
        label.text = "author from iOS"
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
        stackView.addArrangedSubview(author)
        return stackView
    }()
    
    func setConstraints() {
        labelsStack.translatesAutoresizingMaskIntoConstraints = false
        labelsStack.topAnchor.constraint(equalTo: self.topAnchor, constant: 0).isActive = true
        labelsStack.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 0).isActive = true
        labelsStack.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: 0).isActive = true
        labelsStack.heightAnchor.constraint(equalTo: self.heightAnchor, constant: -10).isActive = true
    }
    
}
