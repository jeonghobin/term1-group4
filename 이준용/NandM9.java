package baek;

import java.io.*;
import java.util.*;
public class NandM9 {
	static LinkedHashSet<String> set = new LinkedHashSet();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		ArrayList<Integer> array=new ArrayList<>();
		for(int i=0;i<n;i++) {
			array.add(Integer.parseInt(st.nextToken()));
		}	
		array.sort(Comparator.naturalOrder());
		
		int[]arr =new int[n];
		boolean[] v=new boolean[n];
		for(int i=0;i<n;i++) {
			arr[i]=array.get(i);
		}
		
		recursive(arr, new int[m], 0, v);
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

	private static void recursive(int[] arr, int[] sel, int k, boolean[] v) throws IOException {
		if(k==sel.length) {
			String a="";
			for(int i=0;i<sel.length;i++) {
				a+=sel[i]+" ";
			}
			set.add(a);
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