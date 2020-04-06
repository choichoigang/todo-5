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
    }
    

    required convenience init?(coder: NSCoder) {
        self.init(coder: coder)
        self.addSubview(labelsStack)
    }
    
    override func awakeFromNib() {
        super.awakeFromNib()
        self.addSubview(labelsStack)
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
    }
    
    private var taskTitle: UILabel = {
        let label = UILabel()
        label.textColor = .black
        label.font = UIFont.systemFont(ofSize: 20)
        label.text = "UI 만들기"
        return label
    }()
    
    private var taskContents: UILabel = {
        let label = UILabel()
        label.textColor = .black
        label.font = UIFont.systemFont(ofSize: 18)
        return label
    }()
    
    private var author: UILabel = {
        let label = UILabel()
        label.textColor = .gray
        label.font = UIFont.systemFont(ofSize: 16)
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
        
    }
    
}
