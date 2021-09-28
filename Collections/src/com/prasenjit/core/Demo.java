package com.prasenjit.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class Demo {

	public static void main(String[] args) {
		ArrayList<Integer> objAL = new ArrayList<Integer>();
		objAL.add(10);
		objAL.add(11);
		objAL.add(12);
		objAL.add(15);
		objAL.add(2);
		objAL.add(15000);
		System.out.println(objAL);
		System.out.println(objAL.get(2));
		Collections.sort(objAL);
		System.out.println(objAL);
		Collections.sort(objAL, Collections.reverseOrder());
		System.out.println(objAL);
		
		HashSet<Integer> objHS= new HashSet<Integer>();
		objHS.add(5);
		objHS.add(6);
		objHS.add(7);
		objHS.add(8);
		objHS.add(100);
		objHS.add(5);
		System.out.println(objHS);
		
		HashMap<Integer, String> objHM= new HashMap<Integer, String>();
		objHM.put(1, "Prasenjit");
		objHM.put(2, "ABC");
		objHM.put(3, "XYX");
		objHM.put(null, "LP");
		System.out.println(objHM);
		
		TreeMap<Integer, String> objTM=new TreeMap<Integer, String>();
		objTM.put(1, "A");
		objTM.put(2, "B");
		objTM.put(3, "C");
		objTM.put(4, "D");
		System.out.println(objTM);

	}

}
