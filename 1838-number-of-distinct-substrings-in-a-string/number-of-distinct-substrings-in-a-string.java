class Node {
    Node[] children = new Node[26];
}

class Solution {
    public int countDistinct(String s) {
        Node root = new Node();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Node cur = root;
            for (int j = i; j < s.length(); j++) {
                if (cur.children[s.charAt(j) - 'a'] == null) {
                    cur.children[s.charAt(j) - 'a'] = new Node();
                    res++;
                }
                cur = cur.children[s.charAt(j) - 'a'];
            }
        }
        return res;
    }
}

/*
a=>1
ab=> 3
abc=> 6

So for every character how many substrings are possible on left + how many substrings are possbile on right?
.. wont work..

aabbaba


If Previous character is same then 2*last ans ..
Other wise 2*lastAns+1?

Lets see 

abcdefg
Lets think Naively

a=>1
ab=> One new character got added... Separate this and all its combination with all prev chars 2*prev +1=>3
abc=> One New Character got added... Previous Substrings + (Separate this and all its combination prev chars..) => 3+3
abcd=> 6 + 4
abcde=> 10+5
abcdef=>15+6
abcdefg=>21+7=>28


Now think about duplicates.
aabbaba

a => 1
aa=> hm.contains(a)?  yes, => 1+(2)-1=>
aab=> 2+3 => 5
aabb=> 5+4-1=>8
aabba=>8+5-1=>12
aabbab=>12+

*/