//
//  ViewController.swift
//  mdn
//
//  Created by admin on 2020/1/19.
//  Copyright © 2020 org. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var labelCountdown: UILabel!
    @IBOutlet weak var imageCountdown: UIImageView!

    var timer:Timer?;
    var timeLeft = 119;

    override func viewDidLoad() {
        super.viewDidLoad()
        labelCountdown.isHidden = true;
        imageCountdown.isHidden = true;
    }

    @IBAction func beginCountdown(_ sender: UIButton) {
        imageCountdown.isHidden = false;
        labelCountdown.isHidden = false;
        timer = Timer.scheduledTimer(timeInterval: 1.0, target: self, selector: #selector(onTimerFires), userInfo: nil, repeats: true)
    }
    
    @objc func onTimerFires()
    {
        timeLeft -= 1;
        
        let minutes = timeLeft / 60 % 60;
        let seconds = timeLeft % 60;
        let countdown =  String(format:"%01i:%02i", minutes, seconds);
        labelCountdown.text = "\(countdown)"

        if timeLeft <= 0 {
            timer?.invalidate()
            timer = nil
        }
    }
    
    
    
}

