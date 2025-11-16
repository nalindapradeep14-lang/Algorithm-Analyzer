import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    private static final int [] INPUT_STZES = {200, 700, 2000};
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Algorithm: Binary Search");
        System.out.println("Input Size / Time (ms)");
        System.out.println("-----------------------------");

        for (int size : INPUT_STZES) {
            int[] arr = generateRandomArray(size);
            Arrays.sort(arr);
            int target = arr[random.nextInt(size)];

            long start = System.nanoTime();
            Arrays.binarySearch(arr, target);
            long end = System.nanoTime();

            double timeMs = (end - start) / 1_000_000.0;
            System.out.printf("%-10d | %.4f\n", size, timeMs);

        }

    }

    public static int[]generateRandomArray(int size) {
        int [] arr = new int[size];
        for (int i = 0; i < size; i++) 
            arr[i] = random .nextInt(10000);
        return arr;
    }


}
