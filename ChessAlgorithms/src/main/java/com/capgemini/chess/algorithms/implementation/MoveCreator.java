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
 *
 */
public class MoveCreator {
	
	private ArrayList<PossibleMove> possibleMoves=new ArrayList<PossibleMove>(0);

	/**
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
	
	public int numberMoves() {
		return possibleMoves.size();
	}
	
	public void geometricCond(Coordinate start) {
		int i = 0;
		while (i < numberMoves()) {
			int globalX = start.getX() + possibleMoves.get(i).getX();
			int globalY = start.getY() + possibleMoves.get(i).getY();
			if (globalX < 0 || globalX >= Board.SIZE || globalY < 0 || globalY >= Board.SIZE) {
				possibleMoves.remove(i);
			} else {
				i++;
			}
		}
	}
	
	public void boardCond(Board board, Coordinate start, Move probeMove) {
		Piece targetPiece = null;
		int i = 0;
		while (i < numberMoves()) {
			int globalX = start.getX() + possibleMoves.get(i).getX();
			int globalY = start.getY() + possibleMoves.get(i).getY();
			Coordinate globalPos = new Coordinate(globalX, globalY);
			Color recentColor=board.getPieceAt(start).getColor();
			
			if(globalPos.equals(probeMove.getFrom())){
				targetPiece=null;
			}else if(globalPos.equals(probeMove.getTo())){
				targetPiece=probeMove.getMovedPiece();
			}else{
				targetPiece = board.getPieceAt(globalPos);
			}
			if (targetPiece == null) {
				i++;
				continue;
			} else if (recentColor != targetPiece.getColor()) {
				possibleMoves.get(i).setmType(MoveType.CAPTURE);
				possibleMoves.get(i).setTargetPiece(targetPiece);
				removeFollowers(possibleMoves.get(i).getX(), possibleMoves.get(i).getY());
				i++;
			} else {
				removeFollowers(possibleMoves.get(i).getX(), possibleMoves.get(i).getY());
				possibleMoves.remove(i);
			}
		}
	}
	
	private void removeFollowers(int x, int y) {
		MyVector thisVector = new MyVector((double) x, (double) y);
		int i = 0;
		while (i < numberMoves()) {
			MyVector testVector = new MyVector((double) possibleMoves.get(i).getX(),
					(double) possibleMoves.get(i).getY());
			if ((thisVector.uVector().equals(testVector.uVector())) && (thisVector.length() < testVector.length())) {
				possibleMoves.remove(i);
			} else {
				i++;
			}
		}
	}

	public void removePawnDoubleAttack() {
		Iterator<PossibleMove> movesIterator=possibleMoves.iterator();
		while (movesIterator.hasNext()) {
			PossibleMove move =movesIterator.next();
			if (move.getX() == 0 && Math.abs(move.getY()) == 2) {
				movesIterator.remove();
			}
		}
	}

	public void removeInvalidPawnMoves() {
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

	public boolean containMove(Coordinate start, Coordinate to) {
		Coordinate translation = new Coordinate(to.getX() - start.getX(), to.getY() - start.getY());
		for (int i = 0; i < numberMoves(); i++) {
			if ((translation.getX() == possibleMoves.get(i).getX())
					&& (translation.getY() == possibleMoves.get(i).getY())) {
				return true;
			}
		}
		return false;
	}
	
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

	public boolean isKingCapture() {
		for (int i = 0; i < numberMoves(); i++) {
			if(possibleMoves.get(i).getTargetPiece()==null){
				continue;
			}else if(possibleMoves.get(i).getTargetPiece().getType() == PieceType.KING){
				return true;
			}
		}
		return false;
	}

	public PossibleMove getSelectedMove(int index) {
		if(index>=0&&index<numberMoves()){
			return possibleMoves.get(index);
		}
		return null;
	}
}
