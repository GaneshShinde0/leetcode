class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int[] freq = new int[10];
        int sum = 0;
        boolean onlyZeros = true;
        for(int d:digits){
            freq[d]++;
            sum+=d;
        }
        if(sum%3==1) reduce(freq,1);
        else if(sum%3==2) reduce(freq,2);
        StringBuilder sb = new StringBuilder();
        for(int i=9;i>=0;i--){
            if(freq[i]>0){
                sb.append((i+"").repeat(freq[i]));
                if(i!=0) onlyZeros = false;
            }
        }
        if(onlyZeros && freq[0]>0) return "0";
        return sb.toString();
    }
    private void reduce(int[] freq, int remainder){
        for(int i=1;i<9;i++){
            if(i%3==remainder && freq[i]>0){
                freq[i]--;
                return;
            }
        }
        int[] temp= {11,22,14,44,17,47,52,55,77,28,58,88};
        for(int t:temp){
            int i = t%10;
            int j= t/10;
            if(i==j && freq[i]>=2){
                freq[i]--;
                freq[j]--;
                break;
            }else if(i!=j && freq[i]>0 && freq[j]>0){
                freq[i]--;
                freq[j]--;
                break;
            }
        }
    }
}

/*
Lets look at you later

        if(sum%3==1){
            if(freq[1]>0) freq[1]--;
            else if(freq[4]>0) freq[4]--;
            else if(freq[7]>0) freq[7]--;
        }else if(sum%3==2){
            if(freq[2]>0) freq[2]--;
            else if(freq[5]>0) freq[5]--;
            else if(freq[8]>0) freq[8]--;
            else if(freq[1]>=2) freq[1]-=2;
            else if(freq[1]>0 && freq[4]>0){
                freq[1]--;
                freq[4]--;
            }else if(freq[1]>0 && freq[7]>0){
                freq[1]--;
                freq[7]--;
            }else if(freq[2]>=2) freq[2]-=2;
            else if(freq[2]>0 && freq[8]>0){
                freq[2]--;
                freq[8]--;
            }
        }
*/