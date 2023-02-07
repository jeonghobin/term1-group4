package baek;

import java.io.*;
import java.util.*;
public class Main {

	static int max;
	static char[] list= {'*',' '};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		max=Integer.parseInt(br.readLine());
		recursive(0,"");
	}
	private static void recursive(int n, String star) {
		String newstar="";
		for(int i=0;i<(4*(max-1)+1-2*n);i++) {
			newstar+=list[n%2];
		}
		if(n!=0) {
			newstar=star.substring(0, n)+newstar+star.substring(star.length()-n, star.length());
		}
		
		if(n==2*(max-1)) {
			System.out.println(newstar);
			return;
		}
		System.out.println(newstar);
		recursive(n+1,newstar);
		System.out.println(newstar);
	}
}