package com.capgemini.chess.algorithms.implementation;

import java.util.ArrayList;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.enums.PieceType;

public class BasicMoves {
	private ArrayList<Coordinate> basicMoves;//=null;
	
	public BasicMoves(Piece piece){
		PieceType pieceType=piece.getType();
		Color pieceColor=piece.getColor();
		
		switch(pieceType){
		case PAWN:
			basicMoves.clear();
			addPawnMoves(pieceColor);
			break;
		case ROOK:
			basicMoves.clear();
			addRookMoves();
		case KNIGHT:
			basicMoves.clear();
			addKnightMoves();
		case BISHOP:
			basicMoves.clear();
			addBishopMoves();
		case QUEEN:
			basicMoves.clear();
			addKnightMoves();
			addBishopMoves();
		case KING:
			basicMoves.clear();
			addKingMoves();
		default:
			basicMoves.clear();
		}
	}
	
	private void addPawnMoves(Color color){
		if (color == Color.WHITE) {
			basicMoves.add(new Coordinate(0, 1));
			basicMoves.add(new Coordinate(0, 2));
			basicMoves.add(new Coordinate(-1, 1));
			basicMoves.add(new Coordinate(1, 1));
		} else {
			basicMoves.add(new Coordinate(0, -1));
			basicMoves.add(new Coordinate(0, -2));
			basicMoves.add(new Coordinate(-1, -1));
			basicMoves.add(new Coordinate(1, -1));
		}
	}
	
	private void addRookMoves(){
		basicMoves.add(new Coordinate(1, 0));
		basicMoves.add(new Coordinate(2, 0));
		basicMoves.add(new Coordinate(3, 0));
		basicMoves.add(new Coordinate(4, 0));
		basicMoves.add(new Coordinate(5, 0));
		basicMoves.add(new Coordinate(6, 0));
		basicMoves.add(new Coordinate(7, 0));
		basicMoves.add(new Coordinate(0, -1));
		basicMoves.add(new Coordinate(0, -2));
		basicMoves.add(new Coordinate(0, -3));
		basicMoves.add(new Coordinate(0, -4));
		basicMoves.add(new Coordinate(0, -5));
		basicMoves.add(new Coordinate(0, -6));
		basicMoves.add(new Coordinate(0, -7));
		basicMoves.add(new Coordinate(-1, 0));
		basicMoves.add(new Coordinate(-2, 0));
		basicMoves.add(new Coordinate(-3, 0));
		basicMoves.add(new Coordinate(-4, 0));
		basicMoves.add(new Coordinate(-5, 0));
		basicMoves.add(new Coordinate(-6, 0));
		basicMoves.add(new Coordinate(-7, 0));
		basicMoves.add(new Coordinate(0, 1));
		basicMoves.add(new Coordinate(0, 2));
		basicMoves.add(new Coordinate(0, 3));
		basicMoves.add(new Coordinate(0, 4));
		basicMoves.add(new Coordinate(0, 5));
		basicMoves.add(new Coordinate(0, 6));
		basicMoves.add(new Coordinate(0, 7));
	}
	
	private void addKnightMoves(){
		basicMoves.add(new Coordinate(1, 2));
		basicMoves.add(new Coordinate(2, 1));
		basicMoves.add(new Coordinate(2, -1));
		basicMoves.add(new Coordinate(1, -2));
		basicMoves.add(new Coordinate(-1, -2));
		basicMoves.add(new Coordinate(-2, -1));
		basicMoves.add(new Coordinate(-2, 1));
		basicMoves.add(new Coordinate(-1, 2));
	}
	
	private void addBishopMoves(){
		basicMoves.add(new Coordinate(1, 1));
		basicMoves.add(new Coordinate(2, 2));
		basicMoves.add(new Coordinate(3, 3));
		basicMoves.add(new Coordinate(4, 4));
		basicMoves.add(new Coordinate(5, 5));
		basicMoves.add(new Coordinate(6, 6));
		basicMoves.add(new Coordinate(7, 7));
		basicMoves.add(new Coordinate(1, -1));
		basicMoves.add(new Coordinate(2, -2));
		basicMoves.add(new Coordinate(3, -3));
		basicMoves.add(new Coordinate(4, -4));
		basicMoves.add(new Coordinate(5, -5));
		basicMoves.add(new Coordinate(6, -6));
		basicMoves.add(new Coordinate(7, -7));
		basicMoves.add(new Coordinate(-1, -1));
		basicMoves.add(new Coordinate(-2, -2));
		basicMoves.add(new Coordinate(-3, -3));
		basicMoves.add(new Coordinate(-4, -4));
		basicMoves.add(new Coordinate(-5, -5));
		basicMoves.add(new Coordinate(-6, -6));
		basicMoves.add(new Coordinate(-7, -7));
		basicMoves.add(new Coordinate(-1, 1));
		basicMoves.add(new Coordinate(-2, 2));
		basicMoves.add(new Coordinate(-3, 3));
		basicMoves.add(new Coordinate(-4, 4));
		basicMoves.add(new Coordinate(-5, 5));
		basicMoves.add(new Coordinate(-6, 6));
		basicMoves.add(new Coordinate(-7, 7));
	}
	
	private void addKingMoves(){
		basicMoves.add(new Coordinate(1, 1));
		basicMoves.add(new Coordinate(1, 0));
		basicMoves.add(new Coordinate(1, -1));
		basicMoves.add(new Coordinate(0, -1));
		basicMoves.add(new Coordinate(-1, -1));
		basicMoves.add(new Coordinate(-1, 0));
		basicMoves.add(new Coordinate(-1, -1));
		basicMoves.add(new Coordinate(0, -1));
	}
}
