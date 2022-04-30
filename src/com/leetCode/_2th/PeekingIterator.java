package com.leetCode._2th;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given an Iterator class interface with methods: next() and hasNext(), design
 * and implement a PeekingIterator that support the peek() operation -- it
 * essentially peek() at the element that will be returned by the next call to
 * next().
 * 
 * Here is an example. Assume that the iterator is initialized to the beginning
 * of the list: [1, 2, 3].
 * 
 * Call next() gets you 1, the first element in the list.
 * 
 * Now you call peek() and it returns 2, the next element. Calling next() after
 * that still return 2.
 * 
 * You call next() the final time and it returns 3, the last element. Calling
 * hasNext() after that should return false.
 * 
 * @author Zealot
 * @date 2016年1月10日 下午5:55:25
 */
public class PeekingIterator implements Iterator<Integer>{
	List<Integer> list = new ArrayList<Integer>();
	int index = 0;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
		while(iterator.hasNext()){
			list.add(iterator.next());
		}
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if(list.size()==0){
		   return 0;
		}
		return index>=list.size()?0:list.get(index);
	}
	
	@Override
	public boolean hasNext() {
		if(list.size()==0){
            return false;
        }
        
        return index>=list.size()?false:true;
	}

	@Override
	public Integer next() {
		return list.get(index++);
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
