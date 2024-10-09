class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        char[] first = firstWord.toCharArray();
        char[] second = secondWord.toCharArray();
        char[] target = targetWord.toCharArray();
        for(int i=0;i<first.length;i++)first[i]=(char)(first[i]-49);
        for(int i=0;i<second.length;i++)second[i]=(char)(second[i]-49);
        for(int i=0;i<target.length;i++)target[i]=(char)(target[i]-49);
        int targetInt = Integer.parseInt(new String(first))+Integer.parseInt(new String(second));
        return targetInt == Integer.parseInt(new String(target));
    }

    // Following is optimized and more reliable
    public boolean isSumEqualAlterNateSolution(String firstWord, String secondWord, String targetWord) {
        return getIntValue(firstWord) + getIntValue(secondWord) == getIntValue(targetWord);
    }
    private int getIntValue(String s) {
        int result = 0;
        for(int i=0;i<s.length();i++)
            result = result * 10 + (s.charAt(i) - 'a');
        return result;
    }
}
