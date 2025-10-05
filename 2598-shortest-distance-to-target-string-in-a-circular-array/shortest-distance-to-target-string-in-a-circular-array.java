class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int res=words.length;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(target)){
                res=Math.min(Math.abs(i-startIndex),res);
                res = Math.min(res, words.length-i+startIndex);
                res = Math.min(res, words.length+i-startIndex);
            }
        }
        return res==words.length?-1:res;
    }
}