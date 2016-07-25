package com.vmware.talentboost.ds;

public class AbstractList<E> {
	private Node<E> head;

	protected int getSize() {
		int size = 0;
		Node<E> current = head;
		while (current != null) {
			size++;
			current = current.next;
		}
		return size;
	}

	protected void insertAtIndex(E element, int index) {
		if (index < 0 || index > getSize()) {
			throw new IndexOutOfBoundsException();
		}
		if (head == null) {
			head = new Node<E>(element, null);
		} else if (index == 0) {
			Node<E> temp = new Node<E>(element, head);
			head = temp;

		} else {
			Node<E> current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			Node<E> temp = new Node<E>(element, current.next);
			current.next = temp;
		}

	}

	protected E delete(int index) {
		if (index < 0 || index > getSize()) {
			throw new IndexOutOfBoundsException();
		}
		E deleted;
		if (getSize() == 1) {
			deleted = head.data;
			head = null;
		} else {
			Node<E> current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			deleted = current.next.data;
			current.next = current.next.next;
		}
		return deleted;
	}

	protected E getElement(int index) {
		if (index < 0 || index >= getSize()) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	private static final class Node<E> {
		E data;
		Node<E> next;

		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
}
