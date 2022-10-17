/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int d = 0;
        int x = 0;
        int y = 0;
        int steps = 0;

        System.out.println("(" + x + ", " + y + ")");

        while (d != r) {
            float step = (float) Math.random();
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
            steps += 1;
            d = java.lang.Math.abs(x - 0) + java.lang.Math.abs(y - 0);
            System.out.println("(" + x + ", " + y + ")");
        }
        System.out.println("Steps = " + steps);

    }
}
