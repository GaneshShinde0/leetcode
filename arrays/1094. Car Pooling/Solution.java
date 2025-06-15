class Solution {
    public boolean carPoolingInitialSolution(int[][] trips, int capacity) {
        int[] capArr = new int[1003];
        for(int[] arr:trips){
            int temp=arr[0];
            for(int i=arr[1];i<arr[2];i++){
                capArr[i]+=temp;
                if(capArr[i]>capacity) return false;
            }
        }
        return true;
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int[] distance = new int[1002];
        for (int[] trip : trips) {
            distance[trip[1]] += trip[0];
            distance[trip[2]] -= trip[0];
        }
        int psngr = 0;
        for(int i : distance){
            psngr+=i;
            if(psngr>capacity){
                return false;
            }
        }
        return true;
    }
}
