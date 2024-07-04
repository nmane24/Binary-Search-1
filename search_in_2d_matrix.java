
/*

Time Complexity : log m + log n

Space Complexity : O(4) ~ O(1) ... need to allocate 4 new variables, but its nothing but O(1)

Brute-force way: iterate on all rows and columns to find the target, for which we require two for loops 
Time complexity : m*n ( as rows & columns are not equal hence not n^2)

Different Approaches & their time complexity 
1. Apply binary search on each row , check for the mid is the target , then go for next row : m logn
2. Apply binary search on each column : n logm ( as each coulmn we are doing binary search)
3. Iterate through the row to check range and then do binary search for that row only :  m + log n
4. Similarly Iterate through the col to check range and then do binary search for that col only : n + logm
5. BS on each column first and finding in which row tha target would lie. 
After I found the target in particular row, perform BS on that row again : log m + log n


/*
Leetcode : https://leetcode.com/problems/search-a-2d-matrix/
Search a 2D Matrix

You are given an m x n integer matrix matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.


Code Explanantion:
 * The approach we have taken is we have considered 2d Matrix as 1d Matrix and performed binary search on it.
 * As the binary search is performed on rows * columns the complexity becomes O(log mn) = O(log m + log n) both are same. 
 * The  main part here is to get the index of row and column of 2d matrix as we considered it as 1d matrix. 
 * 1d array index/column_size gives row index and 
 * 1d array index% column_size gives column index
 */


public class search_in_2d_matrix {
    public boolean searchMatrix(int [][]matrix, int target){
        if(matrix.length == 0) return false; // if no rows in matrix then return false
        int m = matrix.length; // rows
        int n = matrix[0].length; // columns

        int low = 0;
        int high = m*n -1 ; // As this is 1d matrix, m*n will give the total length
        //start binary search on 1d matrix now
        while(low <=high){
            int mid  =  low + (high-low)/2;
            int row_index = mid / n;
            int column_index = mid%n;

            if(matrix[row_index][column_index]== target) return true;
            else if(matrix[row_index][column_index]< target){
                low = mid +1;
            }else{
                high = mid -1;
            }
        }
        return false;
    }
}
