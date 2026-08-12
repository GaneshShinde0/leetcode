class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        int ops = 0;
        Set<Integer> set = new HashSet<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                x = queue.poll();
                if(set.contains(x)) continue;
                if(x==y) return ops;
                if(x%11==0) queue.add(x/11);
                if(x%5==0) queue.add(x/5);
                queue.add(x-1);
                queue.add(x+1);
                set.add(x);
            }
            ops++;
        }
        return ops;
    }
}