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
    public boolean isValidSerialization(String preorder){
        // Number of available slots
        int slots = 1;
        int n = preorder.length();
        for(int i=0;i<n;i++){
            if(preorder.charAt(i)==','){
                // Each node takes one slot.
                --slots;
                // If no slots are available
                if(slots<0) return false;
                // Non-Empty node creates tow children slots.
                // i is `,` i-1 should be # or number.
                if(preorder.charAt(i-1)!='#') slots+=2;
            }
        }
        // The last node
        slots = (preorder.charAt(n-1)=='#')?slots-1:slots+1;
        return slots==0;
    }
    public boolean isValidSerializationApproach2(String preorder) {
        if(preorder.equals("#")) return true;
        String[] temp = preorder.split(",");
        int i = temp.length-1, hashCount=0;
        while(i>=0){
            if(temp[i].equals("#")) hashCount++;
            else if(isNumeric(temp[i]) && hashCount>=2){
                hashCount-=1;
            }else{
                return false;
            }
            i--;
        }
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