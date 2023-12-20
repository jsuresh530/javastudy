/**
 * 
 */
package com.other.algorithms;

import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.util.Arrays;


/**
 * @author sjonnalagadda
 *
 */
public class ByteBufferJava
{

	private static ByteBuffer byteBuffer = ByteBuffer.allocate(4);
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try{
			byteBuffer.put((byte) 20);
			byteBuffer.put((byte) 40);
			byteBuffer.put((byte) 60);
			byteBuffer.put((byte) 70);
			//byteBuffer.put((byte) 24);
			
			//byteBuffer.reset(); //Resets this buffer's position to the previously-marked position.
			byteBuffer.rewind(); //Rewinds this buffer. The position is set to zero and the mark is discarded.

			System.err.println(Arrays.toString(byteBuffer.array()));
		}catch(ReadOnlyBufferException e)
		{
			
		}
		
	}
}
