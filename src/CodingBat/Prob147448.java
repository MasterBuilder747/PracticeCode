package CodingBat;

public class Prob147448 {

    public static void main(String[] args) {

        System.out.println(countHi("abc hi ho")); //1
        System.out.println(countHi("ABChi hi")); //2
        System.out.println(countHi("hihi")); //2

    }


    public static int countHi(String str) {

        int count = 0;
        String hi = "hi";

        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i).equals("hi")) { //use .equals

            }
        }
        return count;
    }

}
