/**
 * 
 */
package com.osoobe.odomi.entities;

import java.util.ArrayList;
import java.util.Collections;


/**
 * @author oshane
 *
 */
public class Game {
	static Player[] players;
	ArrayList<Domino> dominoes = new ArrayList<Domino>();
	public static enum STATE{NEW, CONTINUATION}
	public static STATE state = STATE.NEW;
	private static int whoseTurn = 0;
	static int whoWons;
	static int default_numhand = 7, numshared = 0;;
	
	public Game(int numPlayers){
		players = new Player[numPlayers];
		generateDominoes();	
	}
	
	public void addPlayer(Player player){
		int index = 0;
		do{
			if(players[index] == null)
				players[index] = player;
			else
				index++;
		}while(index < players.length);
	}
	
	public void startGame() throws Exception{
		if(players.length != 0){
			numshared = shareDominoes(0, 0);
		}else
			throw new Exception("No player added to this game");
	}
	
	public Domino initiateStarter(){
		if(state == STATE.NEW){
			poseDomino(6,6);
		}
		return null;
	}
	
	public Domino poseDomino(int numer, int denumer){
		Domino domino = null;
		int index;
		for(int i = 0; i < players.length; i++){
			domino = new Domino(numer, denumer);
			index = players[i].hasDomino(domino);
			if(index != -1){
				whoseTurn = i;
				return players[i].playDomino(index);
			}
		}
		if(numer == denumer && numer != 0){
			return poseDomino(numer - 1, denumer - 1);
		}else if(numer == 0 && denumer == 0){
			return poseDomino(numer - 1, denumer);
		}else{		
			return poseDomino(6, denumer - 1);
		}
	}
	
	public Domino doTurn(Domino domino){
		Domino d1 = dominoes.get(0);
		Domino d2 = dominoes.get(-1);
		int index = players[whoseTurn].hasDomino(domino);
		if(index != -1){
			if(d1.equals(domino) || d2.equals(domino))
				return domino;
			else
				return null;
		}		
		return null;		
	}
	
	public void nextPlayerTurn(){
		whoseTurn++;
	}
	
	protected int shareDominoes(int playerIndex, int dominoIndex){
		if(players.length*default_numhand == dominoIndex+1){
			return dominoIndex;
		}else if(players[playerIndex].numDominoes() != default_numhand){
			players[playerIndex].addDomino(dominoes.get(dominoIndex));
			if(playerIndex+1 == 3)
				return shareDominoes(0, dominoIndex+1);
			else
				return shareDominoes(playerIndex+1, dominoIndex+1);
		}else{
			return dominoIndex;
		}		
	}
	
	protected void generateDominoes(){
		for(int i = 1; i < 7; i++){
			for(int j = 1; j < 7; j++){
				if(i <= j)
					dominoes.add(new Domino(i, j));
			}
		}
		Collections.shuffle(dominoes);
	}
}
