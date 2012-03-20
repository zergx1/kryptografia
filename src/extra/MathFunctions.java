package extra;

import java.math.BigInteger;


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

		long ax,bx,t ;
		
		for(long i=n.longValue();i>0;i--)
		{
			ax=i;
			bx=n.longValue();
			while(bx!=0)
			{
				t=bx;
				bx=ax%bx;
				ax=t;
			}
			if(ax==1)
				return BigInteger.valueOf(i); 
		}
		return BigInteger.ONE;
	}
	
}
