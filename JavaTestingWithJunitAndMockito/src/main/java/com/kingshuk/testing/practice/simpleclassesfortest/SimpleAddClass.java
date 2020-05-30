package com.kingshuk.testing.practice.simpleclassesfortest;

public class SimpleAddClass {

	public static void main(String[] args) {
		SimpleAddClass simpleAddClass = new SimpleAddClass();
		System.out.println(simpleAddClass.addtwoValues(13878, 12313));
	}
	
	public Integer addtwoValues(Integer int1, Integer int2) {
		return int1+int2;
	}

}
