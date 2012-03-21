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
//    //Public Key (N, E)
//    //Private Key (N, D) 
//    
    rsa.generateRsaKeys();	//generujemy wszystkie klucze n,e,d,r  
//    rsa.n = new BigInteger("3233");
//    rsa.e =  new BigInteger("17");
//    rsa.d =  new BigInteger("2753");
//    rsa.r =	new BigInteger("3232");
    
//    Szyfrowanie stringu KKK
    String test = "KKK";
    System.out.println("Msg" +test);
//     
    BigInteger text; 
	text = new BigInteger( test.getBytes() );

	System.out.println("Bytes:"+text);
	
    StringFunctions h = new StringFunctions();
    
    Vector<BigInteger> zxc=h.splitAscii(rsa.n, text.toString());
    h.showMeVectorNL(zxc,"Spit bytes");
    //Vector<BigInteger> zxc = new Vector<BigInteger>(); // to encode
    Vector<String> en = new Vector<String>(); // to decode
    Vector<String> de = new Vector<String>();
    
    // BYtes of KKK: 4934475  ustawilem recznie bo nie wiedzialem czy dziala Twoja funkcja split DZIA£A 
    //BOJE SIE TYLKO CO BEDZIE JAK LICZBA DO PODZIELENIA TO NP 122052356 a liczba n to 1121 wtedy podzieli na
    //122 | 0523 | 56 i nie wiem czy szyfrowanie zadziala na 0523
//    zxc.add(new BigInteger("493"));
//    zxc.add(new BigInteger("447"));
//    zxc.add(new BigInteger("5"));


    
//    for(int i=0;i<zxc.size();i++)
//    {
//    	// WSZYSTKIE CZESCI ZAKODOWANE CZY NIE SA MNIEJSZE OD THIS.N czyli 3233
//    	//System.out.println("To encoded: "+zxc.elementAt(i));
//    	System.out.println("Encoded part "+rsa.encrypt(zxc.elementAt(i))); // Szyfrowanie po kolei kawalkow 493, 447, 5
//    	en.add(rsa.encrypt(zxc.elementAt(i)));
//    	//System.out.println("Decoded part: "+rsa.decrypt(new BigInteger(rsa.encrypt(zxc.elementAt(i)))));
//    	de.add(rsa.decrypt(new BigInteger(rsa.encrypt(zxc.elementAt(i)))));// Odszyfrowanie ich od razu
//    }
    Vector<BigInteger> bl = new Vector<BigInteger>(); 	// zaciemnione
    Vector<BigInteger> si = new Vector<BigInteger>();	//podpisane
    Vector<BigInteger> ubl = new Vector<BigInteger>();	//odciemnione
    System.out.println("Blinded values");
    for(int i=0;i<zxc.size();i++)
    {
    	bl.add(rsa.generateBlinded(zxc.elementAt(i)));
    	System.out.println(zxc.elementAt(i)+" -> "+bl.elementAt(i));
    }
    System.out.println("Signed values");
    for(int i=0;i<bl.size();i++)
    {
    	si.add(rsa.generateSignedValue(bl.elementAt(i)));
    	System.out.print(bl.elementAt(i)+" -> "+si.elementAt(i));
    	ubl.add(rsa.generateUnBlinded(si.elementAt(i)));
    	System.out.println(" check "+rsa.checkBlindSignature(ubl.elementAt(i), zxc.elementAt(i)));
    	
    }
    h.nl(1);
    h.showMeVector(ubl,"","ZASZYFROWANA WIADOMOSC");
    Vector<BigInteger> zxc2=h.splitAscii(rsa.n,h.vectorToString(ubl));
    Vector<BigInteger> msg=new Vector<BigInteger> ();
    h.showMeVectorNL(zxc2);
    for(int i=0;i<zxc2.size();i++)
    {
    	msg.add(rsa.generateMsg(zxc2.elementAt(i)));
    }
    h.showMeVector(msg, " ", "Odkodowane");
    rsa.convertByteArrayToString(new BigInteger(h.vectorToString(msg)));
    
