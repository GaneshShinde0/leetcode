class Solution {
    public String majorityFrequencyGroup(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        int l = s.length();
        int[] freql = new int[l + 1];
        int max_freq = 0;
        int max_freq_group = 0;
        Arrays.fill(freql, 0);

        for (int i = 0; i < l; i++) {

            char present = s.charAt(i);
            freq.put(present, freq.getOrDefault(present, 0)+1);
           
        }

        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            int val = e.getValue();
            freql[val]++;
        }

        for(int i=0;i<=l;i++)
            {
                if((freql[i]>max_freq)||(freql[i]==max_freq&&i>max_freq_group))
                   {
                    max_freq = freql[i];
                    max_freq_group = i;
                   }
            }
        
        StringBuilder ans = new StringBuilder();

        for (Map.Entry<Character, Integer> e : freq.entrySet()) {

            char key = e.getKey();

            int val = e.getValue();

            if (val == max_freq_group) {
                ans.append(key);
            }
        }
        return ans.toString();
    }
}