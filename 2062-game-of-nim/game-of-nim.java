/*
Follwing are few important things to keep handy when we are playing game.
- Number of piles 

1,2,3

Alice: 1,2,2
Bob : [1,2,0] or [0,2,2]
Alice makes optimal move by making 0,2,2 to [0,1,2]
Bob[0,1,1]
Alice[0,1,0]
Bob[0,0,0] 
Alice cannot make move BOb Wins


Connsider 3,5
Alice [3,1]
Bob []


Few Rules
=> If Only one pile => Alice
=> 2 Piles
    => If only one of them is greater than one Alice wins
    => If both of them are greater than one 
        => Consider both of them are [2,2]
            => Alice will make one of them as 1.
            => Bob will also make other of them as 1.
            => Alice Picks 1
            => Bob Picks 1 
            => Bob Wins
        => Consider stones are [3,2] {if only on of them greater than 2} whose turn wins.
            => Alice will make one of them as 2 =>[2,2]
            => Bob will make one of them as 1
            => Alice [1,1]
            => Bob [0,1]
            => Alice Wins
        => [5,10] {If both of them are greater than 2} Oppposite Wins
            => Alice will make one of them as 2
            => Bob will make other one as 2
            => Alice will make one of them as 1
            => Bob Makes other one as 1
            => Alice removes 1
            => Bob Removes 1
            => Bob Wins
        => 
*/
class Solution {
    public boolean nimGame(int[] piles) {
        int n = piles.length;
        int nimSum = 0;
        for(int p:piles){
            nimSum = nimSum^p;
        }
        return nimSum!=0;
    }
}