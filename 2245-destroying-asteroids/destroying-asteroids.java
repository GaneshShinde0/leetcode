class Solution1 {
    public boolean asteroidsDestroyed(long mass, int[] asteroids) {
        Arrays.sort(asteroids);
        for(int a:asteroids){
            if(mass>=a){
                mass += a;
            }else{
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int max = 0, min = Integer.MAX_VALUE;
        for(int a:asteroids){
            max = Math.max(a,max);
            min = Math.min(a,min);
        }
        int[] freq = new int[max+1];
        long total = mass;
        for(int a:asteroids){
            if(a>total) freq[a]++;
            else total+=a;
        }
        for(int i=0;i<=max;i++){
            if(i>total) return false;
            else total +=i*freq[i];
        }
        return true;
    }
}