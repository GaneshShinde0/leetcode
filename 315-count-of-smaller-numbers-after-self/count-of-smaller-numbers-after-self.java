
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int offset = 10000;
        int size = 2*10000+2;
        int[] tree = new int[size];
        List<Integer> result = new ArrayList<Integer>();
        for(int i=nums.length-1;i>=0;i--){
            int smallerCount = query(nums[i]+offset, tree);
            result.add(smallerCount);
            update(nums[i]+offset, 1, tree, size);
        }
        Collections.reverse(result);
        return result;
    }

    private void update(int index, int value, int[] tree, int size){
        index++;
        while(index<size){
            tree[index]+=value;
            index+=index&-index;
        }
    }

    private int query(int index, int[] tree){
        int result = 0;
        while(index>=1){
            result += tree[index];
            index -= index&-index;
        }
        return result;
    }
}