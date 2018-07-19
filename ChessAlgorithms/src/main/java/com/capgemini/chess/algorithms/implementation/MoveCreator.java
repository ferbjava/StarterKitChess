package com.capgemini.chess.algorithms.implementation;

import java.util.ArrayList;
import java.util.Iterator;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.enums.PieceType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;

/**
 * 
 * @author MKOTECKI
 *	class where List which contains moves for selected Piece
 *	by using following method impossible moves are removed from list
 */
public class MoveCreator {

	private ArrayList<PossibleMove> possibleMoves = new ArrayList<PossibleMove>(0);

	/**
	 * Creates all possible moves for selected Piece
	 * 
	 * @param piece
	 */
	public void baseMoves(Piece piece) {
		BasicMoves basicMoves = new BasicMoves(piece);
		for (int i = 0; i < basicMoves.getBasicMoves().size(); i++) {
			int localX = basicMoves.getBasicMoves().get(i).getX();
			int localY = basicMoves.getBasicMoves().get(i).getY();
			possibleMoves.add(new PossibleMove(localX, localY, MoveType.ATTACK, null));
		}
	}
	
	/**
	 * 
	 * @return number of the possible moves
	 */
	public int numberMoves() {
		return possibleMoves.size();
	}
	
	/**
	 * Remove impossible moves taking into account empty board
	 * @param from
	 * @param piece
	 */
	public void checkingGeomCond(Coordinate from, Piece piece) {
		Iterator<PossibleMove> movesIterator = possibleMoves.iterator();
		while (movesIterator.hasNext()) {
			PossibleMove move = movesIterator.next();
			int globalX = from.getX() + move.getX();
			int globalY = from.getY() + move.getY();
			if (globalX < 0 || globalX >= Board.SIZE || globalY < 0 || globalY >= Board.SIZE) {
				movesIterator.remove();
			}
		}

		if (!(from.getY() == 1 || from.getY() == 6) && piece.getType() == PieceType.PAWN) {
			removePawnDoubleAttack();
		}
	}
	
	/**
	 * Remove impossible moves taking into account recent situation on the board 
	 * (location of the own and enemy figures)
	 * @param board
	 * @param from
	 * @param probeMove
	 */
	public void checkingBoardCond(Board board, Coordinate from, Move probeMove) {
		Piece targetPiece;
		Color recentColor = board.getPieceAt(from).getColor();
		int i = 0;
		while (i < numberMoves()) {
			int globalX = from.getX() + possibleMoves.get(i).getX();
			int globalY = from.getY() + possibleMoves.get(i).getY();
			Coordinate globalPos = new Coordinate(globalX, globalY);

			if (globalPos.equals(probeMove.getFrom())) {
				targetPiece = null;
			} else if (globalPos.equals(probeMove.getTo())) {
				targetPiece = probeMove.getMovedPiece();
			} else {
				targetPiece = board.getPieceAt(globalPos);
			}

			if (targetPiece != null && recentColor != targetPiece.getColor()) {
				possibleMoves.get(i).setmType(MoveType.CAPTURE);
				possibleMoves.get(i).setTargetPiece(targetPiece);
				removeFollowers(possibleMoves.get(i).getX(), possibleMoves.get(i).getY());
				i++;
			} else if (targetPiece != null && recentColor == targetPiece.getColor()) {
				removeFollowers(possibleMoves.get(i).getX(), possibleMoves.get(i).getY());
				possibleMoves.remove(i);
			} else {
				i++;
			}
		}

		Piece recentPiece=board.getPieceAt(from);
		if (recentPiece.getType() == PieceType.PAWN) {
			removeInvalidPawnMoves();
		}
	}

	/**
	 * 
	 * @param from
	 * @param to
	 * @return "true" if selected move is possible
	 */
	public boolean containMove(Coordinate from, Coordinate to) {
		int localX = to.getX() - from.getX();
		int localY = to.getY() - from.getY();
		for (int i = 0; i < numberMoves(); i++) {
			if ((localX == possibleMoves.get(i).getX()) && (localY == possibleMoves.get(i).getY())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param from
	 * @param to
	 * @return "Move Type" for selected move
	 */
	public MoveType getMoveType(Coordinate from, Coordinate to) {
		int localX = to.getX() - from.getX();
		int localY = to.getY() - from.getY();
		for (int i = 0; i < numberMoves(); i++) {
			if (localX == possibleMoves.get(i).getX() && localY == possibleMoves.get(i).getY()) {
				return possibleMoves.get(i).getmType();
			}
		}
		return null;
	}

	/**
	 * 
	 * @return "true" if any possible move possess "King" as a target piece 
	 */
	public boolean isKingCapture() {
		for (int i = 0; i < numberMoves(); i++) {
			Piece recentPiece = possibleMoves.get(i).getTargetPiece();
			if (recentPiece != null && recentPiece.getType() == PieceType.KING) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param index
	 * @return move for given index
	 */
	public PossibleMove getSelectedMove(int index) {
		if (index >= 0 && index < numberMoves()) {
			return possibleMoves.get(index);
		}
		return null;
	}
	
	// Private methods
	/**
	 * move is removed if target field is lying behind other piece
	 * @param x
	 * @param y
	 */
	private void removeFollowers(int x, int y) {
		MyVector thisVector = new MyVector((double) x, (double) y);
		Iterator<PossibleMove> movesIterator = possibleMoves.iterator();
		while (movesIterator.hasNext()) {
			PossibleMove move = movesIterator.next();
			MyVector testVector = new MyVector((double) move.getX(), (double) move.getY());
			if (thisVector.uVector().equals(testVector.uVector()) && thisVector.length() < testVector.length()) {
				movesIterator.remove();
			}
		}
	}

	/**
	 * remove double Attack for the both colors of the PAWNS if it is not staritn position
	 */
	private void removePawnDoubleAttack() {
		Iterator<PossibleMove> movesIterator = possibleMoves.iterator();
		while (movesIterator.hasNext()) {
			PossibleMove move = movesIterator.next();
			if (move.getX() == 0 && Math.abs(move.getY()) == 2) {
				movesIterator.remove();
			}
		}
	}

	/**
	 * remove "Attack" moves if X=0 and "Capture" move if X!=0
	 */
	private void removeInvalidPawnMoves() {
		Iterator<PossibleMove> movesIterator = possibleMoves.iterator();
		while (movesIterator.hasNext()) {
			PossibleMove move = movesIterator.next();
			if (move.getX() != 0 && move.getTargetPiece() == null) {
				movesIterator.remove();
			} else if (move.getX() == 0 && move.getmType() == MoveType.CAPTURE) {
				movesIterator.remove();
			}
		}
	}
}
