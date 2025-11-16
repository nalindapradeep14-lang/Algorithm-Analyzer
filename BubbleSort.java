import java.util.Random;

public class BubbleSort {

    private static final int[] INPUT_SIZES = {200, 700, 2000};
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Algorithm: Bubble Sort");
        System.out.println("Input Size | Time (ms)");
        System.out.println("-------------------------");

        for (int size : INPUT_SIZES) {
            int[] arr = generateRandomArray(size);

            long start = System.nanoTime();
            bubbleSort(arr);
            long end = System.nanoTime();

            double timeMs = (end - start) / 1_000_000.0;
            System.out.printf("%-10d | %.4f\n", size, timeMs);
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = random.nextInt(10000);
        return arr;
    }
}