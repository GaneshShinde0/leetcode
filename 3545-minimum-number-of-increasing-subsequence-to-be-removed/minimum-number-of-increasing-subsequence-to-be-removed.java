class Solution {
    public int minOperations(int[] nums) {
        TreeMap<Integer, Integer> numFreq = new TreeMap<>();
        for (int num : nums) {
            // delete closest frequency below num
            Integer floorKey = numFreq.floorKey(num - 1);
            if (floorKey != null) {
                int floorFreq = numFreq.get(floorKey) - 1;
                if (floorFreq == 0) {
                    numFreq.remove(floorKey);
                } else {
                    numFreq.put(floorKey, floorFreq);
                }
            }
            // increase frequency for num
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }

        int total = 0;
        for (int value : numFreq.values()) {
            total += value;
        }
        return total;
    }
}