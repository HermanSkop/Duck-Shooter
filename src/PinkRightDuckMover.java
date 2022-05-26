import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinkRightDuckMover extends RightDuckMover{
    PinkRightDuckMover(RunGame currGame){
        super(currGame);
        ImageIcon icon = new ImageIcon("piduck.png");
        duck.setIcon(icon);
        hp = 4;
    }
}