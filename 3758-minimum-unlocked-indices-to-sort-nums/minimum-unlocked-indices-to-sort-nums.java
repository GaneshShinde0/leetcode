class Solution {
    public int minUnlockedIndices(int[] nums, int[] locked) {
        int n = nums.length;
        int unlocks = 0;
        int mostRightOne = n-1;
// find the most right side 1
        while(mostRightOne>=0 && nums[mostRightOne]!=1) mostRightOne--;
        int index = mostRightOne-1;
        int needToUnlock = 0;
     // now find the most left 2 and count the locks
        while(index>=0) {
            if(locked[index]==1) needToUnlock++;
            if(nums[index]==3) return -1; //not possible to sort since 3-1>1
            if(nums[index]==2) {
                unlocks+=needToUnlock;
                needToUnlock=0;
            }
            index--;
        }

        // now look for the most right 2
        int mostRightTWO = n-1;
        while(mostRightTWO>mostRightOne && nums[mostRightTWO]!=2) mostRightTWO--;
        index = mostRightTWO-1;
        needToUnlock=0;
// now look for the most left 3 num and count the locks
        while(index>mostRightOne) {
            if(locked[index]==1) needToUnlock++;
            if(nums[index]==3) {
                unlocks+=needToUnlock;
                needToUnlock=0;
            }
            index--;
        }

        return unlocks;
    }
}