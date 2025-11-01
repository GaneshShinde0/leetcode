/*
Question is asking us to convert given string 
#ABCDEF to new String #XXYYZZ so that we can use it as #XYZ; 

Basically we have to choose a color that is almost close to our original color.
Absolute of Similarity should be minium

*/

class Solution {

    public String findTarget(String color){
        int num = Integer.parseInt(color,16);
        int ans = -1, minDiff = 1000;
        // We try the value of every possible "XX" pair.
        for(int i=0;i<16;i++){
            int currDiff = (int) Math.pow(i*17-num,2);
            if(currDiff<minDiff){
                minDiff = currDiff;
                ans = i;
            }
        }
        return Integer.toHexString(ans).repeat(2);
    }
    public String findTarget1(String color) {
        int num = Integer.parseInt(color,16);
        // Get Rounded VaAlue of num to 17.
        int x = Math.round((float) num/17);
        return Integer.toHexString(x).repeat(2);
    }

    public String similarRGB(String color){
        StringBuilder target = new StringBuilder();
        target.append("#");
        for(int i=1;i<6;i+=2){
            target.append(findTarget(color.substring(i,i+2)));
        }
        return target.toString();
    }
}