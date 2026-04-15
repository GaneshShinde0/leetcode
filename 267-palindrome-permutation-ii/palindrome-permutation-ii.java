
class Solution {
    public List<String> generatePalindromes(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int odds = 0;
        String middle = "";
        int[] halfFreq = new int[26];
        int targetLen = s.length()/2;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                middle = "" + (char) (i + 'a');
                odds++;
            }
            if (odds > 1) return new ArrayList<>(); // Early exit if not a palindrome permutation

            halfFreq[i] = freq[i] / 2; // Store only half for permutations
        }

        List<String> result = new ArrayList<>();
        backtrack(halfFreq, targetLen, new StringBuilder(), middle, result);
        return result;
    }
    private void backtrack(int[] halfFreq, int targetLen, StringBuilder current, String middle, List<String> res) {
        if (current.length() == targetLen) {
            String half = current.toString();
            String full = half + middle + new StringBuilder(half).reverse().toString();
            res.add(full);
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (halfFreq[i] > 0) {
                halfFreq[i]--; // Choose
                current.append((char) (i + 'a'));
                
                backtrack(halfFreq, targetLen, current, middle, res);
                
                current.deleteCharAt(current.length() - 1); // Un-choose
                halfFreq[i]++;
            }
        }
    }
}

class Solution1 {
    Set<String> set = new HashSet<>();
    public List<String> generatePalindromes(String s) {
        int[] freq = new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        int odds = 0;
        String middle = "";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            if(freq[i]%2==1){
                middle = ""+(char) (i+'a');
                odds++;
            }
            if(odds == 2)  return new ArrayList<>(set);
            for (int j = 0; j < freq[i] / 2; j++) {
                sb.append((char) (i + 'a'));
            }
        }
        permutations(0,sb.toString(),middle);
        return new ArrayList<>(set);
    }

    private void permutations(int start, String s, String middle){
        if(start==s.length()){
            StringBuilder sb = new StringBuilder(s);
            sb.append(middle);
            String reverse = sb.reverse().toString();
            set.add(s+reverse);
        }else{
            for(int i=start;i<s.length();i++){
                s = swap(s,i,start);
                permutations(start+1,s,middle);
                s = swap(s,i,start);
            }
        }
    }

    private String swap(String s, int i, int j){
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}