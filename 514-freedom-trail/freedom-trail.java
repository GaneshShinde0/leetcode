/*
Objective:
- Find Minimum number of steps required to spell the keyword using dial.
- Following operations count as one step.
    1. Rotate the metal dial clockwise/anticlockwise.
    2. Press the center button to spell a character.

When spelling a given character key[i], the number of steps it takes to spell the character will be the number of rotations made to put the character int 1200 position plus one, which represents pressing the center button to spell the character.
*/

class Solution{
    public int findRotateSteps(String ring, String key){
        int ringLen = ring.length(), keyLen = key.length();
        int[][] bestSteps = new int[ringLen][keyLen+1];

        for(int keyIdx=keyLen-1;keyIdx>=0;keyIdx--){
            for(int ringIdx=0;ringIdx<ringLen;ringIdx++){
                bestSteps[ringIdx][keyIdx] = Integer.MAX_VALUE/4;
                for(int start = 0;start<ringLen;start++){
                    if(ring.charAt(start)!=key.charAt(keyIdx)) continue;
                    int stepsBetween = Math.abs(start-ringIdx);
                    int stepsAround = ringLen-stepsBetween;
                    int steps = Math.min(stepsBetween, stepsAround);
                    bestSteps[ringIdx][keyIdx] = Math.min(bestSteps[ringIdx][keyIdx],
                                                         steps + bestSteps[start][keyIdx+1]);
                }
            }
        }
        return bestSteps[0][0] + keyLen;
    }
}

// Time:  K.R.R (K Recursive calls, one for each letter in key). (Every character in R is same then initial tryLock will be called R times and in recursion (R-1) times)
// Space: K.R. (Map)
class SolutionTopDown{
    private static final int MAX = Integer.MAX_VALUE;
    public int findRotateSteps(String ring, String key){
        Map<Pair<Integer,Integer>,Integer> bestSteps = new HashMap<>();
        return tryLock(0,0, ring, key, MAX, bestSteps);
    }

    private int countSteps(int curr, int next, int ringLength){
        int stepsBetween = Math.abs(curr-next);
        int stepsAround = ringLength-stepsBetween;
        return Math.min(stepsBetween, stepsAround);
    }
    private int tryLock(int ringIndex, int keyIndex, String ring, String key, int minSteps, Map<Pair<Integer, Integer>, Integer> bestSteps){
        if(bestSteps.containsKey(new Pair<>(ringIndex, keyIndex))){
            return bestSteps.get(new Pair<>(ringIndex, keyIndex));
        }
        if(keyIndex == key.length()) return 0;
        for(int i=0;i<ring.length();i++){
            if(ring.charAt(i)==key.charAt(keyIndex)){
                int currSteps = countSteps(ringIndex, i, ring.length())+1+tryLock(i,keyIndex+1, ring, key,  MAX, bestSteps);
                minSteps = Math.min(minSteps,currSteps);
            }
        }
        bestSteps.put(new Pair<>(ringIndex, keyIndex), minSteps);
        return minSteps;
    }
}
class SolutionBruteForce{
    private static final int MAX = Integer.MAX_VALUE;
    public int findRotateSteps(String ring, String key){
        return tryLock(0,0, ring, key, MAX);
    }

    private int countSteps(int curr, int next, int ringLength){
        int stepsBetween = Math.abs(curr-next);
        int stepsAround = ringLength-stepsBetween;
        return Math.min(stepsBetween, stepsAround);
    }
    private int tryLock(int ringIndex, int keyIndex, String ring, String key, int minSteps){
        if(keyIndex == key.length()) return 0;
        for(int i=0;i<ring.length();i++){
            if(ring.charAt(i)==key.charAt(keyIndex)){
                int currSteps = countSteps(ringIndex, i, ring.length())+1+tryLock(i,keyIndex+1, ring, key,  MAX);
                minSteps = Math.min(minSteps,currSteps);
            }
        }
        return minSteps;
    }
}