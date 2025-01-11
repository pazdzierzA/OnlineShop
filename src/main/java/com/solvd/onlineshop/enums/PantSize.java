package com.solvd.onlineshop.enums;

public enum PantSize {
	SIZE_28_30(28, 30), SIZE_28_32(28, 32), SIZE_30_30(30, 30), SIZE_30_32(30, 32), SIZE_32_32(32, 32),
	SIZE_32_34(32, 34);

	private final Integer waist;
	private final Integer length;

	private PantSize(Integer waist, Integer length) {
		this.waist = waist;
		this.length = length;
	}

	public Integer getWaist() {
		return waist;
	}

	public Integer getLenght() {
		return length;
	}

	@Override
	public String toString() {
		return "Waist: " + waist + ", Length: " + length;
	}

}
