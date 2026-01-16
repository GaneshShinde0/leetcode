class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        arr = Arrays.stream(arr).boxed().sorted((a,b)->Integer.compare(Math.abs(a-x),Math.abs(b-x))).mapToInt(i->i).toArray();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<k;i++){
            result.add(arr[i]);
        }
        result.sort(Comparator.comparingInt(a->a));
        return result;
    }
}