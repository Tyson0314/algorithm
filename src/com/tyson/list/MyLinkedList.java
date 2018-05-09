package com.tyson.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {
	private int flag = 0;
	private int size;
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;
	
	public MyLinkedList() {
		doClear();
	}
	
	public void clear() {
		doClear();
	}
	//清空链表
	public void doClear() {
		beginMarker = new Node<AnyType>(null, null, null);
		endMarker = new Node<AnyType>(null, beginMarker, null);
		beginMarker.next = endMarker;
		
		size = 0;
		flag++;
	}
		
	//链表大小
	public int size() {
		return size;
	}
	
	//添加
	public boolean add(AnyType x) {
		add(size(), x);
		return true;
	}
	public void add(int idx, AnyType x) {
		addBefore(getNode(idx, 0, size()), x);
	}
	public void addBefore(Node<AnyType> n, AnyType x) {
		Node<AnyType> newNode = new Node<AnyType>(x, n.prev, n);
		n.prev.next = newNode;
		n.prev = newNode;
		size++;
		flag++;
	}
	
	//删除节点
	public AnyType remove(int idx) {
		return remove(getNode(idx));
	}
	public Node<AnyType> getNode(int idx) {
		return getNode(idx, 0, size()-1);
	}
	public AnyType remove(Node<AnyType> n) {
		n.next.prev = n.prev;
		n.prev.next = n.next;
		
		size--;
		flag--;
		
		return n.data;
	}
	//得到索引处的节点
	public Node<AnyType> getNode(int idx, int lower, int upper) {
		Node<AnyType> n; 
		
		if(idx<lower||idx>upper) {
			throw new IndexOutOfBoundsException();
		}
		
		if(idx<size()/2) {
			n = beginMarker.next;
			for(int i=0;i<idx;i++) 
				n = n.next;	
		} else {
			n = endMarker;
			for(int i=size();i>idx;i--) 
				n = n.prev;
		}
		
		return n;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(size);
	}

	//set方法
	public AnyType set(int idx, AnyType newVal) {
		Node<AnyType> n = getNode(idx);
		AnyType oldVal = n.data;
		n.data = newVal;
		return oldVal;
	}
	
	//双链表结点
	private static class Node<AnyType> {
		private AnyType data;
		private Node<AnyType> prev;
		private Node<AnyType> next;
		
		public Node(AnyType data, Node<AnyType> prev, Node<AnyType> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

	@Override
	public Iterator<AnyType> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	private class LinkedListIterator implements Iterator<AnyType> {
		private Node<AnyType> current = beginMarker.next;
		private int expectedFlag = flag;
		private boolean okToRemove = false;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != endMarker;
		}

		@Override
		public AnyType next() {
			// TODO Auto-generated method stub
			if(flag != expectedFlag) {
				throw new ConcurrentModificationException();
			}
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			
			AnyType nextItem = current.data;
			current = current.next;
			okToRemove = true;
			return nextItem;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			if(flag != expectedFlag) {
				throw new ConcurrentModificationException();
			}
			if(!okToRemove) {
				throw new IllegalStateException();
			}
			
			MyLinkedList.this.remove(current.prev);
			expectedFlag--;
			okToRemove = false;
		}
		
	}

}
