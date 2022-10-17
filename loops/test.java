/**
 * Write a program RandomWalkers.java that takes two integer command-line arguments r and trials.
 * In each of trials independent experiments, simulate a random walk until the random walker is at
 * Manhattan distance r from the starting point. Print the average number of steps.
 */

public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        double trials = Integer.parseInt(args[1]);
        double random;
        double sum = 0;
        for (int t = 0; t < trials; t++) {
            int x = 0;
            int y = 0;
            int steps = 0;
            int md = x + y;
            while (md != r) {
                random = Math.random();
                // right
                if (random < 0.25) x++;
                    // left
                else if (random < 0.5) x--;
                    // up
                else if (random < 0.75) y++;
                    // down
                else if (random < 1.00) y--;

                md = Math.abs(x) + Math.abs(y);
                steps++;
            }
            sum = sum + steps;
        }
        double average = (sum / trials);
        System.out.println("average number of steps = " + average);
    }
}