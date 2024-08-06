class ToTitleCase {
    public String capitalizeTitleNaive8Ms(String title) {
        String[] arr = title.toLowerCase().split(" ");
        String ans="";
        for(int i=0;i<arr.length;i++){
            if(arr[i].length()>2){
                arr[i]=arr[i].substring(0,1).toUpperCase()+arr[i].substring(1);
            }
            ans+=arr[i]+" ";
        }
        return ans.substring(0,ans.length()-1);

    }
    public String capitalizeTitle(String title) {
        String[] words = title.toLowerCase().split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() > 2) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1));
            } else {
                result.append(word);
            }
            result.append(" ");
        }

        // Remove the trailing space
        result.setLength(result.length() - 1);
        
        return result.toString();
    }

    public String capitalizeTitleFastest(String title) {
        char[] chr = title.toCharArray();

        int lt = 0;
        int rt = 0;

        while (rt < chr.length) {
            if (chr[rt] == ' ') {
                arrangeWord(chr, lt, rt);
                lt = rt + 1;
            }

            rt++;
        }

        arrangeWord(chr, lt, rt);

        return String.valueOf(chr);
    }

    public void arrangeWord(char[] chr, int lt, int rt) {
        if (rt - lt > 2) {
            if (!isUpper(chr[lt])) {
                chr[lt] &= 0x5f;
            }

            lt++;
        }

        while (lt < rt) {
            if (isUpper(chr[lt])) {
                chr[lt] ^= 0x20;
            }

            lt++;
        }
    }

    public boolean isUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
