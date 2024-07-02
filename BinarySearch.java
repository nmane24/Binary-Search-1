//Time Complexity
/*
 searchElement : 0(logn)
 */

//Space Complexity 
/*
 searchElement : 0(1)
 */

//Code Explanation

/* 

Binary search is a search algorithm used to find the position of a target value within a sorted array. 
It works by repeatedly dividing the search interval in half until the target value is found or the interval is empty. 
The search interval is halved by comparing the target element with the middle value of the search space. */

class BinarySearch{
   
     public int searchElement(int arr[], int target){
        int low = 0, high = arr.length -1 ;
       
        while(low <= high){
            int mid = low + (high-low)/2;  // to avoid integer overflow ; 
            // If the element is present at the middle itself
            if(arr[mid]== target) return mid;
            //If target is greater ignore the left half
            if (arr[mid]< target){
                low = mid + 1;
            }// if target is smaller ignore the right half
            else{
                high = mid -1;
            }
             
        }
        return -1;
     }


     public static void main(String[] args) {
         BinarySearch bs = new BinarySearch();
         int arr[] = {1,4,6,10,11,44};
         int target = 10;
         int result = bs.searchElement(arr, target);
         if (result == -1){
            System.out.println("Element does not exists");
         }
         else{
            System.out.println("Element is present at index : "+ result);
         }

     }
}