class Solution {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> numbers = new ArrayList<>();
        Queue<Long> queue = new LinkedList<>();
        numbers.add(0);
        for(long i=1;i<=9;i++)queue.add(i);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                long curr = queue.poll();
                numbers.add((int) curr);
                long next = curr*10+curr%10;
                if (curr % 10 != 0 && next-1<= high) queue.add(next-1);
                if (curr % 10 != 9 && next+1<=high) queue.add(next+1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int num:numbers){
            if(num>=low && num<=high){
                res.add(num);
            }
        }
        return res;
    }
}