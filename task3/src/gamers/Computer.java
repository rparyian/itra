package gamers;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import de.jstacs.utils.random.RandomNumberGenerator;
import main.Hmac_impl;

public class Computer extends RandomNumberGenerator {
	private int key;
	private String HMAC;
	private int move;
	
    public int getKey() {
		return key;
	}
    
    public int getMove(String[] args) {
	key=next(128);
	move=nextInt(args.length);
	System.out.println("Computer made a move");
	try {
	      byte[] hmacSha256 = Hmac_impl.calcHmacSha256(BigInteger.valueOf(key).toByteArray(), args[move].getBytes("UTF-8"));
	      HMAC=String.format("Hmac: %032x", new BigInteger(1, hmacSha256));
	      System.out.println(HMAC); 
	    } catch (UnsupportedEncodingException e) {
	      e.printStackTrace();
	    }
	return move;
	  }
    
    @Override
    protected synchronized int next(int arg0) {
	// TODO Auto-generated method stub
	return super.next(arg0);
}
    
    public boolean checkHMAC(int key, String move) {
	  try {
	      byte[] hmacSha256 = Hmac_impl.calcHmacSha256(BigInteger.valueOf(key).toByteArray(), move.getBytes("UTF-8"));
	      String HMAC1=String.format("Hmac: %032x", new BigInteger(1, hmacSha256));
	      System.out.println(HMAC1); 
	      if (HMAC1.equals(HMAC)) {
	    	  System.out.println("Good play - fair play");
	    	  return true;
	      }
	      else { System.out.println("OK. You caught me. I am cheater)) Disabling cheatMode");
	      		return false;
	      }
	    } catch (UnsupportedEncodingException e) {
	      e.printStackTrace();
	      return true;
	    }
  }
}
