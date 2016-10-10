package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * Class to remove duplicate
 * 
 * @author dell
 *
 */
public class DuplicateRemover {

	public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1,
			18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
			19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	/**
	 * Method to remove duplicate using LinkedHashSet Using LinkedHashset
	 * maintain initial order of array
	 * 
	 * @return int[] return integer array of unique ordered value
	 */
	private int[] deDupByLinkedHashSet() {
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		
		for (int  randomInteger:randomIntegers) {
			set.add(randomInteger);
		}

		int[] dupArr = new int[set.size()];
		int i = 0;
		for (int a : set) {
			dupArr[i++] = a;
		}
		return dupArr;
	}

	/**
	 * method to remove the duplicate using array Using basic arrays
	 * implementation, we are removing duplicate by finding each element no.of
	 * occurrence.
	 * 
	 * @return int[] return integer array of unique ordered value
	 */
	private int[] deDupByArray() {
		int[] dupeRemovedArray = new int[randomIntegers.length];
		int counter = 0;
		boolean found = false;
		for (int randomInteger : randomIntegers) {
			for (int j = 0; j < counter && counter < dupeRemovedArray.length; j++) {
				if (randomInteger == dupeRemovedArray[j]) {
					found = true;
				}
			}
			if (!found) {
				dupeRemovedArray[counter++] = randomInteger;
			} else {
				found = false;
			}
		}
		return Arrays.copyOfRange(dupeRemovedArray, 0, counter);
	}

	/**
	 * method to remove the duplicate using ArrayList Using ArrayLists
	 * implementation, we are removing duplicate by finding each element no.of
	 * occurrence, and populating the int array from the arraylist to return the
	 * unique value
	 * 
	 * @return int[] return integer array of unique ordered value
	 */
	private int[] deDupByArrayList() {
		ArrayList<Integer> dups = new ArrayList<Integer>(10);
		boolean found = false;
		for (int randomInteger : randomIntegers) {
			for (int dup : dups) {
				if (randomInteger == dup) {
					found = true;
				}
			}
			if (!found) {
				dups.add(randomInteger);
			} else {
				found = false;
			}
		}
		int[] dupArr = new int[dups.size()];
		int i = 0;
		for (Integer duplicate : dups) {
			dupArr[i++] = duplicate;
		}
		dups.removeAll(dups);
		return dupArr;
	}

	/**
	 * Main method to call the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DuplicateRemover dp = new DuplicateRemover();

		// call 1st implementation using LinkedHashSet
		int[] dup1s = dp.deDupByLinkedHashSet();
		System.out.println("deDupByLinkedHashSet>:" + dup1s.length);
		for (int dup1:dup1s) {
			System.out.println(dup1);
		}
		// call 2nd implementation by basic array
		int[] dup2s = dp.deDupByArray();
		System.out.println("deDupByArray>:" + dup2s.length);
		for (int dup2:dup2s) {
			System.out.println(dup2);
		}
		// call 3rd implementation using arrayList
		int[] dup3s = dp.deDupByArrayList();
		System.out.println("deDupByArrayList>:" + dup3s.length);
		for (int dup3:dup3s) {
			System.out.println(dup3);
		}

	}

}
