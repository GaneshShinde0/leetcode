class Solution {
    public boolean checkIfExist(int[] arr) {
        boolean[] temp = new boolean[1001];
        boolean[] tempNeg = new boolean[1001];
        int zeroCount = 0;
        for (int i : arr) {
            if (i < 0) tempNeg[-i] = true; // Store the absolute value of negative numbers in tempNeg
            else temp[i] = true;
            if(i==0)zeroCount++;
        }
        if(zeroCount>1) return true;
        
        for (int i = 1; i < 501; i++) {
            if (temp[i] && temp[2 * i]) return true;
            if (tempNeg[i] && i * 2 <= 1000 && tempNeg[2 * i]) return true;
        }
        
        return false;
    }


    public boolean checkIfExistUsingHashSet(int[] arr) {
        Set<Integer> hs = new HashSet<>();
        for(int i:arr){
            if(hs.contains(2*i)||(i%2==0 &&hs.contains(i/2)))return true;
            hs.add(i);
        }
        return false;
    }
}
