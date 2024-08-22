import java.util.ArrayList;
import java.util.List;

class CreateTargetArrayInGivenOrder {
    public int[] createTargetArray(int[] nums, int[] index) {
        // Create an ArrayList to hold the target array
        List<Integer> target = new ArrayList<>();
        
        // Insert elements at the specified positions
        for (int i = 0; i < nums.length; i++) {
            target.add(index[i], nums[i]);
        }
        
        // Convert the ArrayList to an array
        int[] result = new int[target.size()];
        for (int i = 0; i < target.size(); i++) {
            result[i] = target.get(i);
        }
        
        return result;
    }
}
