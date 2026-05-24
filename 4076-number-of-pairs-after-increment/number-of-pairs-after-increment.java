class Solution{
    public int[] numberOfPairs(int[] nums1, int[] nums2, int[][] queries){
        int n = nums2.length, block = (int) Math.sqrt(n)+1;
        Map<Integer,Integer>[] freq = new Map[block];
        for(int i=0;i<block;i++) freq[i] = new HashMap<>();
        for(int i=0;i<n;i++) freq[i/block].put(nums2[i], freq[i/block].getOrDefault(nums2[i],0)+1);

        int[] lazy = new int[block];
        List<Integer> res = new ArrayList<>();
        for(int[] q:queries){
            if(q[0]==1){
                for(int i=q[1];i<=q[2];){
                    int b = i/block;
                    if(i%block==0 && i+block-1<=q[2]){
                        lazy[b]+=q[3]; // full blcok update
                        i+=block;
                    }else{
                        freq[b].put(nums2[i], freq[b].get(nums2[i])-1);
                        nums2[i]+=q[3];
                        freq[b].put(nums2[i], freq[b].getOrDefault(nums2[i],0)+1);
                        i++;
                    }
                }
            }else{
                int count = 0;
                for(int x:nums1){
                    for(int b=0;b<=(n-1)/block;b++){
                        count += freq[b].getOrDefault(q[1]-x-lazy[b],0);
                    }
                }
                res.add(count);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}

class Solution3{
    int s = 300;
    public int[] numberOfPairs(int[] nums1, int[] nums2, int[][] queries){
        Map<Integer, Integer>[] cnt = new Map[s];
        for (int i = 0; i < s; i++) cnt[i] = new HashMap<>();
        int[] lazy = new int[s];
        int n = nums2.length;
        for(int i=0;i<n;i++) cnt[i/s].put(nums2[i], cnt[i/s].getOrDefault(nums2[i], 0) + 1);;
        List<Integer> ans = new ArrayList<>();
        for(int[] query:queries){
            if(query[0]==1){
                int l = query[1], r = query[2]+1, x = query[3];
                while(l<r){
                    if(l%s==0 && l+s<=r){
                        lazy[l/s]+=x;
                        l+=s;
                    }else{
                        cnt[l/s].put(nums2[l], cnt[l/s].get(nums2[l]) - 1);
                        nums2[l] += x;
                        cnt[l/s].put(nums2[l], cnt[l/s].getOrDefault(nums2[l], 0) + 1);
                        l++;
                    }
                }
            }else{
                int curr = 0;
                for(int g=0;g<=(n-1)/s;g++){
                    for(int y:nums1) curr += cnt[g].getOrDefault(query[1] - lazy[g] - y, 0);
                }
                ans.add(curr);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
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
class solution {
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