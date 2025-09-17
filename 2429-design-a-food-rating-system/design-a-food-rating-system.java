// class FoodRatings {
//     private static class Pair{
//         String cuisine;
//         int rating;
//         Pair(String cuisine, int rating){
//             this.cuisine = cuisine;
//             this.rating = rating;
//         }
//     }
//     Map<String,TreeSet<String>> cuisineToFood = new HashMap<>();
//     Map<String,Integer> foodToRating = new HashMap<>();
//     public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
//         int n = foods.length;
//         for(int i=0;i<n;i++){
//             cuisineToFood.computeIfAbsent(cuisines[i], k -> new TreeSet<>()).add(foods[i]);
//             foodToRating.put(foods[i],ratings[i]);
//         }
//     }
    
//     public void changeRating(String food, int newRating) {
//         foodToRating.put(food,newRating);
//     }
    
//     public String highestRated(String cuisine) {
//         TreeSet<String> li = cuisineToFood.get(cuisine);
//         int max = Integer.MIN_VALUE;
//         String res ="";
//         for(String s:li){
//             if(foodToRating.get(s)>max){
//                 max = foodToRating.get(s);
//                 res=s;
//             }
//         }
//         return res;
//     }
// }

class FoodRatings {
    private Map<String, TreeSet<String>> cuisineToFood = new HashMap<>();
    private Map<String, Integer> foodToRating = new HashMap<>();
    private Map<String, String> foodToCuisine = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for(int i = 0; i < n; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToRating.put(food, rating);
            foodToCuisine.put(food, cuisine);

            cuisineToFood.computeIfAbsent(cuisine, k -> new TreeSet<>((a, b) -> {
                int diff = foodToRating.get(b) - foodToRating.get(a);
                if (diff == 0) return a.compareTo(b);
                return diff;
            })).add(food);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        TreeSet<String> set = cuisineToFood.get(cuisine);
        
        // Remove old entry, update rating, then re-insert
        set.remove(food);
        foodToRating.put(food, newRating);
        set.add(food);
    }
    
    public String highestRated(String cuisine) {
        return cuisineToFood.get(cuisine).first();
    }
}
