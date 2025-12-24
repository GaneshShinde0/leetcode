class Solution {
    public int minimumBoxesInitial(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int m = capacity.length-1;
        int i=0;
        int boxes = 0;
        while(m>=0 && i<apple.length){
            if(apple[i]>capacity[m]){
                apple[i]-=capacity[m];
                m--;
                boxes++;
            }else if (apple[i]==capacity[m]){
                apple[i]-=capacity[m];
                m--;
                i++;
                boxes++;
            }else{
                capacity[m]-=apple[i];
                i++;
                if(i==apple.length) boxes++;
            }
        }
        return boxes;
    }

    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int a : apple)
        {
            sum += a;
        }
        Arrays.sort(capacity);

        int count = 0;
        int n = capacity.length;
        for (int i = n - 1; i >= 0; i--) {
            sum -= capacity[i];
            count++;
            if (sum <= 0) {
                break;
            }
        }
        return count;
    }
}