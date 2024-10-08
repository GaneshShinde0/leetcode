class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int count =0;
        for(int i=1;i<colors.length-1;i++){
            if(colors[i]!=colors[i-1]&& colors[i]!=colors[i+1]) count++;
        }
        if(colors[0]!=colors[colors.length-1]&& colors[0]!=colors[1]) count++;
        if(colors[0]!=colors[colors.length-1]&& colors[colors.length-2]!=colors[colors.length-1]) count++;
        return count;
    }

    public int numberOfAlternatingGroupsOtherSolution(int[] colors) {
        int n = colors.length;
        if (n < 3) {
            return 0;
        }
        int groups = 0;
        for (int i = 0; i < n ; i++) {
            if (colors[i] != colors[(i+1)%n] && colors[(i+1)%n] != colors[(i+2)%n]) {
                groups++; 
            }
        }
        return groups;
    }
}
