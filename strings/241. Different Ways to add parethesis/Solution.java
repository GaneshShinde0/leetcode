/*
     Question says return all possible, Hence it is recursive
     Answer order does not matter

    Time Complexity:
    As we are dividing the answer into two parts for every operator time complexity will be n*2^n where n is number of operators.

    Space Complexity:
    As we are dividing and storing result of sub problems it will be 2^n

*/

class Solution {
    public List<Integer> diffWaysToCompute(String ip) {
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<ip.length();i++){
            if(ip.charAt(i)=='-'||
                ip.charAt(i)=='+'||
                ip.charAt(i)=='*'||
                ip.charAt(i)=='/'){
                    String part1 = ip.substring(0,i);
                    String part2 = ip.substring(i+1);
                    List<Integer> p1Li = diffWaysToCompute(part1);
                    List<Integer> p2Li = diffWaysToCompute(part2);
                    for(Integer p1:p1Li){
                        for(Integer p2:p2Li){
                            int c=0;
                            switch(ip.charAt(i)){
                                case '+' -> c= p1+p2;
                                case '-' -> c= p1-p2;
                                case '*' -> c= p1*p2;
                                case '/' -> c= p1/p2;
                            }
                            li.add(c);
                        }
                    }
                }
        }
        if(li.size()==0) li.add(Integer.parseInt(ip));
        return li;
    }
}
