class Solution {
    public int brokenCalcRecursive(int startValue, int target) {
        if(startValue >= target) return startValue - target;
        if(target%2==0){
            return 1+brokenCalcRecursive(startValue,target/2);
        }else{
            return 1+brokenCalcRecursive(startValue, target+1);
        }
    }
    public int brokenCalc(int startValue, int target) {
        int ans = 0;
        while(target>startValue){
            ans++;
            if(target%2==1){
                target++;
            }else{
                target/=2;
            }
        }
        return ans+startValue-target;
    }
}