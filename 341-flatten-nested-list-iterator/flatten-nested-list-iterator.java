/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    int i;
    int size;
    List<Integer> li;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.i = 0;
        this.li = new ArrayList<>();
        addIntegers(nestedList);
        this.size = li.size();
    }

    private void addIntegers(List<NestedInteger> nestedList){
        for(int j=0;j<nestedList.size();j++){
            NestedInteger curr = nestedList.get(j);
            if(curr.isInteger()){
                this.li.add(curr.getInteger());
            }else{
                addIntegers(curr.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if(hasNext()){
            i++;
            return li.get(i-1);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return i<size;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */