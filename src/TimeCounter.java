import javax.swing.*;

public class TimeCounter extends Thread{
    int time = 0;
    JTextField timer;
    JFrame game;
    TimeCounter(JTextField Timer, JFrame main){
        game = main;
        timer = Timer;
        game.pack();
        start();
    }
    @Override
    public void run() {
        while(true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            time += 1;
            timer.setText(Integer.toString(time));
        }
    }

}
