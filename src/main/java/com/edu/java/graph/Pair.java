package com.edu.java.graph;

import java.util.Objects;

public class Pair {

	public int rowIdx;
	public int colIdx;
	public int time;

	public Pair(int rowIdx, int colIdx) {
		this.rowIdx = rowIdx;
		this.colIdx = colIdx;
	}

	Pair(int rowIdx, int colIdx, int time) {
		this(rowIdx, colIdx);
		this.time = time;
	}

	@Override
	public int hashCode() {
		return Objects.hash(colIdx, rowIdx);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		return colIdx == other.colIdx && rowIdx == other.rowIdx;
	}
	
}
