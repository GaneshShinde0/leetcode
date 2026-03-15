/*
Intuition:

Goal is to create a sequence that allows for efficient updates and queries. The sequence supports the following operations.

1. Append: Appends a value to the sequence.
2. Add All: Adds an incremenet to all the elements in the sequence.
3. Multiply All: Multiplies all elments by a given factor.
4. Get Index: Retrieves the value at a specific indexx, adjusted by previous operations.

Use Modular arithmetic to ensure vlues do not overflow. The sequence is designed to handle large numbers efficiently using modular inverse and fast power calculation (Modular exponenciation).

Approach:

The operations are optimized by tracking global multiplier (a) and a global increment (b). These variables represent the combined effects of all previous addAll and multAll operations.

- append(val): When a new value is appended, it is adjusted using the global increment b and the modular inverse of the global multiplier a.
- addAll(inc): This operation adds inc to the global increment b, which will affect all subsequent operations.
- multAll(m): This operation multiplies all values by m by updating both the global multiplier a and the global increment b.
- Thi operation retrieves the value at the specified index, adjusted by both the global multiplier and increment.

## Helper Methods:
- Modular Exponenciation: Efficiently computes x^y%mod using exponenciation by squaring. 
- Modular Inverse: Computes the inverse of a modulo MOD using Fermat's little Theorem, which states that a&(MOD-2)%MOD is the modular inveerse of a when MOD is prime.

Complexity:
- Time Complexity:
    - append(val): O(1)
    - addAll(inc) and multAll(m): O(1)
    - getIndex(idx): O(1)
    - modPow(x,y,mod): O(logy) where y is the exponent in the modular exponenciation.

*/


class Fancy {

    private static final int MOD = 1_000_000_007;
    private ArrayList<Long> sequence;
    private long mult, add;

    public Fancy() {
        sequence = new ArrayList<>();
        mult = 1;
        add = 0; 
    }

    private long modPow(long x, long y, long mod){
        long res = 1;
        x = x%MOD;
        while(y>0){
            if(y%2==1){
                res = (res*x)%MOD;
            }
            y = y/2;
            x = (x*x)%MOD;
        }
        return res;
    }
    
    public void append(int val) {
        long x = (val-add+MOD)%MOD;
        this.sequence.add((x*modPow(mult,MOD-2,MOD))%MOD);
    }

    public void addAll(int inc){
        add = (add+inc)%MOD;
    }

    public void multAll(int m){
        mult = (mult*m)%MOD;
        add = (add*m)%MOD;
    }
    
    public int getIndex(int idx) {
        if(idx>=sequence.size()) return -1;
        return (int)((mult*sequence.get(idx)+add)%MOD);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */