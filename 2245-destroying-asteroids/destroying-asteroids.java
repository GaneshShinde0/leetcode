class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long totalMass = mass;
        for(int i=0;i<asteroids.length;i++){
            if(totalMass>=asteroids[i])totalMass+=asteroids[i];
            else return false;
        }
        return true;
    }
}