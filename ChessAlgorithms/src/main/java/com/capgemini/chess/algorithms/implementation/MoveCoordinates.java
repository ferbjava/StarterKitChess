package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;

public class MoveCoordinates {
	private Coordinate start;
	private Coordinate stop;
	

	
	public MoveCoordinates() {
		this.start=null;
		this.stop=null;
	}
	
	public MoveCoordinates(Coordinate start, Coordinate stop) {
		this.start=start;
		this.stop=stop;
	}
	
	public Coordinate getStart() {
		return start;
	}
	public void setStart(Coordinate start) {
		this.start = start;
	}
	public Coordinate getStop() {
		return stop;
	}
	public void setStop(Coordinate stop) {
		this.stop = stop;
	}
}
