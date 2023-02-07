package baek;

import java.io.*;
import java.util.*;
public class NandM2 {

	static int[] arr;
	static int[] sel;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		arr=new int[n];
		sel=new int[m];
		for(int i=1;i<=n;i++) {
			arr[i-1]=i;
		}
		
		recursive(0,0);
		
	}

	private static void recursive(int i, int j) {
		if(j==sel.length) {
			for(int k=0;k<sel.length;k++) {
				System.out.print(sel[k]+" ");
			}
			System.out.println();
			return;
		}
		if(i==arr.length) return;
		
		sel[j]=arr[i];
		recursive(i+1,j+1);
		
		recursive(i+1,j);
	}
}