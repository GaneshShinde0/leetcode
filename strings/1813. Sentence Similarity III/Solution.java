class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        
        String[] s1arr = s1.split(" ");
        String[] s2arr = s2.split(" ");

        if(s1arr.length<s2arr.length){
            return areSentencesSimilar(s2,s1);
        }
        int left=0, right=s2arr.length, s1right=s1arr.length;
        while(left<right){
            // System.out.println("S2 Left: "+s2arr[left]+"S2 right: "+s2arr[right-1]);
            // System.out.println("S1 Left: "+s1arr[left]+"S1 right: "+s1arr[s1right-1]);
            if(s1arr[left].equals(s2arr[left])){
                left++;
            }else if(s1arr[s1right-1].equals(s2arr[right-1])){
                right--;
                s1right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
