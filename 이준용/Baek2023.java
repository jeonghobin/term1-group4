package backalgo;
import java.io.*;
import java.util.*;

public class Baek2023 {
	
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n;
	static int count=0;

	static ArrayList<Integer> array = new ArrayList<>();
	static ArrayList<Integer> array2 = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
	
		array.add(2);
		array.add(3);
		array.add(5);
		array.add(7);
		
		byte[] last= {1,3,7,9};
		
		if(n==1) {
			for(int i=0;i<array.size();i++) {
				bw.write(array.get(i)+"\n");
			}
			bw.close();
			System.exit(0);
		}
		
		for(int j=1;j<n;j++) {
			count++;
			for(short i=0;i<array.size();i++) {
				recursive(array.get(i), last, new byte[1], 0);
			}
			array.clear();
			array.addAll(array2);
			array2.clear();
		}
		bw.close();
	}
	private static void recursive(int first, byte[] last, byte[] sel, int k) throws IOException {
		if(k==sel.length) {
			String a=Integer.toString(first);
			for(int i=0;i<sel.length;i++) {
				a+=Byte.toString(sel[i]);
			}
			int num=Integer.parseInt(a);
			
			if(find(num)) {
				array2.add(num);
				if(count==n-1) {
					bw.write(num+"\n");
				}
			}
			return;
		}
		for(short i=0;i<last.length;i++) {
			sel[k]=last[i];
			recursive(first, last, sel, k+1);
		}
	}
	private static boolean find(int num) {
		for(int i=3;i<=Math.sqrt(num);i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
}