class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        // Arrays.sort(basket1);
        // Arrays.sort(basket2);
        // int n = basket1.length;
        // int sum1=0,sum2=0,swap=0;
        // for(int i=0; i<n; i++){
        //     // sum1+=basket1[i];
        //     // sum2+=basket2[i];
        //     System.out.println("Sum1: "+sum1+", Sum2: "+sum2);
        //     if(basket1[i]!=basket2[i]){
        //         swap++;
        //         sum1 += basket2[i]-basket1[i];
        //         sum2 += -basket2[i]+basket1[i];
        //     }
        // }
        // if(sum1==sum2) return swap/2;
        // else return -1;
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        int m = Integer.MAX_VALUE;
        for(int b1: basket1){
            freq.put(b1, freq.getOrDefault(b1,0)+1);
            m = Math.min(b1,m);
        }
        for(int b2: basket2){
            freq.put(b2, freq.getOrDefault(b2,0)-1);
            m = Math.min(b2,m);
        }
        // System.out.println(freq);

        List<Integer> merge = new ArrayList<>();
        // Add all the elements in the list which are multiple of two
        for(Map.Entry<Integer,Integer> entry:freq.entrySet()){
            int count = entry.getValue();
            if(count%2 != 0) return -1;
            for(int i=0; i<Math.abs(count)/2; i++){
                merge.add(entry.getKey());
            }
        }

        Collections.sort(merge);
        // System.out.println(merge);
        long res = 0;
        // We can sort anything with anything ... Meaning there can be 
        // Multiple entries of same freq in both baskets.
        // [4,4,4,4,3]
        // [5,5,5,5,3]
        // Hence they can be sorted multiple times and returning merge.size()/2 would not be sufficient then

        for(int i=0; i<merge.size()/2; i++){
            res += Math.min(2*m, merge.get(i));
        }

        return res;
    }
}