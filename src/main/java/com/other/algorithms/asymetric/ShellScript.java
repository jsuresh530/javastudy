/**
 * 
 */


package com.other.algorithms.asymetric;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * @author sjonnalagadda
 *
 */
public class ShellScript
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		shellFileRunning();
	}

	public boolean waitFor(long timeout, TimeUnit unit) throws InterruptedException
	{
		long startTime = System.nanoTime();
		long rem = unit.toNanos(timeout);
		do
		{
			try
			{
				// exitValue();
				return true;
			}
			catch (IllegalThreadStateException ex)
			{
				if (rem > 0)
					Thread.sleep(Math.min(TimeUnit.NANOSECONDS.toMillis(rem) + 1, 100));
			}
			rem = unit.toNanos(timeout) - (System.nanoTime() - startTime);
		}
		while (rem > 0);
		return false;
	}

	private static void shellFileRunning()
	{
		try
		{
			Process proc = Runtime.getRuntime().exec("/home/sjonnalagadda/Desktop/AESDK/PY_AND_SHELL/helloworld.sh"); // Whatever
			BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			try
			{
				proc.waitFor();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			while (br.ready())
			{
				System.err.println(br.readLine());
			}
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
