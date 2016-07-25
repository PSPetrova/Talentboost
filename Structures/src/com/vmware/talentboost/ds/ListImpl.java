package com.vmware.talentboost.ds;

import com.vmware.talentboost.ds.interfaces.List;

public class ListImpl<E> extends AbstractList<E> implements List<E> {

	@Override
	public void add(E data) {
		insertAtIndex(data, getSize());
	}

	@Override
	public E delete(int index) {
		return super.delete(index);
	}

	public E get(int index) {
		return super.getElement(index);
	}

	@Override
	public int getSize() {
		return super.getSize();
	}

}
