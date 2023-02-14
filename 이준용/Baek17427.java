package backalgo;

import java.io.*;
import java.util.*;


public class Baek17427 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long sum;
	
    public static void main(String[] args) throws Exception {
    	int n=Integer.parseInt(br.readLine());
    	
    	for(int i=1;i<=n;i++) {
    		sum+=i*(n/i);
    	}
    	bw.write(sum+"");
    	bw.close();
	}
}