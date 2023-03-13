/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Divisors {
    public static int gcd(int p, int q) {
        p = Math.abs(p);
        q = Math.abs(q);
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static int lcm(int p, int q) {
        return p * q / gcd(p, q);
    }

    public static boolean areRelativelyPrime(int p, int q) {
        return gcd(p, q) == 1;
    }

    public static int totient(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (areRelativelyPrime(i, n)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        System.out.println("gcd(" + p + ", " + q + ") = " + gcd(p, q));
        System.out.println("lcm(" + p + ", " + q + ") = " + lcm(p, q));
        System.out.println(
                "areRelativelyPrime(" + p + ", " + q + ") = " + areRelativelyPrime(p, q));
        System.out.println("totient(" + p + ") = " + totient(p));
        System.out.println("totient(" + q + ") = " + totient(q));
    }
}
