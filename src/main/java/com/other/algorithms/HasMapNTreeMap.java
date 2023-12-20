

package com.other.algorithms;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HasMapNTreeMap implements Comparator<HasMapNTreeMap>, Comparable<HasMapNTreeMap>
{

	public static void main(String[] args)
	{
		Map<Integer, String> tm = new TreeMap<Integer, String>();
		tm.put(1, null);
		tm.put(1, "bau");
		tm.put(2, "ddd");
		System.err.println(tm.toString());
		
		
		Map<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, null);
		hm.put(2, null);
		hm.put(2, "1");
		System.err.println(hm.toString());
	}

	@Override
	public int compare(HasMapNTreeMap o1, HasMapNTreeMap o2)
	{
		return 0;
	}

	@Override
	public int compareTo(HasMapNTreeMap o)
	{
		return 0;
	}
}
