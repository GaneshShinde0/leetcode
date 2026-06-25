class Solution {
    public String arrangeWords(String text) {
        String[] arr = text.split(" ");
        final String temp = text;
        Arrays.sort(arr,(a,b)->{
            
                return Integer.compare(a.length(), b.length());
        });
        String res = String.join(" ",arr);
        return res.substring(0,1).toUpperCase()+res.substring(1).toLowerCase();
    }
}