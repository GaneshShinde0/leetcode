class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=Integer.MIN_VALUE;
        for(int i:candies){
            if(i>max) max=i;
        }

        List<Boolean> li = new ArrayList<>();
        for(int i:candies){
            li.add((i+extraCandies)>=max);
        }
        return li;
    }
}