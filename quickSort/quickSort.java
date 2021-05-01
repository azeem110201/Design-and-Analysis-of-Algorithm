import java.util.Random;
import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;

class quickSort{
    static int partition(int[] nums, int low, int high){
        int pivot = nums[low];
        int i = low + 1;
        int j = high;
        
        while(true){
            while(i <= j && nums[i] <= pivot){
                i++;
            }
            while(nums[j] >= pivot && i <= j){
                j--;
            }
            if(i > j){
                break;
            }
            else{
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[low];
        nums[low] = nums[j];
        nums[j] = temp;

        return j;
    }
    static void quickSortAlgo(int[] nums, int low, int high){
        if(low < high){
            int partitionPos = partition(nums, low, high);

            quickSortAlgo(nums, low, partitionPos - 1);
            quickSortAlgo(nums, partitionPos + 1, high);
        }
    }
    public static void main(String args[]){
        Random rand = new Random();
        try{
            FileWriter writer = new FileWriter("plot.txt", true); 
            int numSize[] = {10000, 20000, 50000, 80000, 100000, 150000, 200000, 300000, 500000, 700000};
            for(int s = 0; s < numSize.length; s++){
                int[] nums = new int[numSize[s]];
                for(int i = 0; i < nums.length; i++){
                    nums[i] = rand.nextInt(1000);
                }

                long start = System.currentTimeMillis();

                quickSortAlgo(nums, 0, nums.length - 1);

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