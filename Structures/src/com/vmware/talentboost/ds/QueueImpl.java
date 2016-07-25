package com.vmware.talentboost.ds;

import com.vmware.talentboost.ds.interfaces.Queue;

public class QueueImpl<E> extends AbstractList<E> implements Queue<E> {

	@Override
	public void enqueue(E element) {
		insertAtIndex(element, 0);
	}

	@Override
	public E dequeue() {
		return delete(getSize() - 1);
	}

	@Override
	public E peek() {
		return getElement(getSize() - 1);
	}

	@Override
	public int size() {
		return getSize();
	}

	@Override
	public boolean isEmpty() {
		return getSize() == 0;
	}

}
