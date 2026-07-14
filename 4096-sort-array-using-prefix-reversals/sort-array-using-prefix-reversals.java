class Solution {
    public int sortArray(int[] nums, int[] pre) {
        List<Integer> start = new ArrayList<>();
        for (int num : nums) {
            start.add(num);
        }
        List<Integer> target = new ArrayList<>(start);
        Collections.sort(target);

        if (start.equals(target)) return 0;

        Queue<List<Integer>> queue = new LinkedList<>();
        Set<List<Integer>> visited = new HashSet<>();
        
        queue.offer(start);
        visited.add(start);

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                List<Integer> curr = queue.poll();
                
                for (int i : pre) {
                    List<Integer> next = new ArrayList<>(curr);
                    Collections.reverse(next.subList(0, i));
                    if (next.equals(target)) {
                        return res + 1;
                    }
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}

class SolutionInitial {
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