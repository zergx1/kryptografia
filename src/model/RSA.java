package model;

import java.math.BigInteger;

public class RSA {
BigInteger n;

public BigInteger generateN()
{
	this.n=BigInteger.valueOf(1515);
	System.out.println("Generuje klucz");
	return n;
}
}
