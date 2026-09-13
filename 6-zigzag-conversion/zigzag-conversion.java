class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        int charsInSection = 2*(numRows-1);
        for(int currRow = 0;currRow<numRows; currRow++){
            int idx = currRow;
            int counter = 0;
            while(idx>=0 && idx<n){
                ans.append(s.charAt(idx));
                if(currRow == 0 || currRow == numRows-1) idx+=2*(numRows-1);
                else if(counter%2==0) idx+=charsInSection;
                else idx+= 2*(numRows-1) - charsInSection;
                counter++;
            }
            charsInSection -=2;
        }
        return ans.toString();
    }
}