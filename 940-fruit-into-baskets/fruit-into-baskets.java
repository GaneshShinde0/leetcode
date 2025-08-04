class Solution {
    public int totalFruit53ms(int[] fruits) {
        int start = 0,end = 0;
        int n = fruits.length,maxLen = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(end<n)
        {
            map.put(fruits[end],map.getOrDefault(fruits[end],0)+1);
            while(map.size()>=3)
            {
                map.put(fruits[start],map.get(fruits[start])-1);
                if(map.get(fruits[start]) == 0) map.remove(fruits[start]);
                start++;
            }
            int currLen = end-start+1;
            maxLen = Math.max(maxLen,currLen);
            end++;
        }
        return maxLen;
    }

    static {
        for (int i = 0; i < 300; i++) {
            totalFruit(new int[0]);
        }
    }
    public static int totalFruit(int[] fruits) {
        int max = 0;
        int type1 = -1, type2 = -1;
        int count1 = 0, count2 = 0;
        int lead = -1, leadIndex = -1;
        for (int i = 0; i < fruits.length; i++) {
            if (type1 == -1 || type1 == fruits[i]) {
                type1 = fruits[i];
                count1++;
                if (lead != type1) {
                    lead = type1;
                    leadIndex = i;
                }
            } else if (type2 == -1 || type2 == fruits[i]) {
                type2 = fruits[i];
                count2++;
                if (lead != type2) {
                    lead = type2;
                    leadIndex = i;
                }
            } else {
                max = Math.max(max, count1+count2);
                if (lead == type1) {
                    count1 = i-leadIndex;
                    type2 = fruits[i];
                    count2 = 1;
                } else {
                    count2 = i-leadIndex;
                    type1 = fruits[i];
                    count1 = 1;
                }
                lead = fruits[i];
                leadIndex = i;
            }
        }

        return Math.max(max, count1+count2);
    }
}