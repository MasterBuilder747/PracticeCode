package LeetCode;

import java.util.Arrays;

public class prob1234 {
    public static int balancedString(String s) {
        // Q, W, E, R
//        for (int i = 1; i < (1 + (s.length() / 4)); i++) {
//            //iterate every sets of 4 characters
//            for (int j = 1; j < 4; j++) {
//                if (s.charAt((i * j) - 1) == s.charAt(i * j)) {
//                    output++;
//                }
//            }
//        }
        // 0=Q, 1=W, 2=E, 3=R
        // store the occurrences of each character
//        int[] data = new int[4];
//        boolean[] isWrong = new boolean[s.length()]; //initializes to false (0?)
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == 'Q') {
//                if (data[0] < ((s.length()/4))) {
//                    data[0]++;
//                } else {
//                    isWrong[i] = true;
//                }
//            }
//            if (s.charAt(i) == 'W') {
//                if (data[1] < ((s.length()/4))) {
//                    data[1]++;
//                } else {
//                    isWrong[i] = true;
//                }
//            }
//            if (s.charAt(i) == 'E') {
//                if (data[2] < ((s.length()/4))) {
//                    data[2]++;
//                } else {
//                    isWrong[i] = true;
//                }
//            }
//            if (s.charAt(i) == 'R') {
//                if (data[3] < ((s.length()/4))) {
//                    data[3]++;
//                } else {
//                    isWrong[i] = true;
//                }
//            }
//        }
//        int start = 0;
//        int end = 0;
//        for (int i = 0; i < isWrong.length; i++) {
//            if (isWrong[i]) {
//                start = i;
//                break;
//            }
//        }
//        for (int i = isWrong.length; i > 0; i--) {
//            if (isWrong[i-1]) {
//                end = i;
//                break;
//            }
//        }
//        System.out.println(Arrays.toString(isWrong));
//        System.out.println(Arrays.toString(data));
//        return (end - start);

        int output = 0;
        // 0=Q, 1=W, 2=E, 3=R
        int[] data = {-(s.length()/4), -(s.length()/4), -(s.length()/4), -(s.length()/4)};
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'Q') {
                data[0]++;
            } else if (s.charAt(i) == 'W') {
                data[1]++;
            } else if (s.charAt(i) == 'E') {
                data[2]++;
            } else {
                data[3]++;
            }
        }
        int chars = 0;
        //any value that does not need to be changed is 0
        //the minimum size of output is the total characters in data
        for (int a : data) {
            if (a > 0) {
                output += a;
                chars++;
            }
        }
        //at this point, we can return 0 if all character counts are correct
        if (chars == 0) {
            return 0;
        }

        //1st test case: if there is only one character, try itself,
        //then test when adding one of each of the other 3 characters
        //in all possible locations on the current string
//        if (chars == 1) {
//            //check for the characters only first
//            String a = buildString(data);
//            if (s.contains(a)) {
//                return output;
//            }
//            //check for some substring length output that contains that number of characters
//            output++;
//            char sub = a.toCharArray()[0]; //get the one character
//            while (true) {
//                for (int i = 0; i < 1+(s.length() - output); i++) {
//                    int check = chars;
//                    for (int j = 0; j < output; j++) {
//                        if (s.charAt(i + j) == sub) {
//                            check--;
//                        }
//                    }
//                    if (check == 0) {
//                        return output;
//                    }
//                }
//                output++;
//            }
//        }

        //System.out.println(Arrays.toString(data));

        //testing of more than one character in the substring of the string
        if (chars > 0) {
            //negative values are 0 to make comparisons work
            for (int i = 0; i < data.length; i++) {
                if (data[i] < 0) {
                    data[i] = 0;
                }
            }
            //increase the values on the key array to make matching easier
            while (true) {
                for (int i = 0; i < 1+(s.length() - output); i++) {
                    //String subStr = s.substring(i, i+output);
                    //System.out.println(subStr);
                    int[] key = new int[4];
                    for (int j = 0; j < output; j++) {
                        if (s.charAt(i+j) == 'Q' && data[0] > 0) {
                            key[0]++;
                        } else if (s.charAt(i+j) == 'W' && data[1] > 0) {
                            key[1]++;
                        } else if (s.charAt(i+j) == 'E' && data[2] > 0) {
                            key[2]++;
                        } else if (s.charAt(i+j) == 'R' && data[3] > 0) {
                            key[3]++;
                        }
                    }
                    //System.out.println(output + ": " + Arrays.toString(key));
                    if (Arrays.equals(data, key)) {
                        return output;
                    }
                }
                output++;
            }
        }
        return output;
    }
