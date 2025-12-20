class Solution {
    public int kSimilarity(String s1, String s2) {
        // Question Asks for smallest -> Smallest can be taken from BFS.
        
        /*
        At Every single level branch into its neighbors and check if they are same.
        */
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(s1);
        queue.add(s1);
        int level = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                String s = queue.poll();
                if(s.equals(s2)) return level;
                List<String> neighbors = getNeighbors(s,s2);
                for(String neighbor:neighbors){
                    if(!visited.contains(neighbor)){
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            level++;
        }
        return level;
    }
    private List<String> getNeighbors(String s1, String s2){
        int i=0;
        char[] arr = s1.toCharArray();
        for(;i<s1.length();i++){
            if(arr[i]!=s2.charAt(i)) break;
        }
        List<String> li = new ArrayList<>();
        for(int j=i+1;j<s1.length();j++){
            // Taking only neighbors which are relevant to our cause.
            if(arr[j]==s2.charAt(i)){
                swap(i,j,arr);
                li.add(new String(arr));
                swap(i,j,arr);
            }
        }
        return li;
    }

    private void swap(int i, int j, char[] arr){
        char temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

    }
}