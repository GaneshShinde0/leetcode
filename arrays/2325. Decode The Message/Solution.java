class Solution {
    public String decodeMessage(String key, String message) {
        key = key.replace(" ","");
        int len = message.length();
        char[] keys = new char[26];
        boolean[] visited = new boolean[26];
        int keysIndex=0;
        for(char c:key.toCharArray()){
            if(!visited[c-'a'] && keys[keysIndex]=='\0') {
                keys[keysIndex]=c;
                visited[c-'a']=true;
                ++keysIndex;
            }
        }
        key = new String(keys);
        char[] result = message.toCharArray();
        for(int i=0;i<len;i++){
            int temp = key.indexOf(result[i]);
            if(temp!=-1){
                result[i]= (char) ('a'+temp);
            }
        }
        return new String(result);
    }
}
