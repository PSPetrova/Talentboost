package com.vmware.talentboost.ds.interfaces;

public interface List<E> {
	public void add(E data);

	public E delete(int index);

	public E get(int index);

	public int getSize();
}
