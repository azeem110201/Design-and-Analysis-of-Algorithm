import java.util.*;
class heapSort {
    public static void HeapSort(int[] arr,int n){
        heapify(arr,n);
            for(int i=n;i>=2;i--){
            int temp = arr[i];
            arr[i] = arr[1];
            arr[1] = temp;
            adjust(arr,1,i-1);
            }
    }
 
    public static void sort(int[] arr,int n){
        for(int i=1;i<=n;i++){
            insert(arr,i);
        }
        for(int i=n;i>=1;i--){
            int x = delMax(arr,i);
            arr[i] = x;
        }
    }
    public static int delMax(int[] arr,int n){
        if(n ==0){
        System.out.println("Heap is Empty");
        }
        int x = arr[1];
        arr[1] = arr[n];
        adjust(arr,1,n-1);
        return x;
    }
    public static void heapify(int[] arr,int n){
        for(int i=n/2;i>=1;i--){
            adjust(arr,i,n);
        }
    }
    public static void insert(int[] arr,int n){
        int i = n;
        int item = arr[n];
        while((i > 1 ) && (arr[i/2] < item)) {
            arr[i] = arr[i/2];
            i = i/2;
        }
        arr[i] = item;
    }
    public static void adjust(int[] arr,int i,int n){
        int j = 2*i;
        int item = arr[i];
        while(j <= n){
            if(j<n && arr[j] < arr[j+1]){
                j = j + 1;
            }
            if(item >= arr[j]){
                break;
            }
            arr[j/2] = arr[j];
            j = 2*j;
        }
        arr[j/2] = item;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int size = sc.nextInt();
        int[] arr = new int[size+1];
        System.out.println("Enter the array elements");
        for(int i=1;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        HeapSort(arr, arr.length-1);
        sort(arr,arr.length-1);
        System.out.println("Array After HeapSort");
        for(int i=1;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
 