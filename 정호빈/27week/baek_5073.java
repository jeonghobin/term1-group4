import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int max = 0;
			int maxi =0;
			int[] a = new int[3];
			for(int i=0;i<3;i++) {
				a[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, a[i]);
				maxi = i;
			}
			if(max==0)break;
			int sum=0;
			for(int i=0;i<3;i++) {
				if(i==maxi)continue;
				sum+=a[i];
			}
			if(max>=sum) {
				System.out.println("Invalid");
				continue;
			}
			int cnt=0;
			if(a[0]==a[1])cnt++;
			if(a[0]==a[2])cnt++;
			if(a[1]==a[2])cnt++;
			
			if(cnt==1) {
				System.out.println("Isosceles");
			}else if(cnt==3) {
				System.out.println("Equilateral");
			}else {
				System.out.println("Scalene");
			}
			
		}
		
	}

}
