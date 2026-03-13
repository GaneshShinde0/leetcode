class Solution {
    public List<Integer> minAvailableDurationUsingSort(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1,(a,b)->Integer.compare(a[0],b[0]));
        Arrays.sort(slots2,(a,b)->Integer.compare(a[0],b[0]));
        int p1 =0, p2=0;
        while(p1<slots1.length && p2<slots2.length){
            int left = Math.max(slots1[p1][0],slots2[p2][0]);
            int right = Math.min(slots1[p1][1],slots2[p2][1]);
            if(right-left>=duration){
                return Arrays.asList(left,left+duration);
            }
            // Move one that ends earlier
            // As this ends earlier and it did not contribute to our result in above code, we are safe to ignore it.
            if(slots1[p1][1]<slots2[p2][1]){
                p1++;
            }else{
                p2++;
            }
        }
        return new ArrayList<>();
    }

    // Using Priority Queue
    // As constraints say that intervals for same slots wont overlap.
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

        PriorityQueue<int[]> timeSlots = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(int[] slot:slots1){
            if(slot[1]-slot[0]>=duration) timeSlots.offer(slot);
        }
        for(int[] slot:slots2){
            if(slot[1]-slot[0]>=duration) timeSlots.offer(slot);
        }

        while(timeSlots.size()>1){ // We have two available slots.
            int[] slot1 = timeSlots.poll();
            int[] slot2 = timeSlots.peek();

            if(slot1[1]>=slot2[0]+duration){
                return Arrays.asList(slot2[0],slot2[0]+duration);
            }
        }
        return new ArrayList<>();

    }
}