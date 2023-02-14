package day0214;

import java.io.*;

public class Baek2247 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int num=Integer.parseInt(br.readLine());
		long sum=0;
		for(int i=2;i<=num;i++) {
			long plus=i*(num/i)-i;
			sum+=i*(num/i)-i;
		}
		bw.write(sum%1000000+"");
		bw.close();
	}
}
