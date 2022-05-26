import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YellowRightDuckMover extends RightDuckMover{
    YellowRightDuckMover(RunGame currGame){
        super(currGame);
        ImageIcon icon = new ImageIcon("yduck.png");
        duck.setIcon(icon);
        hp = 2;
    }
}