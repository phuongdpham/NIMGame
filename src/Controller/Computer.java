/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.NIMGame;

/**
 *
 * @author Ui
 */
public class Computer extends Thread {
    private NIMGame game;
    
    public Computer(NIMGame g) {
        game = g;
    }
    
    @Override
    public void run() {
        
    }
}
