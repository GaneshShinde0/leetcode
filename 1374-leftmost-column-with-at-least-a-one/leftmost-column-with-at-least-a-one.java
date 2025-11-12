/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
//         for(int i=0;i<dim.get(1);i++){
//             for(int j=dim.get(0)-1;j>=0;j--){
//                 if(binaryMatrix.get(j,i)==1) return i;
//             }
//         }
        
        int low = 0, high = dim.get(1)-1;
        while(low<high){
            // System.out.println("High ="+high+", Low="+low);
            int mid = (low +high)/2;
            if(hasOne(binaryMatrix, mid, dim.get(0))){
                high = mid;
            }else{
                low=mid+1;
            }
        }
        if(hasOne(binaryMatrix, high, dim.get(0))) return high;
        else return -1;
//         if(hasOne(binaryMatrix, low, dim.get(0))) return low;
//         else return -1;
    }
    
    private boolean hasOne(BinaryMatrix binaryMatrix, int mid,int rows){
        for(int i=rows-1;i>=0;i--){
            if(binaryMatrix.get(i,mid)==1) return true;
        }
        return false;
    }
}