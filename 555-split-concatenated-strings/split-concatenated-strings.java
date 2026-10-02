class Solution {
    public String splitLoopedString(String[] strs) {
        char max = 'a';
        for(int i = 0; i < strs.length; i++){
            String curr = strs[i];
            for(char chr : curr.toCharArray()){
                if(chr > max){
                    max = chr;
                }
            }
            String reversestring = reverse(curr);
            if(reversestring.compareTo(curr) > 0){
                strs[i] = reversestring;
            }
        }

        String result = new String();
        String maxstring = String.valueOf(max);

        for(int i = 0; i < strs.length; i++){
            String cur = strs[i];
            String reversecur = reverse(cur);
            if(cur.indexOf(maxstring) == -1 && reversecur.indexOf(maxstring) == -1){
                continue;
            }
            for(String string : new String[]{cur, reversecur}){
                for(int k = 0; k < string.length(); k++){
                    if(string.charAt(k) != max){
                        continue;
                    }
                    StringBuilder sb = new StringBuilder(string.substring(k));

                    for(int j = i + 1; j < strs.length; j++){
                        sb.append(strs[j]);
                    }

                    for(int j = 0; j < i; j++){
                        sb.append(strs[j]);
                    }
                    
                    sb.append(string.substring(0, k));
                    String newstring = sb.toString();
                    if(newstring.compareTo(result) > 0){
                        result = newstring;
                    }
                }
            }
        }
        return result;
    }
    private String reverse(String string){
        char[] array = string.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        return new String(array);
    }
}