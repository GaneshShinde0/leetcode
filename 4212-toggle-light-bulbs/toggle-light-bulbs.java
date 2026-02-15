class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        boolean[] b = new boolean[101];
        for(int i:bulbs) b[i]=!b[i];
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<=100;i++){
            if(b[i]) result.add(i);
        }
        return result;
    }
}