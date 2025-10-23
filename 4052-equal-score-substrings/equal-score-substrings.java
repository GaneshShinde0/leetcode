class Solution {
    public boolean scoreBalance(String s) {
        int n = s.length();
        int[] leftScore = new int[n];
        int[] rightScore = new int[n];
        final int POS = 'a'-1;
        leftScore[0]=s.charAt(0)-POS;
        rightScore[n-1]=s.charAt(n-1)-POS;
        for(int i=1;i<n;i++){
            leftScore[i] = leftScore[i-1]+s.charAt(i)-POS;
            rightScore[n-i-1] = rightScore[n-i]+s.charAt(n-i-1)-POS;
        }
        for(int i=0;i<n-1;i++){
            if(leftScore[i]==rightScore[i+1]) return true;
        }
        System.out.println(Arrays.toString(leftScore));
        System.out.println(Arrays.toString(rightScore));
        return false;
    }
}