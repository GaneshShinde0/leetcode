/*
Basic Idea is to find generate a list of strobogrammatic numbers with the length between low and high, then pass the list and ignore the numbers with same length of lower bound or upper bound but not in the range.
*/

class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int count = 0;
        List<String> numbers = new ArrayList<>();
        for(int i=low.length();i<=high.length();i++){
            numbers.addAll(helper(i,i));
        }
        for(String num:numbers){
            if((num.length()==low.length() && num.compareTo(low)<0)|| (num.length()==high.length() && num.compareTo(high)>0)) continue; 
            count++;
        }
        return count;
    }

    private List<String> helper(int curr, int max){
        if(curr == 0) return Arrays.asList("");
        if(curr==1) return Arrays.asList("1","8","0");
        List<String> result = new ArrayList<>();
        List<String> center = helper(curr-2,max);

        for(int i=0;i<center.size();i++){
            String temp = center.get(i);
            if(curr!=max) result.add("0"+temp+"0");
            result.add("1"+temp+"1");
            result.add("6"+temp+"9");
            result.add("9"+temp+"6");
            result.add("8"+temp+"8");
        }
        return result;
    }
}