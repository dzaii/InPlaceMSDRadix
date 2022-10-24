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

        if (startPlusLeft < start) {
            startPlusLeft = start;
        }

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

        if (startPlusLeft < start) {
            startPlusLeft = start;
        }


        if (startPlusLeft > start + 1)
            sorting(arr, start, startPlusLeft, digit >> 1);

        if (end >= startPlusLeft + 2)
            sorting(arr, startPlusLeft, end, digit >> 1);
    }
}




