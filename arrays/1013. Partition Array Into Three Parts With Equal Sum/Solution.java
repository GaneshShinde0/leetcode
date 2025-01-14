class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum=0;
        for(int i:arr){
            sum+=i;
        }
        int average = sum/3, count=0, part=0;
        for(int a:arr){
            part +=a;
            if(part==average){
                ++count;
                part=0;
            }
        }
        return count>=3 && sum%3==0;
    }
}
