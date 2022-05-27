import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RedRightDuckMover extends RightDuckMover{
    RedRightDuckMover(RunGame currGame){
        super(currGame);
        ImageIcon icon = new ImageIcon("rduck.png");
        duck.setIcon(icon);
        hp = 16*currGame.duckHpMultilplyer;
    }
}
