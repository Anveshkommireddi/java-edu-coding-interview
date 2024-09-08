package com.edu.java.misc.nc;

import java.util.ArrayList;
import java.util.List;

public class DSUF {

	private List<Integer> size;

	private List<Integer> parent;

	public DSUF(int totalVerticies) {
		this.size = new ArrayList<>();
		this.parent = new ArrayList<>();
		for (int i = 0; i <= totalVerticies; i++) {
			parent.set(i, i);
			size.set(i, 1);
		}
	}

	public int fup(int u) {
		if (parent.get(u) == u)
			return u;
		int uparent = fup(parent.get(u));
		parent.set(u, uparent);
		return uparent;
	}

	public void union(int u, int v) {
		int pu = fup(u);
		int pv = fup(v);
		if (pu == pv)
			return;
		int su = size.get(pu);
		int sv = size.get(pv);
		if (su < sv) {
			parent.set(pu, pv);
			size.set(sv, su + sv);
		} else if (su > sv) {
			parent.set(pv, pu);
			size.set(su, su + sv);
		}
	}

}
