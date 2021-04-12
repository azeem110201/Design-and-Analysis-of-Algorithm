import java.lang.*;
import java.util.Scanner;


class maxNum{
   public static int findMaxNumber(int[] nums){
      int maxElement = nums[0];
      for(int i = 1; i < nums.length; i++){
         if(nums[i] > maxElement){
            maxElement = nums[i];
         }
      }
      return maxElement;
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
      
      int maxNumber = findMaxNumber(nums);
      System.out.println("The maximum element present in the array is:" + maxNumber);
   }
}
