class Solution {
    public String losingPlayer(int x, int y) {
        int turns = Math.min(x,y/4); // We can take one x & 4 y's; So lets see how many games are possible
        return turns%2==1 ? "Alice":"Bob"; // If Odd Games are possible "Alice" Wins, If Even Games Are Possible Bob Wins.
    }
}
