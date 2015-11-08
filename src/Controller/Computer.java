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
public class Computer {
    private NIMGame game;
    
    public Computer(NIMGame g) {
        game = g;
    }
    
    public void process() {
        game.pick();
    }
    
    public String say() {
        return game.getMessage();
    }
}
