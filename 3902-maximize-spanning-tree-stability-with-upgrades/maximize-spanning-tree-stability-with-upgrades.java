/*
Maximize Spanning Tree Stability with Upgrades

Approach: Binary Search + Minimum Spanning Tree.

Intuition:
This problem essentially asks us to find the maximum possible value of the minimum edge weight in a spanning tree. Problems involving expressions such as "maximize the minimum" or "minimize the maximum" are often solved by using a binary search on the answer framework. In this problem, we perform a binary search on the minimum edge weight and check whether it is possible to construct a spanning tree that satisfies this constraint.

Next, consider the following question: For a given minimum edge weight constraint, what strategy should we use to construct a spanning tree? A greedy strategy is the natural choice. If it is impossible to construct a spanning tree while selecting edges that satisfy the constraint as much as possible, then selecitng less optimal edges will certainly not help satisfy the requirement. This reasoning follows directly from the greedy properties of spanning tree algorithms.

First, ignore the ability to double dge weights k times. To make the selected edges satisfy the constraint as much as possbile, we should greedily choose edges with larger weights. This is equivalent to constructing a maximum spanning tree. We use the Kruskals algorithm as the basic framework for building this spannin tree. 

Now consider the doubling strategy. SInce we greedily choose edges with larger weights, the doubling opportunities are naturally used when necessary. When we encounter an edge whose weight is less than the current constrint, weattempt to double its weight in order to satisfy the constrint and continue building the spannig tree. if the doubled weight is still less thant the constrint, or if all doubling opportunities have already been used then none of the reamining edges can satisfy the constirant, and this construction attempt fails.

During preprocessing, we first force-select the edges with must = 1 to establish the initial state of the Union-Find Structure. The minimum edge weight among these edges serves as the upper bound for the binary search. Meanwhile, to construct a maximum spanning tree, we sort the eges with must = 0 in descending order of weight.

During the binary search process, we follow the steps of Kruskals's algorithm while applying the strategy described above. We Continuously maintian the Union-Find structure to ensure correctness.

THe problem states that the resulting spanning tree must staisfy three properties. Under the condition tat the graph is acyclic, the properties of connectivity and having exactly n-1 edges are equivalent. SInce the Union-Find structure already guarantees that no cycles are formed. We simply check whether  the number of selected edges is exactly n-1 to determine whether a valid spanning tree has been constructed.
*/

class DSU{
    int[] parent;
    DSU(int[] parent){
        this.parent = parent.clone();
    }

    int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);
        return parent[x];
    }

    void join(int x , int y){
        int px = find(x), py = find(y);
        parent[px] = py;
    }
}
class Solution {

    public static final int MAX_STABILITY = 1000000;
    public int maxStability(int n, int[][] edges, int k) {
        int ans = -1;
        if(edges.length<n-1) return -1; // MST Not possible

        List<int[]> mustEdges = new ArrayList<>();
        List<int[]> optionalEdges = new ArrayList();

        for(int[] edge:edges){
            if(edge[3]==1) mustEdges.add(edge);
            else optionalEdges.add(edge);
        }

        if(mustEdges.size()>n-1) return -1; // Minimun spanning tree not possible

        optionalEdges.sort((a,b)->(b[2]-a[2]));
        int selectedInit = 0;
        int mustMinStability = MAX_STABILITY;
        int[] initParent = new int[n];
        for(int i=0;i<n;i++) initParent[i]=i;

        DSU dsuInit = new DSU(initParent);
        for(int[] e:mustEdges){
            int u = e[0], v = e[1], s = e[2];
            if(dsuInit.find(u)==dsuInit.find(v)||selectedInit == n-1) return -1;
            dsuInit.join(u,v);
            selectedInit++;
            mustMinStability = Math.min(mustMinStability, s);
        }

        int l = 0, r = mustMinStability;
        while(l<r){
            int mid = l +(r-l+1)/2;
            DSU dsu = new DSU(dsuInit.parent);
            int selected = selectedInit;
            int doubledCount = 0;
            for(int[] e: optionalEdges){
                int u = e[0], v = e[1], s = e[2];
                if(dsu.find(u)==dsu.find(v)) continue;
                if(s>=mid){
                    dsu.join(u,v);
                    selected++;
                }else if (doubledCount<k && s*2>=mid){
                    doubledCount++;
                    dsu.join(u,v);
                    selected++;
                }else{
                    break;
                }
                if(selected == n-1) break;
            }
            if (selected != n - 1) {
                r = mid - 1;
            } else {
                ans = l = mid;
            }
        }
        return ans;
    }
}