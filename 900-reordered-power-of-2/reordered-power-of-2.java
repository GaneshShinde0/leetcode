class Solution {

    public boolean reorderedPowerOf2(int n) {
        int count = counter(n);

        for (int i = 0; i < 30; ++i)
        if (counter(1 << i) == count)
            return true;

        return false;
    }

    private int counter(int n) {
        int count = 0;

        for (; n > 0; n /= 10)
        count += Math.pow(10, n % 10);

        return count;
    }
    public boolean reorderedPowerOf2_3ms(int n) {
        Set<String> set = new HashSet<>();
        int curr = 1;
        for(int i=0;i<=32;i++){
            char[] s = String.valueOf(curr).toCharArray();
            Arrays.sort(s);
            set.add(new String(s));
            curr = curr*2;
        }
        char[] nArr = String.valueOf(n).toCharArray();
        Arrays.sort(nArr);
        return set.contains((new String(nArr)));
    }
}