/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int count = 0;
        int index = 0;
        int maxCAG = 0;

        while (index <= dna.length() - 3) {
            if (!(dna.substring(index, index + 3).equals("CAG"))) {
                index++;
            }
            if (index <= dna.length() - 3) {
                while (dna.substring(index, index + 3).equals("CAG")) {
                    count++;
                    index = index + 3;
                    if (index > dna.length() - 3) break;
                }
            }
            if (count > maxCAG) {
                maxCAG = count;
            }
            count = 0;

        }

        return maxCAG;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        return s.replace(" ", "").replace("\n", "").replace("\t", "");
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats < 10) {
            return "not human";
        }
        else if (maxRepeats < 36) {
            return "normal";
        }
        else if (maxRepeats < 40) {
            return "high risk";
        }
        else if (maxRepeats < 181) {
            return "Huntington's";
        }
        else {
            return "not human";
        }
    }

    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        String seq = in.readAll();

        seq = removeWhitespace(seq);
        int count = maxRepeats(seq);
        String diagnose = diagnose(count);

        System.out.println(diagnose);
    }
}
