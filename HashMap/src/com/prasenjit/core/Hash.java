package com.prasenjit.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Hash {
public static void main(String[] args) {
	HashMap map = new HashMap();
	ArrayList al = new ArrayList();
	LinkedList ll = new LinkedList();
	HashSet hs = new HashSet();
	
	map.put("001", "Prasenjit");
	map.put("002", "Malakar");
	map.put("", "Kumar");
	map.put("", "Ranjit");
	System.out.println(map);
	System.out.println(map.get("002"));
	al.add("Array");
	al.add("Array");
	System.out.println(al.get(1));
	System.out.println(al);
	ll.add("Linked");
	ll.add("Linked");
	System.out.println(ll);
	hs.add("Hash");
	hs.add("Hash");
	hs.addAll(al);
	System.out.println(hs);
	System.out.println(hs.size());
	
	
}
}
