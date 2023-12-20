package com.coreexamples.CoreJava;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestNetwork {

	private static String systemHostAddress = getSystemHostAddress();
	private static final String PRIMARY_URL = "uat42.auruspay.com";
	private static final String SECONDARY_URL = "sgnd42.auruspay.com";
	private static final String WINDOWS_OS = "Windows";
	String logKey = "NW ";

	private static final List<String> LINUX_SCRIPTS = Arrays.asList("curl -I https://" + PRIMARY_URL,
			"ping -c 5 " + PRIMARY_URL, "ip r", "ping -c 5 " + systemHostAddress, "dig " + PRIMARY_URL,
			"nslookup  " + PRIMARY_URL, "traceroute " + PRIMARY_URL, "netstat -ntupl", "netstat -ntapl");

	private static final List<String> WINDOWS_SCRIPTS = Arrays.asList(
			// "curl -I https://"+DESTINATION_URL,
			"ping " + PRIMARY_URL, "route print", "ping " + systemHostAddress, "nslookup  " + PRIMARY_URL,
			"ping " + SECONDARY_URL, "route print", "ping " + systemHostAddress, "nslookup  " + SECONDARY_URL
			
			//"tracert " + DESTINATION_URL, "netstat"
	);



	private static String generateLinuxScriptDump(String indent) throws IOException {

		System.err.println("==================================================================================");
		System.err.println("Generating the linux scripts               ");
		System.err.println("==================================================================================");
		System.err.println();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(byteArrayOutputStream);
		String output = "";
		try {
			String newIndent = indent + "  ";
			for (int i = 0; i < LINUX_SCRIPTS.size(); i++) {
				System.err.println(">>>>==>>>>  Executing linux script  ==>>>>  " + i + "  :: " + indent + " :: "
						+ LINUX_SCRIPTS.get(i));
				// printStream.printf("%s%s:%n", indent, LINUX_SCRIPTS.get(i));
				Process process = Runtime.getRuntime().exec(LINUX_SCRIPTS.get(i));
				InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String line;
				while ((line = bufferedReader.readLine()) != null) {

					// printStream.printf("%s%s%n", newIndent, line);
					System.err.println(line);
				}
				bufferedReader.close();
				inputStreamReader.close();
			}
			output = byteArrayOutputStream.toString();
			printStream.close();
			byteArrayOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != printStream) {
					printStream.close();
				}
				if (null != byteArrayOutputStream) {
					byteArrayOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return output;
	}

	private static String generateWindowsScriptDump(String indent) throws IOException {
		System.err.println("==================================================================================");
		System.err.println("Generating the windows scripts             ");
		System.err.println("==================================================================================");

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(byteArrayOutputStream);
		String output = "";
		try {
			String newIndent = indent + "  ";
			for (int i = 0; i < WINDOWS_SCRIPTS.size(); i++) {
				// printStream.printf(">>>> Executing windows script ========== >>>> "+i+" : ",
				// indent, WINDOWS_SCRIPTS.get(i));
				// printStream.printf("%s%s:%n", indent, WINDOWS_SCRIPTS.get(i));
				System.err.println(">>>>==>>>>  Executing windows script  ==>>>>  " + i + "  :: " + indent + " :: "
						+ WINDOWS_SCRIPTS.get(i));

				Process process = Runtime.getRuntime().exec(WINDOWS_SCRIPTS.get(i));
				InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					System.err.println(line);
					// printStream.printf("%s%s%n", newIndent, line);
				}
				bufferedReader.close();
				inputStreamReader.close();
			}
			output = byteArrayOutputStream.toString();
			printStream.close();
			byteArrayOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != printStream) {
					printStream.close();
				}
				if (null != byteArrayOutputStream) {
					byteArrayOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return output;
	}

	private static String getSystemHostAddress() {
		try {
			Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
			while (enumeration.hasMoreElements()) {
				if (searchHostAddress(enumeration.nextElement().getInetAddresses())) {
					break;
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return systemHostAddress;
	}

	private static boolean searchHostAddress(Enumeration<InetAddress> enumeration) {
		boolean outerBreakFlag = false;
		String hostAddress = "";
		while (enumeration.hasMoreElements()) {
			hostAddress = enumeration.nextElement().getHostAddress();
			if (!hostAddress.equalsIgnoreCase("127.0.0.1") && hostAddress.split("\\.").length == 4) {
				outerBreakFlag = true;
				systemHostAddress = hostAddress;
				break;
			}
		}
		return outerBreakFlag;
	}

	/**
	 * @param port
	 * @throws IOException
	 */
	private static void printProcessStream(String port) throws IOException {
		System.err.println("==================================================================================");
		System.err.println("Checking the port status   :" + port);
		System.err.println("==================================================================================");

		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/C", "netstat -aon | findstr :" + port);
		Process process = builder.start();
		try {
			process.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int bytesRead = -1;
		byte[] bytes = new byte[1024];
		String output = "";
		while ((bytesRead = process.getInputStream().read(bytes)) > -1) {
			output = output + new String(bytes, 0, bytesRead);
		}
		System.err.println("The netstat command response is :" + output);
		if (output != null && output.trim() != "") {
			System.err.println("service running on port " + output);
		} else {
			System.err.println("service not running " + output);
		}

	}

	public static void cpuUtilization() {

		System.err.println("==================================================================================");
		System.err.println("CPU utilization reports       ");
		System.err.println("==================================================================================");

		/* Total number of processors or cores available to the JVM */
		System.err.println("Available processors (cores)        : " + Runtime.getRuntime().availableProcessors());

		/* Total amount of free memory available to the JVM */
		System.err.println("Free memory (bytes)                 : " + Runtime.getRuntime().freeMemory());

		/* This will return Long.MAX_VALUE if there is no preset limit */
		long maxMemory = Runtime.getRuntime().maxMemory();
		/* Maximum amount of memory the JVM will attempt to use */
		System.err.println(
				"Maximum memory (bytes)              : " + (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));

		/* Total memory currently available to the JVM */
		System.err.println("Total memory available to JVM (bytes): " + Runtime.getRuntime().totalMemory());

		/* Get a list of all filesystem roots on this system */
		File[] roots = File.listRoots();

		/* For each filesystem root, print some info */
		for (File root : roots) {
			System.err.println("File system root                     : " + root.getAbsolutePath());
			System.err.println("Total space (bytes)                  : " + root.getTotalSpace());
			System.err.println("Free space (bytes)                   : " + root.getFreeSpace());
			System.err.println("Usable space (bytes)                 : " + root.getUsableSpace());
		}

		System.err.println("==================================================================================");
		System.err.println("System properties            ");
		System.err.println("==================================================================================");

		RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
		Map<String, String> systemProperties = runtimeBean.getSystemProperties();
		Set<String> keys = systemProperties.keySet();
		for (String key : keys) {
			String value = systemProperties.get(key);
			System.err.println(key + "   ::   " + value);
			// System.err.println("[%s] = %s.\n", key, value);
		}
	}

}
