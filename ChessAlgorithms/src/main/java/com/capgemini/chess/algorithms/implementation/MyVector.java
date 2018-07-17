package com.capgemini.chess.algorithms.implementation;

public class MyVector {
	private double x;
	private double y;

	public MyVector(double x, double y) {
		setX(x);
		setY(y);
	}
	
	public double length(){
		return Math.sqrt(Math.pow(x, 2.0)+Math.pow(y,2.0));
	}
	
	public MyVector uVector(){
		MyVector uVector= new MyVector(x/length(),y/length());
		return uVector;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj){
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		MyVector testObject=(MyVector) obj;
		if(Math.abs(x-testObject.x)>0.001)
			return false;
		if(Math.abs(y-testObject.y)>0.001)
			return false;
		return true;
	}

}
