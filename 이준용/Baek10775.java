package day0227;

import java.io.*;
import java.util.*;

public class Baek10775 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int G,P;
	static int[] parents;
	static int[] rank;

	public static void main(String[] args) throws NumberFormatException, IOException {
		G=Integer.parseInt(br.readLine());
		P=Integer.parseInt(br.readLine());

		parents=new int[G+1];
		for(int i=1;i<=G;i++) {
			parents[i]=i;
		}
		
		
	}

}
