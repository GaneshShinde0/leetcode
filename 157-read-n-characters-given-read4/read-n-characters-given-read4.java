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
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int count = 0, readChars = 4;

        while(count<n && readChars == 4){
            readChars = read4(temp);
            for(int i = 0;i<readChars;i++){
                if(count == n) return count;
                buf[count] = temp[i];
                count++;
            }
        }
        return count;
    }
}