package com.osoobe.odomi.entities;

import java.util.ArrayList;

public class Player {
	private String name;
	private ArrayList<Domino> dominoes = new ArrayList<Domino>();
	private int wins = 0;
	private int lose = 0;
	
	public Player(String name){
		this.name = name;
	}
	
	public void addDomino(Domino domino){
		dominoes.add(domino);
	}
	
	public Domino playDomino(int index){
		try {
			return dominoes.remove(index);
		} catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	
	public Domino playDomino(Domino domino){
		int index = hasDomino(domino);
		if(index != -1)
			return playDomino(index);
		return null;
	}
	
	public int hasDomino(Domino domino){
		return dominoes.indexOf(domino);
	}
	
	public int numDominoes(){
		return dominoes.size();
	}
	
	public void win(){
		wins++;
	}
	
	public void lose(){
		lose++;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	
}
