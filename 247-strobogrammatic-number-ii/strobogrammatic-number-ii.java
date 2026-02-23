/*


0 
1
8

11
69
88
96

Algorithm:
1. Initialize a data structure reversiblePairs, which contains all pairs of reversible digits.
2. Call and return the recursive funciton, generateStroboNumbers(n, finalLength), where n indicates the current call will generate all n-digit strobogrammatic numbers. The second argument indicates the length of the final strobogrammatic numbers that we will generate and will be used to check if we can add '0' to the beginning and end of a number.
3. Create a function generateStroboNumbers(n, finalLength) which will return all strobogrammatic numbers of n-digits:
    - Check for base cases, if n==0 return an array with empty string [""], otherwise if n==1 return ["0","1","8"].
    - Call generateStroboNumbers(n-2,finalLength) to get all the strobogrammatic numbers of (n-2) digits and store them in subAns.
    - Initialize an empty array currStroboNums to store strobogrammatic numbers of n-digits.
    - For each number in prevStroboNums we append all reversiblePairs at the beginning and the end except when the current reversible pair is '00' and n==finalLength (because we can't append '0' at the beginning of a number) and push this number in ans.
    - At the end of the function, return all the strobogrammatic numbers, i.e., currStroboNums.


*/

class Solution {

    public char[][] reversiblePairs = {{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};

    public List<String> generateStroboNumbers(int n, int finalLength){
        if(n==0){
            // 0-digit strobogrammatic number is an empty string.
            return new ArrayList<>(List.of(""));
        }
        if(n==1){
            // 1-digit strobogrammatic numbers.
            return new ArrayList<>(List.of("0","1","8"));
        }
        List<String> prevStroboNums = generateStroboNumbers(n-2,finalLength);
        List<String> currStroboNums = new ArrayList<>();

        for(String prevStroboNum: prevStroboNums){
            for(char[] pair:reversiblePairs){
                if(pair[0]!='0' || n!=finalLength){
                    currStroboNums.add(pair[0]+prevStroboNum+pair[1]);
                }
            }
        }
        return currStroboNums;
    }
    public List<String> findStrobogrammatic(int n) {
        return generateStroboNumbers(n,n);
    }
}

/*
N is length of strobogrammatic numbers we need to find.

Lets try visualizing the recursion tree for our approach, Our recursibe function makes another recursive call with each recursive call we decrease N by 2.
[N, N-2, N-4, N-6,... ,0]

Hence, in our recursion tree, we will have at most N/2 levels.

Time Complexity: N*5^[N/2]+1.

Space O(N*5^[n/2])
*/