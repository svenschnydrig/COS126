/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Minesweeper {
    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        double[][] grid = new double[m + 2][n + 2];
        boolean[][] check = new boolean[m + 2][n + 2];

        int mines = 0;
        while (mines < k) {
            int mr = (int) Math.round((Math.random() * (m - 1) + 1));
            int nr = (int) Math.round((Math.random() * (n - 1) + 1));
            if (check[mr][nr] == false) {
                check[mr][nr] = true;
                mines++;
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (check[i][j] == false) {
                    int sum = 0;
                    if (check[i - 1][j - 1] == true) {
                        sum++;
                    }
                    if (check[i + 1][j + 1] == true) {
                        sum++;
                    }
                    if (check[i - 1][j] == true) {
                        sum++;
                    }
                    if (check[i + 1][j] == true) {
                        sum++;
                    }
                    if (check[i][j - 1] == true) {
                        sum++;
                    }
                    if (check[i][j + 1] == true) {
                        sum++;
                    }
                    if (check[i + 1][j - 1] == true) {
                        sum++;
                    }
                    if (check[i - 1][j + 1] == true) {
                        sum++;
                    }
                    grid[i][j] = sum;
                }
                else {
                    grid[i][j] = 0.5;
                }
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (grid[i][j] != 0.5) {
                    System.out.print((int) grid[i][j] + "  ");
                }
                else {
                    System.out.print("*  ");
                }
            }
            System.out.println();
        }
    }
}
