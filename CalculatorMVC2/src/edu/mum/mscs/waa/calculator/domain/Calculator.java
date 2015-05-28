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
	private Integer add1;
	private Integer add2;
	private Integer prd1;
	private Integer prd2;
	private Integer sum;
	private Integer product;
	
	public Integer getAdd1() {
		return add1;
	}

	public void setAdd1(Integer add1) {
		this.add1 = add1;
	}

	public Integer getAdd2() {
		return add2;
	}

	public void setAdd2(Integer add2) {
		this.add2 = add2;
	}

	public Integer getPrd1() {
		return prd1;
	}

	public void setPrd1(Integer prd1) {
		this.prd1 = prd1;
	}

	public Integer getPrd2() {
		return prd2;
	}

	public void setPrd2(Integer prd2) {
		this.prd2 = prd2;
	}

	public Integer getSum() {
		sum = add1+add2;
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public Integer getProduct() {
		product =  prd1*prd2; 
		return product;
	}

	public void setProduct(Integer product) {
		this.product = product;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
