package extra;

import java.math.BigInteger;


public class MathFunctions {

	public long eulerFunction (long n) 	//funkcja przypisuj¹ca ka¿dej liczbie naturalnej liczbê (iloœæ)
										//liczb wzglêdnie z ni¹ pierwszych nie wiêkszych od niej samej
	{

	      long result;
	      result= n;

	      for(long i=2;i*i<=n;i++) //sprawdzanie do pierwiastka z zakresu
	      {
	        if (n%i==0)				//jeœli liczba dzieli siê przez i
	            result-=result/i;	//to odejmujemy od wyniku iloraz
	        while (n%i==0)			
	            n=n/i;   			//pozbywanie sie wielokrotnosci tej liczby
	      }
	      
	      if(n>1)result-=result/n;

	      //przyklad dzialania
	      //n=20 result=20
	      //i=2 .. 4
	      //i=2 20%2=0 to result=20-20/2 = 10
	      //n=20/2 = 5 
	      //i=3 5%3!=0
	      //i=4 5%4!=0
	      
	      //5>1 result=10-10/5 = 8
	      
	    
	      return result;
	    
	}
	
	public BigInteger eulerFunction2 (BigInteger p,BigInteger q)	//(p-1)*(q-1)
	{
		p=p.subtract(BigInteger.ONE);
		q=q.subtract(BigInteger.ONE);
		return p.multiply(q);
	}
	
	public long relativelyPrimeNumbers (long n)	//funkcja zwraca najwieksza liczbê wzglêdnie pierwsz¹
												//do n ale mniejsza od n
	{
		long ax,bx,t ;
		
		for(long i=n;i>0;i--)
		{
			ax=i;
			bx=n;
			while(bx!=0)
			{
				t=bx;
				bx=ax%bx;
				ax=t;
			}
			if(ax==1)
				return i; 
		}
		return 1;
	}
	
}
