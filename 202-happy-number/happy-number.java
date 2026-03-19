class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while(!visited.contains(n)){
            int temp = n;
            int sum = 0;
            while(temp>0){
                int curr = temp%10;
                temp=temp/10;
                sum += (curr*curr);
            }
            visited.add(n);
            n=sum;
            if(sum==1) return true;
        }
        return false;
    }
}