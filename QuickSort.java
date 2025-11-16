import java.util.Random;

public class QuickSort {
   private static final int[] INPUT_SIZES = {200, 700, 2000};
    private static final Random random = new Random();

    public static void main(String[] args){
        System.out.println("Algorithm:QuickSort");
        System.out.println("input Size| Time(ms)");
        System.out.println("-------------------------");

        for(int size: INPUT_SIZES){
            int[] arr = generateRandomArray(size);

            long start = System.nanoTime();
            quickSort(arr,0,arr.length-1);
            long end = System.nanoTime();

            double timeMS =(end-start)/1_000_000.0;
            System.out.printf("%-10d|%.4f\n",size,timeMS);

        }

    }
    
    public static void quickSort(int[]arr,int low,int high){
        if (low<high){
            int p = partition(arr,low,high);
            quickSort(arr,low,p-1);
            quickSort(arr,p+1,high);
        }
    }
    public static int partition(int[] arr,int low,int high){
        int pivot = arr[high];
        int i =low -1;
        for(int j =low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                int temp =arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp =arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        return i+1;
    }
    public static int[]generateRandomArray(int size) {
        int[]arr = new int[size];
        for(int i =0;i<size;i++)
          arr[i]= random.nextInt(10000);
        return arr;  

    }
}
