class Solution {
    public List<Integer> findLonely(int[] nums) {
        int[] freq = new int[1000001];
        List<Integer> res = new ArrayList<>();
        for(int i:nums){
            freq[i]++;
        }
        for(int i=1;i<1000000;i++){
            if(freq[i]==1 && freq[i-1]==0 && freq[i+1]==0) res.add(i);
        }
        if(freq[0]==1&&freq[1]==0) res.add(0);
        if(freq[1000000]==1&&freq[999999]==0) res.add(1000000);
        return res;
    }

    public List<Integer> findLonelyAlternate(int[] nums) {
        int maxNum = 0;
        for (int num:nums) {
            if (num > maxNum) {
                maxNum = num;
            }
        }
        int[] arr = new int[maxNum+2];
        for (int num:nums) {
            arr[num]++;
        }
        List<Integer> lst = new ArrayList<>();
        for (int num:nums) {
            if (arr[num] == 1 && arr[num+1] == 0) {
                if (num == 0 || arr[num-1] == 0) {
                    lst.add(num);
                }
            }
        }
        return lst;
    }
}
