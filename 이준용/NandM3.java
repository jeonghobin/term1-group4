package baek;
import java.io.*;
import java.util.*;
public class NandM3 {

	static int[] arr;
	static int[] sel;
	static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		arr=new int[n];
		sel=new int[m];
		for(int i=1;i<=n;i++) {
			arr[i-1]=i;
		}
		
		recursive(0);
		
	}

	private static void recursive(int k) throws IOException {

		if(k==sel.length) {
			for(int i=0;i<sel.length;i++) {
				bw.write(sel[i]+" ");
			}
			bw.write("\n");
			
			return;
		}
		
		for(int i=0;i<arr.length;i++) {
			sel[k]=arr[i];
			recursive(k+1);
		}
		bw.flush();
	}
}
