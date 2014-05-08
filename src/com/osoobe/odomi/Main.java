package com.osoobe.odomi;

import com.osoobe.odomi.entities.Game;
import com.osoobe.odomi.entities.Player;

public class Main {
	
	
	public static void main(String[] args){
		Game dominoGame = new Game(3);
		dominoGame.addPlayer(new Player("Oshane"));
		dominoGame.addPlayer(new Player("Aldin"));
		dominoGame.addPlayer(new Player("Abigail"));
		try {
			dominoGame.startGame();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
