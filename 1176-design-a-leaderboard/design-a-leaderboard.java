/*

playerId, K <= 10000
score<=100
1000 calls;
1000 calls to 10000... Suggests Time Complexity should be O(log(n));

Has there are 100 scores only... We can use set to save score and then save id of player into Set of That store.
Kind of like HashMap<Integer, Set<Integer>> = new HashMap();
*/

class LeaderboardInitial{
    TreeMap<Integer, Set<Integer>> scoreToPlayers;
    HashMap<Integer,Integer> playerToScore;
    public LeaderboardInitial() {
       scoreToPlayers= new TreeMap<>();
       playerToScore = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        int newScore = playerToScore.getOrDefault(playerId, 0)+score;
        reset(playerId);
        scoreToPlayers.computeIfAbsent(newScore,k->new HashSet<Integer>()).add(playerId);
        playerToScore.put(playerId, newScore);
    }
    
    public int top(int K) {
        int res = 0;
        for(Map.Entry<Integer, Set<Integer>> e: scoreToPlayers.descendingMap().entrySet()){
            if(K>e.getValue().size()){
                res+=e.getKey()* e.getValue().size();
                K -= e.getValue().size();
            }else{
                res+= e.getKey()*K;
                break;
            }
        }
        return res;
    }
    
    public void reset(int playerId) {
        int score = 0;
        if(playerToScore.containsKey(playerId)){
            score = playerToScore.get(playerId);
            playerToScore.remove(playerId);
        }
        Set<Integer> set = scoreToPlayers.get(score);
        if(set==null) return;
        if(set.contains(playerId)) set.remove(playerId);
    }
}

class Leaderboard {
    private final TreeMap<Integer, Set<Integer>> scoreToPlayers;
    private final Map<Integer, Integer> playerToScore;

    public Leaderboard() {
        scoreToPlayers = new TreeMap<>();
        playerToScore = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        int oldScore = playerToScore.getOrDefault(playerId, 0);
        int newScore = oldScore + score;

        if (oldScore != 0) removeFromScoreMap(playerId, oldScore);
        scoreToPlayers.computeIfAbsent(newScore, k -> new HashSet<>()).add(playerId);
        playerToScore.put(playerId, newScore);
    }

    public int top(int K) {
        int sum = 0;
        for (var entry : scoreToPlayers.descendingMap().entrySet()) {
            int score = entry.getKey();
            Set<Integer> players = entry.getValue();
            int count = players.size();

            if (K > count) {
                sum += score * count;
                K -= count;
            } else {
                sum += score * K;
                break;
            }
        }
        return sum;
    }

    public void reset(int playerId) {
        Integer oldScore = playerToScore.remove(playerId);
        if (oldScore != null) removeFromScoreMap(playerId, oldScore);
    }

    private void removeFromScoreMap(int playerId, int score) {
        Set<Integer> set = scoreToPlayers.get(score);
        if (set == null) return;
        set.remove(playerId);
        if (set.isEmpty()) scoreToPlayers.remove(score);
    }
}
/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */