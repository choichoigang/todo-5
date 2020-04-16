//
//  TitleView.swift
//  TodoApp
//
//  Created by delma on 2020/04/06.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class TitleView: UIView {
    
    var delegate: TitleViewDelegate?
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        addSubViews()
        setConstraints()
        configure()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        addSubViews()
        setConstraints()
        configure()
    }
    
    private var tasksCount: UILabel = {
        let label = UILabel()
        label.textColor = .black
        label.backgroundColor = .white
        label.clipsToBounds = true
        label.layer.cornerRadius = label.font.pointSize * 0.80
        label.textAlignment = .center
        label.text = "0"
        return label
    }()
    
    private var tasksTitle: UILabel = {
        let label = UILabel()
        label.textColor = .black
        label.font = UIFont.boldSystemFont(ofSize: 20)
        return label
    }()
    
    private lazy var addButton: UIButton = {
        let button = UIButton()
        button.setImage(UIImage(systemName: "plus"), for: .normal)
        button.tintColor = .black
        button.addTarget(self, action:  #selector(presentNewCardView), for: .touchUpInside)
        return button
    }()
    
    private func setConstraints() {
        tasksCount.translatesAutoresizingMaskIntoConstraints = false
        tasksCount.topAnchor.constraint(equalTo: self.topAnchor, constant: 15).isActive = true
        tasksCount.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 15).isActive = true
        tasksCount.widthAnchor.constraint(equalToConstant: 28).isActive = true
        tasksCount.heightAnchor.constraint(equalToConstant: 28).isActive = true
        
        tasksTitle.translatesAutoresizingMaskIntoConstraints = false
        tasksTitle.topAnchor.constraint(equalTo: self.topAnchor, constant: 15).isActive = true
        tasksTitle.leadingAnchor.constraint(equalTo: tasksCount.trailingAnchor, constant: 15).isActive = true
        
        addButton.translatesAutoresizingMaskIntoConstraints = false
        addButton.topAnchor.constraint(equalTo: self.topAnchor, constant: 15).isActive = true
        addButton.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -15).isActive = true
    }
    
    private func addSubViews() {
        self.addSubview(tasksCount)
        self.addSubview(tasksTitle)
        self.addSubview(addButton)
    }
    
    private func configure() {
        self.backgroundColor = #colorLiteral(red: 1, green: 0.6671907108, blue: 0.5906356103, alpha: 1)
    }
    
    func setTasksCount(count: Int) {
        DispatchQueue.main.async {
            self.tasksCount.text = "\(count)"
        }
    }
    
    func setTitle(title: String) {
        DispatchQueue.main.async {
            self.tasksTitle.text = title
        }
    }

    @objc private func presentNewCardView() {
        delegate?.presentNewCardView(contents: nil, isEdit: false, taskId: nil)
    }
}
