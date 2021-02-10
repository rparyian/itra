package info;

import main.Game;

public class ResultInfo {
public void getStats(Game game) {
	 int wins = game.getUserScore();
     int losses = game.getComputerScore();
     int ties = game.getNumberOfGames() - wins - losses;
     double percentageWon = (wins + ((double) ties) / 2) / game.getNumberOfGames();
 
     System.out.print("+");
     printDashes(68);
     System.out.println("+");
 
    
     System.out.printf("|  %6s  |  %6s  |  %6s  |  %12s  |  %14s  |\n",
             "WINS", "LOSSES", "TIES", "GAMES PLAYED", "PERCENTAGE WON");
 
     System.out.print("|");
     printDashes(10);
     System.out.print("+");
     printDashes(10);
     System.out.print("+");
     printDashes(10);
     System.out.print("+");
     printDashes(16);
     System.out.print("+");
     printDashes(18);
     System.out.println("|");
 
     System.out.printf("|  %6d  |  %6d  |  %6d  |  %12d  |  %13.2f%%  |\n",
             wins, losses, ties, game.getNumberOfGames(), percentageWon * 100);
 
     System.out.print("+");
     printDashes(68);
     System.out.println("+");
 }

 private void printDashes(int numberOfDashes) {
     for (int i = 0; i < numberOfDashes; i++) {
         System.out.print("-");
     }
 }
}
