package extra;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;


public class MathFunctions {
	
	public BigInteger eulerFunction (BigInteger p,BigInteger q)	//(p-1)*(q-1)
	{
		p=p.subtract(BigInteger.ONE);
		q=q.subtract(BigInteger.ONE);
		return p.multiply(q);
	}
	
	public BigInteger relativelyPrimeNumbers (BigInteger n)	//funkcja zwraca najwieksza liczbê wzglêdnie pierwsz¹
												//do n ale mniejsza od n
	{
		BigInteger r = null;
		SecureRandom random;
		try {
			random = SecureRandom.getInstance("SHA1PRNG","SUN");
			byte [] randomBytes = new byte[10];
	      
	      BigInteger gcd = null;
	      BigInteger one = new BigInteger("1");
	      //check that gcd(r,n) = 1 && r < n && r > 1
	      do {
	          random.nextBytes(randomBytes);
	          r = new BigInteger(randomBytes);
	          gcd = r.gcd(n);
	      }
	      while(!gcd.equals(one) || r.compareTo(n)>=0 || r.compareTo(one)<=0);
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			return new BigInteger("65537");
		} catch (NoSuchProviderException e1) {
			// TODO Auto-generated catch block
			return new BigInteger("65537");
		}
		return r;
	}
	
}
