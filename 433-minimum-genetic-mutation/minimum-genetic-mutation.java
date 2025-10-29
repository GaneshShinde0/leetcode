// class Solution {
//     public int minMutation(String startGene, String endGene, String[] bank) {
//         int count = 0;
//         Set<String> set = new HashSet<>();
//         for(String s:bank){
//             set.add(s);
//         }
//         for(int i=0;i<8;i++){
//             boolean flag = false;
//             if(startGene.charAt(i)!=endGene.charAt(i)){
                
//                 char[] arr = startGene.toCharArray();
//                 for(char c:"ACGT".toCharArray()){
//                     arr[i]=endGene.charAt(i);
//                     if(set.contains(new String(arr))){
//                         flag = true;
                        
//                     }
//                 }
//                 if(flag) count++;
//                 else return -1;
//             }
//         }
//         for(String s:bank){
//             if(s.equals(endGene)) return count;
//         }
//         return -1;
//     }
// }

/*
Intuition:
We can imagine problem as a graph Each gene string is a node, and mutations are edges. Two nodes have an edge if they differ by one character (ACGT) and each node must be int the bank.

Problem is simplififed what is the shortest path between start and end? When graph problem involves shortest path, BFS is better than DFS. This is because with BFS, all nodes at distance x from start will be visited before any node at distance x+1 will be visited. End will probide us shortest number of steps possible.
*/
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        Set<String> bankSet = new HashSet<>();
        for(String s:bank) bankSet.add(s);

        queue.add(start);
        seen.add(start);

        int steps = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                String node = queue.remove();
                if(node.equals(end)) return steps;
                char[] nodeArr = node.toCharArray();
                for(char c:"ACGT".toCharArray()){
                    for(int j=0;j<node.length();j++){
                        char temp = nodeArr[j];
                        nodeArr[j] = c;
                        String neighbor = new String(nodeArr);
                        if(!seen.contains(neighbor) && bankSet.contains(neighbor)){
                            queue.add(neighbor);
                            seen.add(neighbor);
                        }
                        nodeArr[j]=temp;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}