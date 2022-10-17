/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class ThreeSort {
    public static void main(String[] args) {

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        // compute stats
        double min = Math.min(a, Math.min(b, c));
        double max = Math.max(a, Math.max(b, c));
        double median = a + b + c - min - max;

        // print stats
        System.out.println("1: " + min);
        System.out.println("2: " + median);
        System.out.println("3: " + max);

    }
}
