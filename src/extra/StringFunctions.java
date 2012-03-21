package extra;

import java.math.BigInteger;
import java.util.Vector;

public class StringFunctions {

	public BigInteger returnByte (String msg)
	{
		BigInteger result;
		result=new BigInteger(msg.getBytes());
	     return result;
	}
	
	public String returnByteString (String msg)
	{
		BigInteger result;
		result=new BigInteger(msg.getBytes());
	     return result.toString();
	}

	public Vector<BigInteger> splitAscii(BigInteger split, String msg)
	{
		System.out.println("Wiadomosc do podzielenia "+msg+" na czesci mniejsze od "+split);
		int j;
		
		Vector<BigInteger> blocks=new Vector();
		for(int i=0;i<msg.length();)
		{
			j=i+1;
			//System.out.println("i= "+i);
			while(BigInteger.valueOf(Long.valueOf(msg.substring(i, j))).compareTo(split)==-1)
			{
				//System.out.println("j= "+j);
				if(j+1>msg.length())
				{
					j++;
					break;
					
				}
					
				
				//System.out.println(msg.substring(i, j));
				j++;
			}
			j--;
			//System.out.println("wziolem od "+i+" do "+j+" "+msg.substring(i, j));
			blocks.addElement(new BigInteger((msg.substring(i, j))));
			i=j;
			//System.out.println("i= "+i);
		}
		//System.out.println("KONIEC----");
		return blocks;
	}

	public Vector splitAsciiTo(int split,String msg)
	{
		Vector blocks=new Vector();
		String ascii=this.returnByteString(msg);
		int i=0;
		System.out.println();
		while(true)
		{
			
			//System.out.println(i);
			if(i+split<ascii.length())
				blocks.addElement(ascii.substring((int)i,(int)(i+split)));
			else
			{
				blocks.addElement(ascii.substring((int)i,ascii.length()));
				break;	
			}
			
				i+=split;
		}
		return blocks;
	}
	
	public void showMeVectorNL(Vector vec)
	{

		for(int i=0;i<vec.size();i++)
		{
			System.out.println(vec.elementAt(i));
		}
	}
	public void showMeVector(Vector vec,String space)
	{

		for(int i=0;i<vec.size();i++)
		{
			System.out.print(vec.elementAt(i));
			if(i!=vec.size()-1)
				System.out.print(space);
		}
		System.out.println();
	}
	public void showMeVectorNL(Vector vec, String msg)
	{

		System.out.println(msg);
		for(int i=0;i<vec.size();i++)
		{
			System.out.println(vec.elementAt(i));
		}
	}
	public void showMeVector(Vector vec,String space, String msg)
	{
		System.out.println(msg);
		for(int i=0;i<vec.size();i++)
		{
			System.out.print(vec.elementAt(i));
			if(i!=vec.size()-1)
				System.out.print(space);
		}
		System.out.println();
	}
	public String vectorToString(Vector vec)
	{
		String result="";
		for(int i=0;i<vec.size();i++)
		{
			result+=vec.elementAt(i);
		}
		return result;
	}
	public void nl(int n)
	{
		while(n!=0)
		{
			System.out.println();
			n--;
		}
	}
}
