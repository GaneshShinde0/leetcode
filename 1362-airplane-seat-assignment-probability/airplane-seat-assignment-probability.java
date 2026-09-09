class Solution {
    public double nthPersonGetsNthSeat(int n) {
        if(n==1) return 1.0;
        return 0.5;
    }
}

/*
**The chain-of-displacement explanation, crisp version:**

- Passenger 1 sits randomly in seat `k`.
- If `k = 1` → no chaos → passenger n gets seat n. ✅
- If `k = n` → passenger n's seat taken → passenger n loses. ❌
- If `k` is any middle seat → passengers between just sit normally, and passenger `k` becomes the new "random picker," repeating the same situation.

So it's a chain: person 1 → displaces someone → displaces someone → ... until the chain randomly lands on **seat 1** or **seat n**. Those are the only two seats that end the chain; every other seat just continues it.

Since seat 1 and seat n are treated identically by this random process (neither is special during the chain), the chain is equally likely to end on either one.

**Result:** `P(seat 1 ends it) = P(seat n ends it) = 1/2` → so passenger n gets their own seat with probability **1/2**, for any `n ≥ 2`. For `n = 1`, probability is trivially `1`.
*/