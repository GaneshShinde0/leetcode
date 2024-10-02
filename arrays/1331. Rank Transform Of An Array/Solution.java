class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] res = new int[arr.length];
        res = Arrays.copyOf(arr,arr.length);
        Arrays.sort(res);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.putIfAbsent(res[i],map.size()+1);
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }

    public int[] arrayRankTransformUsingOrderredMap(int[] arr) {
        // Store the rank for each number in arr
        TreeMap<Integer, List<Integer>> numToIndices = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!numToIndices.containsKey(arr[i])) {
                numToIndices.put(arr[i], new ArrayList<>());
            }
            numToIndices.get(arr[i]).add(i);
        }
        int rank = 1;
        for (int num : numToIndices.keySet()) {
            for (int index : numToIndices.get(num)) {
                arr[index] = rank;
            }
            rank++;
        }
        return arr;
    }

    public int[] arrayRankTransformDeduplicatingWithSet(int[] arr) {
        // Store the rank for each number in arr
        HashMap<Integer, Integer> numToRank = new HashMap<>();
        // Deduplicate and sort arr
        TreeSet<Integer> nums = new TreeSet<>();
        for (int num : arr) nums.add(num);
        int rank = 1;
        for (int num : nums) {
            numToRank.put(num, rank);
            rank++;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = numToRank.get(arr[i]);
        }
        return arr;
    }
}
