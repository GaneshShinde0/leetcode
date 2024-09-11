class Solution {
    public int[] relativeSortArrayHm(int[] arr1, int[] arr2) {
        // HashMap to store the frequency of each element in arr1
        Map<Integer, Integer> hm = new HashMap<>();
        for (int num : arr1) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        int index = 0;
        // First, place elements from arr2 in arr1 based on their order in arr2
        for (int num : arr2) {
            int count = hm.getOrDefault(num, 0);
            for (int i = 0; i < count; i++) {
                arr1[index++] = num;
            }
            // Remove the processed element from the map
            hm.remove(num);
        }

        // Then, place the remaining elements from the map in ascending order
        for (int key : hm.keySet()) {
            int count = hm.get(key);
            for (int i = 0; i < count; i++) {
                arr1[index++] = key;
            }
        }
        
        return arr1;
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Frequency array to store the count of each element in arr1
        int[] count = new int[1001];
        for (int num : arr1) {
            count[num]++;
        }

        int index = 0;
        // First, place elements from arr2 in arr1 based on their order in arr2
        for (int num : arr2) {
            while (count[num] > 0) {
                arr1[index++] = num;
                count[num]--;
            }
        }

        // Then, place the remaining elements from arr1 in ascending order
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr1[index++] = i;
                count[i]--;
            }
        }
        return arr1;
    }
}
