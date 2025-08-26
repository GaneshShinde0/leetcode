class Solution {
    public int maximizeGreatness(int[] temp) {
        Arrays.sort(temp);
        int count =0;
        for(int i=0;i<temp.length;i++){
            if(temp[count]<temp[i]) count++;
        }
        return count;
    }
}