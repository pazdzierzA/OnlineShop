package com.solvd.onlineshop.enums;

public enum ApparelSize {
	SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

	private final String sizeCode;

	private ApparelSize(String sizeCode) {
		this.sizeCode = sizeCode;
	}

	public String getSizeCode() {
		return sizeCode;
	}

}
