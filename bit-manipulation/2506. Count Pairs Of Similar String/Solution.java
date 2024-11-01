class Solution {
    public int similarPairs(String[] words) {
        int count = 0;
        int n = words.length;
        boolean[][] temp = new boolean[n][26];
        for(int i=0;i<n;i++){
            temp[i]=freqChar(words[i]);
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isSimilarArr(temp[i],temp[j])){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isSimilar(String a, String b){
        boolean[] arr1 = new boolean[26]; 
        boolean[] arr2 = new boolean[26];
        for(char c:a.toCharArray()){
            arr1[c-'a']=true;
        }
        for(char c:b.toCharArray()){
            arr2[c-'a']=true;
        }
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]) return false;
        }
        return true;
    }
    private boolean[] freqChar(String a){
        boolean[] arr1 = new boolean[26]; 
        for(char c:a.toCharArray()){
            arr1[c-'a']=true;
        }
        return arr1;
    }
    private boolean isSimilarArr(boolean[] arr1,boolean[] arr2){
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i]) return false;
        }
        return true;
    }

    public int similarPairsUsingBitMask(String[] words) {
        int pairs = 0;
        int n = words.length;
        int[] masks = new int[n];
        for (int i = 0; i < n; i++) {
            masks[i] = getMask(words[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (masks[i] == masks[j]) {
                    pairs++;
                }
            }
        }

        return pairs;
    }

    private int getMask(String s) {
        int mask = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            mask |= (1 << s.charAt(i) - 'a');
        }

        return mask;
    }
}
