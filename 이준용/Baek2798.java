package day0207;

import java.io.*;
import java.util.*;

public class Baek2798 {

	static int m=0;
	static int max=0;
	static int sum=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		int[] arr=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		recursive(arr, new int[3], 0, 0);
		bw.write(max+"");
		bw.close();
	}

	private static void recursive(int[] arr, int[] sel, int idx, int k) {
		if(k==sel.length) {
			for(int i=0;i<sel.length;i++) {
				sum+=sel[i];
			}
			if(sum<=m) {
				max=Math.max(max, sum);
			}
			sum=0;
			return;
		}
		if(idx==arr.length) return;
		sel[k]=arr[idx];
		recursive(arr, sel, idx+1, k+1);
		recursive(arr, sel, idx+1, k);
	}
}
