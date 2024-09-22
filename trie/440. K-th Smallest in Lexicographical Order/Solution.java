class Solution {
    public int findKthNumberPrevious(int n, int k) {
        List<Integer> li = new ArrayList<>();
        int num =1;
        int ptr = 1;
        for(int i=0;i<n;i++){
            if(ptr==k) return num;
            // li.add(num);
            if(num*10<=n){
                num = num*10;
            }else{
                // When we encounter number like 9, 19, 29, 39....
                // Or when number>=n;
                while(num%10==9 || num>=n){
                    num/=10;
                }
                num+=1;
            }
            ptr++;
        }
        // System.out.println(li);
        return 0;
    }

    // Sorting will consume more time & increase space complexity.
    // Lets treat numbers as trees, where each node represents a number and its children represent numbers with the same prefix.

    // Example: 1 has children 10, 11, 12,...,19
    // This gives us a prefix tree like strucute where each node corresponds to a number and branches out the other numbers by appending digits.
    // If we traverse this tree in lexicographical order, it's as if we're listing all numbers in their proper order.


    public int findKthNumber(int n, int k){
        int curr = 1;
        k--;

        while(k>0){
            int step = countSteps(n, curr, curr+1);
            // If steps are less than or equal to k, we skip this prefix's subtree
            if(step<=k){
                // Move to the next Prefix and decrease k by the number of steps we skip.
                curr++;
                k-=step;
            }else{
                // Move to the next level of the tree and decrement k by 1
                curr *= 10;
                k--;
            }
        }
        return curr;
    }

    // To count how many numbers exist between prefix1 and prefix2
    private int countSteps(int n, long prefix1, long prefix2){
        int steps = 0;
        while(prefix1<=n){
            steps+=Math.min(n+1,prefix2) - prefix1;
            prefix1*=10;
            prefix2*=10;
        }
        return steps;
    }
}
