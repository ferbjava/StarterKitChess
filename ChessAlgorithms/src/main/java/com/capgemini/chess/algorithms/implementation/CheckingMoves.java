package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.enums.PieceType;
import com.capgemini.chess.algorithms.data.generated.Board;

public class CheckingMoves {
	private Board board;
	private Coordinate from;
	private Move probeMove;
	
	public CheckingMoves(Board board, Coordinate from, Move probeMove) {
		this.board=board;
		this.from=from;
		this.probeMove=probeMove;
	}
	
	public MoveCreator generateMoves(){
		Piece movingPiece=board.getPieceAt(from);
		MoveCreator movesCreator = new MoveCreator();
		movesCreator.baseMoves(movingPiece);

		// Checking geometric conditions (removing moves out of the board range)
		movesCreator.geometricCond(from);
		
		// Removing double ATTACK if next move for PAWN
		if (!(from.getY() == 1 || from.getY() == 6) && movingPiece.getType() == PieceType.PAWN) {
			movesCreator.removePawnDoubleAttack();
		}

		// Checking situation of the field
		movesCreator.boardCond(board, from, movingPiece.getColor(),probeMove);

		// Removing invalid moves for PAWN
		if (movingPiece.getType() == PieceType.PAWN) {
			movesCreator.removeInvalidPawnMoves();
		}
		
		return movesCreator;
	}
}
