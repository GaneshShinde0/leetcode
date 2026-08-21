/*
**General Inclusion-Exclusion (n sets):**
$$|A_1 \cup A_2 \cup ... \cup A_n| = \sum |A_i| - \sum |A_i \cap A_j| + \sum |A_i \cap A_j \cap A_k| - ... $$

The sign alternates strictly by subset size: **odd size → +, even size → −**. This is exactly what `Integer.bitCount(mask) % 2` checks in your code.
---

## Example 1: 3 coins → `coins=[2,3,5]`, `x=30`

**General formula:**
$$|A\cup B\cup C| = |A|+|B|+|C| - |A\cap B|-|A\cap C|-|B\cap C| + |A\cap B\cap C|$$

**Every individual subset (mask):**

| Subset | lcm | x/lcm | Sign | Contribution |
|---|---|---|---|---|
| {2} | 2 | 15 | + | +15 |
| {3} | 3 | 10 | + | +10 |
| {5} | 5 | 6 | + | +6 |
| {2,3} | 6 | 5 | − | −5 |
| {2,5} | 10 | 3 | − | −3 |
| {3,5} | 15 | 2 | − | −2 |
| {2,3,5} | 30 | 1 | + | +1 |

**Plug into formula:**
$$(15+10+6) - (5+3+2) + 1 = 31 - 10 + 1 = 22$$

**Final total = 22** (verified: numbers 1–30 not divisible by 2,3,5 = 8, so 30−8=22 ✅)

---

## Example 2: 5 coins → `coins=[2,3,4,5,6]`, `x=60`

**General formula:**
$$|A\cup B\cup C\cup D\cup E| = \sum|A_i| - \sum|A_i\cap A_j| + \sum|A_i\cap A_j\cap A_k| - \sum(\text{4-way}) + |A\cap B\cap C\cap D\cap E|$$

**Every individual subset (mask), grouped by size:**

*Size 1 (sign +):*
| Subset | lcm | x/lcm |
|---|---|---|
| {2} | 2 | 30 |
| {3} | 3 | 20 |
| {4} | 4 | 15 |
| {5} | 5 | 12 |
| {6} | 6 | 10 |

Sum = 87

*Size 2 (sign −):*
| Subset | lcm | x/lcm |
|---|---|---|
| {2,3} | 6 | 10 |
| {2,4} | 4 | 15 |
| {2,5} | 10 | 6 |
| {2,6} | 6 | 10 |
| {3,4} | 12 | 5 |
| {3,5} | 15 | 4 |
| {3,6} | 6 | 10 |
| {4,5} | 20 | 3 |
| {4,6} | 12 | 5 |
| {5,6} | 30 | 2 |

Sum = 70

*Size 3 (sign +):*
| Subset | lcm | x/lcm |
|---|---|---|
| {2,3,4} | 12 | 5 |
| {2,3,5} | 30 | 2 |
| {2,3,6} | 6 | 10 |
| {2,4,5} | 20 | 3 |
| {2,4,6} | 12 | 5 |
| {2,5,6} | 30 | 2 |
| {3,4,5} | 60 | 1 |
| {3,4,6} | 12 | 5 |
| {3,5,6} | 30 | 2 |
| {4,5,6} | 60 | 1 |

Sum = 36

*Size 4 (sign −):*
| Subset | lcm | x/lcm |
|---|---|---|
| {2,3,4,5} | 60 | 1 |
| {2,3,4,6} | 12 | 5 |
| {2,3,5,6} | 30 | 2 |
| {2,4,5,6} | 60 | 1 |
| {3,4,5,6} | 60 | 1 |

Sum = 10

*Size 5 (sign +):*
| Subset | lcm | x/lcm |
|---|---|---|
| {2,3,4,5,6} | 60 | 1 |

Sum = 1

**Plug into formula:**
$$87 - 70 + 36 - 10 + 1 = 44$$

**Final total = 44**

This matches the direct check: numbers 1–60 not divisible by any of 2,3,4,5,6 (equivalent to not divisible by 2,3, or 5) = 16, so 60−16=44 ✅

*/

class Solution {
    private int[] coins;
    public long findKthSmallest(int[] coins, int k) {
        this.coins = coins;
        Arrays.sort(coins);
        long left = k, right = 1l*k*coins[0];
        while(left<right){
            long mid = (left+right)/2;
            long coinsFound = count(mid);
            if(coinsFound>=k){ // 
                right = mid;
            }else if(coinsFound<k){
                left = mid+1;
            }
        }
        return left;
    }
    private long count(long x){
        long total = 0;
        // Enumerate every non-empty subset of coins using bitmask.
        // mask's bits tell us which coins belong to this subset.
        for(int mask = 1; mask < (1 << coins.length); mask++){
            long lcm = 1;
            for(int i = 0; i < coins.length; i++){
                if(((1<<i) & mask) > 0) {
                    lcm = lcm(coins[i], lcm); // lcm of all coins included in this subset
                    if(lcm > x) break;  // stop building THIS subset's lcm early
                }
            }

            // x / lcm = count of numbers <= x divisible by EVERY coin in this subset
            // (i.e., the size of the intersection of "multiples of coin_i" sets for i in subset)

            if(Integer.bitCount(mask) % 2 == 0){
                // Even-sized subset -> this intersection was already
                // double-counted when we added its individual smaller subsets,
                // so we cancel out the over-count by subtracting it.
                total -= x/lcm;
            } else {
                // Odd-sized subset -> by the inclusion-exclusion pattern
                // (+ for size 1, - for size 2, + for size 3, ...),
                // this intersection needs to be added back in.
                total += x/lcm;
            }
        }
        return total; // total number of amounts <= x achievable by at least one coin
    }
    private long lcm(long a, long b){
        return a*b/gcd(a,b);
    }
    private long gcd(long a, long b){
        return a%b==0?b:gcd(b,a%b);
    }
}