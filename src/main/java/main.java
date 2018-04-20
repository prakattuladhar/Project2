
import java.io.IOException;

import threads.Clock;

public class main {
    public static void main(String[] args) throws IOException{
        GUI gui = new GUI();
        Clock.instance().run();


    }
}
