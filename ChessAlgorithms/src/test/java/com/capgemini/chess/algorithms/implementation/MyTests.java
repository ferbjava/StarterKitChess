package com.capgemini.chess.algorithms.implementation;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.BoardState;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

/**
 * Class with additional tests
 * 
 * @author MKOTECKI
 *
 */
public class MyTests {

	@Test
	public void shouldReturnExceptionInvalidPawnCapture() {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(1, 1));
		board.setPieceAt(Piece.BLACK_PAWN, new Coordinate(1, 3));

		// when
		BoardManager boardManager = new BoardManager(board);
		boolean exceptionThrown = false;
		try {
			boardManager.performMove(new Coordinate(1, 1), new Coordinate(1, 3));
		} catch (InvalidMoveException e) {
			exceptionThrown = true;
		}

		// then
		assertTrue(exceptionThrown);
	}

	@Test
	public void shouldReturnVectorLenght5() {
		// given
		double x = 3.0;
		double y = 4.0;
		double EXPECTED_LENGTH = 5.0;

		// when
		MyVector testVector = new MyVector(x, y);
		double testLenght = testVector.length();

		// then
		assertTrue((EXPECTED_LENGTH - testLenght) < 0.0000001);
	}

	@Test
	public void shouldReturnVerticalUnitVector() {
		// given
		double x = 0.0;
		double y = 5.0;
		MyVector EXPECTED_UNIT_VECTOR = new MyVector(0.0, 1.0);

		// when
		MyVector testVector = new MyVector(x, y);
		MyVector testUnitVector = testVector.uVector();

		// then
		assertEquals(EXPECTED_UNIT_VECTOR, testUnitVector);
	}

	@Test
	public void shouldReturn25MovesForQueen() {
		// given
		Piece testQueen = Piece.WHITE_QUEEN;
		Coordinate from = new Coordinate(4, 5);
		int EXPECTED_MOVES = 25;

		// when
		MoveCreator queenMoves = new MoveCreator();
		queenMoves.baseMoves(testQueen);
		queenMoves.checkingGeomCond(from, testQueen);

		// then
		assertTrue(EXPECTED_MOVES == queenMoves.numberMoves());
	}

	@Test
	public void shouldReturn10MovesForRook() {
		// given
		Board board = new Board();
		Piece figure1 = Piece.WHITE_ROOK;
		Piece figure2 = Piece.WHITE_PAWN;
		Coordinate fig1Field = new Coordinate(2, 2);
		Coordinate fig2field = new Coordinate(4, 2);
		Move probeMove = new Move();
		probeMove.setFrom(new Coordinate(-1, -1));
		probeMove.setTo(new Coordinate(-1, -1));
		int EXPECTED_MOVES = 10;

		// when
		board.setPieceAt(figure1, fig1Field);
		board.setPieceAt(figure2, fig2field);
		MoveCreator rookMoves = new MoveCreator();
		rookMoves.baseMoves(figure1);
		rookMoves.checkingGeomCond(fig1Field, figure1);
		rookMoves.checkingBoardCond(board, fig1Field, probeMove);

		// then
		assertTrue(EXPECTED_MOVES == rookMoves.numberMoves());
	}

	@Test
	public void shouldReturnQueenAfterPromotion() throws InvalidMoveException {
		// given
		Board board = new Board();
		Piece figure1 = Piece.WHITE_PAWN;
		Coordinate from = new Coordinate(3, 6);
		Coordinate to = new Coordinate(3, 7);
		board.setPieceAt(figure1, from);

		Piece EXPECTED_PIECE = Piece.WHITE_QUEEN;

		// when
		BoardManager boardManager = new BoardManager(board);
		boardManager.performMove(from, to);

		// then
		assertTrue(EXPECTED_PIECE == boardManager.getBoard().getPieceAt(to));
	}

	@Test
	public void shouldReturnSchoolCheckMate() throws InvalidMoveException {
		// given
		ArrayList<Move> moves = new ArrayList<>();
		Move move1 = new Move();
		move1.setFrom(new Coordinate(5, 1));
		move1.setTo(new Coordinate(5, 3));
		move1.setType(MoveType.ATTACK);

		Move move2 = new Move();
		move2.setFrom(new Coordinate(4, 6));
		move2.setTo(new Coordinate(4, 5));
		move2.setType(MoveType.ATTACK);

		Move move3 = new Move();
		move3.setFrom(new Coordinate(6, 1));
		move3.setTo(new Coordinate(6, 3));
		move3.setType(MoveType.ATTACK);

		Move move4 = new Move();
		move4.setFrom(new Coordinate(3, 7));
		move4.setTo(new Coordinate(7, 3));
		move4.setType(MoveType.ATTACK);

		moves.add(move1);
		moves.add(move2);
		moves.add(move3);
		moves.add(move4);

		BoardState EXPECTED_BOARD_STATUS = BoardState.CHECK_MATE;

		// when
		BoardManager boardManager = new BoardManager(moves);
		boardManager.updateBoardState();
		boardManager.getBoard().getState();

		// then
		assertTrue(EXPECTED_BOARD_STATUS == boardManager.getBoard().getState());
	}

	@Test
	public void shouldReturnException2MovesSamePlayer() throws InvalidMoveException {
		// given
		ArrayList<Move> moves = new ArrayList<>();
		Move move1 = new Move();
		move1.setFrom(new Coordinate(5, 1));
		move1.setTo(new Coordinate(5, 3));
		move1.setType(MoveType.ATTACK);

		moves.add(move1);
		BoardManager boardManager = new BoardManager(moves);
		boolean exceptionThrown = false;

		// when
		try {
			boardManager.performMove(new Coordinate(6, 1), new Coordinate(6, 2));
		} catch (InvalidMoveException e) {
			exceptionThrown = true;
		}

		// then
		assertTrue(exceptionThrown);
	}

	@Test
	public void shouldReturnCheckForWhite() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(4, 3));
		board.setPieceAt(Piece.WHITE_ROOK, new Coordinate(3, 2));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(3, 7));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(2, 7));
		board.getMoveHistory().add(createDummyMove(board));

		// when
		BoardManager boardManager = new BoardManager(board);
		boardManager.updateBoardState();
		boardManager.performMove(new Coordinate(2, 7), new Coordinate(3, 5));
		boardManager.updateBoardState();

		// then
		assertEquals(BoardState.CHECK, boardManager.getBoard().getState());
	}

	@Test
	public void shouldReturnCheckForBlack() {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KING, new Coordinate(4, 3));
		board.setPieceAt(Piece.WHITE_ROOK, new Coordinate(3, 2));
		board.setPieceAt(Piece.BLACK_KING, new Coordinate(3, 7));
		board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(2, 7));
		board.getMoveHistory().add(createDummyMove(board));

		// when
		BoardManager boardManager = new BoardManager(board);
		boardManager.updateBoardState();

		// then
		assertEquals(BoardState.CHECK, boardManager.getBoard().getState());
	}

	@Test
	public void shouldReturnAttackForKnight() throws InvalidMoveException {
		// given
		Board board = new Board();
		board.setPieceAt(Piece.WHITE_KNIGHT, new Coordinate(2, 3));
		board.setPieceAt(Piece.BLACK_PAWN, new Coordinate(2, 4));
		board.setPieceAt(Piece.BLACK_PAWN, new Coordinate(3, 3));
		board.setPieceAt(Piece.BLACK_PAWN, new Coordinate(3, 4));
		board.setPieceAt(Piece.BLACK_PAWN, new Coordinate(4, 3));

		BoardManager boardManager = new BoardManager(board);

		// when
		Move move = boardManager.performMove(new Coordinate(2, 3), new Coordinate(4, 4));

		// then
		assertEquals(Piece.WHITE_KNIGHT, board.getPieceAt(new Coordinate(4, 4)));
		assertEquals(MoveType.ATTACK, move.getType());
	}

	private Move createDummyMove(Board board) {

		Move move = new Move();

		if (board.getMoveHistory().size() % 2 == 0) {
			board.setPieceAt(Piece.WHITE_ROOK, new Coordinate(0, 0));
			move.setMovedPiece(Piece.WHITE_ROOK);
		} else {
			board.setPieceAt(Piece.BLACK_ROOK, new Coordinate(0, 0));
			move.setMovedPiece(Piece.BLACK_ROOK);
		}
		move.setFrom(new Coordinate(0, 0));
		move.setTo(new Coordinate(0, 0));
		move.setType(MoveType.ATTACK);
		board.setPieceAt(null, new Coordinate(0, 0));
		return move;
	}

}
