import java.util.Random;
import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class mergeSort {
    static void mergeSortAlgo(int[] nums,int low, int high){
        if(low < high){
            int mid = low + (high - low)/2;

            mergeSortAlgo(nums, low, mid);
            mergeSortAlgo(nums, mid + 1, high);

            merge(nums, low, mid, high);

        }
    }
    static void merge(int[] nums, int low, int mid, int high){
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = nums[low + i];
        for (int j = 0; j < n2; ++j)
            R[j] = nums[mid + 1 + j];

        int i = 0, j = 0;

        int k = low;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k] = L[i];
                i++;
            }
            else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = R[j];
            j++;
            k++;
        }
    }
    public static void main(String args[]){
        Random rand = new Random();
        try{
            FileWriter writer = new FileWriter("plot.txt", true); 
            int numSize[] = {10000, 20000, 30000, 50000, 80000, 100000, 150000, 200000, 500000, 700000};
            for(int s = 0; s < numSize.length; s++){
                int[] nums = new int[numSize[s]];
                for(int i = 0; i < nums.length; i++){
                    nums[i] = rand.nextInt(1000);
                }

                long start = System.currentTimeMillis();

                mergeSortAlgo(nums, 0, nums.length - 1);

                long end = System.currentTimeMillis();

                String text = "Time taken to sort the array of size " + numSize[s] + " is " + (end - start) + "ms";

                System.out.println(text);
                writer.write(text + "\n");

            }
            writer.close();
       }
       catch(IOException e){
           System.out.println(e.getMessage());
       }
    }
}
