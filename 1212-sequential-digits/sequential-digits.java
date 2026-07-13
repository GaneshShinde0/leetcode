class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int initialLow = low;
        List<Integer> result = new ArrayList<>();
        while(low<=high){
            int curr = formSequence(low);
            int lenLow = String.valueOf(low).length();
            int lenCurr = String.valueOf(curr).length();
            if(lenCurr<lenLow) low = (int) Math.pow(10,lenLow);
            else{
                if(curr>=initialLow && curr<=high){
                    result.add(curr);
                }
                low = curr+(int) Math.pow(10, (int) Math.log10(curr));
            }
        }
        return result;
    }

    private int formSequence(int num){
        String s = num+"";
        int len = s.length(), ptr = 0;
        char beginning = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        while(ptr<s.length() && beginning<='9'){
            sb.append(beginning++);
            ptr++;
        }
        return Integer.parseInt(sb.toString());
    }
}