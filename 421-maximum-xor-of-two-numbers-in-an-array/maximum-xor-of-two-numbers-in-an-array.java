class Solution {
    public int findMaximumXOR(int[] nums) {
        int n = nums.length, res = 0;
        for(int i=31;i>=0;i--){
            Set<Integer> prefixes = new HashSet<Integer>();
            int target = res | (1<<i);
            for(int num:nums){
                num = (num>>i)<<i; // Mask out everything below i
                prefixes.add(num);
            }
            // System.out.println(prefixes);
            for(Integer p1:prefixes){
                int p2 = p1^target;
                if(prefixes.contains(p2))res = Math.max (res,p1^p2);
            }
        }
        return res;
    }
}
/*
The answer should be O(n) or O(nlogn);
Possibilities
1,2,4,8,16
In this case max xor would be 24

... 
1,2,3,7
In this case max xor would be 6.

Here, Binary search or any such alogorithm wont work.

Lets see relation between and and xor
Bits => And => OR => XOR
00 => 0 => 0 => 0
01 => 0 => 1 => 1
10 => 0 => 1 => 1
11 => 1 => 1 => 0

(And of all bits ^(XOR) OR of all bits) might work
Lets test on some in put.
3, 10, 5 => 11, 1010, 101 => 15
Bits => And => OR => XOR
AND => 0
OR => 1111
(AND ^ OR) 0 ^ 1111=> 1111 => Works

Another input 
3,10,7 => 11, 1010, 111 => 1101 =>13
AND => 10
OR => 1111
XOR (AND ^ OR)=> 1101 => Works

Another Input
1,2,4,8,16  => 1,10, 100, 1000, 10000 => 11000=> 24
AND = 0
OR = 11111
XOR (AND ^ OR)= 11111 => does not work.

We need to group all the numbers with rightmost bits.. and maybe check first 0 bit after that bit for all numbers are present or not.
Maybe some kind of df



*/