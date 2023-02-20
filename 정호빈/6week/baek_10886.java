import java.util.*;
import java.io.*;
public class Main {
	
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		int N = Integer.parseInt(br.readLine());
		int[] submit = new int[2];
		for(int i=0;i<N;i++) {
			int a = Integer.parseInt(br.readLine());
			submit[a]++;
		}
		if(submit[0]>submit[1]) {
			System.out.println("Junhee is not cute!");
		}else {
			System.out.println("Junhee is cute!");
		}
		
	}


}
