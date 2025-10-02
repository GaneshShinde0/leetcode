class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordSize = words[0].length(),wordsLength=words.length;
        int n = s.length();
        List<Integer> res = new ArrayList<>();
        if(wordSize==0||wordsLength==0) return res;

        HashMap<String,Integer> originalCount = new HashMap<>();
        for(int i=0;i<words.length;i++){
            originalCount.put(words[i],originalCount.getOrDefault(words[i],0)+1);
        }

        for(int offset = 0; offset<wordSize; offset++){
            HashMap<String,Integer> currentCount = new HashMap<>();
            int start = offset;
            int count = 0;
            for(int end = offset;end+wordSize<=n;end+=wordSize){
                String currWord = s.substring(end,end+wordSize);
                if(originalCount.containsKey(currWord)){
                    currentCount.put(currWord, currentCount.getOrDefault(currWord,0)+1);
                    count++;

                    while(currentCount.get(currWord)>originalCount.get(currWord)){
                        String startWord = s.substring(start,start+wordSize);
                        currentCount.put(startWord, currentCount.get(startWord)-1);
                        start+=wordSize;
                        count--;
                    }

                    if(count == wordsLength) res.add(start);
                }else{
                    count = 0;
                    start=end+wordSize;
                    currentCount.clear();
                }
            }
        }
        return res;
    }
}