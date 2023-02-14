package day0214;

import java.io.*;
import java.util.*;

public class Baek10973 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] arr;
	static int[] target;
	static int[] back;
	static boolean check;
	
	public static void main(String[] args) throws IOException {
		int n=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		arr=new int[n];
		back=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=i+1;
		}
		target=new int[n];
		for(int i=0;i<n;i++) {
			target[i]=Integer.parseInt(st.nextToken());
		}
		boolean[] v=new boolean[n];
		
		if(Arrays.toString(arr).equals(Arrays.toString(target))) {
			System.out.println("-1");
		}
		else {
			recursive(new int[n], v, 0);
		}
	}

	private static void recursive(int[] sel, boolean[] v, int k) throws IOException {
		if(k==sel.length) {
			
			if(check==true) {
				for(int i=0;i<sel.length;i++) {
					bw.write(sel[i]+" ");
				}
				bw.close();
				System.exit(0);
			}
			if(Arrays.toString(sel).equals(Arrays.toString(target))) {
				check=true;
			}
			return;
		}
		for(int i=0;i<arr.length;i++) {
			if(v[i]==false) {
				sel[k]=arr[arr.length-(i+1)];
				v[i]=true;
				recursive(sel, v, k+1);
				v[i]=false;
			}
		}
	}
}
