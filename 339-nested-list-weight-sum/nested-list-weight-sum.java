/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int res =0;
        for(int i=0;i<nestedList.size();i++){
            if(!nestedList.get(i).isInteger()){
                res+=helper(nestedList.get(i).getList(),1);
            }else{
                res+=nestedList.get(i).getInteger();
            }
        }
        return res;
    }
    private int helper(List<NestedInteger> nestedList,int depth){
        int res = 0;
        for(int i=0;i<nestedList.size();i++){
            if(!nestedList.get(i).isInteger()){
                res+=helper(nestedList.get(i).getList(),depth+1);
            }else{
                res+=(depth+1)*nestedList.get(i).getInteger();
            }
        }
        return res;
    }
}