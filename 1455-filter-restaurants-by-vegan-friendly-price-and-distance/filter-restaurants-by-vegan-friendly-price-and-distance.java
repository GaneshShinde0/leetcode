class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        PriorityQueue<int[]> idToRating = new PriorityQueue<>(
            (a,b)->{
                if(a[1]!=b[1]){
                    return Integer.compare(b[1],a[1]);
                }else{
                    return Integer.compare(b[0],a[0]);
                }
            }
        );
        for(int[] r:restaurants){
            if(r[4]<=maxDistance && r[3]<=maxPrice && (veganFriendly==0||r[2]==veganFriendly)){
                idToRating.add(new int[]{r[0],r[1]});
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!idToRating.isEmpty()){
            result.add(idToRating.poll()[0]);
        }
        return result;
    }
}