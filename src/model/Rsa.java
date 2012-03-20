package model;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

import extra.MathFunctions;
import extra.StringFunctions;

/*

 */
public class Rsa {
	// KLUCZ PUBLICZNY DEFINIOWANY JEST JAKO PARA LICZB (n, e)
	// KLUCZ PRYWATNY DEFINIOWANY JEST JAKO PARA LICZB (n, d)
	private int bitlen = 1024;
	private BigInteger n; // n=p*q
	private BigInteger p;
	private BigInteger q;
	private BigInteger d; // odwrotnosc e mod eul
	private BigInteger eul; //  eulera(n)
	private BigInteger e;
	

	
  public static void main(String[] unused) {
    Random prng = new SecureRandom();  // self-seeding
    Rsa rsa = new Rsa();
    //Public Key (N, E) = (2951147, 13)
    //Private Key (N, D) = (2951147, 1133677)
    
    rsa.n = new BigInteger("3233");
    rsa.e =  new BigInteger("17");
    rsa.d =  new BigInteger("2753");
    
    String test = "KKKk";
    BigInteger text;
    System.out.println(test);
    
	text = new BigInteger( test.getBytes() );
	//text = new BigInteger("493");
	System.out.println("Bytes:"+text);
	
    StringFunctions h = new StringFunctions();
    //h.splitAscii(rsa.n, text);
	
	String encoded = rsa.encrypt( text ); 
    System.out.println("Encoded: "+encoded);

    
    String decoded = rsa.decrypt(new BigInteger(encoded));
    System.out.println("Decoded: "+decoded);
    

    
    
    //rsa.convertByteArrayToString( text );

	//BigInteger h = new BigInteger( test.getBytes() ).toString();

   /* String crypted = rsa.encrypt(test);
    System.out.println(crypted);
    test
    String decrypted = rsa.decrypt(test);
    System.out.println(decrypted);*/
	//System.out.println(rsa.encrypt(new BigInteger("910")));

    
    
    rsa.generate_rsa();
    //System.out.println(rsa.n);
    }
  
  public BigInteger getN() {
	return n;
}

public BigInteger getD() {
	return d;
}

public BigInteger getE() {
	return e;
}

public void setN(BigInteger n) {
	this.n = n;
}

public void setD(BigInteger d) {
	this.d = d;
}

public void setE(BigInteger e) {
	this.e = e;
}

public void convertByteArrayToString(BigInteger msg) {
	  
      
      byte[] byteArray = msg.toByteArray();
      
      String value = new String(byteArray);
      
      System.out.println(value);
  }
  
  public void generate_rsa()
  {
	  this.q = this.return_random_prime(this.bitlen); // Losowanie liczyb pierwszej q
	  this.p = this.return_random_prime(this.bitlen); // Losowanie liczby pierwsze p

	  this.n = q.multiply(p); // n = p*q
	  
	  
	  MathFunctions mat=new MathFunctions();
	  this.eul=mat.eulerFunction(p, q);
	  //System.out.println(eul);
	  
	  
	  this.p=BigInteger.ZERO;
	  this.q=BigInteger.ZERO;
	  this.e=new BigInteger("65537");     // common value in practice = 2^16 + 1
//	  while(!e.gcd(eul).equals(BigInteger.ONE))
//	  this.e=mat.relativelyPrimeNumbers(eul);
	  //System.out.println(e);

	  this.d = e.modInverse(eul);
	  //System.out.println(d);
	  //System.out.println("koniec");
  }
  
  
  public BigInteger return_random_prime(int bitlength)
  {
	  /*
	   * Funkjca zwraca losowa liczbe pierwsza o podanej dlugosci bitow
	   */
	  Random prng = new SecureRandom();
	  return BigInteger.probablePrime(bitlength/2, prng);
	  
  }
  
  
  public String encrypt(BigInteger msg) {
      return new String( msg.modPow(this.e, this.n).toString() ); // text ^ e mod n
  }
  
  
  public String decrypt(BigInteger msg) {
      return new String(msg.modPow(this.d, this.n).toString() );
  }



  
  
}