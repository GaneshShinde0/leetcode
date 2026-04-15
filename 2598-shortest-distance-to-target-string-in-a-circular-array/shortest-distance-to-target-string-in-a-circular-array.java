class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int result = Integer.MAX_VALUE;
        int n = words.length;
        for(int i=0;i<words.length;i++){
            if(target.equals(words[i])){
                result = Math.min(Math.min(Math.abs(startIndex-i),(n-startIndex)%n+i),result);
                result = Math.min((n-i)%n+startIndex,result);
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}