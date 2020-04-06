//
//  TitleView.swift
//  TodoApp
//
//  Created by delma on 2020/04/06.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class TitleView: UIView {

    override init(frame: CGRect) {
        super.init(frame: frame)
        self.addSubview(tasksCount)
        setConstraints()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        self.addSubview(tasksCount)
        setConstraints()
    }

    private var tasksCount: UILabel = {
       let label = UILabel()
        label.textColor = .black
        label.backgroundColor = .white
        label.clipsToBounds = true
        label.layer.cornerRadius = label.font.pointSize * 0.80
        label.textAlignment = .center
        label.text = "22"
        return label
    }()
    
    func setConstraints() {
        tasksCount.translatesAutoresizingMaskIntoConstraints = false
        tasksCount.topAnchor.constraint(equalTo: self.topAnchor, constant: 15).isActive = true
        tasksCount.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 15).isActive = true
        tasksCount.widthAnchor.constraint(equalToConstant: 28).isActive = true
        tasksCount.heightAnchor.constraint(equalToConstant: 28).isActive = true
    }
    
    func setTasksCount() {
        
    }
}
