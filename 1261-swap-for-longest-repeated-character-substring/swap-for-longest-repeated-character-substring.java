class Solution {
    public int maxRepOpt1(String text) {
        List<List<Integer>> li = new ArrayList<>();
        int[] freq = new int[26];
        for(int i=0;i<text.length();i++){
            char c = text.charAt(i);
            int size = li.size();
            if(size>0 && li.get(size-1).get(0)==(int) c){
                int currGroupSize = li.get(size-1).get(1);
                li.get(size-1).set(1,currGroupSize+1);
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add((int) c);
                temp.add(1);
                li.add(temp);
            }
            freq[c-'a']++;
        }
        int result = 0;
        for(List<Integer> temp:li){
            result = Math.max(Math.min(temp.get(1)+1, freq[temp.get(0)-'a']),result);
        }

        for(int i=1;i<li.size()-1;i++){
            List<Integer> curr = li.get(i);
            List<Integer> prev = li.get(i-1);
            List<Integer> next = li.get(i+1);
            if(prev.get(0)==next.get(0) && curr.get(1)==1){
                result = Math.max(result, Math.min(prev.get(1)+next.get(1)+1, freq[prev.get(0)-'a']));
            }
        }
        return result;
    }
}