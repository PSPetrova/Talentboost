package com.tb.app;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Duplicate {

	public boolean containsDuplicate(int[] nums) {
		if (nums == null) {
			return false;
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 2, 4, 8, 3, 1 };
		Duplicate d = new Duplicate();
		System.out.println(d.containsDuplicate(nums));
	}

}
