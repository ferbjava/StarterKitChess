package com.capgemini.chess.algorithms.implementation;

public class ConsolTests {

	public static void main(String[] args) {
		System.out.println("Test mojego wektora");
		int x=0;
		int y=4;
		MyVector wektor1= new MyVector((double)x,(double) y);
		System.out.println("Wspolrzedne: x = "+wektor1.getX()+", y = "+wektor1.getY());
		System.out.println();
		System.out.println("Dlugosc wektora: "+wektor1.length());
		System.out.println("Wektor jednostkowy: x= "+wektor1.uVector().getX()+", y= "+wektor1.uVector().getY());
	}

}
