package com.capgemini.chess.algorithms.implementation;

import java.util.ArrayList;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.enums.PieceType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.data.Coordinate;
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
	
	public int numberMoves(){
		return possibleMoves.size();
	}
	
	public void geometricCond(Coordinate start){
		int i=0;
		while(i<possibleMoves.size()){
			int globalX=start.getX()+possibleMoves.get(i).getX();
			int globalY=start.getY()+possibleMoves.get(i).getY();
			if((globalX<0||globalX>7)||(globalY<0||globalY>7)){
				possibleMoves.remove(i);
			}else{
				i++;
			}
		}
	}
	
	public void boardCond(Board board, Coordinate start, Color myColor){
		Piece targetPiece=null;
		int i=0;
		while(i<possibleMoves.size()){
			int globalX=start.getX()+possibleMoves.get(i).getX();
			int globalY=start.getY()+possibleMoves.get(i).getY();
			Coordinate globalPos=new Coordinate(globalX, globalY);
			targetPiece=board.getPieceAt(globalPos);
			if(targetPiece==null){
				i++;
				continue;
			}else if(myColor!=targetPiece.getColor()){
				possibleMoves.get(i).setmType(MoveType.CAPTURE);
				possibleMoves.get(i).setTargetPiece(targetPiece);
				removeFollowers(possibleMoves.get(i).getX(),possibleMoves.get(i).getY());
				i++;
			}else {
				removeFollowers(possibleMoves.get(i).getX(),possibleMoves.get(i).getY());
				possibleMoves.remove(i);
			}
		}
	}
	
	private void removeFollowers(int x, int y) {
		MyVector thisVector = new MyVector((double)x, (double)y);
		int i=0;
		while(i<possibleMoves.size()){
			MyVector testVector=new MyVector((double)possibleMoves.get(i).getX(),(double)possibleMoves.get(i).getY());
//			MyVector thisUVector=thisVector.uVector();
//			MyVector testUVector=testVector.uVector();
//			double thisLength=thisVector.length();
//			double testLength=testVector.length();
			if((thisVector.uVector().equals(testVector.uVector()))&&(thisVector.length()<testVector.length())){
				possibleMoves.remove(i);
			}else{
				i++;
			}
		}
	}

	public void removePawnDoubleAttack() {
		int i=0;
		while(i<possibleMoves.size()){
			if((possibleMoves.get(i).getX()==0)&&(possibleMoves.get(i).getY()==2)){
				possibleMoves.remove(i);
			}else{
				i++;
			}
		}
	}

	public boolean containMove(Coordinate start, Coordinate to){
		Coordinate translation=new Coordinate(to.getX()-start.getX(),to.getY()-start.getY());
		for (int i=0;i<possibleMoves.size();i++){
			if((translation.getX()==possibleMoves.get(i).getX())&&(translation.getY()==possibleMoves.get(i).getY())){
				return true;
			}
		}
		return false;
	}
	
	public Piece getTargetPiece(int i){
		return possibleMoves.get(i).getTargetPiece();
	}
	
	public Piece getMovePiece(Coordinate start, Coordinate stop){
		int localX=stop.getX()-start.getX();
		int localY=stop.getY()-start.getY();
		for(int i=0;i<possibleMoves.size();i++){
			if((localX==possibleMoves.get(i).getX())&&(localY==possibleMoves.get(i).getY())){
				return possibleMoves.get(i).getTargetPiece();
			}
		}
		return null;
	}
	
	public MoveType getMoveType(Coordinate start, Coordinate stop){
		int localX=stop.getX()-start.getX();
		int localY=stop.getY()-start.getY();
		for(int i=0;i<possibleMoves.size();i++){
			if((localX==possibleMoves.get(i).getX())&&(localY==possibleMoves.get(i).getY())){
				return possibleMoves.get(i).getmType();
			}
		}
		return null;
	}
}
