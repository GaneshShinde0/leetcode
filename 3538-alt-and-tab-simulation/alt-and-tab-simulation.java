class Solution {
    public int[] simulationResult(int[] windows, int[] queries) {
        int n = windows.length;
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = queries.length-1; i>=0;i--){
            if(queue.isEmpty()){
                queue.add(queries[i]);
            }else{
                if(set.contains(queries[i])){
                    continue;
                }else{
                    queue.add(queries[i]);
                }
            }
            set.add(queries[i]);
        }        

        int[] result = new int[windows.length];
        int index = 0;
        while(!queue.isEmpty()){
            result[index] = queue.poll();
            index++;
        }
        for(int i=0;i<windows.length;i++){
            if(!set.contains(windows[i])){
                result[index] = windows[i];
                index++;
            }
        }
        return result;
    }
}