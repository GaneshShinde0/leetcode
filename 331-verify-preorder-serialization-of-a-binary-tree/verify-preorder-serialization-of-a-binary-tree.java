/*
9,3,4,#,#,1,#,#,2,#,6,#,#"
9,3,4,#,#,1,#,#,2,#,#
9,3,4,#,#,1,#,#,#
9,3,4,#,#,#,#
9,3,#,#,#
9,#,#
#


*/

class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder.equals("#")) return true;
        String[] temp = preorder.split(",");
        int i = temp.length-1, hashCount=0;
        while(i>=0){
            if(temp[i].equals("#")) hashCount++;
            else if(isNumeric(temp[i])){
                if(hashCount<=1) return false;
                hashCount-=1;
            }else{
                return false;
            }
            i--;
            System.out.println(hashCount);
        }
        // System.out.println(Arrays.toString(temp));
        //         System.out.println(isNumeric("#"));

        return hashCount==1 && isNumeric(temp[0]);
    }

    public boolean isValidSerializationInitialDoesNotWork(String preorder) {
        String[] temp = preorder.split(",");
        int i = temp.length-1, hashCount=0;
        while(i>0){
            System.out.println(Arrays.toString(temp));
            if(i>=4 && temp[i].equals("#") && temp[i-1].equals("#") && temp[i-2].equals("#") && temp[i-3].equals("#") && (isNumeric(temp[i-4]))){
                temp[i-4]="#";
                i-=1;
            }else if(i>=3 && temp[i].equals("#") && temp[i-1].equals("#") && temp[i-2].equals("#") && (isNumeric(temp[i-3]))){
                temp[i-3]="#";
                i-=1;
            }else if(i>=2 && temp[i].equals("#") && temp[i-1].equals("#")){
                temp[i-2]="#";
                i-=1;
            }else{
                return false;
            }
            i--;
        }
        return isNumeric(temp[0]) && temp.length>=3;
    }

    private boolean isNumeric(String s){
        for(char c:s.toCharArray()){
            if(c<'0' || c>'9') return false;
        }
        return true;
    }
} 