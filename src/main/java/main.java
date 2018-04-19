
import java.io.IOException;

import Threads.Clock;

public class main {
    public static void main(String[] args) throws IOException{
        GUI gui = new GUI();
        Clock.getInstance().run();


    }
}
