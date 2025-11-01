class StringIterator {
    private int i;
    private int j;
    private String s;
    char ch = ' ';
    public StringIterator(String compressedString) {
        this.s = compressedString;
        this.i=0;
        this.j=0;
    }
    
    public char next() {
        if(!hasNext()) return ' ';
        if(j==0){
            ch = s.charAt(i++);
            while(i<s.length() && Character.isDigit(s.charAt(i))){
                j = j*10+s.charAt(i++)-'0';
            }
        }
        j--;
        return ch;
    }
    
    public boolean hasNext() {
        return i!=s.length()||j!=0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */