package com.tb.multithreading;

import java.io.File;

public class Task1 {

	public static void main(String[] args) throws InterruptedException {
		long mainTimeStart = System.currentTimeMillis();
		File file1 = new File("C:\\Windows");
		File file2 = new File("C:\\Program Files");
		Runnable countTask1 = new FileCountTask(file1);
		Runnable countTask2 = new FileCountTask(file2);
		Thread thread1 = new Thread(countTask1, "Thread1");
		Thread thread2 = new Thread(countTask2, "Thread2");
		thread1.start();
		thread2.start();
		thread2.join();
		thread1.join();
		long mainTimeFinish = System.currentTimeMillis() - mainTimeStart;
		System.out.println("Main Thread finished in " + mainTimeFinish);
	}

	static class FileCountTask implements Runnable {
		private final File fileStart;

		public FileCountTask(File file) {
			this.fileStart = file;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " started");
			long timeStart = System.currentTimeMillis();
			System.out.println(countFilesRecursively(fileStart));
			long timeFinish = System.currentTimeMillis() - timeStart;
			System.out.println(Thread.currentThread().getName() + " finished in " + timeFinish + " miliseconds");
		}

		private int countFilesRecursively(File file) {
			int result = 0;
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				if (files != null) {
					for (File tmp : files) {
						if (tmp.isDirectory()) {
							result += countFilesRecursively(tmp);
						} else {
							result++;
						}
					}
				}
			} else {
				result++;
			}
			return result;
		}
	}
}
