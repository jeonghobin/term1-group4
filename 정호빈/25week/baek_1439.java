import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str = br.readLine();
		int[] cnt = new int[2];
		int pre;
		if(str.charAt(0)=='0') {
			cnt[0]++;
			pre = 0;
		}else {
			cnt[1]++;
			pre = 1;
		}
		for(int i=1;i<str.length();i++) {
			if(str.charAt(i)=='0') {
				if(pre==0)continue;
				else {
					pre=0;
					cnt[0]++;
				}
			}else {
				if(pre==1)continue;
				else {
					pre=1;
					cnt[1]++;
				}
			}
		}
		int min = Math.min(cnt[0], cnt[1]);
		
		System.out.println(min);
	}

}
