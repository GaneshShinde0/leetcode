/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrityInitial(int n) {
        System.out.println(n);
        int[] knowsCount = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j ) continue;
                else if(!knows(j,i)) break;
                else knowsCount[i]++;
                System.out.println(i+", j"+j);
            }
        }
        System.out.println(Arrays.toString(knowsCount));
        int res = -1;
        int count = 0;
        for(int i=0;i<n;i++){
            if(knowsCount[i]==n-1){
                res = i;
                count++;
            }
        }
        if(count!=1) return -1;
        return res;
    }

    
    private int numberOfPeople;
    
    private Map<Pair<Integer, Integer>, Boolean> cache = new HashMap<>(); 
    
    @Override
    public boolean knows(int a, int b) {
        if (!cache.containsKey(new Pair(a, b))) {
            cache.put(new Pair(a, b), super.knows(a, b));
        }
        return cache.get(new Pair(a, b));
    }
    
    public int findCelebrity(int n) {
        numberOfPeople = n;
        int celebrityCandidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(celebrityCandidate, i)) {
                celebrityCandidate = i;
            }
        }
        if (isCelebrity(celebrityCandidate)) {
            return celebrityCandidate;
        }
        return -1;
    }
    public int findCelebrityON(int n) {
        numberOfPeople = n;
        int celebrityCandidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(celebrityCandidate, i)) {
                celebrityCandidate = i;
            }
        }
        if (isCelebrity(celebrityCandidate)) {
            return celebrityCandidate;
        }
        return -1;
    }
    
    private boolean isCelebrity(int i) {
        for (int j = 0; j < numberOfPeople; j++) {
            if (i == j) continue; // Don't ask if they know themselves.
            if (knows(i, j) || !knows(j, i)) {
                return false;
            }
        }
        return true;
    }
}