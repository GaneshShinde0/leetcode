/*
# Intuition

Each type of garbage (Paper **P**, Glass **G**, Metal **M**) is collected by a separate truck.
A truck only needs to travel **up to the last house** where its garbage type appears.

So for each garbage type:

* Count how many units of that garbage exist (each unit takes 1 minute to pick).
* Track the **last index** where that garbage appears.
* Add the travel time needed to reach that last house.

The final answer is the **sum of collection time + travel time** for all three garbage types.

---

# Approach

1. Traverse all houses once:

   * Count total units of **P**, **G**, and **M**.
   * Track the last house index where each garbage type appears.
2. For each garbage type:

   * Add its total units (pickup time).
   * Add the travel time from house `0` to its last required house.
3. Travel time is computed using a helper method that sums the `travel[]` array up to the required index.
4. Return the total accumulated time.

This avoids redundant travel and ensures each truck only goes as far as needed.

---

# Complexity

* **Time complexity:**
  [
  O(n + t)
  ]
  where `n` is the total number of characters across all `garbage[i]` strings and `t` is the length of the `travel` array.

* **Space complexity:**
  [
  O(1)
  ]
  Only constant extra variables are used.

---


Input: garbage = ["G","P","GP","GG"], travel = [2,4,3]

Paper: (2)=>2+1=> 3+(4)+1=> 8
Metal: 0 
Glass: 1 => 1+(2) =>3+(4)+1 => 8+(3)+2=>13 
*/
class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int p=0, g=0, m=0;
        int res = 0;
        int pu=0 , gu=0, mu = 0; // Paper, Glass, Metal Units.
        for(int i=0; i<garbage.length; i++){
            for(char c:garbage[i].toCharArray()){
                if(c=='G') {
                    gu++;
                    g=i;
                }
                if(c=='P'){
                    pu++;
                    p=i;
                }
                if(c=='M'){
                    mu++;
                    m=i;
                }
            }
        }
        res+=calculateTravelTime(travel,g)+gu;
        res+=calculateTravelTime(travel,m)+mu;
        res+=calculateTravelTime(travel,p)+pu;
        return res;
    }
    private int calculateTravelTime(int[] travel, int lastHouse){
        int travelTime = 0;
        for(int i=0;i<lastHouse;i++){
            travelTime +=travel[i];
        }
        return travelTime;
    }
}