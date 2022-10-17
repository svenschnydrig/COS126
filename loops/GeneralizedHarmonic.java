/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class GeneralizedHarmonic {
    public static void main(String[] args) {

        double n = Double.parseDouble(args[0]);
        double r = Double.parseDouble(args[1]);

        double H = 0;
        for (double i = 1; i <= n; i++) {
            H += 1 / Math.pow(i, r);
        }
        System.out.println(H);
    }
}
