package com.tyson.list;

import java.util.Iterator;

public class MyArrayList<AnyType> implements Iterable<AnyType> {
	private static final int CAPACITY = 10;
	
	private int size;//数组大小
	private AnyType[] items;
	
	//size方法
	public int size() {
		return size;
	}
	
	//get方法
	public AnyType get(int idx) {
		if(idx<0||idx>=size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return items[idx];
	}
	
	//clear方法
	public void clear() {
		doClear();
	}
	
	//doclear
	public void doClear() {
		size = 0;
		ensureCapacity(CAPACITY);
	}
	
	//isEmpty方法
	public boolean isEmpty() {
		return size == 0;
	}
	
	//trimToSize方法，删除多余容量
	public void trimToSize() {
		ensureCapacity(size);
	}
	
	//add方法
	public boolean add(AnyType x) {
		add(size(), x);
		return true;
	}
	public void add(int idx, AnyType x) {
		if(items.length == size) 
			ensureCapacity(size*2 + 1);
		for(int i=size;i>idx;i--) {
			items[i] = items[i-1];
		}
		items[idx] = x;
		
		size++;
	}
	
	//remove方法
	public AnyType remove(int idx) {
		AnyType oldItem = items[idx];
		for(int i=idx;i<size-1;i++) {
			items[i] = items[i+1];
		}
		
		size--;
		return oldItem;
	}
	
	//改变数组容量
	public void ensureCapacity(int newCapacity) {
		if(newCapacity < size) {
			return ;
		}
		
		AnyType[] old = items;
		items = (AnyType[]) new Object[newCapacity];
		for(int i=0;i<size;i++) {
			items[i] = old[i];
		}
	}
	
	@Override
	public Iterator<AnyType> iterator() {
		// TODO Auto-generated method stub
		return new ArrayListIterator();
	}
	//Iterator具体实现
	class ArrayListIterator implements Iterator<AnyType> {
		private int current;
		
		public boolean hasNext() {
			return current<size;
		}
		public AnyType next() {
			return items[current++];
		}
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			MyArrayList.this.remove(--current);
		}
	}
}
