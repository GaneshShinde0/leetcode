class SolutionInitial {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int n  = nums.length;
        List<Integer> li = new ArrayList<>();
        for(int i:nums){
            hm.put(i, hm.getOrDefault(i,0)+1);
            if(hm.get(i)==(n/3+1)) li.add(i);
        }
        return li;
    }
}
class SolutionWithWrapperClasses {
    public List < Integer > majorityElement(int[] nums) {
        int count1 =0, count2=0, len= nums.length;
        Integer candidate1 = null, candidate2 = null;
        for (int n: nums) {
            if (candidate1 != null && candidate1 == n) {
                count1++;
            } else if (candidate2 != null && candidate2 == n) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = n;
                count1++;
            } else if (count2 == 0) {
                candidate2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(Integer num:nums){
            if(num.equals(candidate1)) count1+=1;
            if(num.equals(candidate2)) count2+=1;
        }
        List<Integer> result = new ArrayList<>();
        if(count1>len/3) result.add(candidate1);
        if(count2>len/3 && candidate1!=candidate2) result.add(candidate2);
        
        return result;
    }
}

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int candidate1 = 0, candidate2 = 0;

        // 1st Pass: Find potential candidates
        for (int n : nums) {
            if (n == candidate1) {
                count1++;
            } else if (n == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = n;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // 2nd Pass: Verify candidates
        count1 = 0;
        count2 = 0;
        for (int n : nums) {
            if (n == candidate1) {
                count1++;
            } else if (n == candidate2) {
                // The 'else if' ensures we don't double count if 
                // candidate1 and candidate2 happen to be the same value.
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;
        
        if (count1 > threshold) result.add(candidate1);
        if (count2 > threshold) result.add(candidate2);

        return result;
    }
}