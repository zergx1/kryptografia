package model;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class Knapsack {
	private static int val = 7;
	private int[] sequence = new int[val];
	private Random random = new Random();
	private int min = 0;
	private int max = 500;
	private int M = 7013;
	private int W = 13;

	public void generateSequence() {
		for (int i = 0; i < val; i++) {
			sequence[i] = random.nextInt(max - min + 1) + min;
		}
		Arrays.sort(sequence);
		int actualSum = sequence[0] + sequence[1];
		for (int i = 2; i < val; i++) {
			if (actualSum >= sequence[i]) {
				sequence[i] = actualSum + random.nextInt(100 - 0 + 1);
			}
			actualSum += sequence[i];
		}
		System.out.println(actualSum);

	}


	public void saySomething() {
		Character a = 'A';
		String c = Integer.toBinaryString(a);
		//System.out.println(c);


	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

}
