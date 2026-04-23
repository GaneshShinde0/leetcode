// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer peekingValue;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.iter = iterator;
        this.peekingValue = null;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(peekingValue==null){
            peekingValue = iter.next();
        }
        return peekingValue;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(peekingValue!=null){
            Integer toReturn = peekingValue;
            peekingValue = null;
            return toReturn;
        }
        return iter.next();
	}
	
	@Override
	public boolean hasNext() {
	    return peekingValue!=null || iter.hasNext();
	}
}