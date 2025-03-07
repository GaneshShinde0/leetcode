class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;

        boolean[] track = new boolean[right + 1];
        Arrays.fill(track, true);
        track[0] = false;
        track[1] = false;

        for (int i = 2; i <= Math.sqrt(right); i++) {
            if(track[i]){
                for(int j = i * i; j <= right; j += i)
                    track[j] = false;
            }
        }

        ArrayList<Integer> prime = new ArrayList<>();
        for(int i=left; i<right + 1; i++)
            if(track[i])
                prime.add(i);

            
        int min = Integer.MAX_VALUE;
        for(int i=0; i< prime.size() - 1; i++){
            int temp = prime.get(i+1) - prime.get(i); 
            if(temp < min){
                min = temp;
                res[0] = prime.get(i);
                res[1] = prime.get(i + 1);
            }
        }
        return res;
    }
}
