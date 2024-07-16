//Time Complexity : log m + log n ; here m is the number of steps / number of times we multiplied to get to the range 
// and n is the length of the range we are doing Binary Search on. 


//Space Complexity : O(3): we allocated 3 variables ~ this is nothing but constant hence O(1)


/*
Leetcode : https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
Search in a Sorted Array of Unknown Size

You have a sorted array of unique elements and an unknown size. You do not have an access to the array but you can use the ArrayReader interface to access it. You can call ArrayReader.get(i) that:
returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
returns 231 - 1 if the i is out of the boundary of the array.
You are also given an integer target.
Return the index k of the hidden array where secret[k] == target or return -1 otherwise.
You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: secret = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in secret and its index is 4.
Example 2:

Input: secret = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in secret so return -1.


*/


/* Code Explanation:
We take fast and slow pointers/index here. These two indexes are used to find the range in which the target can lie and 
finally on the range we found; perform the Binary Search that is between those two indexes.
 */


public class search_in_unknown_size_array
{
    public int search(ArrayReader reader, int target){

        if(reader.get(0) == Integer.MAX_VALUE) return -1;
        if (reader.get(0) == target) return 0;
        
        int low = 0, high =1;
        while(reader.get(high) < target){ // Finding the range 
            low = high;
            high = high*2;
        }
        
        while(low <=high){
            int mid = low + (high -low)/2;
            if(reader.get(mid) == target) return target;
            else if(reader.get(mid) > target){
                high = mid -1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}
