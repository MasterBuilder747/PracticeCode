package LeetCode;

public class prob1184 {
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int i = start;
        int j = start;
        int total1 = 0;
        int total2 = 0;
        while (i != destination) {
            total1 += distance[i];
            i++;
            if (i >= distance.length) {
                i = 0;
            }
        }
        do {
            j--;
            if (j < 0) {
                j = distance.length - 1;
            }
            total2 += distance[j];
        } while (j != destination);
        return Math.min(total1, total2);
    }

    public static void main(String[] args) {
        System.out.println(distanceBetweenBusStops(new int[] {1, 2, 3, 4}, 0, 3));
    }
}
