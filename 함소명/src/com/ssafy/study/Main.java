package com.ssafy.study;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		map.put("dd", 1);

		if (!map.containsKey("dd"))
			System.out.println("???");
	}

}
