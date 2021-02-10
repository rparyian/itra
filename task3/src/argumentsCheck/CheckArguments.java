package argumentsCheck;

import java.util.Arrays;

public class CheckArguments {
	public static boolean checkarguments(String[] args) {
		if (args.length<3) {
		System.out.println("3 arguments at least required");
		return false;
		}
		else if((args.length%2)==0) {
			System.out.println("Odd number of arguments required");
			return false;
		}
		else if (!isUniq(args))
			return false;
		else return true;
	}
	public static boolean isUniq(String[] args) {
		Arrays.sort(args);
		for(int i=0;i<args.length-1;i++) {
			if (args[i].equals(args[i+1])) {
				System.out.println("Only unique arguments required");
				return false;
			}	
		}
		return true;
	}
}
