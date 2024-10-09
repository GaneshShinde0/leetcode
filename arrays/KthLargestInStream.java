// Following approach uses heap and takes about 10ms
class KthLargestInStream {

    private int size = 0;
    private final int k;
    private final int[] heap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new int[k + 1];
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        
        if (size == k) {
            if (val < heap[1]) {
                return heap[1];
            }
            pop();
        }

        heap[++size] = val;

        int index = size;
        int parent = size / 2;

        while (heap[parent] > heap[index] && index > 1) {

            int temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;

            index = parent;
            parent = parent / 2;
        }

        return heap[1];
    }

    public void pop() {
        heap[1] = heap[size--];

        int index = 1;
        while (index <= size / 2) {
            int left = index * 2;
            int right = (index * 2) + 1;

            if (heap[index] > heap[left] || heap[index] > heap[right]) {
                if (heap[left] < heap[right]) {
                    int temp = heap[left];
                    heap[left] = heap[index];
                    heap[index] = temp;
                    index = left;
                } else {
                    int temp = heap[right];
                    heap[right] = heap[index];
                    heap[index] = temp;
                    index = right;
                }
            } else {
                break;
            }
        }
    }

}

// Optimized one
class KthLargestTakes26ms {
    List<Integer> stream;
    int k;

    //This is same as mine 
    public KthLargestTakes26ms(int k, int[] nums){
        stream = new ArrayList<Integer>(nums.length);
        this.k = k;

        for(int num:nums){
            stream.add(num);
        }
        Collections.sort(stream);
    }

    public int add(int val){
        int index = getIndex(val);
        stream.add(index,val);
        return stream.get(stream.size()-k);
    }

    // Following is the logic for getting index where val should be inserted.
    // We simply use binary search which has time complexity of logn;
    private int getIndex(int val){
        int left =0;
        int right=stream.size()-1;

        while(left<=right){
            int mid = (left+right)/2;
            int midElement = stream.get(mid);
            if (midElement == val) return mid;
            if (midElement>val){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}

// Following has time complexity of O(n) for add and sort  O(nlogn);
class KthLargestVerySlow500ms {
    private int k;
    private List<Integer> nums;
    int count=0;

    public KthLargestVerySlow500ms(int k, int[] nums) {
        this.k=k;
        this.nums=new ArrayList<>();
        for (int i : nums) {
            this.nums.add(i);
            count++;
        }
        Collections.sort(this.nums,Collections.reverseOrder());
    }
    
    public int add(int val) {
        int i=0;
        while(nums.size()>i&& val<nums.get(i)){
            i++;
        }
        nums.add(i,val);
        /*
        nlogn time complexity
        nums.add(val);
        Collections.sort(nums,Collections.reverseOrder());
        */
        return nums.get(k-1);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
