class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        for(int i=1;i<warehouse.length;i++){
            warehouse[i]=Math.min(warehouse[i],warehouse[i-1]);
        }
        int wp = warehouse.length-1;
        int bp = 0;
        while(bp<boxes.length && wp>=0){
            if(boxes[bp]<=warehouse[wp]){
                bp++;
            }
            wp--;
        }
        return bp;
    }
}