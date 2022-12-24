import java.util.Random;
import java.util.Arrays;

public class InPlaceMSDRadix {
    public static int msbSignificance(int n) {

        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;

        n = n + 1;

        return (n >> 1);
    }

    public static int largest(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max |= arr[i];
        }
        return max;
    }

    public static void Sort(int[] arr) {
        int digit = msbSignificance(largest(arr));
        int temp;
        int start = 0;
        int end = arr.length;
        int startPlusLeft = start;
        int endMinusRight = end - 1;

        for (int i = start; startPlusLeft < endMinusRight; i++) {

            if ((arr[startPlusLeft] & digit) != 0) {
                startPlusLeft++;
                continue;
            }
            if ((arr[endMinusRight] & digit) == 0) {
                endMinusRight--;
                continue;
            }
            temp = arr[startPlusLeft];
            arr[startPlusLeft] = arr[endMinusRight];
            arr[endMinusRight] = temp;
            startPlusLeft++;
            endMinusRight--;
        }

        if (startPlusLeft == endMinusRight)
            if ((arr[startPlusLeft] & digit) != 0)
                startPlusLeft++;


        if (startPlusLeft > start + 1)
            sorting(arr, start, startPlusLeft, digit >> 1);

        if (end >= startPlusLeft + 2)
            sorting(arr, startPlusLeft, end, digit >> 1);
    }

    public static void sorting(int[] arr, int start, int end, int digit) {

        if (digit < 1)
            return;

        int temp;
        int startPlusLeft = start;
        int endMinusRight = end - 1;

        for (int i = start; startPlusLeft < endMinusRight; i++) {

            if ((arr[startPlusLeft] & digit) != 0) {
                startPlusLeft++;
                continue;
            }
            if ((arr[endMinusRight] & digit) == 0) {
                endMinusRight--;
                continue;
            }
            temp = arr[startPlusLeft];
            arr[startPlusLeft] = arr[endMinusRight];
            arr[endMinusRight] = temp;
            startPlusLeft++;
            endMinusRight--;
        }

        if (startPlusLeft == endMinusRight)
            if ((arr[startPlusLeft] & digit) != 0)
                startPlusLeft++;

        if (startPlusLeft > start + 1)
            sorting(arr, start, startPlusLeft, digit >> 1);

        if (end > startPlusLeft + 1)
            sorting(arr, startPlusLeft, end, digit >> 1);
    }
    public static void main(String[] args) {

        int[] mat = new int[100000000];
        Random r = new Random();
        for (int i = 0; i < mat.length; i++) {
            mat[i] = r.nextInt(100000000);
        }

        long begTime = System.currentTimeMillis();
            Sort(mat);

        long endTime = System.currentTimeMillis();
        System.out.printf("Total time : %d ms\n", (endTime - begTime));

        for (int i = 0; i < mat.length - 1; i++) {
            if (mat[i] < mat[i + 1]) {
                System.out.println();
                System.out.println("No good");
                System.out.println(mat[i] + " " + mat[i + 1]);
                break;
            }
        }
        System.out.println("haha");
    }
}




