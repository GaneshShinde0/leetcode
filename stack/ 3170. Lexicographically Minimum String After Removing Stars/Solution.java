class Solution {
    public String clearStarsTLE(String s) {
        boolean[] removed = new boolean[s.length()];
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length(); i++){

            if(s.charAt(i)=='*'){
                removed[i]=true;
                int temp =i;
                for(int j=0;j<26;j++){
                    if(freq[j]>0){
                        freq[j]--;
                        while(temp>=0){
                            if(!removed[temp]&&s.charAt(temp)==(j+'a')){
                                removed[temp]=true;
                                break;
                            }
                            temp--;
                        }
                        break;
                    }
                    
                }
            }else{
                freq[s.charAt(i)-'a']++;
            }
        }
        for(int i=0;i<s.length();i++){
            if(!removed[i]){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public String clearStars(String s){
        Deque<Integer>[] cnt = new Deque[26];
        for(int i=0; i<26; i++){
            cnt[i]= new ArrayDeque<>(); 
        }

        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i]!='*'){
                cnt[arr[i]-'a'].push(i);
            }else{
                for(int j=0; j<26;j++){
                    if(!cnt[j].isEmpty()){
                        arr[cnt[j].pop()] = '*';
                        break;
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for(char c: arr){
            if(c!='*'){
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
