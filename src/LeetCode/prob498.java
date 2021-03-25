package LeetCode;

import java.util.Arrays;

public class prob498 {
    public static int[] findDiagonalOrder(int[][] matrix) {
        int[] output;
        if (matrix.length == 0) {
            return new int[0];
        } else {
            output = new int[matrix.length * matrix[0].length];
        }
        //output[0] = matrix[0][0];

        //if x == matrix[y].length-1 && y == matrix.length-1, stop
        //down then up
        int y = 0;
        int x = 0;
        data d = new data(output, matrix, x, y, 0);
        //move marker to:
        while (!(x == matrix[y].length-1 && y == matrix.length-1)) {
            d = diagUp(d);
            d = diagDown(d);
            x = d.x; y = d.y;
            output = d.o;
        }
        output[output.length-1] = matrix[matrix.length-1][matrix[0].length-1];
        return output;
    }
    //code:
    //true: move to the next
    public static data diagUp(data d) {
        int x = d.x;
        int y = d.y;
        int c = d.c;
        int[][] a = d.a;
        int[] o = d.o;
        //boolean code = d.code;
        //diagonal up: y--, x++ until:
        //if y = 0 and x != matrix[y].length-1, x++
        //if y !=0 and x == matrix[y].length-1, y++
        //if y = 0 and x == matrix[y].length-1, y++
        while(true) {
            o[c] = a[y][x];
            if (x == a[y].length-1 && y == a.length-1) {
                break;
            }
            if (y == 0 && x != a[y].length-1) {
                x++;
                c++;
                break;
            }
            if (y != 0 && x == a[y].length-1) {
                y++;
                c++;
                break;
            }
            if (y == 0 && x == a[y].length-1) {
                y++;
                c++;
                break;
            }
            y--; x++;
            c++;
        }
        return new data(o, a, x, y, c);
    }
    public static data diagDown(data d) {
        int x = d.x;
        int y = d.y;
        int c = d.c;
        int[][] a = d.a;
        int[] o = d.o;
        //diagonal down: y++, x-- until:
        //if x = 0 and y != matrix.length-1, y++
        //if x !=0 and y == matrix.length-1, x++
        //if x = 0 and y == matrix.length-1, x++
        while(true) {
            o[c] = a[y][x];
            if (x == a[y].length-1 && y == a.length-1) {
                break;
            }
            if (x == 0 && y != a.length-1) {
                y++;
                c++;
                break;
            }
            if (x != 0 && y == a.length-1) {
                x++;
                c++;
                break;
            }
            if (x == 0 && y == a.length-1) {
                x++;
                c++;
                break;
            }
            y++; x--;
            c++;
        }
        return new data(o, a, x, y, c);
    }
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        /*
        12345
        67890
        1col26col73col48col95row0
        2x5: 1 2 2 2 2 1

        123
        4 move marker to56
        789
        1col24row753row68col9
        3x3: 1 2 3 2 1

        12
        34
        56
        78
        90
        1col23row54row67row98row0
        5x2: 1 2 2 2 2 1

        1,2,3,4
        5,6,7,8
        9,10,11,12
        1col25row963col4,7,10col11,8row12
        3x4:
        */
        System.out.println(Arrays.toString(findDiagonalOrder(a)));
    }
}
