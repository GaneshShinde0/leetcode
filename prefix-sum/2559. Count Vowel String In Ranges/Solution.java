class Solution {
    public int[] vowelStringsTLE(String[] words, int[][] queries) {
        boolean[] flag = new boolean[words.length];
        String vowels = "aeiouAEIOU";
        int[] temp = new int[words.length];
        int prev=0;
        for(int i=0;i<words.length;i++){
            if(vowels.indexOf(words[i].charAt(0))>-1&&vowels.indexOf(words[i].charAt(words[i].length()-1))>-1){
                flag[i]=true;
                temp[i]+=prev+1;
                prev=temp[i];
            }
        }
        int[] res = new int[queries.length];
        int j=0;
        // System.out.println(Arrays.toString(flag));
        for(int[] query:queries){
            int count =0;
            // System.out.println(Arrays.toString(query));
            for(int i=query[0];i<=query[1];i++){
                if(flag[i])count++;
            }
            res[j]=count;
            j++;
        }
        return res;
    }

    public int[] vowelStringsMineBeats74Time6ms(String[] words, int[][] queries) {
        boolean[] flag = new boolean[words.length];
        String vowels = "aeiouAEIOU";
        int[] temp = new int[words.length];
        int prev=0;
        for(int i=0;i<words.length;i++){
            if(vowels.indexOf(words[i].charAt(0))>-1&&vowels.indexOf(words[i].charAt(words[i].length()-1))>-1){
                flag[i]=true;
                temp[i]+=prev+1;
                prev=temp[i];
            }else{
                temp[i]=prev;
            }
        }
        int[] res = new int[queries.length];
        int j=0;
        for(int[] query:queries){
            int count =0;
            // System.out.println(Arrays.toString(query));
            res[j]=temp[query[1]]-temp[query[0]];
            if(flag[query[0]]==true) res[j]+=1;
            j++;
        }
        return res;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u')
        );
        int[] prefixSum = new int[words.length];
        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            if (
                vowels.contains(currentWord.charAt(0)) &&
                vowels.contains(currentWord.charAt(currentWord.length() - 1))
            ) {
                sum++;
            }
            prefixSum[i] = sum;
        }

        for (int i = 0; i < queries.length; i++) {
            int[] currentQuery = queries[i];
            ans[i] =
                prefixSum[currentQuery[1]] -
                (currentQuery[0] == 0 ? 0 : prefixSum[currentQuery[0] - 1]);
        }

        return ans;
    }
}
