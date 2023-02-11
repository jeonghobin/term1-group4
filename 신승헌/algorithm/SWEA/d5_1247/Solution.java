package algo.swea.d5_1247;

import java.io.*;
import java.util.*;

class Location {
	int x;
	int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
				
	}
	
	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + "]";
	}
}

public class Solution {
	static int answer = Integer.MAX_VALUE; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			
			st = new StringTokenizer(br.readLine());
			
			Location company = new Location( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) ); 
			Location home = new Location( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) ); 
			Location[] customer = new Location[N]; 
			
			for (int i = 0; i < customer.length; i++) {
				customer[i] = new Location( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) ); 
			}
			
			answer = Integer.MAX_VALUE; 
			recursive(customer, new Location[N], new boolean[N], 0, home, company);
			
			
			
			System.out.println("#" + test_case + " " + answer);
		} // [E] test_case
	}

	private static void recursive(Location[] customer, Location[] sel, boolean[] v, int sIdx, Location home,
			Location company) {


		// basis part
		if (sIdx == customer.length) {
			int com2cus = 0;
			int cus2cus = 0;
			int cus2home = 0;
			
			com2cus = Math.abs(sel[0].x - company.x) + Math.abs(sel[0].y - company.y);
			
			for (int i = 0; i < v.length - 1; i++) {
				cus2cus = cus2cus + Math.abs(sel[i].x - sel[i+1].x) + Math.abs(sel[i].y - sel[i+1].y);				
			}
			
			cus2home = Math.abs(sel[customer.length - 1].x - home.x) + Math.abs(sel[customer.length - 1].y - home.y);
			
			if(answer > com2cus + cus2cus + cus2home) {
				answer = com2cus + cus2cus + cus2home;
			}
			
			return;
		}
		
		// inductive part
		for (int i = 0; i < customer.length; i++) {
			if (v[i] == false) {
				v[i] = true;
				sel[sIdx] = customer[i];
				recursive(customer, sel, v, sIdx + 1, home, company);
				v[i] = false;
			}
		}
	}
}
