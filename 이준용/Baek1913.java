package day0210;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Baek1913 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		BigInteger big1=new BigInteger(st.nextToken());
		BigInteger big2=new BigInteger(st.nextToken());
		
		bw.write(big1.add(big2).toString());
		bw.close();
	}
}