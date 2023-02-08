package baek;

import java.io.*;
import java.util.*;
public class NandM7 {

	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			array.add(Integer.parseInt(st.nextToken()));
		}
		array.sort(Comparator.naturalOrder());
		
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=array.get(i);
		}
		
		recursive(arr, new int[m], 0);
	}
	private static void recursive(int[] arr, int[] sel, int k) throws IOException {
		if(k==sel.length) {
			for(int i=0;i<sel.length;i++) {
				bw.write(sel[i]+" ");
			}
			bw.write("\n");
			return;
		}
		for(int i=0;i<arr.length;i++) {
			sel[k]=arr[i];
			recursive(arr, sel, k+1);
		}
		bw.flush();
	}
}