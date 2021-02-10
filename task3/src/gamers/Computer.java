package gamers;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.SecureRandom;

import main.Hmac_impl;

public class Computer  {
	SecureRandom random = new SecureRandom();
	private byte[] key=new byte[16];
	private String HMAC;
	private int move;
	
    public String getKey() {
    	StringBuilder result = new StringBuilder();
        for (byte temp : key) {
            result.append(String.format("%02x", temp));
        }
        return result.toString();
	}
    
    public int getMove(String[] args) {
    	random.nextBytes(key);
	move=random.nextInt(args.length);
	System.out.println("Computer made a move");
	try {
	      byte[] hmacSha256 = Hmac_impl.calcHmacSha256(key, args[move].getBytes("UTF-8"));
	      HMAC=String.format("Hmac: %032x", new BigInteger(1, hmacSha256));
	      System.out.println(HMAC); 
	    } catch (UnsupportedEncodingException e) {
	      e.printStackTrace();
	    }
	return move;
	  }
    public boolean checkHMAC(byte[] key, String move) {
	  try {
	      byte[] hmacSha256 = Hmac_impl.calcHmacSha256(key, move.getBytes("UTF-8"));
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
