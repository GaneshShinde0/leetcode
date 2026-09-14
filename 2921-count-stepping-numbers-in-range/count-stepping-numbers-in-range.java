/*

For low ...

Keep changing digits from Left

*/

class Solution {
    private int MOD = 1_000_000_007;
    String str;
    int[][][][] memo;
    public int countSteppingNumbers(String low, String high) {
        return (steppingNumbers(high)-steppingNumbers(substractOneFromString(low))+MOD)%MOD;
    }
    private int steppingNumbers(String num){
        this.str = num;
        int n = str.length();
        this.memo = new int[n][10][2][2];
        for(int[][][] a:memo){
            for(int[][] b: a){
                for(int[] c: b){
                    Arrays.fill(c,-1);
                }
            }
        }
        return solve(0, 0, true, false);
    }

    private int solve(int pos, int prevDigit, boolean tight, boolean started){
        if(pos == str.length()) return started?1:0;
        int tightIdx = tight?1:0;
        int startedIdx = started?1:0;
        if(memo[pos][prevDigit][tightIdx][startedIdx] !=-1) return memo[pos][prevDigit][tightIdx][startedIdx];
        int limit = tight?str.charAt(pos)-'0':9;
        long res = 0;

        for(int d=0;d<=limit; d++){
            boolean nextTight = tight && (d==limit);
            if(!started){
                if(d==0){
                    // Still padding with Zeros, Number has not started.
                    res = (res+solve(pos+1,0, nextTight, false))%MOD;
                }else{
                    // This digit starts the real number
                    res = (res+solve(pos+1, d, nextTight, true))%MOD;
                }
            }else{
                // Must statisfy stepping condition
                if(Math.abs(d-prevDigit)==1){
                    res = (res+solve(pos+1, d, nextTight, true))%MOD;
                }
            }
        }
        memo[pos][prevDigit][tightIdx][startedIdx] = (int) res;
        return (int) res;
    }
    
    private String substractOneFromString(String s){
        boolean subtracted=false;
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            char curr = s.charAt(i);
            if(subtracted){
                sb.insert(0, (char)(curr));
            }else if(curr=='0' && !subtracted){
                sb.insert(0,'9');
            }else{
                sb.insert(0,(char)(curr-1));
                subtracted = true;
            }
        }
        return sb.toString();
    }
}

class SolutionUsingBFS_Fails_For_Larger_Constraints {
    private int MOD = 1_000_000_007;
    public int countSteppingNumbers(String low, String high) {
        return steppingNumbers(high)-steppingNumbers(substractOneFromString(low));
    }
    private String substractOneFromString(String s){
        boolean subtracted=false;
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            char curr = s.charAt(i);
            if(subtracted){
                sb.insert(0, (char)(curr));
            }else if(curr=='0' && !subtracted){
                sb.insert(0,'9');
            }else{
                sb.insert(0,(char)(curr-1));
                subtracted = true;
            }
        }
        return sb.toString();
    }
    private int steppingNumbers(String num){
        if(num.length()==1) return Integer.parseInt(num);
        Queue<String> queue = new LinkedList<>();
        for(int i=1;i<10;i++){
            queue.add(""+i);
        }
        long res = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            res=(res+size)%MOD;
            System.out.println(queue);
            int lastIdx = queue.peek().length()-1;
            for(int i=0;i<size;i++){
                String curr = queue.poll();
                int last = curr.charAt(lastIdx)-'0';
                if(last == 0 && compare(curr+(last+1),num)<1) queue.add(curr+(last+1));
                else{
                    if(compare(curr+(last-1),num)<1) queue.add(curr+(last-1));
                    if( last!=9 && compare(curr+(last+1),num)<1) queue.add(curr+(last+1));
                }
            }
        }
        return (int)(res);
    }
    private Integer compare(String a, String b){
        if(a.length()!=b.length()) return Integer.compare(a.length(), b.length());
        else return a.compareTo(b);
    }
}