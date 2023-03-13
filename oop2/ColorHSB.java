/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class ColorHSB {

    private int h;
    private int s;
    private int b;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h0, int s0, int b0) {
        if (h0 > 359 || h0 < 0 || s0 > 100 || s0 < 0 || b0 > 100 || b0 < 0) {
            throw new IllegalArgumentException("Arguments are out of range");
        }

        h = h0;
        s = s0;
        b = b0;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + h + ", " + s + ", " + b + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return (s == 0 || b == 0);
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException("Argument value is null");
        }
        return (int) (Math.min(Math.pow((h - that.h), 2),
                               Math.pow(360 - Math.abs((h - that.h)), 2)) +
                Math.pow((s - that.s), 2) +
                Math.pow((b - that.b), 2));
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        ColorHSB inputColor = new ColorHSB(h, s, b);

        String colorName;
        String minColorName = "";
        ColorHSB minColor = new ColorHSB(0, 0, 0);
        int hFile;
        int sFile;
        int bFile;

        int minDistance = 360 * 360;

        while (!StdIn.isEmpty()) {
            colorName = StdIn.readString();
            hFile = StdIn.readInt();
            sFile = StdIn.readInt();
            bFile = StdIn.readInt();

            ColorHSB secondColor = new ColorHSB(hFile, sFile, bFile);
            if (inputColor.distanceSquaredTo(secondColor) < minDistance) {
                minDistance = inputColor.distanceSquaredTo(secondColor);
                minColor = new ColorHSB(hFile, sFile, bFile);
                minColorName = colorName;
            }
        }
        System.out.println(minColorName + " " + minColor.toString());
    }
}
