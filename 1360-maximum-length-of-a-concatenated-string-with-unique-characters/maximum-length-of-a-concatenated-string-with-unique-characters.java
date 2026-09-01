class Solution {
    public int maxLength(List<String> arr) {
        int n = arr.size();
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<n;i++){
            int temp = 0;
            for(char c:arr.get(i).toCharArray()){
                int shift = c-'a';
                if(((1<<shift) & temp) >0){
                    temp = 0;
                    break;
                }
                temp = (1<<shift)|temp;
            }
            if(temp!=0) li.add(temp);
        }
        int bitLength = li.size();
        int res = 0;
        // This for loop is for all the strings, if ith bit from left is 1 we will consider that string.
        for(int i=0;i<(1<<bitLength);i++){
            int curr = 0;
            int mask = i;
            for(int currBit = 0; currBit<bitLength;currBit++){
                if(((1<<currBit) & mask)>0){
                    int currWord = li.get(currBit);
                    if((currWord & curr)>0){
                        curr=0;
                        break;
                    }
                    curr |= currWord;
                }
            }
            res = Math.max(res, Integer.bitCount(curr));
        }
        return res;
    }
}