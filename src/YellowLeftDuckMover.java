import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YellowLeftDuckMover extends LeftDuckMover{

    YellowLeftDuckMover(RunGame currGame) {
        super(currGame);
        ImageIcon icon = new ImageIcon("yduck-l.png");
        duck.setIcon(icon);
        hp = 2*currGame.duckHpMultilplyer;
    }

}
