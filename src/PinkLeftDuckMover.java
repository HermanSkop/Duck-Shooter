import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinkLeftDuckMover extends LeftDuckMover{

    PinkLeftDuckMover(RunGame currGame) {
        super(currGame);
        ImageIcon icon = new ImageIcon("piduck-l.png");
        duck.setIcon(icon);
        hp = 10*currGame.duckHpMultilplyer;
    }
}
