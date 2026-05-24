class Solution1{
    public int[] numberOfPairsInitial(int[] nums1, int[] nums2, int[][] queries) {
        HashMap<Integer,Integer> num1Freq= new HashMap<>();
        for(int i:nums1) num1Freq.put(i, num1Freq.getOrDefault(i,0)+1);
        List<Integer> li = new ArrayList<>();
        for(int[] query:queries){
            if(query[0]==1){
                addInRange(nums2,query[1],query[2],query[3]);
            }else if(query[0]==2){
                int target = query[1];
                int count = 0;
                for(int num:nums2){
                    if(num1Freq.containsKey(target-num)){
                        count+=num1Freq.get(target-num);
                    }
                }
                li.add(count);
            }
        }
        int[] res = li.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }
    private void addInRange(int[] arr, int start, int end, int val){
        for(int i=start;i<=end;i++){
            arr[i]+=val;
        }
    }
    public int[] numberOfPairs(int[] nums1, int[] nums2, int[][] queries){
        Map<Integer,Integer> freq1 = new HashMap<>();
        Map<Integer,Integer> freq2 = new HashMap<>();
        for(int i:nums1) freq1.put(i, freq1.getOrDefault(i,0)+1);
        for(int i:nums2) freq2.put(i, freq2.getOrDefault(i,0)+1);
        List<Integer> li = new ArrayList<>();
        for(int[] query:queries){
            if(query[0]==1){
                int start = query[1], end = query[2], val = query[3];
                for(int i=start;i<=end;i++){
                    int prev = nums2[i];
                    freq2.put(prev, freq2.get(prev)-1);
                    if (freq2.get(prev) == 0) {
                        freq2.remove(prev);
                    }
                    nums2[i]+=val;
                    freq2.put(nums2[i],freq2.getOrDefault(nums2[i],0)+1);
                }
            }else if(query[0]==2){
                int target = query[1];
                int count = 0;
                for(Map.Entry<Integer, Integer> e:freq2.entrySet()){
                    int num2 = e.getKey();
                    int freqNum2 = e.getValue();
                    count += freqNum2*freq1.getOrDefault(target-num2,0);
                }
                li.add(count);
            }
        }
        int[] res = li.stream().mapToInt(Integer::intValue).toArray();
        return res;  
    }
}
class Solution {
    int B;
    int[] a;
    int[] lazy;
    HashMap<Integer, Integer>[] freq;
    public int[] numberOfPairs(int[] nums1, int[] nums2, int[][] queries) {
        build(nums2);
        ArrayList<Integer> res = new ArrayList<>();
        for(int[] q:queries){
            if(q[0]==1){
                int start = q[1], end = q[2], val = q[3];
                rangeAdd(start, end, val);
            }else{
                int total = q[1];
                int pairs = 0;
                for(int x:nums1){
                    int need = total-x;
                    pairs+=countValue(need);
                }
                res.add(pairs);
            }
        }
        int[] ans = new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }

    void build(int[] nums2){
        int n = nums2.length;
        a = nums2;
        B = (int) Math.sqrt(n)+1;
        int blocks = (n+B-1)/B;
        lazy  = new int[blocks];
        freq = new HashMap[blocks];
        for(int i=0;i<blocks;i++){
            freq[i] = new HashMap<>();
        }
        for(int i=0;i<n;i++){
            int b = i/B;
            freq[b].put(a[i], freq[b].getOrDefault(a[i],0)+1);
        }
    }

    void rebuild(int b){
        freq[b].clear();
        int l = b*B;
        int r = Math.min(a.length-1,l+B-1);
        for (int i = l; i <= r; i++) {
            freq[b].put(a[i], freq[b].getOrDefault(a[i], 0) + 1);
        }
    }
    void push(int b){
        if(lazy[b]==0) return;
        int l = b*B;
        int r = Math.min(a.length-1, l+B-1);
        for(int i=l;i<=r;i++){
            a[i]+=lazy[b];
        }
        lazy[b]=0;
    }
    void rangeAdd(int l, int r, int val){
        int bl = l/B, br = r/B;
        if(bl==br){
            push(bl);
            for(int i=l;i<=r;i++){
                a[i]+=val;
            }
            rebuild(bl);
            return;
        }
        push(bl);
        int end1 = (bl+1)*B-1;
        for(int i=l;i<=end1;i++){
            a[i]+=val;
        }
        rebuild(bl);
        for(int b = bl+1;b<br;b++){
            lazy[b]+=val;
        }
        push(br);
        int start2 = br*B;
        for(int i=start2;i<=r;i++) a[i]+=val;
        rebuild(br);
    }

    int countValue(int x){
        int ans = 0;
        for(int b=0;b<freq.length;b++){
            int need = x-lazy[b];
            ans+=freq[b].getOrDefault(need,0);
        }
        return ans;
    }
}