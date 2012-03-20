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

	public Vector splitAscii(BigInteger split, String msg)
	{
		int j;
		msg=this.returnByteString(msg);
		Vector blocks=new Vector();
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
			blocks.addElement(Integer.valueOf(msg.substring(i, j)));
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
	
	public void showMeVector(Vector vec)
	{

		for(int i=0;i<vec.size();i++)
		{
			System.out.println(vec.elementAt(i));
		}
	}
}
