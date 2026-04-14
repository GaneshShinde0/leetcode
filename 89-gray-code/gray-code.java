class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> li = new ArrayList<>();
        li.add(0);
        for(int i=1;i<=n;i++){
            int size = li.size();
            for(int j=size-1;j>=0;j--){
                li.add(li.get(j)+(1<<(i-1)));
            }
        }
        return li;
    }
}
/*
1 => [0,1]
2 => [0,1,3,2]
3 => [0,1,3,2,6,7,5,4]
*/