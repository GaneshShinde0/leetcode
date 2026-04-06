class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int[] arr: matrix){
            reverse(arr);
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                swap(matrix,i,j,n-j-1,n-i-1);
            }
        }
    }
    private void swap(int[][] nums, int i, int j, int k, int l){
        int temp = nums[i][j];
        nums[i][j] = nums[k][l];
        nums[k][l] = temp;
    }
    private void reverse(int[] nums){
        int left = 0, right = nums.length-1;
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}

/*
Input: matrix = 
[
    [1,2,3],
    [4,5,6],
    [7,8,9]
]

[
    [3,2,1],
    [6,5,4],
    [9,8,7]
]

0,1 -> 1,2

Reverse All the rows.
Flip the elements which are in middle positions


Input: matrix = 
[
    [5,1,9,11],
    [2,4,8,10],
    [13,3,6,7],
    [15,14,12,16]
]

After Reverse:
[
    [11,9,1,5],
    [10,8,4,2],
    [7,6,3,13],
    [16,12,14,15]
]

Now Swap diagonals
    i=1, j=1 ; k=2,l = 2;
    i=0,j=2, k=4-2-1=1, l = 4-0-1=3
    
for(int i=0;i<m;i++){
    for(int j=0;j<n-1;j++){
        swap(nums,i,j,n-j-1,n-i-1);
    }
}


This can also be done with transpose and reverse.

*/
