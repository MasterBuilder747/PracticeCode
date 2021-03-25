package LeetCode;

public class ama {

    public static int go(int num, int[] skills, int team, int min, int max) {
        int size = 0;
        for (int i : skills) {
            if (i >= min && i <= max) {
                size++;
            }
        }
        return 0;
    }

    public static int factor(int f) {
        int out = f;
        int l = f - 1;
        for (int i = 0; i < f - 1; i++) {
            out *= l;
            l--;
        }
        return out;
    }

    public static void main(String[] args) {
        int[] skills = {1, 2, 3, 4, 5};
        System.out.println(go(5, skills, 2, 2, 5));
        //System.out.println(factor(1));
    }

}
