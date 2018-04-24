
import java.io.IOException;

import javax.swing.JFrame;

import threads.Clock;

public class main {
    public static void main(String[] args) throws IOException{
        GUI gui = new GUI();
        Clock.instance();
        gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
