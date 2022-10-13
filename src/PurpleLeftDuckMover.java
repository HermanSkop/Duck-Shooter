import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PurpleLeftDuckMover extends LeftDuckMover{

    PurpleLeftDuckMover(RunGame currGame) {
        super(currGame);
        ImageIcon icon = new ImageIcon("pduck-l.png");
        duck.setIcon(icon);
        hp = 15*currGame.duckHpMultilplyer;
    }
}
