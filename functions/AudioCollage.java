/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class AudioCollage {
    public static double[] amplify(double[] a, double alpha) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i] * alpha;
        }
        return b;
    }

    public static double[] reverse(double[] a) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[a.length - 1 - i];
        }
        return b;
    }

    public static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            c[i + a.length] = b[i];
        }
        return c;
    }

    public static double[] mix(double[] a, double[] b) {
        double[] c = new double[Math.max(a.length, b.length)];
        for (int i = 0; i < Math.min(a.length, b.length); i++) {
            c[i] = a[i] + b[i];
        }
        if (a.length > b.length) {
            for (int i = b.length; i < a.length; i++) {
                c[i] = a[i];
            }
        }
        else if (b.length > a.length) {
            for (int i = a.length; i < b.length; i++) {
                c[i] = b[i];
            }
        }
        return c;
    }

    public static double[] changeSpeed(double[] a, double alpha) {
        double[] b = new double[(int) (a.length / alpha)];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[(int) (i * alpha)];
        }
        return b;
    }

    public static void main(String[] args) {
        double[] a = StdAudio.read(args[0]);
        double[] b = StdAudio.read(args[1]);

        double[] c = amplify(a, 0.5);
        double[] d = reverse(b);
        double[] e = merge(c, d);
        double[] f = mix(e, a);
        double[] g = changeSpeed(f, 1.5);
        
        StdAudio.play(g);
    }
}
