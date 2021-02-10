package gamers;

import java.util.Scanner;

public class User {
	 private Scanner inputScanner;
     
     public User() {
         inputScanner = new Scanner(System.in);
     }

	public int getMove(String[] args) {
		System.out.println("Make your move");
		for (int i=0;i<args.length;i++)
		System.out.println("Press "+i+" for "+args[i]+" move");
		String userInput = inputScanner.nextLine();
		if (!isUserMoveCorrect(userInput,args)) {
			System.out.println("Incorrect move");
			getMove(args);
		}
		return Integer.parseInt(userInput);
		
	}
	public boolean isUserMoveCorrect(String userInput, String[]args) {
		boolean flag=false;
		for(int i=0;i<args.length;i++) {
			if (Integer.valueOf(i).toString().equals(userInput))
					flag=true;
		}
		return flag;
	}
	public boolean playAgain() {
		System.out.print("Do you want play one more time? Press 'Y' for yes ");
        String userInput = inputScanner.nextLine();
        userInput = userInput.toUpperCase();
        return userInput.charAt(0) == 'Y';
	}
    public boolean wannaCheckHonesty() {
    	System.out.print("Do you want to check honesty of computer? Press 'Y' for yes");
        String userInput = inputScanner.nextLine();
        userInput = userInput.toUpperCase();
        return userInput.charAt(0) == 'Y';
    }

	public byte[] enterKey() {
		System.out.print("Please, enter key");
        String userInput = inputScanner.nextLine();
        return hexStringToByteArray(userInput);
	}
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}

	public String enterMove() {
		System.out.print("Please, enter computer's move name");
        return inputScanner.nextLine();
	}
}
