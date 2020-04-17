//
//  ActivityTableViewCell.swift
//  TodoApp
//
//  Created by delma on 2020/04/16.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class ActivityTableViewCell: UITableViewCell {
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: .default, reuseIdentifier: "ActivityTableViewCell")
        addSubViews()
        configureConstraints()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        addSubViews()
        configureConstraints()
    }
    
    private var profileImage: UIImageView = {
        let imageView = UIImageView()
        imageView.image = #imageLiteral(resourceName: "profile")
        imageView.contentMode = .scaleToFill
        return imageView
    }()
    
    private var activityLabel: UILabel = {
        let label = UILabel()
        label.textColor = .black
        label.font = UIFont.boldSystemFont(ofSize: 16)
        label.textAlignment = .left
        label.numberOfLines = 3
        label.lineBreakMode = .byWordWrapping
        return label
    }()
    
    private var timeLabel: UILabel = {
        let label = UILabel()
        label.textColor = #colorLiteral(red: 0.7300325191, green: 0.5339502537, blue: 0.4001027512, alpha: 1)
        label.font = UIFont.boldSystemFont(ofSize: 14)
        label.textAlignment = .left
        return label
    }()
    
    private func addSubViews() {
        self.contentView.addSubview(profileImage)
        self.contentView.addSubview(activityLabel)
        self.contentView.addSubview(timeLabel)
    }
    
    private func configureConstraints() {
        profileImage.translatesAutoresizingMaskIntoConstraints = false
        profileImage.topAnchor.constraint(equalTo: self.contentView.topAnchor, constant: 8).isActive = true
        profileImage.leadingAnchor.constraint(equalTo: self.contentView.leadingAnchor, constant: 8).isActive = true
        profileImage.bottomAnchor.constraint(equalTo: self.contentView.bottomAnchor, constant: -8).isActive = true
        profileImage.widthAnchor.constraint(equalTo: self.contentView.widthAnchor, multiplier: 0.2).isActive = true
        profileImage.heightAnchor.constraint(equalTo: self.profileImage.widthAnchor, constant: 0).isActive = true
        
        activityLabel.translatesAutoresizingMaskIntoConstraints = false
        activityLabel.topAnchor.constraint(equalTo: profileImage.topAnchor, constant: 0).isActive = true
        activityLabel.leadingAnchor.constraint(equalTo: self.profileImage.trailingAnchor, constant: 8).isActive = true
        activityLabel.trailingAnchor.constraint(equalTo: self.contentView.trailingAnchor, constant: -8).isActive = true
        
        timeLabel.translatesAutoresizingMaskIntoConstraints = false
        timeLabel.topAnchor.constraint(equalTo: activityLabel.bottomAnchor, constant: 8).isActive = true
        timeLabel.leadingAnchor.constraint(equalTo: activityLabel.leadingAnchor, constant: 0).isActive = true
        timeLabel.trailingAnchor.constraint(equalTo: self.contentView.trailingAnchor, constant: -8).isActive = true
        timeLabel.bottomAnchor.constraint(equalTo: self.contentView.bottomAnchor, constant: -8).isActive = true
    }
    
    func configureData(activitySentence: String, time: String) {
        activityLabel.text = activitySentence
        timeLabel.text = time
    }
}
