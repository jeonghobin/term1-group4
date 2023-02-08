package baek;

import java.io.*;
import java.util.*;
public class NandM8 {

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
		
		recursive(arr, new int[m], 0, 0);
	}
	private static void recursive(int[] arr, int[] sel, int i, int k) throws IOException {
		if(k==sel.length) {
			for(int j=0;j<sel.length;j++) {
				bw.write(sel[j]+" ");
			}
			bw.write("\n");
			return;
		}
		if(i==arr.length) return;
		
		sel[k]=arr[i];
		recursive(arr, sel, i++, k+1);
		recursive(arr, sel, i++, k);
		
		bw.flush();
	}
}