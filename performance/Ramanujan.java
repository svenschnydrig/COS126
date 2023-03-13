/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        if (n < 1729) return false;

        int count = 0;
        long cubeRootOfN = (long) Math.cbrt(n);

        for (long a = 1; a <= cubeRootOfN; a++) {
            long a3 = a * a * a;
            double guessB = Math.cbrt(n - a3);

            if (count == 2) {
                break;
            }

            if ((guessB % 1 == 0.0) && (guessB > a)) {
                count++;
            }

        }
        return count == 2;

    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}
