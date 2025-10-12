class Solution {

    private List<Integer> runningSums;
    private int totalSum;
    public Solution(int[] weights) {
        runningSums = new ArrayList<>();
        int runningSum = 0;
        for(int w:weights){
            runningSum+=w;
            runningSums.add(runningSum);
        }
        totalSum = runningSum;
    }
    
    public int pickIndex() {
        Random random = new Random();
        int target = random.nextInt(totalSum)+1;
        int low=0;
        int high=runningSums.size();
        while(low<high){
            int mid = low+(high-low)/2;
            if(target>runningSums.get(mid)){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */






































// Initial Solution
//  class Solution {

//     private int length;
//     private int[] weight;
//     private int totalWeight;
//     TreeMap<Integer,Integer> hm;
//     public Solution(int[] w) {
//         this.hm = new TreeMap<>();
//         this.weight = w;
//         this.length=w.length;
//         for(int i=0;i<w.length;i++){
//             this.totalWeight+=w[i];
//         }
//         for(int i=0;i<w.length;i++){
//             this.totalWeight+=w[i];
//         }
//         int currWeight = 0;
//         for(int i=0;i<w.length;i++){
//             for(int j=0;j<weight[i];j++){
//                 hm.put(currWeight,i);
//                 currWeight++;
//             }
//         }
//     }
    
//     public int pickIndex() {
//         double random = Math.random();
//         return hm.get(this.hm.floorKey((int)(random*this.totalWeight)));
//     }
// }

// /**
//  * Your Solution object will be instantiated and called as such:
//  * Solution obj = new Solution(w);
//  * int param_1 = obj.pickIndex();
//  */