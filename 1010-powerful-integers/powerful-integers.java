class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();
        for (int a = 1; a < bound; a *= x) {
            for (int b = 1; a + b <= bound; b *= y) {
                result.add(a + b);
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }
        return new ArrayList<>(result);
    }
}
class Solution1{
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        // Math.log(1)=0, gives Infinity 
        // Math.log() returns double, Math.log(1) returns 0.
        // Floating-point division by zero does not throw an exception — it follows IEEE 754 rules instead.
        // double/0.0 =>t returns Double.POSITIVE_INFINITY or negative infinity;
        System.out.println(Math.ceil(Math.log(bound)/Math.log(1)));
        int xMaxPow = x==1?1:(int) Math.ceil(Math.log(bound)/Math.log(x));
        int yMaxPow = y==1?1:(int) Math.ceil(Math.log(bound)/Math.log(y));
        for(int i=0;i<=xMaxPow;i++){
            for(int j=0;j<=yMaxPow;j++){
                int value = (int) (Math.pow(x,i)+Math.pow(y,j));
                if(value<=bound) set.add(value);
            }
        }
        return new ArrayList<Integer>(set);
    }
}