package com.capgemini.chess.algorithms.implementation;

import java.util.ArrayList;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.enums.PieceType;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;

public class MoveCreator {
	
	private ArrayList<PossibleMove> possibleMoves=new ArrayList<PossibleMove>(0);

	public void baseMoves(Piece piece){
		PieceType pieceType = piece.getType();
		Color color = piece.getColor();
		
		switch (pieceType) {
		case PAWN:
			if (color == Color.WHITE) {
				possibleMoves.clear();
				possibleMoves.add(new PossibleMove(0, 1, MoveType.ATTACK, null));
				possibleMoves.add(new PossibleMove(0, 2, MoveType.ATTACK, null));

				possibleMoves.add(new PossibleMove(-1, 1, MoveType.CAPTURE, null));
				possibleMoves.add(new PossibleMove(1, 1, MoveType.CAPTURE, null));
				break;
			} else {
				possibleMoves.clear();
				possibleMoves.add(new PossibleMove(0, -1, MoveType.ATTACK, null));
				possibleMoves.add(new PossibleMove(0, -2, MoveType.ATTACK, null));

				possibleMoves.add(new PossibleMove(-1, -1, MoveType.CAPTURE, null));
				possibleMoves.add(new PossibleMove(1, -1, MoveType.CAPTURE, null));
				break;
			}
		case ROOK:
			possibleMoves.clear();
			possibleMoves.add(new PossibleMove(1, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(2, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(3, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(4, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(5, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(6, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(7, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, -1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, -2, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, -3, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, -4, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, -5, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, -6, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, -7, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-1, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-2, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-3, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-4, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-5, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-6, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-7, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, 1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, 2, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, 3, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, 4, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, 5, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, 6, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, 7, MoveType.ATTACK, null));
			break;
		case KNIGHT:
			possibleMoves.clear();
			possibleMoves.add(new PossibleMove(1, 2, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(2, 1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(2, -1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(1, -2, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-1, 2, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-2, 1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-2, -1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-1, -2, MoveType.ATTACK, null));
			break;
		case BISHOP:
			possibleMoves.clear();
			possibleMoves.add(new PossibleMove(1, 1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(2, 2, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(3, 3, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(4, 4, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(5, 5, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(6, 6, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(7, 7, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(1, -1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(2, -2, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(3, -3, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(4, -4, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(5, -5, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(6, -6, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(7, -7, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-1, -1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-2, -2, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-3, -3, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-4, -4, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-5, -5, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-6, -6, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-7, -7, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-1, 1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-2, 2, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-3, 3, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-4, 4, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-5, 5, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-6, 6, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-7, 7, MoveType.ATTACK, null));
			break;
		case QUEEN:
			possibleMoves.clear();
			//ruchy dla wierzy
			possibleMoves.add(new PossibleMove(1, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(2, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(3, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(4, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(5, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(6, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(7, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, -1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, -2, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, -3, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, -4, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, -5, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, -6, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, -7, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-1, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-2, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-3, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-4, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-5, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-6, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-7, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, 1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, 2, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, 3, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, 4, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, 5, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, 6, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, 7, MoveType.ATTACK, null));
			//ruchy dla gonca
			possibleMoves.add(new PossibleMove(1, 1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(2, 2, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(3, 3, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(4, 4, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(5, 5, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(6, 6, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(7, 7, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(1, -1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(2, -2, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(3, -3, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(4, -4, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(5, -5, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(6, -6, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(7, -7, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-1, -1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-2, -2, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-3, -3, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-4, -4, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-5, -5, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-6, -6, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-7, -7, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-1, 1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-2, 2, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-3, 3, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-4, 4, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-5, 5, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-6, 6, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-7, 7, MoveType.ATTACK, null));
			break;
		case KING:
			possibleMoves.clear();
			possibleMoves.add(new PossibleMove(1, 1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(1, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(1, -1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, -1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-1, -1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-1, 0, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(-1, 1, MoveType.ATTACK, null));
			possibleMoves.add(new PossibleMove(0, 1, MoveType.ATTACK, null));
			break;
		default:
			possibleMoves.clear();
			break;
		}
	}

	public ArrayList<PossibleMove> getPossibleMoves() {
		return possibleMoves;
	}

}
