package com.tb.dynpr;

import java.util.Scanner;

public class Fibonachi {

	public void nnthFibNum() {
		int num1 = 0;
		int num2 = 1;
		int nthFibNum = 0;
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		for (int i = 1; i < num; i++) {
			nthFibNum = num1 + num2;
			num1 = num2;
			num2 = nthFibNum;
		}
		scan.close();
		System.out.println(nthFibNum);
	}

	public static void main(String[] args) {
		Fibonachi f = new Fibonachi();
		f.nnthFibNum();
	}
}
