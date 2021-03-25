package LeetCode;

public class prob941 {
    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int i;
        if (arr[0] >= arr[1]) {
            return false;
        } else {
            i = 1;
            while (true) {
                //mountain can never be flat
                if (arr[i] == arr[i+1]) {
                    return false;
                }
                //move to the fall loop
                if (arr[i] > arr[i+1]) {
                    if (i < arr.length-2) {
                        i++;
                        break;
                    } else {
                        return true;
                    }
                }
                //keep going, but make sure bounds is correct
                if (i < arr.length-2) {
                    i++;
                } else {
                    return false;
                }
            }
        }
        while (true) {
            //mountain can never be flat
            if (arr[i] == arr[i+1]) {
                return false;
            }
            //move to the fall loop
            if (arr[i] < arr[i+1]) {
                return false;
            }
            //keep going, but make sure bounds is correct
            if (i < arr.length-2) {
                i++;
            } else {
                if (arr[i] > arr[i+1]) {
                    return true;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 1};
        System.out.println(validMountainArray(a));
    }
}
