package com.tb.dynpr;

import java.util.Random;

public class Bagpack {
	Bagpack() {
		size = 20;
	}

	private final int size;

	public int store(int[] array) {
		int currentSize = 0;

		int index = 0;
		sort(array);
		while (currentSize < size) {
			currentSize += array[index];
			index++;
		}
		return index - 1;
	}

	public static void sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}

	}

	public static void main(String[] args) {
		int length = 10;
		Random rand = new Random();
		int[] array = new int[length];
		for (int i = 0; i < length; i++) {

			array[i] = rand.nextInt(20);
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " , ");
		}
		System.out.println();
		Bagpack b = new Bagpack();
		System.out.println(b.store(array));
	}
}
