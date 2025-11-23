/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    private int buffPtr = 0;
    private int charRead = 0;
    private char[] buff = new char[4];
    public int read(char[] buf, int n) {
        int N = n;
        int curr = 0;
        while(curr<n){
            if(buffPtr==0){
                charRead=read4(buff);
            }
            // System.out.println("Chars Read:"+charRead);
            // System.out.println("Chars Read:"+charRead);
            // System.out.println(charRead);
            while(curr<N && buffPtr<charRead){
                buf[curr++] = buff[buffPtr++];
            }
            if(buffPtr>=charRead) buffPtr = 0;
            if(charRead<4) break;
        }
        return curr;
    }
}