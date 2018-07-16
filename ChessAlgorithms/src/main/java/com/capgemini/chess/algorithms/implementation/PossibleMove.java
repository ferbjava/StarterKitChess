package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.PieceType;

public class PossibleMove {

	private int xMove;
	private int yMove;
	private MoveType mType;
	private PieceType targetPiece;

	public PossibleMove(int xMove, int yMove, MoveType mType, PieceType targetPiece) {
		this.setX(xMove);
		this.setY(yMove);
		this.setmType(mType);
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

	public PieceType getTargetPiece() {
		return targetPiece;
	}

	public void setTargetPiece(PieceType targetPiece) {
		this.targetPiece = targetPiece;
	}

}
