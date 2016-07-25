package com.vmware.talentboost.ds;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.vmware.talentboost.ds.interfaces.Queue;

/**
 * Contains tests for {@link com.vmware.talentboost.ds.ImperfectStack}. For the
 * sake of simplicity, and because element type is of little importance, strings
 * are used for the queue elements.
 */
public class UnfinishedImperfectQueueTest {

	private Queue<String> queue;

	private static final String FIRST_STRING = "Crime and Punishment";
	private static final String SECOND_STRING = "The Great Gatsby";
	private static final String THIRD_STRING = "The Bible";

	private static final void addElements(Queue<? super String> someQueue) {
		someQueue.enqueue(FIRST_STRING);
		someQueue.enqueue(SECOND_STRING);
		someQueue.enqueue(THIRD_STRING);
	}

	/**
	 * Executed before each test method, setting up a stack with some elements.
	 */
	@Before
	public void setUp() {
		queue = new QueueImpl<>();
		addElements(queue);
	}

	@Test
	public void testSetup() {
		assertEquals(3, queue.size());
		assertEquals(FIRST_STRING, queue.dequeue());
		assertEquals(SECOND_STRING, queue.dequeue());
		assertEquals(THIRD_STRING, queue.dequeue());
		assertEquals(0, queue.size());
	}

	@Test
	public void testAddingToEmptyQueue() {

		queue = new ImperfectQueue<>();
		queue.enqueue(FIRST_STRING);
		String tail = queue.peek();
		assertEquals(FIRST_STRING, tail);
		assertEquals(queue.size(), 1);
	}

	@Test
	public void testRemoveFromTheHead_NotEmpty() {

		assertEquals(queue.dequeue(), FIRST_STRING);
		assertEquals(queue.peek(), SECOND_STRING);
		assertEquals(queue.size(), 2);
	}

	@Test(expected = EmptyQueueException.class)
	public void testRemoveFromTheHead_EmptyQueue() {
		queue = new ImperfectQueue<>();
		queue.dequeue();
	}

	@Test
	public void testPeekReturnTheRightElement_NotEmpty() {
		assertEquals(queue.peek(), FIRST_STRING);
		assertEquals(queue.size(), 3);
	}

	@Test(expected = EmptyQueueException.class)
	public void testPeekReturnTheRightElement_Empty() {
		queue = new ImperfectQueue<>();
		queue.peek();
	}

	@Test
	public void testSizeFunctionality() {
		queue = new ImperfectQueue<>();
		assertEquals(queue.size(), 0);
		queue.enqueue(FIRST_STRING);
		assertEquals(1, queue.size());
		queue.dequeue();
		assertEquals(0, queue.size());
	}

	@Test
	public void testIsEmptyFunctionality() {
		queue = new ImperfectQueue<>();
		assertEquals(true, queue.isEmpty());
		queue.enqueue(FIRST_STRING);
		assertEquals(false, queue.isEmpty());
		queue.dequeue();
		assertEquals(true, queue.isEmpty());
	}

}
// ---------------------------------------------------------------------------
// IMPLEMENT TESTS BELOW
// ---------------------------------------------------------------------------
