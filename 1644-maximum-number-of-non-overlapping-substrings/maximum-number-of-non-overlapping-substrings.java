/*
First We will have to divide string at point where no character on left of string contains on right side or vice versa.
*/

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26], last = new int[26];
        Arrays.fill(first,-1);
        for(int i=0;i<n;i++){
            int c = s.charAt(i)-'a';
            if(first[c]==-1) first[c] = i;
            last[c] = i;
        }
        List<int[]> intervals = new ArrayList<>();
        for(int c = 0; c<26; c++){
            if(first[c]==-1) continue;
            int left = first[c], right = last[c];
            int k = left;
            while(k<=right){
                int currChar = s.charAt(k)-'a';
                boolean extended = false;
                if(first[currChar]<left){
                    left = first[currChar];
                    extended = true;
                }
                if(last[currChar]>right){
                    right = last[currChar];
                    extended = true;
                }
                if(extended) k = left;
                else k++;
            }
            intervals.add(new int[]{left, right});
        }
        intervals.sort((a,b)->{
            if(a[1]!=b[1]) return Integer.compare(a[1],b[1]);
            else return Integer.compare(b[0],a[0]); // The one which ends first
        });
        List<String> result = new ArrayList<>();
        int prevEnd = -1;
        for(int[] interval:intervals){
            if(interval[0]>prevEnd){
                result.add(s.substring(interval[0], interval[1]+1));
                prevEnd = interval[1];
            }
        }
        return result;

    }
}
class SolutionDoesNotWork{
    public List<String> maxNumOfSubstrings(String s) {
        List<String> result = new ArrayList<>();
        int[] freq = new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        Set<Long> visited = new HashSet<>();
        helper(result,visited,s, freq,0);
        return result;
    }
    private void helper(List<String> result,Set<Long> visited, String s, int[] freq, int start){
        if(visited.contains(start+s.length()*100000L)) return;
        visited.add(start+s.length()*100000L);
        if(s.length()==1){
            result.add(s);
            return;
        }
        int[] freqOnLeft = new int[26];
        boolean minimalString = true;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            freqOnLeft[c-'a']++;
            if(checkLeftAndRightHaveDiffChars(freq,freqOnLeft)){
                if(i==s.length()-1) continue;
                helper(result, visited, s.substring(0,i+1), freqOnLeft, start);
                helper(result, visited, s.substring(i+1), subtract(freq,freqOnLeft), start+i+1);
                minimalString = false;
            }
        }
        if(minimalString) result.add(s);
    }

    private boolean checkLeftAndRightHaveDiffChars(int[] freq, int[] freqOnLeft){
        for(int i=0;i<26;i++){
            if(freqOnLeft[i]!=0 && freqOnLeft[i]!=freq[i]) return false;
        }
        return true;
    }
    private int[] subtract(int[] freq, int[] freqOnLeft){
        int[] freqOnRight = new int[26];
        for(int i=0;i<26;i++){
            freqOnRight[i] = freq[i]-freqOnLeft[i];
        }
        return freqOnRight;
    }
}