// class Solution {
//     public int maxSumDivThree(int[] nums) {
//         int sum = 0;
//         PriorityQueue<Integer> minOne = new PriorityQueue<>();
//         PriorityQueue<Integer> minTwo = new PriorityQueue<>();

//         for(int i:nums){
//             if(i%3==1){
//                 minOne.add(i);
//             }else if(i%3==2){
//                 minTwo.add(i);
//             }
//             sum+=i;
//             // if(minOne.size()>2)minOne.poll(); 
//             // if(minTwo.size()>2)minTwo.poll(); 
//         }
//         if(sum%3==0) return sum;
//         int temp1=0,temp2=0;
//         int reduce = 0;
//         if(minTwo.size()>1) reduce = minTwo.poll()-minTwo.poll();
//         temp1 = Math.max(sum-minOne.poll(), sum-reduce);
//         reduce = 0;
//         if(minOne.size()>1) reduce = minOne.poll()-minOne.poll();
//         temp2 = Math.max(sum-reduce, sum-minTwo.poll());
//         return Math.max(temp1, temp2);
//     }
// }

class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        PriorityQueue<Integer> minOne = new PriorityQueue<>();
        PriorityQueue<Integer> minTwo = new PriorityQueue<>();

        for(int i:nums){
            if(i%3==1){
                minOne.add(i);
            }else if(i%3==2){
                minTwo.add(i);
            }
            sum+=i; 
        }
        if(sum%3==0) return sum;
        else if(sum%3==1){
            int reduce = 0;
            if(minTwo.size()>1) reduce = minTwo.poll()+minTwo.poll();
            if(reduce>0 && minOne.size()>=1) return Math.max(sum-minOne.poll(),sum-reduce);
            if(minOne.size()>=1) return Math.min(sum-minOne.poll(), sum-reduce);
            else return sum-reduce;
        }else{
            int reduce = 0;
            if(minOne.size()>1) reduce = minOne.poll()+minOne.poll();
            if(reduce>0 && minTwo.size()>=1) return Math.max(sum-reduce, sum-minTwo.poll());
            if(minTwo.size()>=1) return Math.min(sum-reduce, sum-minTwo.poll());
            else return sum-reduce;
        }
        // return 0;
    }
}