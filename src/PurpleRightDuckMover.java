import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PurpleRightDuckMover extends RightDuckMover{
    PurpleRightDuckMover(RunGame currGame){
        super(currGame);
        ImageIcon icon = new ImageIcon("pduck.png");
        duck.setIcon(icon);
        hp = 15*currGame.duckHpMultilplyer;
    }
}