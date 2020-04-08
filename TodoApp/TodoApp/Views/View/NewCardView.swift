//
//  NewCardView.swift
//  TodoApp
//
//  Created by delma on 2020/04/08.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class NewCardView: UIView, UITextViewDelegate {
    
    let titlePlaceholder = "제목을 입력해주세요"
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        titleView.delegate = self
        contentsView.delegate = self
        addSubViews()
        configureConstraints()
        configure()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        titleView.delegate = self
        contentsView.delegate = self
        addSubViews()
        configureConstraints()
        configure()
    }
    
    private var cancelButton: UIButton = {
        let button = UIButton()
        button.setImage(UIImage(systemName: "x.circle.fill"), for: .normal)
        button.imageView?.contentMode = .scaleAspectFit
        button.tintColor = .red
        return button
    }()
    
    private var sendButton: UIButton = {
        let button = UIButton()
        button.setImage(UIImage(systemName: "arrow.up.circle.fill"), for: .normal)
        button.imageView?.contentMode = .scaleAspectFit
        button.tintColor = .blue
        button.isEnabled = false
        return button
    }()
    
    private lazy var titleView: UITextView = {
        let textView = UITextView()
        textView.text = titlePlaceholder
        textView.textContainer.maximumNumberOfLines = 1
        textView.textContainer.lineBreakMode = .byTruncatingTail
        textView.font = UIFont.boldSystemFont(ofSize: 30)
        textView.textColor = .lightGray
        textView.isScrollEnabled = false
        return textView
    }()
    
    private var contentsView: UITextView = {
        let textView = UITextView()
        textView.font = UIFont.systemFont(ofSize: 20)
        return textView
    }()
    
    private var authorView: UILabel = {
        let label = UILabel()
        label.textColor = .lightGray
        return label
    }()
    
    func addSubViews() {
        self.addSubview(cancelButton)
        self.addSubview(sendButton)
        self.addSubview(titleView)
        self.addSubview(contentsView)
        self.addSubview(authorView)
    }
    
    func configure() {
        self.backgroundColor = .white
    }
    
    func configureConstraints() {
        sendButton.translatesAutoresizingMaskIntoConstraints = false
        sendButton.topAnchor.constraint(equalTo: self.topAnchor, constant: 8).isActive = true
        sendButton.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -8).isActive = true
        sendButton.widthAnchor.constraint(equalToConstant: 30).isActive = true
        sendButton.heightAnchor.constraint(equalToConstant: 30).isActive = true
        
        cancelButton.translatesAutoresizingMaskIntoConstraints = false
        cancelButton.topAnchor.constraint(equalTo: self.topAnchor, constant: 8).isActive = true
        cancelButton.trailingAnchor.constraint(equalTo: sendButton.leadingAnchor, constant: -8).isActive = true
        cancelButton.widthAnchor.constraint(equalToConstant: 30).isActive = true
        cancelButton.heightAnchor.constraint(equalToConstant: 30).isActive = true
        
        titleView.translatesAutoresizingMaskIntoConstraints = false
        titleView.topAnchor.constraint(equalTo: self.topAnchor, constant: 40).isActive = true
        titleView.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 8).isActive = true
        titleView.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -8).isActive = true
        titleView.heightAnchor.constraint(equalToConstant: 40).isActive = true
        
        contentsView.translatesAutoresizingMaskIntoConstraints = false
        contentsView.topAnchor.constraint(equalTo: titleView.bottomAnchor, constant: 8).isActive = true
        contentsView.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 8).isActive = true
        contentsView.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -8).isActive = true
        contentsView.heightAnchor.constraint(equalToConstant: 200).isActive = true
        
        authorView.translatesAutoresizingMaskIntoConstraints = false
        authorView.topAnchor.constraint(equalTo: contentsView.bottomAnchor, constant: 8).isActive = true
        authorView.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 8).isActive = true
        authorView.widthAnchor.constraint(equalToConstant: 100).isActive = true
        authorView.heightAnchor.constraint(equalToConstant: 30).isActive = true
        
    }
    
    private func titleViewConfigure() {
        if titleView.text == titlePlaceholder {
            titleView.text = ""
            titleView.textColor = .black
        } else if titleView.text == "" {
            titleView.text = titlePlaceholder
            titleView.textColor = .lightGray
            
        }
    }
    
    func textViewDidBeginEditing(_ textView: UITextView) {
        if textView == titleView { titleViewConfigure() }
    }
    
    func textViewDidEndEditing(_ textView: UITextView) {
        if titleView.text == "" {
            titleViewConfigure()
        }
    }
    
    func textView(_ textView: UITextView, shouldChangeTextIn range: NSRange, replacementText text: String) -> Bool {
        //글자 입력시 완료버튼 활성화..
        if textView == titleView, text == "\n" {
            titleView.resignFirstResponder()
            return true
        }
        guard textView == contentsView, let str = textView.text else { return true }
        let newLength = str.count + text.count - range.length
        return newLength <= 500
    }
    
}
