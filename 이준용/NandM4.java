package baek;
import java.io.*;
import java.util.*;

public class NandM4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=i+1;
		}	
		
		recursive(arr, new int[m], 0, 0);
	}

	private static void recursive(int[] arr, int[] sel, int i, int k) {
		if(k==sel.length) {
			for(int j=0;j<sel.length;j++) {
				System.out.print(sel[j]+" ");
			}
			System.out.println();
			return;
		}
		if(i==arr.length) return;
		
		sel[k]=arr[i];
		recursive(arr, sel, i++, k+1);
		recursive(arr, sel, i++, k);
	}
}