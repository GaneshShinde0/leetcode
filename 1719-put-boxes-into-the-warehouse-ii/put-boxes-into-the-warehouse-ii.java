/*
3,3,1,1
1,1,1,2
*/
class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int n = warehouse.length;
        int left = 0, right = n-1, bp = boxes.length-1;
        Arrays.sort(boxes);
        int[] fromLeft = new int[n];
        int[] fromRight = new int[n];
        fromLeft[0] = warehouse[0];
        fromRight[n-1] = warehouse[n-1];
        for(int i=1;i<n;i++){
            fromLeft[i] = Math.min(warehouse[i],fromLeft[i-1]);
            fromRight[n-i-1] = Math.min(warehouse[n-i-1],fromRight[n-i]);
        }
        while(left<=right && bp>=0){
            if(fromLeft[left]<fromRight[right] && boxes[bp]<=fromRight[right]){
                right--;
            }else if(boxes[bp]<=fromLeft[left]){
                left++;
            }
            bp--;
        }
        return left+warehouse.length-right-1;
    }
}