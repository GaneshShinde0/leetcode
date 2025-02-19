class Solution {

    List<String> happyStrings = new ArrayList<>();
    public String getHappyStringBackTracking27ms(int n, int k) {
        String currentString = "";
        generateHappyStringsBackTracking27ms(n, currentString);
        if(happyStrings.size()<k) return "";
        Collections.sort(happyStrings);
        return happyStrings.get(k-1);
    }
    private void generateHappyStringsBackTracking27ms(int n, String str){
        if(str.length()==n){
            happyStrings.add(str);
            return;
        }
        for(char currentChar = 'a'; currentChar<='c'; currentChar++){
            if(str.length()>0 && str.charAt(str.length()-1)==currentChar) continue;
            generateHappyStringsBackTracking27ms(n, str+currentChar);
        }
    }

    public String getHappyString(int n, int k){
        Stack<String> stringsStack = new Stack<>();
        int indexInSortedList = 0;
        stringsStack.push(""); // Start with an empty string
        while(stringsStack.size()>0){
            String currentString = stringsStack.pop();
            if(currentString.length()==n){
                indexInSortedList++;
                if(indexInSortedList == k){
                    return currentString;
                }
                continue;
            }
            for(char currentChar = 'c'; currentChar>='a'; currentChar--){
                if(currentString.length()==0 || currentString.charAt(currentString.length()-1)!=currentChar){
                    stringsStack.push(currentString+currentChar);
                }
            }
        }
        return "";
    }
}
