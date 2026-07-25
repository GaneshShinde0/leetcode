class Solution {
    public int maxProduct(int n) {
        List<Integer> li = new ArrayList<>();
        while(n>0){
            li.add(n%10);
            n/=10;
        }
        Collections.sort(li);
        return li.get(li.size()-1)*li.get(li.size()-2);
    }
}