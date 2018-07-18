package com.capgemini.chess.algorithms.implementation;

import java.util.ArrayList;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.enums.PieceType;

public class BasicMoves {
	private ArrayList<Coordinate> basicMoves=new ArrayList<Coordinate>(0);//=null;
	
	public BasicMoves(Piece piece) {
		PieceType pieceType = piece.getType();
		Color pieceColor = piece.getColor();

		switch (pieceType) {
		case PAWN:
			getBasicMoves().clear();
			addPawnMoves(pieceColor);
			break;
		case ROOK:
			getBasicMoves().clear();
			addRookMoves();
			break;
		case KNIGHT:
			getBasicMoves().clear();
			addKnightMoves();
			break;
		case BISHOP:
			getBasicMoves().clear();
			addBishopMoves();
			break;
		case QUEEN:
			getBasicMoves().clear();
			addRookMoves();
			addBishopMoves();
			break;
		case KING:
			getBasicMoves().clear();
			addKingMoves();
			break;
		default:
			getBasicMoves().clear();
			break;
		}
	}
	
	private void addPawnMoves(Color color) {
		if (color == Color.WHITE) {
			getBasicMoves().add(new Coordinate(0, 1));
			getBasicMoves().add(new Coordinate(0, 2));
			getBasicMoves().add(new Coordinate(-1, 1));
			getBasicMoves().add(new Coordinate(1, 1));
		} else {
			getBasicMoves().add(new Coordinate(0, -1));
			getBasicMoves().add(new Coordinate(0, -2));
			getBasicMoves().add(new Coordinate(-1, -1));
			getBasicMoves().add(new Coordinate(1, -1));
		}
	}
	
	private void addRookMoves() {
		getBasicMoves().add(new Coordinate(1, 0));
		getBasicMoves().add(new Coordinate(2, 0));
		getBasicMoves().add(new Coordinate(3, 0));
		getBasicMoves().add(new Coordinate(4, 0));
		getBasicMoves().add(new Coordinate(5, 0));
		getBasicMoves().add(new Coordinate(6, 0));
		getBasicMoves().add(new Coordinate(7, 0));
		getBasicMoves().add(new Coordinate(0, -1));
		getBasicMoves().add(new Coordinate(0, -2));
		getBasicMoves().add(new Coordinate(0, -3));
		getBasicMoves().add(new Coordinate(0, -4));
		getBasicMoves().add(new Coordinate(0, -5));
		getBasicMoves().add(new Coordinate(0, -6));
		getBasicMoves().add(new Coordinate(0, -7));
		getBasicMoves().add(new Coordinate(-1, 0));
		getBasicMoves().add(new Coordinate(-2, 0));
		getBasicMoves().add(new Coordinate(-3, 0));
		getBasicMoves().add(new Coordinate(-4, 0));
		getBasicMoves().add(new Coordinate(-5, 0));
		getBasicMoves().add(new Coordinate(-6, 0));
		getBasicMoves().add(new Coordinate(-7, 0));
		getBasicMoves().add(new Coordinate(0, 1));
		getBasicMoves().add(new Coordinate(0, 2));
		getBasicMoves().add(new Coordinate(0, 3));
		getBasicMoves().add(new Coordinate(0, 4));
		getBasicMoves().add(new Coordinate(0, 5));
		getBasicMoves().add(new Coordinate(0, 6));
		getBasicMoves().add(new Coordinate(0, 7));
	}
	
	private void addKnightMoves() {
		getBasicMoves().add(new Coordinate(1, 2));
		getBasicMoves().add(new Coordinate(2, 1));
		getBasicMoves().add(new Coordinate(2, -1));
		getBasicMoves().add(new Coordinate(1, -2));
		getBasicMoves().add(new Coordinate(-1, -2));
		getBasicMoves().add(new Coordinate(-2, -1));
		getBasicMoves().add(new Coordinate(-2, 1));
		getBasicMoves().add(new Coordinate(-1, 2));
	}
	
	private void addBishopMoves() {
		getBasicMoves().add(new Coordinate(1, 1));
		getBasicMoves().add(new Coordinate(2, 2));
		getBasicMoves().add(new Coordinate(3, 3));
		getBasicMoves().add(new Coordinate(4, 4));
		getBasicMoves().add(new Coordinate(5, 5));
		getBasicMoves().add(new Coordinate(6, 6));
		getBasicMoves().add(new Coordinate(7, 7));
		getBasicMoves().add(new Coordinate(1, -1));
		getBasicMoves().add(new Coordinate(2, -2));
		getBasicMoves().add(new Coordinate(3, -3));
		getBasicMoves().add(new Coordinate(4, -4));
		getBasicMoves().add(new Coordinate(5, -5));
		getBasicMoves().add(new Coordinate(6, -6));
		getBasicMoves().add(new Coordinate(7, -7));
		getBasicMoves().add(new Coordinate(-1, -1));
		getBasicMoves().add(new Coordinate(-2, -2));
		getBasicMoves().add(new Coordinate(-3, -3));
		getBasicMoves().add(new Coordinate(-4, -4));
		getBasicMoves().add(new Coordinate(-5, -5));
		getBasicMoves().add(new Coordinate(-6, -6));
		getBasicMoves().add(new Coordinate(-7, -7));
		getBasicMoves().add(new Coordinate(-1, 1));
		getBasicMoves().add(new Coordinate(-2, 2));
		getBasicMoves().add(new Coordinate(-3, 3));
		getBasicMoves().add(new Coordinate(-4, 4));
		getBasicMoves().add(new Coordinate(-5, 5));
		getBasicMoves().add(new Coordinate(-6, 6));
		getBasicMoves().add(new Coordinate(-7, 7));
	}
	
	private void addKingMoves() {
		getBasicMoves().add(new Coordinate(1, 1));
		getBasicMoves().add(new Coordinate(1, 0));
		getBasicMoves().add(new Coordinate(1, -1));
		getBasicMoves().add(new Coordinate(0, -1));
		getBasicMoves().add(new Coordinate(-1, -1));
		getBasicMoves().add(new Coordinate(-1, 0));
		getBasicMoves().add(new Coordinate(-1, 1));
		getBasicMoves().add(new Coordinate(0, 1));
	}

	public ArrayList<Coordinate> getBasicMoves() {
		return basicMoves;
	}
	
}
