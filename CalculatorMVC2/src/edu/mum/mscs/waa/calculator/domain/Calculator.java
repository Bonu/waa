/**
 * 
 */
package edu.mum.mscs.waa.calculator.domain;

import java.io.Serializable;

/**
 * @author 984417
 *
 */
public class Calculator implements Serializable{

	private static final long serialVersionUID = -8244393005618186280L;
	private int add1;
	private int add2;
	private int prd1;
	private int prd2;
	private int sum;
	private int product;
	
	public int getAdd1() {
		return add1;
	}

	public void setAdd1(int add1) {
		this.add1 = add1;
	}

	public int getAdd2() {
		return add2;
	}

	public void setAdd2(int add2) {
		this.add2 = add2;
	}

	public int getPrd1() {
		return prd1;
	}

	public void setPrd1(int prd1) {
		this.prd1 = prd1;
	}

	public int getPrd2() {
		return prd2;
	}

	public void setPrd2(int prd2) {
		this.prd2 = prd2;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
