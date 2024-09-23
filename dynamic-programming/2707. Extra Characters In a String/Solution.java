class Solution {
    public int minExtraCharFails37TestCases(String s, String[] dictionary) {
        Arrays.sort(dictionary, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.length()>b.length()) return -1;
                else if(a.length()<b.length()) return 1;
                else return 0;
            }
        });
        // System.out.println(Arrays.toString(dictionary));
        for(String word:dictionary){
            s=s.replace(word,"");
        }
        System.out.println(s);
        return s.length();
    }

    public int minExtraChar(String s, String[] dictionary){
        int n = s.length();
        Set<String> hs = new HashSet<>(Arrays.asList(dictionary));
        var dp = new int[n+1];
        for(int start = n-1;start>=0;start--){
            dp[start] = dp[start+1]+1;
            for(int end = start;end<n;end++){
                var curr = s.substring(start,end+1);
                if(hs.contains(curr)){
                    dp[start] = Math.min(dp[start],dp[end+1]);
                }
            }
        }
        return dp[0];
    }
}
