/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p27;

import java.util.Arrays;

/**
 *
 * @author Predator
 */
public class P27
{

    /**
     * @param args the command line arguments
     */
    int limit = 2000;

    public static void create_prime_list(int limit, int[] primes)
    {
	double NT = Math.sqrt(limit) + 1;
	int i = 0, j = 0;
	while (i < limit)
	{
	    primes[i] = i;
	    i++;
	}
	i = 1;
	while (true)
	{
	    j = 0;
	    while (true)
	    {
		i++;
		if (primes[i] != 0)
		{
		    break;
		}
	    }
	    if (i >= NT)
	    {
		break;
	    }
	    j += i;
	    while (true)
	    {
		j += i;
		if (j >= limit)
		{
		    break;
		}
		primes[j] = 0;
	    }
	}
	i = 0;
	j = 0;
	while (i < limit)
	{
	    if (primes[i] != 0)
	    {
		primes[j] = primes[i];
		j++;
	    }
	    i++;
	}
	j--;
	primes[j] = 0;
	primes[0] = j;
    }

    public static boolean check_if_prime(int test, int[] primes)
    {
	int i = 0;
	while (i < primes[0])
	{
	    if (primes[i] == test)
	    {
		return true;
	    }
	    i++;
	    if (test < primes[i])
	    {
		break;
	    }
	}
	return false;
    }

    public static void Quadratic_primes(int[] primes)
    {
	int n = 2, t, c = 0, a = 2, b = 2, limit = 1000, bestc = 0, besta = 0, bestb = 0, i = 0, j = 0, k = 0;
	while (true)
	{
	    while (true)
	    {
		n = 0;
		while (true)
		{
		    t = (n * n) - (n * a) + b;
		    if (check_if_prime(t, primes))
		    {
			c++;
		    }
		    else
		    {
			if (bestc < c)
			{
			    bestc = c;
			    besta = a;
			    bestb = b;
			}
			c = 0;
			break;
		    }
		    n++;
		    k++;
		}
		i++;
		a = primes[i];
		if (a > limit)
		{
		    break;
		}
	    }
	    j++;
	    i = 0;
	    b = primes[j];
	    if (b > limit)
	    {
		break;
	    }
	}
	System.out.println(-besta * bestb);
    }

    public static void main(String[] args)
    {
	P27 cprimes = new P27();
	int[] prime_list;
	prime_list = new int[cprimes.limit];
	create_prime_list(cprimes.limit, prime_list);
	Quadratic_primes(prime_list);
    }

}
