// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer peekedValue;
	public PeekingIterator(Iterator<Integer> iterator) {
        this.iter = iterator;
        peekedValue=null;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (peekedValue == null) {
            peekedValue = iter.next();
        }
        return peekedValue;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if(peekedValue != null){
            Integer toReturn = peekedValue;
            peekedValue = null;
            return toReturn;
        }
	    return iter.next();
	}
	
	@Override
	public boolean hasNext() {
	    return peekedValue != null ||  iter.hasNext();
	}
}