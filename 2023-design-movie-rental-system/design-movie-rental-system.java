/*

Movie Rental System
- n shops.
- searching, booking, returnig movies & generate report of currently rented movvies.
- Each movie is given as a 2D integer array entry, inside entries
- entries[i] = [shop i, movie i, price i]; indicates ith movie is present in shop and has price.

Functional Requirements:
- Search: 
    - Find cheapest 5 shops that have movie, shops should be sorted by price in ascending order and case of tie, the one with smaller shop i should appear first. (use comparator here).
    - If there are less than 5 matching shop, return them. If no shops return empty List.
- Rent:
    - Rents an unrented copy of a given movie from a given shop.
- Drop:
    - Drops off a previously rented copy of a given movie at a given shop.
- Report:
    - Return 5 cheapest rented movies. (possibly of the same movie id) as a 2d list res where res[j]=[shop j, movie j] describes that the jth cheapest rented movie movie j was rented from the shop shop j. The movies in res should be sorted by price in ascending order, and in case of a tie, the one with smaller shop j should appear first, and if there is still tie, the one with the smaller movie j should appear first.

Intuition:
- We need to support fast queries for two different lists:
1. Available copies per movie -> for search();
2. All Rented copies -> for report();

- Both must be sorted by (price -> shop -> movie) order.
- Also we need to quickly move a copy from available -> rented (rent) and rented -> available (drop).

So Main Idea:
- Use ordered sets (TreeSet) to always keep elements sorted automatically.
- Use a map (shop, movie)-> node for O(1) lookup when moving between sets.

# Approach:
1. Data Structures used.
- availableByMovie -> movieid -> TreeSet (All available copies of this movie, sorted by price/shop).
- rentedSet -> single TreeSet contianing all rented movies.
- byPair-> quick map to find (shop,movie) -> Node.

2. search(movie):
- Lookup avaialbleByMovie.
- Take upto 5 cheapest shops (treeSet); first 5 of treeSet

3. Rent(shop, movie):
- Lookup node.
- Remove it from availableByMovie(movieId);
- Add it to rentedSet.

4. drop(shop, movie):
- Remove from rentedSet
- Add backinto availableByMovie(movie)

5. Report ():
- Take up to 5 from rentedSet(already sorted).

# Complexity
- Time Complexity: O(ElogE+QLogE)
- Where Q = Number of operations performed.
- Space Complexity: O(E).
*/

class MovieRentingSystem {

    private static class Node{
        final int shop;
        final int movie;
        final int price;
        Node(int shop, int movie, int price){
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }
    }

    // Order: price, shop, movie (Strict: never returns 0 for distinct nodes)
    private static final Comparator<Node> CMP = (a,b)->{
        int c = Integer.compare(a.price, b.price);
        if(c!=0) return c;
        c = Integer.compare(a.shop, b.shop);
        if(c!=0) return c;
        return Integer.compare(a.movie, b.movie);
    };

    // Available copies grouped by movie
    private final Map<Integer, TreeSet<Node>> availableByMovie = new HashMap<>();
    // All Currently rented copies
    private final TreeSet<Node> rentedSet = new TreeSet<>(CMP);
    // Quickly lookup from (shop, movies)-> Node
    private final Map<Long, Node> byPair = new HashMap<>();

    private static long key(int shop, int movie){
        return (((long) shop)<<32)^(movie & 0xffffffffL);
    }
    public MovieRentingSystem(int n, int[][] entries) {
        for(int[] e:entries){
            int shop = e[0],movie = e[1], price = e[2];
            Node node = new Node(shop, movie, price);
            byPair.put(key(shop,movie),node);
            availableByMovie.computeIfAbsent(movie,k->new TreeSet<>(CMP)).add(node);
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> ans = new ArrayList<>(5);
        TreeSet<Node> set = availableByMovie.get(movie);
        if(set ==null || set.isEmpty()) return ans;
        Iterator<Node> it = set.iterator();
        for(int i=0;i<5&&it.hasNext();i++) ans.add(it.next().shop);
        return ans;
    }
    
    public void rent(int shop, int movie) {
        long k = key(shop,movie);
        Node node = byPair.get(k);
        if(node == null) return;
        TreeSet<Node> set = availableByMovie.get(movie);
        if(set!=null) set.remove(node);
        rentedSet.add(node);
    }
    
    public void drop(int shop, int movie) {
        long k = key(shop,movie);
        Node node = byPair.get(k);
        if(node == null) return; // Defensive
        rentedSet.remove(node);
        availableByMovie.computeIfAbsent(movie, x-> new TreeSet<>(CMP)).add(node);
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>(5);
        Iterator<Node> it = rentedSet.iterator();
        for(int i=0;i<5 && it.hasNext();i++){
            Node n = it.next();
            ans.add(Arrays.asList(n.shop, n.movie));
        }
        return ans;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */