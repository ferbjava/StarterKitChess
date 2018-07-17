package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;

public class CheckingMove {
	private Coordinate from;
	private Coordinate to;
	
	
	
	public CheckingMove(Coordinate from, Coordinate to) {
		this.from=from;
		this.to=to;
		
	}

	public Coordinate getFrom() {
		return from;
	}

	public void setFrom(Coordinate from) {
		this.from = from;
	}

	public Coordinate getTo() {
		return to;
	}

	public void setTo(Coordinate to) {
		this.to = to;
	}
	
}
