class Solution {
    public int[] sortByBits(int[] arr) {

        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]:: new);
        // Comparator<Integer> comparator = new CustomComparator();
        Arrays.sort(nums,(a,b)->{
            if(Integer.bitCount(a)==Integer.bitCount(b)) return a-b;
            else return Integer.compare(Integer.bitCount(a),Integer.bitCount(b));
        });
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}