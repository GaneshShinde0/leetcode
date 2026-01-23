class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> fruitToCount = new HashMap<>();
        int left =0, result = 0;
        for(int right =0;right<fruits.length;right++){
            fruitToCount.put(fruits[right],fruitToCount.getOrDefault(fruits[right],0)+1);
            if(fruitToCount.size()>2){
                fruitToCount.put(fruits[left],fruitToCount.getOrDefault(fruits[left],0)-1);
                if(fruitToCount.get(fruits[left])==0) fruitToCount.remove(fruits[left]);
                left++;
            }
            result= Math.max(right-left+1,result);
        }
        return result;
    }
}