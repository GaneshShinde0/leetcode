class Solution {
    public double equalizeWater(int[] buckets, int loss) {
        double low = 0, high = 100000, retainPercent = (100.0-loss)/100;
        while(high-low>0.00001){
            double mid = (low+high)/2, need = 0, have = 0;
            for(int b: buckets){
                if(b>=mid) have += b-mid;
                else need += mid-b;
            }
            if(have*retainPercent>=need){
                low = mid;
            }else high = mid;
        }
        return low;
    }
}