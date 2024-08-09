class ArrayFormOfInteger {
    public List<Integer> addToArrayForm55Ms(int[] num, int k) {
        long a=0;
        int carry=0;
        List<Integer> li = new ArrayList<Integer>();
        for(int i=num.length-1;i>=0;i--){
            int last = num[i]+k%10+carry;
            k=k/10;
            carry=last/10;
            li.add(0,last%10);
        }
        //If there is still a carry or k is not exhausted
        while (k > 0 || carry > 0) {
            int sum = k % 10 + carry;
            li.add(0, sum % 10);
            carry = sum / 10;
            k = k / 10;
        }
        return li;
    }

    public List<Integer> addToArrayForm3Ms(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int n = num.length;
        int i = n - 1;
        int carry = 0;
        
        while (i >= 0 || k > 0) {
            int digit = (i >= 0) ? num[i] : 0;
            int sum = digit + (k % 10) + carry;
            result.add(sum % 10);
            carry = sum / 10;
            k /= 10;
            i--;
        }
        
        if (carry > 0) {
            result.add(carry);
        }
        
        Collections.reverse(result);
        return result;
    }
    

    // Following code ignores calculations for k<=0; carry==1; As a result far less iterations
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        for (int i = num.length - 1; i >= 0 && (k > 0 || carry == 1); i--) {
            int curr = k % 10;
            k /= 10;
            num[i] += curr + carry;
            carry = 0;
            if (num[i] > 9) {
                num[i] %= 10;
                carry = 1;
            }
        }
        k += carry;
        while (k > 0) {
           result.add(0, k % 10);
           k /= 10;
        }
        for (int n : num) {
            result.add(n);
        }
        return result;
    }
}
