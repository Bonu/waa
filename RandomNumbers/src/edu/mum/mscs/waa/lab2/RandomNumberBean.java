package edu.mum.mscs.waa.lab2;

import java.util.Random;

public class RandomNumberBean {

	private int rn1=0, rn2=0, rn3=0, rn4=0;

	public RandomNumberBean() {
		setRn1(randInt());
		setRn2(randInt());
		setRn3(randInt());
		setRn4(randInt());
	}

	public int getRn1() {
		return rn1;
	}

	public void setRn1(int rn1) {
		this.rn1 = rn1;
	}

	public int getRn2() {
		return rn2;
	}

	public void setRn2(int rn2) {
		this.rn2 = rn2;
	}

	public int getRn3() {
		return rn3;
	}

	public void setRn3(int rn3) {
		this.rn3 = rn3;
	}

	public int getRn4() {
		return rn4;
	}

	public void setRn4(int rn4) {
		this.rn4 = rn4;
	}
	
	public static int randInt() {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((10 - 1) + 1) + 1;

	    return randomNum;
	}
}
