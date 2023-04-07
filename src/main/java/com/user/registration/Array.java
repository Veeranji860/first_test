package com.user.registration;

import java.util.Arrays;

class Sample{

	public void hello(){
		System.out.println("hello naga");
	}

	public void hello2(){
		System.out.println("helllll2");
	}
	
	public void hello3(){
		 System.out.println("hello naga3");
	}
}

public class Array<E> extends Thread{
	private int DEFAULT_CAPACITY=16;
	private static final Object[] EMPTY_ELEMENTDATA = {};
	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
	public Object[] elementData;
	transient int modCount=0;
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	private int size;

	public Array(int initialCapacity) {
		if (initialCapacity > 0) {
			this.elementData = new Object[initialCapacity];
		} else if (initialCapacity == 0) {
			this.elementData = EMPTY_ELEMENTDATA;
		} else {
			throw new IllegalArgumentException("Illegal Capacity: "+
					initialCapacity);
		}
	}

	public Array() {
		this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
	}

	public boolean add(E e) {
		modCount++;
		add(e, elementData, size);
		return true;
	}

	private void add(E e, Object[] elementData2, int size2) {
		if (size2 == elementData.length)
			elementData = grow();
		elementData[size2] = e;
		size = size2 + 1;

	}

	private Object[] grow(int minCapacity) {
		return elementData = Arrays.copyOf(elementData,
                 newCapacity(minCapacity));
	}

	public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

	private int newCapacity(int minCapacity) {
		int oldCapacity = elementData.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if (newCapacity - minCapacity <= 0) {
			if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
				return Math.max(DEFAULT_CAPACITY, minCapacity);
			if (minCapacity < 0) // overflow
				throw new OutOfMemoryError();
			return minCapacity;
		}
		return (newCapacity - MAX_ARRAY_SIZE <= 0)
				? newCapacity
				: hugeCapacity(minCapacity);
	}

	private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE)
            ? Integer.MAX_VALUE
            : MAX_ARRAY_SIZE;
    }

	private Object[] grow() {
        return grow(size + 1);
    }
}

