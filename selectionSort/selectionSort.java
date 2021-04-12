import java.lang.*;
import java.util.Scanner;


class selectionSort{
   public static int[] selectionSortFunc(int[] nums){
      for(int i = 0; i < nums.length; i++){
         int j = i;
         for(int k = i + 1; k < nums.length; k++){
            if(nums[k] < nums[j]){
               j = k;
            }
         }
         int temp = nums[i];
         nums[i] = nums[j];
         nums[j] = temp;
      }
      return nums;
   }
public static void main(String args[]){
      int size;
      Scanner scr = new Scanner(System.in);
      System.out.print("Enter the size of the array:");
      size = scr.nextInt();
      
      int[] nums = new int[size];
      System.out.println("Enter the elements of array.....");
      
      for(int i = 0; i < size; i++){
         nums[i] = scr.nextInt();
      }
      
      int[] sortedArray = selectionSortFunc(nums);
      
      System.out.println("The sorted array is.............");
      for(int i = 0; i < sortedArray.length; i++){
         System.out.print(sortedArray[i] + " ");
      }
   }
}
