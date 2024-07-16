//Time Complexity
 //searchElement : 0(logn)

 //Space Complexity : O(1)

 
/*
Leetcode : https://leetcode.com/problems/search-in-rotated-sorted-array/

There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1

*/


/* Code Explanation
 * In a rotated sorted array, everytime one of the part of the array will be sorted. It can happen both the parts are also sorted;
 * but atleast on of the parts will be sorted. We will be using binary search to divide the search space in half and 
 * checking if the array is left sorted or right sorted; and post that if the element lies in which part of the array. 
 * The target is compared with the middle value of search space and every time the mid is moved by checking the range of target.
 * 
 */

public class RotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length -1;

        while(low <= high){
            int mid = low + (high-low)/2 ; //To avoid integer overflow
            if(nums[mid]== target) return mid;
            else if(nums[low]<= nums[mid]){  //left sorteed
                //check element lies in which part of array
                if(nums[low]<= target && target > nums[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                //right sorted
                //check element lies in which part of array
                if(nums[mid]< target && target <= nums[high]){
                    low = mid+1;
                }
                else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
