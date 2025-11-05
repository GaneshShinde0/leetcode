/*
Find Frequency of first K elements. HashMap<>();
- We have to get elements with highest frequency ... Can be done through iteration.
    - but value of k and n is large so time complexity will be ((10^5*10^5)/4)
- Use sliding window of size k.
- Reduce Frequency of element at i-k
- Add frequency of element at i

- Trick is to get element with max frequency. 
- There should be some data structure or some variant of 

Can I store TreeMap by Order of values.. What if I use HashMap<Integer, PQ<Integer>> ... this way I will get frequency ... based on that frequency get highest element of pq ... in next iteration remove that element from that value... add once more with i-k and I recalculation.

*/
/*
Approach: HashTable + Ordered Set

- We need a data strucutre, that allows
    - Add
    - Delete
    - Calculate x-sum of all current elements.
- X sum is sum of x most frequently occuring elements. (We can use sorted set to maintain these elements and their frequencies )
    - A set larget for most frequently occuring x elements.
    - A set small for the remaining elements.

Each item in a sorted set is a tuple (freq, num), representing the element num and its frequency freq. Both sorted sets are maintained in ascending order based on freq as the primary key and num as the secondary key.

When we add an element num, we first obtain its freq, if freq>0 freq+1,num; or 1 if its new
When we delete we will do freq-1, num

For adding (freq, num) to an ordered set:
- If number of tuples in large is less than x, add(freq, num) to large.
- If (freq, num) is smaller than the smallest pair in large, add it to small.
- Otherwise, remove the smallest tuple from large, move it to small, and add (freq, num) to large

For removing (freq, num) from an ordered set:
- If (freq, num) is smaller than the smallest pair in large, it belongs to small and should be removed from it. 
- Otherwise, it is removed from large. At this point, if small is not empty, the largest tuple in small is moved to large.

The frequency freq of each element can be maintained using an auxiliary hash table. Whenever a pair is added to or removed from large, we increase or decrease freq*num accordingly. This allows us to efficiently obtain the x-sum at any moment.

*/

class Helper{

    private int x;
    private long result;
    private TreeSet<Pair> large, small;
    private Map<Integer, Integer> freq;

    public Helper(int x){
        this.x = x;
        this.result = 0;
        this.large = new TreeSet<>();
        this.small = new TreeSet<>();
        this.freq = new HashMap<>();
    }
    private static class Pair implements Comparable<Pair>{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair pair){
            if(this.first != pair.first){
                return Integer.compare(this.first, pair.first);
            }
            return Integer.compare(this.second, pair.second);
        }

        @Override
        public boolean equals(Object obj){
            if(this == obj) return true;
            if(obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode(){
            return Objects.hash(first, second);
        }
    }

    public void insert(int num){
        if(freq.containsKey(num) && freq.get(num)>0){
            internalRemove(new Pair(freq.get(num), num));
        }
        freq.put(num, freq.getOrDefault(num,0)+1);
        internalInsert(new Pair(freq.get(num), num));
    }
    public void remove(int num){
        internalRemove(new Pair(freq.get(num),num));
        freq.put(num, freq.get(num)-1);
        if(freq.get(num)>0) internalInsert(new Pair(freq.get(num),num));
    }
    public long get(){ return result; }

    private void internalInsert(Pair p){
        if(large.size()<x || p.compareTo(large.first())>0){
            result += (long) p.first*p.second;
            large.add(p);
            if(large.size()>x){
                Pair toRemove = large.first();
                result -= (long) toRemove.first * toRemove.second;
                large.remove(toRemove);
                small.add(toRemove);
            }
        }else{
            small.add(p);
        }
    }

    private void internalRemove(Pair p){
        if(p.compareTo(large.first())>=0){
            result -= (long) p.first*p.second;
            large.remove(p);
            if(!small.isEmpty()){
                Pair toAdd = small.last();
                result += (long) toAdd.first * toAdd.second;
                small.remove(toAdd);
                large.add(toAdd);
            }
        }else{
            small.remove(p);
        }
    }
}
class Solution {

    public long[] findXSum(int[] nums, int k, int x) {
        Helper helper = new Helper(x);
        List<Long> ans = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            helper.insert(nums[i]);
            if(i>=k) helper.remove(nums[i-k]);
            if(i>=k-1) ans.add(helper.get());
        }
        return ans.stream().mapToLong(Long::longValue).toArray();
    }
}