/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 *     int coefficient, power;
 *     PolyNode next = null;
 
 *     PolyNode() {}
 *     PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 *     PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode temp = new PolyNode(Integer.MAX_VALUE, Integer.MAX_VALUE);
        PolyNode res = temp;
        while(poly1!=null && poly2!=null){
            if(poly1.power>poly2.power){
                res.next = new PolyNode(poly1.coefficient, poly1.power);
                poly1 = poly1.next;
                res = res.next;
            }else if(poly2.power>poly1.power){
                res.next = new PolyNode(poly2.coefficient, poly2.power);
                poly2 = poly2.next;
                res = res.next;
            }else{
                if(poly1.coefficient+poly2.coefficient!=0){
                    res.next = new PolyNode(poly1.coefficient+poly2.coefficient, poly1.power);
                    res = res.next;
                }
                poly1 = poly1.next;
                poly2 = poly2.next;
            }
        }
        
        if(poly1!=null){
            res.next = poly1;
        }
        if(poly2!=null){
            res.next = poly2;
        }
        return temp.next;
    }
}