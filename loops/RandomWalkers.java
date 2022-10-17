/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        double trials = Integer.parseInt(args[1]);

        int d = 0;
        int x = 0;
        int y = 0;
        double steps = 0;

        for (int i = 0; i < trials; i++) {
            x = 0;
            y = 0;
            d = 0;
            while (d != r) {
                double step = (double) Math.random();
                if (step <= 0.25) {
                    x += 0;
                    y += 1;
                }
                else if (step <= 0.5) {
                    x += 0;
                    y += -1;
                }
                else if (step <= 0.75) {
                    x += 1;
                    y += 0;
                }
                else {
                    x += -1;
                    y += 0;
                }
                d = java.lang.Math.abs(x) + java.lang.Math.abs(y);
                steps++;
            }
        }

        double average = steps / trials;
        System.out.println("average number of steps = " + average);
    }
}
