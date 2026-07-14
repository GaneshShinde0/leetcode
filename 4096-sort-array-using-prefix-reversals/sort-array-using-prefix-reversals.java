class Solution {
    public int sortArray(int[] nums, int[] pre) {
        int res = 0;

        String startStr = Arrays.toString(nums);
        Arrays.sort(nums);
        String targetStr = Arrays.toString(nums);
        if(startStr.equals(targetStr)) return 0;
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.add(startStr);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int j=0;j<size;j++){
                String curr = queue.poll();
                curr = curr.substring(1,curr.length()-1);            
                for(int i:pre){
                    String[] temp = curr.split(", ");
                    reverse(0,i-1,temp);
                    String reversed = Arrays.toString(temp);
                    if(reversed.equals(targetStr)) return res+1;
                    if(!visited.contains(reversed)) queue.add(reversed);
                    visited.add(reversed);
                    System.out.println(reversed);
                }
            }
            res++;
        }
        return -1;
    }
    private void reverse(int start, int end, String [] nums){
        while(start<end){
            String temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}