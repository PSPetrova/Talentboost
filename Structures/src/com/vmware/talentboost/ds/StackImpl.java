package com.vmware.talentboost.ds;

import com.vmware.talentboost.ds.interfaces.Stack;

public class StackImpl<E> extends AbstractList<E> implements Stack<E> {

	@Override
	public void push(E element) {
		insertAtIndex(element, getSize());
	}

	@Override
	public E pop() {
		return delete(getSize() - 1);
	}

	@Override
	public E peek() {
		return getElement(getSize() - 1);
	}

	@Override
	public boolean isEmpty() {
		return getSize() == 0;
	}

	@Override
	public int size() {
		return super.getSize();
	}

}