//    public static String buildString(int[] data) {
//        //builds a string of characters based off of the positive (extra) values
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < data.length; i++) {
//            if (data[i] > 0) {
//                for (int j = 0; j < data[i]; j++) {
//                    switch (i) {
//                        case 0:
//                            sb.append("Q");
//                            break;
//                        case 1:
//                            sb.append("W");
//                            break;
//                        case 2:
//                            sb.append("E");
//                            break;
//                        case 3:
//                            sb.append("R");
//                            break;
//                    }
//                }
//            }
//        }
//        return sb.toString();
//    }
    public static void main(String[] args) {
        String s = "EQWEEEWERRWERQQQWWQEQWEEWQRWQWWWQWRWEWERWQEWWQWWQRRQWQERWWQRERRRRRWQEQRERRWRREEEERRWERQRQEWREQREWWEWRRRERWRRWEQWQQRRWQEREEEERWQWEWQEWRWREWQEREQWQEQWRQQQWRWWRWERWQWWQQREWREEWRWWQRWQRWWQWWREWWWEWQRWRRWQEWRRRWWQRRQREQRWRRQWREQWEQRWQRWQRWERRREEREEQQEREREWQQWRWEWEQQRWEWEQWEEQEEERWWWEQRRRWRQWWQQEQRWRWRWEQRRQRQRQWWWEQWERWEQRWQRERWQQQWWWQWRWEREWRQWQWERRQQWRQWRWQQQEEQREQWRWWEQRWWWEEERQWQWEWRQQRWQWEQQEWEWRQWWERERQREWWEEREQRRWQRRRWQEEWEWQEEEQRQQEWREQWQWRRWREQQQEEEWWRQEEEWQQEQEQWWREEWRQQQRQQEERQQQEEQWERRQEEQQRQQQWWEQEEQWRQWEQWEEQQEEQQEERQEEWQEEEWQRERRERQRQQQQWRQRRQQWQEEWRRQEWQWREWERWQRQQWEEERREQEEQWQQRWERWRWEEQWEREREWRWREEWRRRQEQQERRRERQRQWRWWREQQWWEQQWQWRRWEQRWEQQEQWWWQWWEWWEEEWEWRQWQWWQQQQEWRQEQWWRWWEQRRRWREREWRQQERQRQEQWWQQWRQRRQRWRQEEEWRRQREWRRERRQEEREERWEQQQWEWWEERWQWQQWWEQWWQWERRRWQWEEEEQEEWQRRWRWEEEWEWRREWWEQQERRQWQEWQQQRWEWRQEQWREWEWEEWWWWWWWWEQRWRRQQEEEERQEWQQEQQEEEWWRWRQQQQWRREEWRWWWQRWRWRWQWWEREQQEEEWREERQEWEERQWQREEQRQWEQEREQWWEWEEWREREWRQQWREEEEQRRWRWRQRRRWRQQQRRQQRQEWEEQQEREWQEEWEWWEQRRQWRQRQQREREQRWWQEEERREWRREWRRRQQQRQEQEWQWEEQQERQRRRWRRWWEEQRWQQQQQQWREWEWWRQREWREQRRQEQEERRQERWEEQRWWQRWQRWWERQEWEQERWRWQRQEEQEQEWWQWWRREEWEWWRRQEQQWEERWEWWWQEWWRRWRWQEERQRQWEQQEWWRRRRWQEWQQQQWWEEE";
        System.out.println(s.length());
        System.out.println(balancedString(s));
    }
}
