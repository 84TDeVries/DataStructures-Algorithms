import java.util.*;
public class AdvanceSort
{
    public static void main(String []args){
        Scanner console = new Scanner(System.in); 
        boolean cont = console.nextBoolean(); 
        while(cont){
            int[] nums = new int[console.nextInt()]; 
            randomizer(nums); 
            print(nums);
            print(copy(nums,0,nums.length-2)); 
            System.out.println(); 
            System.out.println("Shell Sort Method"); 
            print(shellSort(nums)); 
            
            System.out.println("Quick Sort Method"); 
            int[] arr = copy(nums);
            quickSort(arr, 0, arr.length-1); 
            print(arr);
            
            System.out.println("Partition Sort Method");
            
            System.out.println("Radix Sort Method"); 
            arr = radixSort(nums);
            print(arr); 
            
            if (console.hasNextBoolean()){
                cont = console.nextBoolean(); 
            }else{
                cont = false; 
            }
            
        }
        /*
        
        SortImage f = new SortImage();
        
        while(console.hasNextInt()){
            n = console.nextInt(); 
            //scale = console.nextDouble(); 
            col = 0; 
            if (n == -1)
                break; 
            SwingUtilities.updateComponentTreeUI(f);
        }
    
         */
        
    }
    
    
    
    
    public static void quickSort(int[] arr,int s, int f){
        if (f > s){
            print(arr); 
            int pivot = partition(arr, s, f);
            quickSort(arr, s, pivot-1);
            quickSort(arr, pivot+1, f); 
            
        }
    }public static int[] radixSort(int[] arr){
        int m = max(arr, arr.length);
        //print(arr);
        //System.out.println(m); 
        int[] nums = copy(arr);
        for(int exp = 1; m/exp > 0; exp *= 10){
            print(nums); 
            countSort(nums, arr.length, exp); 
        }
        return nums; 
    }public static void countSort(int[] arr, int n, int ex){
        int[] output = new int[n]; 
        int i;
        int[] count = new int[10];
        for(i = 0; i < n; i++)
            count[(arr[i]/ex)%10]++; 
        //print(count);
        for(i = 1; i < 10; i++)
            count[i] += count[i-1]; 
        //print(count); 
        for(i = n-1; i >= 0; i--){
            output[count[(arr[i]/ex)%10]-1] = arr[i]; 
            count[(arr[i]/ex)%10]--; 
            //print(output);
        }for(i = 0; i < n; i++)
            arr[i] = output[i]; 
        //print(arr); 
    }public static int[] shellSort(int[] arr){
        int[] nums = copy(arr);
        for(int gap = nums.length/2; gap > 0; gap /= 2){
            for(int i = gap; i < nums.length; i++){
                int temp = nums[i];
                int j;
                for(j = i; j >= gap && nums[j-gap] > temp; j-= gap){
                    nums[j] = nums[j-gap]; 
                }
                
                nums[j] = temp; 
                print(nums); 
            }
        }return nums; 
         
    }public static void partitionSort(int[] arr, int l, int r){
      
    }public static int partition(int[] nums, int s, int f){
        int larger = s;
        for(int i = s; i < f; i++){
            if(nums[i] <= nums[f]){
                swap(nums, larger, i); 
                larger++; 
            }
        }swap(nums,f,larger); 
        return larger; 
    }
    
    
    
    public static int max(int[] arr, int ind){
        int mx = arr[0];
        for(int i = 1; i < ind; i++){
            if(arr[i]>mx)
                mx = arr[i];
        }return mx; 
    }public static void print(int[] arr){
        for(int i: arr){
            System.out.print(i + ", ");
        }System.out.println(); 
    }public static int minimum(int[] arr, int startInd){
        int min = arr[startInd]; 
        int minInd = startInd; 
        for(int i = startInd+1; i < arr.length; i++){
            if (arr[i] < min){
                min = arr[i];
                minInd = i; 
            }
        } 
        return minInd; 
    }public static int[] copy(int[] arr){
        int[] nums = new int[arr.length]; 
        for(int i = 0; i < arr.length; i ++){
            nums[i] = arr[i]; 
        }
        return nums; 
    }public static void swap(int[] arr, int startInd, int endInd){
        int temp = arr[startInd]; 
        arr[startInd] = arr[endInd]; 
        arr[endInd] = temp; 
    }public static int[] copy(int[] arr, int start, int end){
        if (end > start){
            int[] nums = new int[(end - start) + 1]; 
            int j = 0; 
            for(int i = start; i <= end; i ++){
                nums[j] = arr[i]; 
                j++; 
            }
            
            return nums; 
        }else{
            return new int[0]; 
        }
        
    }public static int binarySearch(int[] arr, int num){
        int mid = arr.length/2;
        int s = 0;
        int e = arr.length; 
        while (s < e){
            mid = (s + e)/2; 
            if (arr[mid] > num){
                e = mid - 1;
            }else if (num > arr[mid]){
                s = mid+1; 
            }else{
                return mid; 
            }
        }
        return -1; 
    }public static int linearSearch(int[] arr, int num){
        for(int i = 0; i < arr.length; i++){
           if (arr[i] == num)
            return i; 
        }
        return -1; 
    }public static void randomizer(int[] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*100)+1; 
        }
    }
}