/*
# 254 Factor Combinations
Numbers can be regarded as the product of their factors.

For example, 8 = 2 x 2 x 2 = 2 x 4.
Given an integer n, return all possible combinations of its factors. You may return the answer in any order.

Factors should be in the range [2, n - 1].

Example 1: 
Input: n = 1
Output: []

Example 2:
Input: 12
Output: [[2,6], [4,3], [2,2,3]]

Example 3:
Input: 17
Output: []

# Approach 1: Backtracking

Intuition:
- This is a search problem and we need to find all solutions. The key point is to enumerate all the solutions without missing any or duplicating any, to do that we will need a well defined order to enumerate the solutions.

- Each solution is a list where the products of the numbers in the list are equal to n. For each solution, we want to try to extend the length of the list to find new solutions. We can do this by choosing a number in the list, let's say x, and splitting it into two numbers a and b, such that a*b = x;

To Avoid duplicates (12 = 2*2*3 = 2*3*2 ) we keep the factors in each solution sorted ascending. At each step, we will choose x as the last (largest) element in the list, let's call it lastFactor. Then we search for a,b such that a*b = lastFactor and replace last factor with a,b. To keep the list sorted after the replacement, we need both a and b to be greater than or equal to second largest element in the original list. 

Example: n = 96
One of our solution is [2,3,16]. We want to replace the 16, but both numbers need to be greater than or equal to 3. If we choose 2,8 then after the replacement our list will be [2,3,2,8], Which is not sorted. We can choose 4,4, and after replacement, we have new solution: [2,3,4,4]. This is how we avoid duplicates.

To get the values of a and b, we can iterate with an integer i. We want to start i at the 2nd largest element in the list to ensure the list stays sorted. We can iterate until sqrt(lastFacor), i.e. i*i>lastFactor, so iterate until i>lastFacor/i.

If the list only contains one number (the first list only has n), then we can start iterating from the minimum possible factor, which is 2.

At each value of i, we know that i is a factor of lastFactor if lastFacor%i==0, Then we have a = i and b = lastFactor/i.

At a high level, this kind of question is called "implicit graph search/traversal". For instance, if we take all the sorted factor lists as a graph's nodes and for 2 lists(nodes) A and B, we add a directed edge from A to B if and only if B can be obtained from A by splitting the last integer lastFactor in A into 2 number a,b.

Then finding all the solutions is the same as doing a graph traversal. Because in our graph each list only points to another list with a length 1 more than itself, the graph is tree. 

            [12]
        [2,6]   [3,4]
    [2,2,3]

Recursively traversing the tree gives us backtracking approach, Everytime we perform a split, we can also add the new solution to a variable ans to return at the end.

# Algorithm

backtracking(List<> factors, List<List<>> ans){
    - if factors.size()>1, add a copy of it into ans since its one of the desired solutions.
    - Get the last element of factors lastFacor and remove it from facros.
    - If factors is empty, iterate over i from 2, other wise loop i from last value in factors. Iterate until i>lastFactor/i.
        - For each i, if lastFactor%i==0, put i and lastFactor/i in the factors list and call backtracking(factors, ans).
        - Restore the list(backtrack) factors by removing the last 2 elements in factors.
    - Restore the list backtrack factors by adding the lastFactor back.
}
*/
class SolutionApproach1 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(new ArrayList<Integer>(Arrays.asList(n)), ans);
        return ans;
    }
    private void backtracking(List<Integer> factors, List<List<Integer>> ans){
        if(factors.size()>1) ans.add(new ArrayList<>(factors));
        int lastFactor = factors.remove(factors.size()-1);

        for(int i= factors.isEmpty()?2:factors.get(factors.size()-1); i<=lastFactor/i;++i){
            if(lastFactor %i==0){
                factors.add(i);
                factors.add(lastFactor/i);
                backtracking(factors, ans);
                factors.removeLast();
                factors.removeLast();
            }
        }
        factors.add(lastFactor);
    }
}

/*
# Approach 2: Iterative DFS
# Intuition:
The intuition is the same as before. Start with the single number n as the list of factors. We again maintain the factors list sorted and at each step, replace last factor in the list lastFactor with a,b as discussed in previous approach. Instead of using recursive backtracking, we can use a stack to traverse the tree iteratively DFS.

Algorithm:
- Create a stack which contains list with the only element n initially.
- Create an empty list ans
- Until Stack is empty pop a factors list.
    - Get last element of factors lastFactor and remove it from factors. 
    - If factors is empty, iterate over i from 2, otherwise loop i from the last value in factors. Iterate until i>lastFactor/i.
        - For each i, if lastFactor%i==0, make one copy of the list factors named newFactors. Put i and lastFactor%i into newFactors.
        - Push newFactors into the stack stack.
        - Push a copyy of newFactors into the stack stack.
- return ans;
*/


class Solution{
    public List<List<Integer>> getFactors(int n){
        final List<List<Integer>> ans = new LinkedList<>();
        final Stack<LinkedList<Integer>> stack = new Stack<>();
        stack.push(new LinkedList<>(new LinkedList<>(Arrays.asList(n))));
        while(!stack.isEmpty()){
            final LinkedList<Integer> factors = stack.pop();
            final int lastFactor =  factors.removeLast();
            for(int i=factors.isEmpty()?2:factors.peekLast();i<=lastFactor/i;i++){
                if(lastFactor%i==0){
                    LinkedList<Integer> newFactors = new LinkedList<>(factors);
                    newFactors.add(i);
                    newFactors.add(lastFactor/i);
                    stack.push(newFactors);
                    ans.add(new LinkedList<>(newFactors));
                }
            }
        }
        return ans;
    }
}
/*
Time Complexity: O(2^logN)
Space Complexity:
Recursion Depth: O(logN) 
Factor List O(logN)
*/

/*
2 = 2
3 = 1
*/