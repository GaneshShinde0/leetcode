class Solution {
    public long minOperations(int[] nums, int k) {
        int n = nums.length;
        PQ above = new PQ(); // maintain invariant - size is always = k/2(except when adding first k/2-1 elements))
        PQ bellow = new PQ(); // rest of the elements goes here. 
        // Note bellow contains negated numbers so that i get PQ sorted by max value
        long result = -1;
        for (int i = 0; i < n; i++) {
            
            // adding next element
            // add one and poll min into bellow (up remainks k/2 size)
            above.add(nums[i]);
            if (above.size() > k/2) {
                int x = -above.pollMin();
                bellow.add(x);
            }

            // removing nums[i-k]
            // try to remove it from bellow, if its there - great 
            // if not there then remove it from above but then i need to poll one from bellow to maintain invariant
            if (i >= k) {
                if (!bellow.remove(-nums[i-k])) {
                    above.remove(nums[i-k]);
                    above.add(-bellow.pollMin());
                }
            }

            // skip if not enought elements in the array
            if (above.size() + bellow.size() != k) continue;

            // so for k odd this is obvious
            // but for k even it actually can be any number from -bellow.peekMin() to above.peekMin() 
            long md = -bellow.peekMin();

            // 
            long curr = bellow.sum() + md*bellow.size() + above.sum() - md*above.size();
            if (result == -1) result = curr;
            else result = Math.min(result, curr);
        }
        return result;
    }

    static class PQ {
        TreeMap<Integer, Integer> tree;
        int n;
        long sum;
        PQ() {
            tree = new TreeMap<Integer, Integer>();
            n = 0;
            sum = 0;
        }

        void add(int x) {
            tree.put(x, tree.getOrDefault(x, 0)+1);
            n++;
            sum += x;
        }

        int peekMin() {
            return tree.firstKey();
        }

        int pollMin() {
            int x = tree.firstKey();
            remove(x);
            return x;
        }

        int size() {
            return n;
        }

        long sum() {
            return sum;
        }

        boolean remove(int x) {
            if (!tree.containsKey(x)) return false;
            tree.put(x, tree.get(x)-1);
            if (tree.get(x) == 0) tree.remove(x);
            sum -= x;
            n--;
            return true;
        }
    }
}