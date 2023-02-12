package backalgo;

import java.io.*;
import java.util.*;

public class Baek2491 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n=Integer.parseInt(br.readLine());
		String st = br.readLine();
		
		byte[] map=new byte[n];
		for(int i=0;i<n;i++) {
			map[i]=(byte)(st.charAt(i*2));
		}
		int max=1;
		int upcnt=1;
		int downcnt=1;
		byte start=map[0];
		
		for(int i=1;i<n;i++) {
			byte now=map[i];
			
			if(now==start) {
				upcnt++;
				downcnt++;
			}
			else if(now>start) {
				max=Math.max(max, downcnt);
				downcnt=1;
				upcnt++;
				start=now;
			}
			else {
				max=Math.max(max, upcnt);
				upcnt=1;
				downcnt++;
				start=now;
			}
		}
		max=Math.max(max, upcnt);
		max=Math.max(max, downcnt);
		bw.write(max+"");
		bw.close();
	}
}
