package com.capgemini.chess.algorithms.implementation;

import java.util.ArrayList;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;

public class MoveCreator {
	
	private ArrayList<PossibleMove> possibleMoves=new ArrayList<PossibleMove>(0);

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
		while (i < possibleMoves.size()) {
			int globalX = start.getX() + possibleMoves.get(i).getX();
			int globalY = start.getY() + possibleMoves.get(i).getY();
			if ((globalX < 0 || globalX > 7) || (globalY < 0 || globalY > 7)) {
				possibleMoves.remove(i);
			} else {
				i++;
			}
		}
	}
	
	public void boardCond(Board board, Coordinate start, Color recentColor) {
		Piece targetPiece = null;
		int i = 0;
		while (i < possibleMoves.size()) {
			int globalX = start.getX() + possibleMoves.get(i).getX();
			int globalY = start.getY() + possibleMoves.get(i).getY();
			Coordinate globalPos = new Coordinate(globalX, globalY);
			targetPiece = board.getPieceAt(globalPos);
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
		while (i < possibleMoves.size()) {
			MyVector testVector = new MyVector((double) possibleMoves.get(i).getX(),
					(double) possibleMoves.get(i).getY());
			// MyVector thisUVector=thisVector.uVector();
			// MyVector testUVector=testVector.uVector();
			// double thisLength=thisVector.length();
			// double testLength=testVector.length();
			if ((thisVector.uVector().equals(testVector.uVector())) && (thisVector.length() < testVector.length())) {
				possibleMoves.remove(i);
			} else {
				i++;
			}
		}
	}

	public void removePawnDoubleAttack() {
		int i = 0;
		while (i < possibleMoves.size()) {
			if ((possibleMoves.get(i).getX() == 0) && (possibleMoves.get(i).getY() == 2)) {
				possibleMoves.remove(i);
			} else {
				i++;
			}
		}
	}

	public void removeInvalidPawnMoves() {
		int i = 0;
		while (i < possibleMoves.size()) {
			if ((possibleMoves.get(i).getX() != 0) && (possibleMoves.get(i).getTargetPiece() == null)) {
				possibleMoves.remove(i);
			} else if ((possibleMoves.get(i).getX() == 0) && (possibleMoves.get(i).getmType() == MoveType.CAPTURE)) {
				possibleMoves.remove(i);
			} else {
				i++;
			}
		}
	}

	public boolean containMove(Coordinate start, Coordinate to) {
		Coordinate translation = new Coordinate(to.getX() - start.getX(), to.getY() - start.getY());
		for (int i = 0; i < possibleMoves.size(); i++) {
			if ((translation.getX() == possibleMoves.get(i).getX())
					&& (translation.getY() == possibleMoves.get(i).getY())) {
				return true;
			}
		}
		return false;
	}

	public Piece getTargetPiece(int i) {
		return possibleMoves.get(i).getTargetPiece();
	}
	
	public Piece getTargetPiece(Coordinate start, Coordinate stop) {
		int localX = stop.getX() - start.getX();
		int localY = stop.getY() - start.getY();
		for (int i = 0; i < possibleMoves.size(); i++) {
			if ((localX == possibleMoves.get(i).getX()) && (localY == possibleMoves.get(i).getY())) {
				return possibleMoves.get(i).getTargetPiece();
			}
		}
		return null;
	}
	
	public MoveType getMoveType(Coordinate start, Coordinate stop) {
		int localX = stop.getX() - start.getX();
		int localY = stop.getY() - start.getY();
		for (int i = 0; i < possibleMoves.size(); i++) {
			if ((localX == possibleMoves.get(i).getX()) && (localY == possibleMoves.get(i).getY())) {
				return possibleMoves.get(i).getmType();
			}
		}
		return null;
	}
}
