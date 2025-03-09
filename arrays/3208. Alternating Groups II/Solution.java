class Solution {
    public int numberOfAlternatingGroupsExpandingArrayAndSlidingWindow(int[] colors, int k) {
        int[] temp = new int[colors.length+k-1];
        for(int i=0;i<colors.length;i++) temp[i]=colors[i];
        for(int i=0; i<k-1;i++) temp[colors.length+i]=colors[i];
        int length = temp.length;
        int res = 0;
        int left = 0;
        int right = 1;
        while(right<length){
            if(temp[right]==temp[right-1]){
                left = right;
                right++;
                continue;
            }
            right++;
            if(right-left<k) continue;
            res++;
            left++;
        }
        return res;
    }

    public int numberOfAlternatingGroupsTwoPasses(int[] colors, int k) {
        int n = colors.length;
        int res = 0;
        int currAltCount = 1;
        for(int i=1;i<n;i++){
            if(colors[i]==colors[i-1]){
                currAltCount=1;
                continue;
            }
            currAltCount++;
            if(currAltCount>=k) res++;
        }
        int temp = colors[n-1];
        for(int i=0;i<k-1;i++){
            if(colors[i]==temp)break;
            currAltCount++;
            if(currAltCount>=k) res++;
            temp=colors[i];
        }
        return res;
    }

    // One Pass
    public int numberOfAlternatingGroups(int[] colors, int k){
        int n = colors.length;
        int res = 0;
        int currAltCount = 1;
        int lastColor = colors[0];
        for(int j=1;j<n+k-1;j++){
            int i = j%n;
            if(colors[i]==lastColor){
                currAltCount=1;
                lastColor = colors[i];
                continue;
            }
            currAltCount+=1;
            if(currAltCount>=k) res++;
            lastColor = colors[i];
        }      
        return res;  
    }
}
