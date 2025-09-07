import java.util.*;

public class Solution {

    public long bowlSubarraysInitial(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0L;

        // 1) Next Greater-or-Equal to the right (NGE>=)
        int[] nextGE = new int[n];
        Arrays.fill(nextGE, -1);
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // While current >= top, this is the NGE>= for that top
            while (!st.isEmpty() && nums[i] >= nums[st.peekLast()]) {
                nextGE[st.pollLast()] = i;
            }
            st.addLast(i);
        }

        // Count bowls where the smaller endpoint is on the left (or equal)
        long count = 0;
        for (int i = 0; i < n; i++) {
            int r = nextGE[i];
            if (r != -1 && r - i >= 2) count++;
        }

        // 2) Previous Greater-or-Equal to the left (PGE>=)
        int[] prevGE = new int[n];
        Arrays.fill(prevGE, -1);
        st.clear();
        for (int i = 0; i < n; i++) {
            // Maintain stack with values >= current on top (pop strictly smaller)
            while (!st.isEmpty() && nums[st.peekLast()] < nums[i]) {
                st.pollLast();
            }
            prevGE[i] = st.isEmpty() ? -1 : st.peekLast();
            st.addLast(i);
        }

        // Count bowls where the smaller endpoint is on the right (strictly smaller)
        for (int r = 0; r < n; r++) {
            int l = prevGE[r];
            if (l != -1 && r - l >= 2 && nums[l] > nums[r]) {
                count++;
            }
        }

        return count;
    }

    public long bowlSubarrays(int[] nums){
        long res = 0;
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        for(int r = 0; r<n; r++){
            int a = nums[r];
            while(!stk.empty() && nums[stk.peek()]<=a){
                int l = stk.pop();
                if(r-l+1>=3){
                    res+=1;
                }
            }
            if(!stk.empty() && r-stk.peek()+1>=3){
                res+=1;
            }
            stk.push(r);
        }
        return res;
    }
}