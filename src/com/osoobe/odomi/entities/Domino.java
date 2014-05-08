/**
 * 
 */
package com.osoobe.odomi.entities;

/**
 * @author oshane
 *
 */
public class Domino {
	int numer, denumer;
	
	public Domino(int numer, int denumer){
		this.numer = numer;
		this.denumer = denumer;
	}
	
	public boolean hasValue(int value){
		if(this.numer == value || this.denumer == value){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean hasValue(int numer, int denumer){
		if(hasValue(numer) && hasValue(denumer)){
			return true;
		}else{
			return false;
		}
	}
}
