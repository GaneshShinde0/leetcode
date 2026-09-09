class Solution {
    public double nthPersonGetsNthSeat(int n) {
        if(n==1) return 1.0;
        return 0.5;
    }
}

/*
1st person sat randomly..
Probability of him getting correct sit 1/n.

2nd Person sat randomly.
Probability of him getting corret sit.. His Initial probability 
    => If person 1 selects his sit... (1/n)
        => Personn 2 will select his sit for sure as he has ticket... 1.
            => Final 1;
    => If Person 1 selects wrong sit...  This is very high (n-1)/n
        => Probability of second person getting his own sit. (n-1)/n
            => Final (n-1)/n;
    
3rd Person.

    => If first person sat correctly. (1/n)
        => Personn 2 will select his sit for sure as he has ticket... 1.
            => Personn 3 will select his sit for sure as he has ticket... 1.
                => Final 1;
    => If first person seats wrongly. (n-1)/n.
        => Probability of second person getting his own sit. (n-1)/n
            => He gets correct seat => (n-1)/n.
                => Probability of Third Person Getting Correct Seat 1.
            => He does not get correct seat => 1/n.
                => He Sits at random place .. making 2 wrong positions... Which will lead to (n-3) Positions (Wrong).
                    n-3/n
        
            => Probabilitty of third person getting his own sit. (n-2)/n


*/