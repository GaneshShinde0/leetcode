public class ZigzagIterator {
    boolean turn;
    int idx1;
    int idx2;
    List<Integer> v1;
    List<Integer> v2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.turn = true;
        this.idx1 = 0;
        this.idx2 = 0;
        this.v1 = v1;
        this.v2= v2;
    }

    public int next() {
        if(turn && idx1<v1.size()){
            turn=!turn;
            idx1++;
            return v1.get(idx1-1);
        }else if(!turn && idx2<v2.size()){
            turn=!turn;
            idx2++;
            return v2.get(idx2-1);
        }else if(idx1<v1.size()){
            idx1++;
            return v1.get(idx1-1);
        }else if(idx2<v2.size()){
            idx2++;
            return v2.get(idx2-1);
        }
        return -1;
    }

    public boolean hasNext() {
        return idx1<v1.size()||idx2<v2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */