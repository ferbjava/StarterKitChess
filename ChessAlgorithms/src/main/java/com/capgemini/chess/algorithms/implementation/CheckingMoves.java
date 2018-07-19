package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;

public class CheckingMoves {
	private Board board;
	private Coordinate from;
	private Move probeMove;

	public CheckingMoves(Board board, Coordinate from, Move probeMove) {
		this.board = board;
		this.from = from;
		this.probeMove = probeMove;
	}

	public MoveCreator generateMoves() {
		Piece recentPiece = board.getPieceAt(from);
		MoveCreator movesCreator = new MoveCreator();
		movesCreator.baseMoves(recentPiece);

		// Checking geometric conditions (removing moves out of the board range)
		movesCreator.checkingGeomCond(from, recentPiece);

		// Checking situation of the field
		movesCreator.checkingBoardCond(board, from, probeMove);

		return movesCreator;
	}
}
