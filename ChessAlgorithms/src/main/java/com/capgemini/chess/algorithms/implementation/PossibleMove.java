package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;

public class PossibleMove {

	private int xMove;
	private int yMove;
	private MoveType mType;
	private Piece targetPiece;

	public PossibleMove(int xMove, int yMove, MoveType mType, Piece targetPiece) {
		this.setX(xMove);
		this.setY(yMove);
		this.setmType(mType);
		this.setTargetPiece(targetPiece);
	}

	public PossibleMove(Piece targetPiece) {
		this.setTargetPiece(targetPiece);
	}

	public int getX() {
		return xMove;
	}

	public void setX(int xMove) {
		this.xMove = xMove;
	}

	public int getY() {
		return yMove;
	}

	public void setY(int yMove) {
		this.yMove = yMove;
	}

	public MoveType getmType() {
		return mType;
	}

	public void setmType(MoveType mType) {
		this.mType = mType;
	}

	public Piece getTargetPiece() {
		return targetPiece;
	}

	public void setTargetPiece(Piece targetPiece) {
		this.targetPiece = targetPiece;
	}

}
