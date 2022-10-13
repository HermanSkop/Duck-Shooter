import javax.swing.*;

public class CloudMover extends Thread{
    int x;
    int xStart;
    JPanel cloudPanel;
    JButton cloud;

    CloudMover(JFrame frame, JLayeredPane layer, JButton Cloud){
        x = frame.getWidth();
        xStart = x;
        System.out.println(x);
        cloud = Cloud;
        cloudPanel = new JPanel();
        cloudPanel.setBounds(x, -50, 280, 250);
        cloudPanel.setOpaque(false);
        cloudPanel.add(cloud);
        layer.add(cloudPanel, new Integer(1));
        start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                sleep(30);
                x -= 1;
                cloudPanel.setBounds(x, -50, 280, 250);
                if(x<=-280)x = xStart;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
