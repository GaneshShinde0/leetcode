class Solution {
    public String addBinary(String a, String b) {
        if(a.length()<b.length()) return addBinary(b,a);
        int alen = a.length();
        b=padWithZeros(b,alen);
        int blen = b.length();

        StringBuilder res = new StringBuilder();
        char carry='0';
        int i=1;
        // System.out.println(a);
        // System.out.println(b);

        while(i<=alen){
            if(a.charAt(alen-i)=='1' && b.charAt(blen-i)=='1' && carry=='0'){
                res.append('0');
                carry = '1';
            }else if(a.charAt(alen-i)=='1' && b.charAt(blen-i)=='1' && carry=='1'){
                res.append('1');
                carry = '1';
            }else if(((a.charAt(alen-i)=='1' && b.charAt(blen-i)=='0')||(a.charAt(alen-i)=='0' && b.charAt(blen-i)=='1')) && carry=='0'){
                res.append('1');
                carry = '0';
            }else if(((a.charAt(alen-i)=='1' && b.charAt(blen-i)=='0')||(a.charAt(alen-i)=='0' && b.charAt(blen-i)=='1')) && carry=='1'){
                res.append('0');
                carry = '1';
            }else if(a.charAt(alen-i)=='0' && b.charAt(blen-i)=='0'){
                res.append(carry);
                carry='0';
            }
            i++;
        }
        if(carry=='1')res.append(carry);
        return res.reverse().toString();
    }

    public String padWithZeros(String str, int length) {
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() < length) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }

    public String addBinaryPrevNotWorking(String a, String b) {
        int res = Integer.parseInt(a,2)+Integer.parseInt(b,2);
        String s = getBin(res);
        return s.length()==0?"0":s;
    }
    public String getBin(int num){
        StringBuilder sb = new StringBuilder();
        while(num>0){
            sb.append(num%2);
            num=num/2;
        }
        return sb.reverse().toString();
    }


    public String addBinary0ms(String a, String b) {
        if (a.length() > b.length())
            return addBinary(b, a);
        
        char[] charArray = new char[b.length()+1];
        int charIndex = charArray.length-1;
        int carry = 0;
        int aLength = a.length()-1;
        int bLength = b.length()-1;
        while (bLength >= 0){
            if (aLength >= 0){
                carry +=  (int) (a.charAt(aLength)-'0');
                aLength--;
            }
            if (bLength >= 0){
                carry += (int) (b.charAt(bLength)-'0');
                bLength--;
            }
            charArray[charIndex--] = (char) ('0'+carry%2);
            carry = carry/2;
        }
        if (carry == 1){
            charArray[0] = '1';
            return new String(charArray);
        }
        return new String(charArray, 1, charArray.length-1);
    }

    public String addBinary1ms(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while(i >= 0|| j >= 0) {
            int sum = carry;

            if(j >= 0) sum += b.charAt(j--) - '0';
            if(i >= 0) sum += a.charAt(i--) - '0';

            sb.append(sum % 2);
            carry = sum / 2;
        }

        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
