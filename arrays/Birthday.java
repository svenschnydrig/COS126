/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Birthday {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);

        double[] counts = new double[n + 2];

        for (int i = 0; i < s; i++) {
            boolean[] check = new boolean[n];
            boolean found = false;
            int count = 0;
            while (!found) {
                int birthday = (int) (Math.random() * n);
                if (check[birthday]) {
                    found = true;
                    counts[count] += 1;
                }
                else {
                    check[birthday] = true;
                    count++;
                }
            }
        }

        double fraction = 0.0;
        int i = 0;
        while (fraction < 0.5) {
            fraction += counts[i] / s;
            System.out.print(i + 1 + "\t" + (int) counts[i] + "\t" + fraction);
            System.out.println();
            i++;
        }
    }
}