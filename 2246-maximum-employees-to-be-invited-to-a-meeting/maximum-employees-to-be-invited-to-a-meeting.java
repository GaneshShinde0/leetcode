/*

Calculate Frequency of most fvourite persons.

If person is liked by more than two people (We can just select two of them).
Making result +=2  and addition of that favourite person. => Others will be ignored.

- But atleast one of two we are adding should be favourite  of person we are adding.

-- So we will mandatorily add person who is its favourite and other one as person with max Frequency... 
    -> From Here we will have to check same thing for newly added persons left and right as well.
        -> Left faviourite of currnet
        -> Right (someone with max) freq.
            -> But choosing Max frequency wll not work or it will be same as choosing someone with one frequency.
            -> We have to choose a person who likes our current person and chained by likes by maximum possible persons.
            -> Same goes the other way
                -> And when these two ways are meeting later in circular table the tails they can be anyone as they have already someone (tail.prev) who they like.



Approach:
    There is pair of close friends, who are each others favourite. So anyone who likes them can be considered.

\
 \----------|
  A-B-------D---------------------
/ 

Here we have to consider longest path.
We also have to consider circle, everything outside circle will be eliminated.
*/

class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());

        int answer = 0;
        List<List<Integer>> pairs = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i==favorite[favorite[i]]){ // Checking if there is pair of friends who like each other for current node.
                if(i<favorite[i]){  // Consider only one pair
                    List<Integer> pair  = new ArrayList<>();
                    pair.add(i);
                    pair.add(favorite[i]);
                    pairs.add(pair);
                }
            }else{ 
                graph.get(favorite[i]).add(i); // Adding current to gavorite graph, This way if multiple people have same favorite[i] they will be added to same favorite[i] node.
            }
        }

        boolean[] visited = new boolean[n];
        for(List<Integer> pair: pairs){
            answer += dfs(graph, pair.get(0),visited)+dfs(graph, pair.get(1),visited); // Here also we wont have to worry about cycles or one person liking more than one person.
        }
        int[] counter = new int[n];
        int[] round = new int[n];
        int rnd = 1, maxCircle = 0;
        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            if(round[i]!=0) continue;
            int cnt = 1;
            int j = i;
            while(counter[j]==0){
                counter[j]=cnt;
                round[j]=rnd;
                j=favorite[j];
                cnt++;
            }
            if(round[j]==rnd){
                maxCircle = Math.max(maxCircle, cnt-counter[j]);
            }
            rnd++;
        }
        return Math.max(maxCircle, answer);
    }

    private int dfs(List<List<Integer>> graph, int node, boolean[] visited){
        visited[node] = true;
        int max = 0;
        // Getting maximum depth until we can reach, Here we dont have to worry about cycles as we already took care of that using List of Pairs.
        for(int neighbor: graph.get(node)){
            max = Math.max(max, dfs(graph, neighbor, visited));
        }
        return max+1;
    }
}