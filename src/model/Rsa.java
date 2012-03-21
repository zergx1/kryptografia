package model;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Vector;

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
	private BigInteger r;
	

	
  public static void main(String[] unused) {
    Random prng = new SecureRandom();  // self-seeding
    Rsa rsa = new Rsa();
//    //Public Key (N, E) = (2951147, 13)
//    //Private Key (N, D) = (2951147, 1133677)
//    
    rsa.n = new BigInteger("3233");
    rsa.e =  new BigInteger("17");
    rsa.d =  new BigInteger("2753");
//    
    String test = "KKK";
    BigInteger text;
    System.out.println(test);
//    
	text = new BigInteger( test.getBytes() );
	//text = new BigInteger("493");
	System.out.println("Bytes:"+text);
	
    StringFunctions h = new StringFunctions();
    
    h.splitAscii(rsa.n, text.toString());
    Vector<BigInteger> zxc = new Vector<BigInteger>(); // to encode
    Vector<String> en = new Vector<String>(); // to decode
    Vector<String> de = new Vector<String>();

    zxc.add(new BigInteger("493"));
    zxc.add(new BigInteger("447"));
    zxc.add(new BigInteger("5"));
    
    for(int i=0;i<zxc.size();i++)
    {
    	//System.out.println("To encoded: "+zxc.elementAt(i));
    	System.out.println("Encoded part "+rsa.encrypt(zxc.elementAt(i)));
    	en.add(rsa.encrypt(zxc.elementAt(i)));
    	//System.out.println("Decoded part: "+rsa.decrypt(new BigInteger(rsa.encrypt(zxc.elementAt(i)))));
    	de.add(rsa.decrypt(new BigInteger(rsa.encrypt(zxc.elementAt(i)))));
    }
    System.out.println("ENCODED WITH PARTS: ");
    for(int i=0;i<en.size();i++)
    {
    	System.out.print(en.elementAt(i));

    }
    System.out.println();
    System.out.println("Decoded WITH PARTS: ");
    String part_de = "";
    for(int i=0;i<en.size();i++)
    {
    	System.out.print(de.elementAt(i));
    	part_de += de.elementAt(i);
    }
    BigInteger tmp = new BigInteger(part_de);
    System.out.println();
    System.out.println("Convert back to text: ");
    rsa.convertByteArrayToString( tmp );

    
	
	String encoded = rsa.encrypt( text ); 
    System.out.println("Encoded: "+encoded);

    
    String decoded = rsa.decrypt(new BigInteger(encoded));
    System.out.println("Decoded: "+decoded);
    

    
    
    rsa.convertByteArrayToString( text );

	//BigInteger h = new BigInteger( test.getBytes() ).toString();

   /* String crypted = rsa.encrypt(test);
    System.out.println(crypted);
    test
    String decrypted = rsa.decrypt(test);
    System.out.println(decrypted);*/
	//System.out.println(rsa.encrypt(new BigInteger("910")));

    //String test = "Xfdsddasdasdasdasda89765458790087965465rtgyhbnjuy7utfgvbhysdgdfgddgd";
    //BigInteger raw;
	//raw =  new BigInteger( test.getBytes() );
	//System.out.println(raw);
    
    
    
    //rsa.generate_rsa();
    //rsa.generate_blind_signature(new BigInteger("7575757575"));
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
	  
	  this.p=BigInteger.ZERO;
	  this.q=BigInteger.ZERO;
	  this.e=mat.relativelyPrimeNumbers(eul);    // common value in practice = 2^16 + 1
	  this.d = e.modInverse(eul);

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

 public void generate_blind_signature(BigInteger msg)
     {
	 MathFunctions mat=new MathFunctions();
	 this.r=mat.relativelyPrimeNumbers(n);
      BigInteger blind;	//m' -zaciemnienie
      //BLIND
      blind = ((this.r.modPow(this.e,this.n)).multiply(msg)).mod(n);
      //SIGNAtURE
      BigInteger signature = blind.modPow(d,n);	//s' -podpis
      //UNBLIND
         BigInteger unblinded = this.r.modInverse(n).multiply(signature).mod(n);
         //SIGNATURE OF MSG
         BigInteger sig_of_m = msg.modPow(this.d,this.n);
         System.out.println("signature_of_m = " + sig_of_m);
         
         //check that unblinded is equal to a signature of m:
         System.out.println(unblinded.equals(sig_of_m));
         
         //try to verify using the RSA formula
         BigInteger check = unblinded.modPow(this.e,this.n);
         System.out.println(msg.equals(check));
      
     }

  
  
}