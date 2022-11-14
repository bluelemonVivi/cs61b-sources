package gh2;

import java.util.Scanner;

import deque.ArrayDeque;
import deque.Deque;

public class GuitarHero {

    static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    public static void main(String[] args) {
        GuitarString String = new GuitarString(100);
        Scanner myScanner = new Scanner(System.in);
        Deque<Double> keyboards = new ArrayDeque<>();
        for (int i = 0; i< 37; i++) {
            double frequency = Math.pow(440*2,(i-24)/12);
            keyboards.addFirst(frequency);
        }
        
        while (true) {
            String next = myScanner.next();
            if (!keyboard.contains(next)) {continue;}
            int i = keyboard.indexOf(next);
        }
    }
}
