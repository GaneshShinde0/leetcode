class Solution {
    public int minimumRecolorsInitial(String blocks, int k) {
        int res = Integer.MAX_VALUE;
        int n = blocks.length();
        char[] chars = blocks.toCharArray();
        for(int i=0;i<=n-k;i++){
            int temp = 0;
            for(int j=i;j<i+k;j++){
                if(chars[j]=='W') temp++;
            }
            res = Math.min(res, temp);
        }
        return res;
    }

    // Sliding Window
    public int minimumRecolorsSlidingWindow(String blocks, int k){
        int l=0,whites = 0, recolors = Integer.MAX_VALUE;

        for(int right = 0; right<blocks.length();right++){
            if(blocks.charAt(right)=='W') whites++;
            if(right-l+1==k){
                recolors = Math.min(recolors,whites);
                if(blocks.charAt(l)=='W') whites--;
                l++;
            }
        }    
        return recolors;
    }    
    public int minimumRecolors(String blocks, int k){
        Queue<Character> blockQueue = new LinkedList<>();
        int whites=0;
        // Initiate queue with first k values.
        for(int i = 0; i<k; i++){
            char curr = blocks.charAt(i);
            if(curr=='W') whites++;
            blockQueue.add(curr);
        }
        int recolors = whites;
        for(int i=k;i<blocks.length();i++){
            if(blockQueue.poll()=='W')whites--;
            char curr = blocks.charAt(i);
            if(curr=='W') whites++;
            blockQueue.add(curr);
            recolors = Math.min(recolors, whites);
        }
        return recolors;
    }
}
