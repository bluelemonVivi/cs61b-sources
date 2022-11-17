package gh2;

import java.util.Scanner;
import edu.princeton.cs.algs4.StdAudio;

public class GuitarHero {

    static final String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        GuitarString[] guitarStrings = new GuitarString[37];
        for (int i = 0; i< 37; i++) {
            double frequency = Math.pow(440*2,(i-24)/12.0);
            GuitarString String_i = new GuitarString(frequency);
            guitarStrings[i] = String_i;
        }

        while (true) {
            if (myScanner.hasNext()) {
                String next = myScanner.next();
                if (!KEYBOARD.contains(next)) {
                    continue;
                }
                int keyIndex = KEYBOARD.indexOf(next);
                if (keyIndex > 0) {
                    guitarStrings[keyIndex].pluck();
                }
            }
            double sample = 0.0;
            for (GuitarString s : guitarStrings) {
                sample += s.sample();
            }
            StdAudio.play(sample);
            for (GuitarString s : guitarStrings) {
                s.tic();
            }
        }
    }
}
