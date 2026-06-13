/*
Sort the input
1,2,5,8,13,21

Selet k elements such that their difference is maximum.



*/
class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int low = 0, high = price[price.length-1]-price[0]+1;
        while(low<high){
            int mid = low+(high-low)/2;
            if(check(mid,price,k)) low = mid+1;
            else high = mid;
        }
        return low-1;
    }
    private boolean check(int x, int[] price, int k){
        int prev = price[0], count = 1, i = 1;
        while(count<k && i<price.length){
            if(price[i]-prev>=x){
                prev = price[i];
                count++;
            }
            i++;
        }
        return count == k;
    }
}