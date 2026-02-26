class UnionFind{
    int[] parent;
    int[] rank;
    UnionFind(int n){
        this.rank = new int[n];
        this.parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }

    int find(int x){
        if(x!=parent[x]) x=find(parent[x]);
        return x;
    }

    void union(int x, int y){
        int parX = find(x), parY = find(y);
        if(parX==parY) return;
        else if(rank[parX]<rank[parY]) parent[parX]=parY;
        else if(rank[parY]<rank[parX]) parent[parY]=parX;
        else{
            parent[parX] = parY;
            rank[parY]++;
        }
    }
}
class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        Map<String, Integer> emails = new HashMap<>();
        Map<Integer, String> name = new HashMap<>();
        Map<String, Integer> seen = new HashMap<>(); 

        for(int i=0;i<n;i++){
            name.put(i, accounts.get(i).get(0));
            for(int j=1;j<accounts.get(i).size();j++){
                String email = accounts.get(i).get(j);
                emails.put(email,i);
                if(seen.containsKey(email)){
                    uf.union(i,seen.get(email));
                }else{
                    seen.put(email,i);
                }
            }
        }
        // Phase 2: Group emails by their root account
        Map<Integer,Set<String>> filtered = new HashMap<>();
        for(Map.Entry<String, Integer> entry: emails.entrySet()){
            String email = entry.getKey();
            int id = entry.getValue();
            int root = uf.find(id);
            filtered.computeIfAbsent(root,k->new TreeSet<>()).add(email);
        }

        // Phase 3: Format the output
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Integer, Set<String>> entry: filtered.entrySet()){
            int k = entry.getKey();
            Set<String> v = entry.getValue();
            List<String> cur = new ArrayList<>();
            cur.add(name.get(k));
            cur.addAll(v);
            res.add(cur);
        }
        return res;
    }

    public List<List<String>> accountsMergeFailsSomeTestCases(List<List<String>> accounts) {
        List<List<String>> res= new ArrayList<>();
        HashMap<String, Set<String>> hm = new HashMap<>();
        int dups = 0;
        for(List<String> account:accounts){
            boolean flag = true;
            for(int j=0;j<dups;j++){
                if(hm.containsKey(account.get(0)+","+j)){
                    Set<String> set = hm.get(account.get(0)+","+j);
                    for(int i=1;i<account.size();i++){
                        if(set.contains(account.get(i))){
                            set.addAll(account);
                            set.remove(account.get(0));
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if(flag){
                hm.computeIfAbsent(account.get(0)+","+dups, k->new HashSet<>()).addAll(account);
                hm.get(account.get(0)+","+dups).remove(account.get(0));
                dups++;
            }
        }
        for(Map.Entry<String,Set<String>> e:hm.entrySet()){
            List<String> li = new ArrayList<>();
            li.add(e.getKey().split(",")[0]);
            List<String> temp = new ArrayList<>(e.getValue());
            Collections.sort(temp);
            li.addAll(temp);
            res.add(li);
        }
        res.sort((a,b)->a.get(0).compareTo(b.get(0)));
        return res;
    }
}