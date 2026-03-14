class Solution {
    public String getHappyString(int n, int k) {
        List<String> li = new ArrayList<>();
        recurse(0,n,k,"",li);
        if(li.size()<k)return ""; 
        return li.get(k-1);
    }
    private void recurse(int i, int n, int k, String s, List<String> li){
        if(s.length()==n){
            li.add(s);
            i++;
            if(i==k) return;
        }else{
            for(char c='a';c<='c';c++){
                if(s.length()==0||s.charAt(s.length()-1)!=c){
                    recurse(i,n,k,s+c,li);
                }
            }
        }
    }
}