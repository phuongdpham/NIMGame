/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;

/**
 *
 * @author Ui
 */
public class NIMGame {
    private int [] coc;
    private boolean result;  // true: computer win
    private int status;  // tong nim
    public boolean turn; // true: computer's turn
    public boolean finished; // true: game is finished
    
    private int MAXN = 3;
    private int MAXR = 20;
    
    private String message = "";
    
    public boolean started = false;
    
    private Random rand = new Random();
    
    public NIMGame() {
        coc = new int[MAXN];
        for (int i = 0; i < MAXN; i++) {
            coc[i] = 0;
        }
        result = true;
        status = 0;
    }
    
    public void initGame() {
        
        for (int i = 0; i < MAXN; i++) {
            while (true) {
                coc[i] = rand.nextInt(MAXR);
                if (coc[i] > 0) break;
            }
        }
        turn = false;
        finished = false;
        updateStatus();
    }
    
    private void updateStatus() {
        status = 0;
        for (int i = 0; i < MAXN; i++) {
            status ^= coc[i];
        }
    }
    
    private int getNIM() {
        updateStatus();
        
        return status;
    }
    
    private int getCoc() {
        updateStatus();
        
        for (int i = 0; i < coc.length; i++) {
            if ((status ^ coc[i]) < coc[i]) {
                return i;
            }
        }
        
        int res;
        while (true) {
            res = rand.nextInt(MAXN);
            if (coc[res] > 0) break;
        }
        return res;
    }
    
    public void pick() {
        int index = getCoc();
        StringBuffer sb = new StringBuffer();
        
        if (status == 0) {
            sb.append("Tôi lấy cọc ");
            sb.append(index + 1);
            sb.append(", ");
            sb.append(1);
            sb.append(" quân.\n");
            
            message = sb.toString();
            coc[index]--;
        } else {
            int x = coc[index] ^ status;
            int q = coc[index] - x;
            coc[index] = x;
            
            sb.append("Tôi lấy cọc ");
            sb.append(index + 1);
            sb.append(", ");
            sb.append(q);
            sb.append(" quân.\n");
            
            message = sb.toString();
        }
    }
    
    public String getMessage() {
        return message;
    }
        
    public Integer getData(int i) {
        return coc[i];
    }
    
    public void userEnter(int c, int number) {
        coc[c] -= number;
    }
    
    public boolean isFinished() {
        int res = 0;
        
        for (int i = 0; i < MAXN; i++) {
            res |= coc[i];
        }
        
        return res == 0;
    }
}
