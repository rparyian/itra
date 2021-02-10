package moves;

public class MoveLogics {
public static int compareMoves(int userMove,int computerMove,String[] args ) {
	if (userMove==computerMove)
		return 0;
	if (userMove<computerMove) {
		if ((userMove+args.length/2)>=computerMove)
			return -1;
		else return 1;
	}
	else {
		if ((computerMove+args.length/2)>=userMove)
			return 1;
		else return -1;
	}	
}
}
