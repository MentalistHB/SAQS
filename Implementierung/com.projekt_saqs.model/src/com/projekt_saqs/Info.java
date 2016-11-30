package com.projekt_saqs;

import java.util.Random;

public class Info extends Station{
	private float actual;

	public Info(){
		super();
		this.actual = this.generateActual(5, 100);
	}
	public float getActual() {
		return actual;
	}

	public void setActual(float actual) {
		this.actual = actual;
	}
	
	public float generateActual(float min, float max){
		Random r = new Random();
		float newTarget = (float) (min + (max - min) * r.nextDouble());
		return newTarget;
	}
}