//    System.out.println("ENCODED WITH PARTS: ");
//    for(int i=0;i<en.size();i++)
//    {
//    	//WYSWIETLENIE WSZYSTKICH ZAKODOWANCYH CZESCI RAZEMA BY ZOBACZYC CALY STRING
//    	System.out.print(en.elementAt(i));
//
//    }
//    System.out.println();
//    System.out.println("Decoded WITH PARTS: ");
//    String part_de = "";
//    for(int i=0;i<en.size();i++)
//    {
//    	//TO SAMO TYLKO ABY ZOBACZYC ODKOWANE
//    	System.out.print(de.elementAt(i));
//    	part_de += de.elementAt(i);
//    }
//    BigInteger tmp = new BigInteger(part_de);
//    System.out.println();
//    System.out.println("Convert back to text: ");
//    rsa.convertByteArrayToString( tmp );
//    //rsa.generate_blind_signature( tmp ); // nie dziala bo najpierw trzeba generate_rsa
//    //PRZYWROCENIE DO TEKSTU po zlaczeniu kawalkow
//    
//
//    
//	
//	String encoded = rsa.encrypt( text ); 
//    System.out.println("Encoded: "+encoded);
//
//    
//    String decoded = rsa.decrypt(new BigInteger(encoded));
//    System.out.println("Decoded: "+decoded);
//    
//
//    
//    
//    rsa.convertByteArrayToString( text );
//
//	//BigInteger h = new BigInteger( test.getBytes() ).toString();
//
//   /* String crypted = rsa.encrypt(test);
//    System.out.println(crypted);
//    test
//    String decrypted = rsa.decrypt(test);
//    System.out.println(decrypted);*/
//	//System.out.println(rsa.encrypt(new BigInteger("910")));
//
//    //String test = "Xfdsddasdasdasdasda89765458790087965465rtgyhbnjuy7utfgvbhysdgdfgddgd";
//    //BigInteger raw;
//	//raw =  new BigInteger( test.getBytes() );
//	//System.out.println(raw);
//    
//    
//    
//    //rsa.generate_rsa();
//    //rsa.generate_blind_signature(new BigInteger("7575757575"));
//    //System.out.println(rsa.n);
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
  
  public void generateRsaKeys()
  {
	  this.q = this.return_random_prime(this.bitlen); // Losowanie liczyb pierwszej q
	  this.p = this.return_random_prime(this.bitlen); // Losowanie liczby pierwsze p

	  this.n = q.multiply(p); // n = p*q
	  
	  MathFunctions mat=new MathFunctions();
	  this.eul=mat.eulerFunction(p, q);  
	  
	  this.p=BigInteger.ZERO;
	  this.q=BigInteger.ZERO;
	  this.e=mat.relativelyPrimeNumbers(eul);    
	  this.d = e.modInverse(eul);
	  this.r=mat.relativelyPrimeNumbers(n);

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

  public BigInteger generateBlinded(BigInteger msg)
  {
	  BigInteger blind;	//zaciemnienie
      
      blind = ((this.r.modPow(this.e,this.n)).multiply(msg)).mod(n);
      return blind;	//zaciemniona wiadomosc wysylana do podpisu
  }
  
  public BigInteger generateSignedValue(BigInteger blind)
  {
	//podpis
	return blind.modPow(d,n);
	  
  }
 
  public BigInteger generateUnBlinded(BigInteger signature)
  {
	  //jezeli zwrocona wartosc to msg to jest ok
	  return this.r.modInverse(n).multiply(signature).mod(n);
  }
  
  public BigInteger generateMsg(BigInteger signature)
  {
	  
     BigInteger check = signature.modPow(this.e,this.n);    //try to verify using the RSA formula
    //System.out.print("signature "+signature+" check= "+check);
return check;

  }
  
  public boolean checkBlindSignature(BigInteger signature,BigInteger msg)
  {
	
    BigInteger sig_of_m = msg.modPow(this.d,this.n);    //check that unblinded is equal to a signature of m:
     BigInteger check = signature.modPow(this.e,this.n);    //try to verify using the RSA formula
    
//System.out.print("signature= "+signature+" check= "+check);
    if(signature.equals(sig_of_m) && msg.equals(check))
    	return true;
    else
    	return false;

  }

//  public void generate_blind_signature(BigInteger msg)
//     {
//	 MathFunctions mat=new MathFunctions();
//	 this.r=mat.relativelyPrimeNumbers(n);
//      BigInteger blind;	//m' -zaciemnienie
//      //BLIND
//      blind = ((this.r.modPow(this.e,this.n)).multiply(msg)).mod(n);
//      //SIGNAtURE
//      BigInteger signature = blind.modPow(d,n);	//s' -podpis
//      //UNBLIND
//         BigInteger unblinded = this.r.modInverse(n).multiply(signature).mod(n);
//         //SIGNATURE OF MSG
//         BigInteger sig_of_m = msg.modPow(this.d,this.n);
//         System.out.println("signature_of_m = " + sig_of_m);
//         
//         //check that unblinded is equal to a signature of m:
//         System.out.println(unblinded.equals(sig_of_m));
//         
//         //try to verify using the RSA formula
//         BigInteger check = unblinded.modPow(this.e,this.n);
//         System.out.println(msg.equals(check));
//      
//     }

  
  
}