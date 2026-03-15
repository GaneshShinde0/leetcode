/*
Basic Idea is to find generate a list of strobogrammatic numbers with the length between low and high, then pass the list and ignore the numbers with same length of lower bound or upper bound but not in the range.
*/

class Solution {
    public int strobogrammaticInRange(String low, String high) {
        List<String> numbers = new ArrayList<>();
        for(int i=low.length();i<=high.length();i++){
            numbers.addAll(helper(i,i));
        }
        int result = 0;
        for(String num:numbers){
            if( (num.length()==low.length() && num.compareTo(low)<0) || (num.length()==high.length() && num.compareTo(high)>0)) continue;
            result++;
        }
        return result;
    }

    private List<String> helper(int curr, int max){
        if(curr==0) return Arrays.asList("");
        if(curr==1) return Arrays.asList("0","1","8");
        List<String> middleElements = helper(curr-2, max);
        List<String> result = new ArrayList<>();
        for(String middle:middleElements){
            if(curr!=max) result.add("0"+middle+"0");
            result.add("1"+middle+"1");
            result.add("6"+middle+"9");
            result.add("9"+middle+"6");
            result.add("8"+middle+"8");
        }
        return result;
    }
}