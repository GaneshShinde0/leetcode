class Solution {
    // 1 ms Beats 100%
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        String vowels = "aeiouAEIOU";
        StringBuilder res = new StringBuilder();
        for(int i=0;i<words.length;i++){
            StringBuilder sb = new StringBuilder();
            if(vowels.indexOf(words[i].charAt(0))!=-1){
                sb.append(words[i]);
            }else{
                sb.append(words[i].substring(1));
                sb.append(words[i].charAt(0));
            }
            sb.append("ma");
            sb.append("a".repeat(i+1));
            sb.append(" ");
            res.append(sb.toString());
        }
        return res.toString().substring(0,res.length()-1);
    }

    public String toGoatLatinOtherSolution(String sentence) {
        String[] words = sentence.split(" ");
        String vowels = "aeiouAEIOU";
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            char firstChar = words[i].charAt(0);
            
            // Append word with vowel check
            if (vowels.indexOf(firstChar) != -1) {
                res.append(words[i]);
            } else {
                res.append(words[i].substring(1)).append(firstChar);
            }
            
            // Add "ma" and "a" repeated (i + 1) times
            res.append("ma");
            for (int j = 0; j <= i; j++) {
                res.append('a');
            }

            // Add space except after the last word
            if (i < words.length - 1) {
                res.append(' ');
            }
        }

        return res.toString();
    }

}
