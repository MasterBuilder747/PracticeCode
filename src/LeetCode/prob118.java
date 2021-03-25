package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class prob118 {
    public static List<List<Integer>> generate(int numRows) {
        //first line
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> line = new ArrayList<>();
        line.add(1);
        output.add(line);
        //second line
        if (numRows > 1) {
            line = new ArrayList<>();
            line.add(1);
            line.add(1);
            output.add(line);
        }
        //3+
        if (numRows > 2) {
            for (int i = 1; i < numRows-1; i++) {
                line = new ArrayList<>();
                line.add(1);
                //add the values in between
                for (int j = 0; j < i; j++) {
                    line.add(output.get(i).get(j) + output.get(i).get(j+1));
                }
                line.add(1);
                output.add(line);
            }
        }
        return output;
    }
    public static void main(String[] args) {
        System.out.println(generate(5).toString());
    }
}
