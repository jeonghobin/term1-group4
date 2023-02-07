package baek;
import java.io.*;
import java.util.*;
public class NandM1 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		int[] arr=new int[n];
		boolean[] v=new boolean[n];
		for(int i=1;i<=n;i++) {
			arr[i-1]=i;
		}
		recursive(arr, new int[m], 0, v);
		
	}

	private static void recursive(int[] arr, int[] sel, int k, boolean[] v) {
		if(k==sel.length) {
			for(int i=0;i<sel.length;i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<arr.length;i++) {
			if(v[i]==false) {
				sel[k]=arr[i];
				v[i]=true;
				recursive(arr, sel, k+1, v);
				v[i]=false;
			}
		}
	}
}