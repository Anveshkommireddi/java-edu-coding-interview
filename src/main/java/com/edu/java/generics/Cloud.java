package com.edu.java.generics;

public class Cloud<T extends CloudType>  implements Comparable<T>{

	private T cloud;

	public Cloud(T cloud) {
		this.cloud = cloud;
	}

	public void setCloud(T cloud) {
		this.cloud = cloud;
	}

	public T getCloud() {
		return cloud;
	}

	@Override
	public int compareTo(T o) {
		return 0;
	}

}
