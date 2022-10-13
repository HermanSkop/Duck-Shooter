import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ExitShortcut extends Thread implements KeyListener {
    boolean q = false;
    boolean shift = false;
    boolean ctrl = false;
    RunGame currGame;
    ExitShortcut(RunGame currGame){
        this.currGame = currGame;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==81)q=true;
        else if(e.getKeyCode()==16) shift=true;
        else if(e.getKeyCode()==17) ctrl=true;
        if(q&&shift&&ctrl){
            currGame.finishGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==81)q=false;
        else if(e.getKeyCode()==16) shift=false;
        else if(e.getKeyCode()==17) ctrl=false;
    }
}
