import java.util.*;
public class Sorting
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
            System.out.println("Insert Sort method"); 
            print(insertSort(nums));
            System.out.println();
            System.out.println("Selection Sort Method"); 
            print(selectSort(nums));
            System.out.println(); 
            System.out.println("Merge Sort Method");
            int[] numbs = copy(nums); 
            print(numbs); 
            mergeSort(numbs, 0, numbs.length-1); 
            print(numbs);
            System.out.println(binarySearch(numbs, nums[0])); 
            System.out.println(); 
            System.out.println("Bubble Sort Method"); 
            print(bubbleSort(nums));
            
            if (console.hasNextBoolean()){
                cont = console.nextBoolean(); 
            }else{
                cont = false; 
            }
        }
    }
    
    
    
    
    public static int[] insertSort(int[] arr){
        int[] nums = copy(arr); 
        for(int i = 0; i < nums.length; i++){
            print(nums); 
            int minInd = minimum(nums, i);
            swap(nums, i, minInd);  
        }
        return nums; 
    }public static int[] bubbleSort(int[] arr){
        int[] nums = copy(arr); 
        int index = nums.length - 1;
        boolean sort; 
        while(index >= 0){
            sort = false; 
            for(int i = 0; i < index; i++){
                if(nums[i] > nums[i+1]){
                    swap(nums, i, i+1);
                    sort = true; 
                }
                print(nums);
            }
            if (!sort){
                return nums; 
            }
            index-= 1;
            
        }return nums; 
    }public static int[] selectSort(int[] arr){
        int[] nums = copy(arr); 
        int prev;
        int num; 
        for(int i = 1; i < nums.length; i++){
            print(nums); 
            prev = i - 1; 
            num = nums[i]; 
            while(prev >= 0 && num < nums[prev]){
                swap(nums, prev+1, prev); 
                 
                prev--; 
                
            }
        }return nums; 
    }public static void mergeSort1(int[] arr, int l, int r){
      if(l < r){
          int mid = (r+l)/2;
          print(arr); 
          mergeSort(arr, l,mid);
          mergeSort(arr, mid+1,r); 
          merge(arr, l, mid, r);
          
      }
    }public static void merge1(int[] arr, int s, int mid, int e){
        int i, j, k; 
        int iL = mid - s + 1; 
        int iR = e - mid; 
        
        int[] l = copy(arr, iL, mid - 1); 
        int[] r = copy(arr, iR, e); 
        i = 0;
        j = 0; 
        k = s; 
        while (i < iL && j < iR){
            if (l[i] <= r[j]){
                arr[k] = l[i];
                i++; 
            }else {
                arr[k] = r[i]; 
                j++; 
            }k++; 
        }while (i < iL){
            arr[k] = l[i];
            i++;
            k++; 
        }while (j < iR){
            arr[k] = r[j]; 
            j++;
            k++; 
        }
    }public static void merge(int arr[], int l, int m, int r) 
        { 
            int i, j, k; 
            int n1 = m - l + 1; 
            int n2 = r - m; 
        
            /* create temp arrays */
            int[] L = new int[n1];
            int[] R = new int[n2]; 
        
            /* Copy data to temp arrays L[] and R[] */
            for (i = 0; i < n1; i++) 
                L[i] = arr[l + i]; 
            for (j = 0; j < n2; j++) 
                R[j] = arr[m + 1+ j]; 
        
            /* Merge the temp arrays back into arr[l..r]*/
            i = 0; // Initial index of first subarray 
            j = 0; // Initial index of second subarray 
            k = l; // Initial index of merged subarray 
            while (i < n1 && j < n2) 
            { 
                if (L[i] <= R[j]) 
                { 
                    arr[k] = L[i]; 
                    i++; 
                } 
                else
                { 
                    arr[k] = R[j]; 
                    j++; 
                } 
                k++; 
            } 
            while (i < n1) { 
                arr[k] = L[i]; 
                i++; 
                k++; 
            } while (j < n2) { 
                arr[k] = R[j]; 
                j++; 
                k++; 
            } 
            print(arr); 
        } 
        public static void mergeSort(int[] arr, int l, int r) 
        { 
            if (l < r) 
            { 
                
                int m = l+(r-l)/2; 
                
         
                mergeSort(arr, l, m); 
                mergeSort(arr, m+1, r); 
        
                merge(arr, l, m, r); 
            } 
    }public static void quickSort(int[] arr, int l, int h){
        if (h > l){
            
        }
    }public static void partition(int[] arr, int l, int h){
        
    }
    
    
    
    public static void print(int[] arr){
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
            arr[i] = (int)(Math.random()*10)+1; 
        }
    }
}