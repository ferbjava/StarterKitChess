package com.capgemini.chess.algorithms.implementation;

import java.util.ArrayList;

public class ConsolTests {

	public static void main(String[] args) {
		System.out.println("MyVector test");
		int x=0;
		int y=4;
		MyVector vector01= new MyVector((double)x,(double) y);
		System.out.println("Coordinates: x = "+vector01.getX()+", y = "+vector01.getY());
		System.out.println();
		System.out.println("Vector length: "+vector01.length());
		System.out.println("Unit vetor: x= "+vector01.uVector().getX()+", y= "+vector01.uVector().getY());
	}

}
