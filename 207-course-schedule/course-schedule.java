class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap<Integer, Set<Integer>> adj = new HashMap<>();
        for(int i=0;i<numCourses;i++) adj.put(i, new HashSet<Integer>());
        for(int[] preReq: prerequisites){
            inDegree[preReq[0]]++;
            if(preReq[0]==preReq[1]) return false;
            adj.get(preReq[1]).add(preReq[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0) queue.add(i);
        }
        int count = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            count++;
            for(int node:adj.get(curr)){
                inDegree[node]--;
                if(inDegree[node]==0) queue.add(node);
            }
        }
        return count==numCourses;
    }
}

/*
1-> 0 , 2
0 -> 1

*/