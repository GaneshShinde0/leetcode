class Solution {
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