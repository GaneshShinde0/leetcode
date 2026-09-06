class Solution {
    
    public int countGroups(int[] position, int[] speed, int distance) {
        boolean canMerge = true;
        int n = position.length;
        Stack<Integer> stk = new Stack<>();
        stk.add(n-1);
        int nextPos = position[n-1];
        
        for(int i=n-2;i>=0;i--){
            if(speed[i]<=speed[stk.peek()] && distance<nextPos-position[i]){
                stk.push(i);
            }
            nextPos = position[i];
        }
        return stk.size();
    }


    public int countGroupsDoesNotWork(int[] position, int[] speed, int distance) {
        boolean canMerge = true;
        int n = position.length;
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<n;i++) li.add(i);
        while(canMerge){
            canMerge = false;
            List<Integer> curr = new ArrayList<>();
            curr.add(li.get(0));
            for(int i=1;i<li.size();i++){
                int prev = curr.get(curr.size()-1);
                if(position[li.get(i)]-position[prev]<=distance || speed[li.get(i)]<speed[prev]){
                    canMerge=true;
                    curr.set(curr.size()-1, li.get(i));
                }else{
                    curr.add(li.get(i));
                }
            }
            System.out.println(li);
            li = curr;
        }
        return li.size();
    }
}