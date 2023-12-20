package com.other.algorithms;


public class DnsTest {
	public static void main(String[] args) {
		
		int [] arr = new int[3];
		for (int i = 0; i<3; i++)
		{
			arr[i] = i;
		}
		
		int res = arr[0] + arr[2];
		System.out.println(res);
		try {
			//System.out.println("fffffffffffffffff");
            SecurityManager sec = System.getSecurityManager();

			
			//displayStuff("127.0.0.1", inetAddress);
			//System.out.println("---sdgsg-----------------------"+sec.getThreadGroup().activeGroupCount());
			//inetAddress = InetAddress.getByName("www.google.com");
			//displayStuff("www.google.com", inetAddress);
			//System.out.print("--------------------------");
			/*InetAddress[] inetAddressArray = InetAddress.getAllByName("www.google.com");
			for (int i = 0; i < inetAddressArray.length; i++) {
				displayStuff("www.google.com #" + (i + 1), inetAddressArray[i]);
			}*/
		} catch (Exception e) {
		}
	}
	
	private static byte[] hex2byte(byte[] b, int offset, int len) {
		byte[] d = new byte[len];
		for (int i = 0; i < len * 2; i++) {
			int shift = i % 2 == 1 ? 0 : 4;
			d[i >> 1] |= Character.digit((char) b[offset + i], 16) << shift;
		}
		return d;
	}

}
