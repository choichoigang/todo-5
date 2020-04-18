//
//  NewCardView.swift
//  TodoApp
//
//  Created by delma on 2020/04/08.
//  Copyright © 2020 delma. All rights reserved.
//

import UIKit

class NewCardView: UIView, UITextViewDelegate {
    
    var delegate: NewCardViewDelegate?
    var categoryNum: Int?
    
    let titlePlaceholder = "제목을 입력해주세요"
    let contentsPlaceholder = "내용을 입력해주세요"
    private var titleFlag = false
    private var contentsFlag = false
    var newTask: Contents?
    var isEdit = false
    var taskID: Int?
    
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
        button.imageEdgeInsets = UIEdgeInsets(top: 30, left: 30, bottom: 30, right: 30)
        button.tintColor = #colorLiteral(red: 0.8472001904, green: 0.6247957149, blue: 0.4608203123, alpha: 1)
        button.addTarget(self, action: #selector(dismissNewCardView), for: .touchUpInside)
        return button
    }()
    
    private var sendButton: UIButton = {
        let button = UIButton()
        button.setImage(UIImage(systemName: "arrow.up.circle.fill"), for: .normal)
        button.imageView?.contentMode = .scaleAspectFit
        button.imageEdgeInsets = UIEdgeInsets(top: 30, left: 30, bottom: 30, right: 30)
        button.tintColor = .lightGray
        button.isEnabled = false
        button.addTarget(self, action: #selector(addNewCard), for: .touchUpInside)
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
    
    private lazy var contentsView: UITextView = {
        let textView = UITextView()
        textView.text = contentsPlaceholder
        textView.font = UIFont.systemFont(ofSize: 18)
        textView.textColor = .lightGray
        textView.flashScrollIndicators()
        return textView
    }()
    
    private var authorView: UILabel = {
        let label = UILabel()
        label.textColor = .lightGray
        label.text = "Author by App"
        return label
    }()
    
    private func addSubViews() {
        self.addSubview(cancelButton)
        self.addSubview(sendButton)
        self.addSubview(titleView)
        self.addSubview(contentsView)
        self.addSubview(authorView)
    }
    
    private func configure() {
        self.backgroundColor = .white
    }
    
    private func configureConstraints() {
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
        contentsView.topAnchor.constraint(equalTo: titleView.bottomAnchor, constant: 20).isActive = true
        contentsView.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 8).isActive = true
        contentsView.trailingAnchor.constraint(equalTo: self.trailingAnchor, constant: -8).isActive = true
        contentsView.heightAnchor.constraint(equalToConstant: 400).isActive = true
        
        authorView.translatesAutoresizingMaskIntoConstraints = false
        authorView.topAnchor.constraint(equalTo: contentsView.bottomAnchor, constant: 8).isActive = true
        authorView.leadingAnchor.constraint(equalTo: self.leadingAnchor, constant: 8).isActive = true
        authorView.widthAnchor.constraint(equalToConstant: 200).isActive = true
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
    
    private func contentsViewConfigure() {
        if contentsView.text == contentsPlaceholder {
            contentsView.text = ""
            contentsView.textColor = .black
        }else if contentsView.text == "" {
            contentsView.text = contentsPlaceholder
            contentsView.textColor = .lightGray
        }
    }
    
    private func judgeValuesConfigured() {
        if titleFlag, contentsFlag {
            sendButton.tintColor = #colorLiteral(red: 0.5487859114, green: 0.817265746, blue: 0.6769449538, alpha: 1)
            sendButton.isEnabled = true
        }else {
            sendButton.tintColor = .lightGray
            sendButton.isEnabled = false
        }
    }
    
    func textViewDidBeginEditing(_ textView: UITextView) {
        if textView == titleView, titleView.text != "" {
            titleFlag = true
            titleViewConfigure()
        } else if textView == contentsView, contentsView.text != "" {
            contentsFlag = true
            contentsViewConfigure()
        }
    }
    
    func textViewDidEndEditing(_ textView: UITextView) {
        if textView == titleView, titleView.text == "" {
            titleFlag = false
            titleViewConfigure()
        }else if textView == contentsView, contentsView.text == "" {
            contentsFlag = false
            contentsViewConfigure()
        }
    }
    
    func textView(_ textView: UITextView, shouldChangeTextIn range: NSRange, replacementText text: String) -> Bool {
        if textView == titleView, text == "\n" {
            titleView.resignFirstResponder()
            return true
        }
        
        if textView == contentsView, let str = textView.text {
            judgeValuesConfigured()
            let newLength = str.count + text.count - range.length
            return newLength <= 500
        }
        judgeValuesConfigured()
        
        return true
    }
    
    @objc func dismissNewCardView() {
        delegate?.dismissNewCardView()
    }
    
    @objc func addNewCard() {
        newTask = Contents(id: taskID, title: titleView.text, content: contentsView.text, priority: nil, author: "jypthemiracle", categoryTo: nil, categoryNum: categoryNum!, deleted: nil)
        guard let newTask = newTask else { return }
        delegate?.addNewCard(content: newTask, isEdit: isEdit)
    }
    
    func configureEditData() {
        guard let newTask = newTask else { return }
        titleView.text = newTask.title
        titleView.textColor = .black
        contentsView.text = newTask.content
        contentsView.textColor = .black
    }
    
}
