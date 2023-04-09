package KMP;

import java.io.*;
import java.util.*;

public class KMP_contains {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int cnt;
	static Queue<Integer>q=new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		String parent=br.readLine();
		String pattern=br.readLine();
		
		int cnt=0;
		int idx=0;
		while(idx<=parent.length()) {
			if(parent.substring(idx).contains(pattern)) {
				cnt++;
				idx+=parent.substring(idx).indexOf(pattern)+1;
				q.add(idx-1);
			}
			else {
				idx+=pattern.length();
			}
		}
		bw.write(cnt+"\n");
		for(int out:q) {
			bw.write(out+1+"\n");
		}
		bw.close();
	}
}
