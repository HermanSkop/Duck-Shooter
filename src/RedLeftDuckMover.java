import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RedLeftDuckMover extends LeftDuckMover{

    RedLeftDuckMover(RunGame currGame) {
        super(currGame);
        ImageIcon icon = new ImageIcon("rduck-l.png");
        duck.setIcon(icon);
        hp = 16*currGame.duckHpMultilplyer;
    }
}
