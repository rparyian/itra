package main;

import gamers.Computer;
import gamers.User;
import info.ResultInfo;
import moves.MoveLogics;
import javax.xml.bind.DatatypeConverter;
import java.math.BigInteger;
import java.util.Random;

import argumentsCheck.CheckArguments;

public class Game {
	 private User user;
	 private Computer computer;
	 private int userScore;
	 private int computerScore;
	 private int numberOfGames;
	 private String cheatMode="ON";

public int getUserScore() {
		return userScore;
	}

	public int getComputerScore() {
		return computerScore;
	}

	public int getNumberOfGames() {
		return numberOfGames;
	}

public static void main(String[] args) {
	 new Game().startGame(args);
}

public Game() {
	user = new User();
    computer = new Computer();
    userScore = 0;
    computerScore = 0;
    numberOfGames = 0;
}

public void startGame(String [] args) {
	if (!CheckArguments.checkarguments(args))
		return;
	int computerMove=computer.getMove(args);
	int userMove=user.getMove(args);
	if (cheatModeOn()) {
		if (userMove==args.length-1)
			computerMove=0;
		else computerMove=userMove+1;
	}
	int result=	MoveLogics.compareMoves(userMove, computerMove, args);
	this.getResultGame(result,userMove,computerMove,args);
	System.out.println();
	if (user.wannaCheckHonesty()) {
		if (!computer.checkHMAC(user.enterKey(), user.enterMove()))
			cheatMode="OFF";
	}
		
	if (user.playAgain()) {
		 System.out.println();
         startGame(args);
     } else {
         new ResultInfo().getStats(this);
     }
	}
private boolean cheatModeOn() {
	return (cheatMode.equals("ON"));
}

public void getResultGame(int result,int userMove,int computerMove,String[] args) {
	System.out.println("Secret key is- "+computer.getKey());
	switch (result) {
	case 0:
		System.out.println("Your move is- "+args[userMove]+". Computer's move is- "+args[computerMove]+". Tie!");
		break;
	case 1:
		System.out.println("Your move is- "+args[userMove]+". Computer's move is- "+args[computerMove]+". You won!");
		userScore++;
		break;
	case -1:
	    System.out.println("Your move is- "+args[userMove]+". Computer's move is- "+args[computerMove]+". You lose!");
	    computerScore++;
	    break;
	}
	numberOfGames++;
	
}
}
