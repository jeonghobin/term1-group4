package day0210;

import java.io.*;
import java.util.*;

public class Swea1225 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for(int t=1; t<=10; t++) {
			br.readLine();
			st=new StringTokenizer(br.readLine());
			ArrayList<Integer> array=new ArrayList<Integer>();
			for(int i=0;i<8;i++) {
				array.add(Integer.parseInt(st.nextToken()));
			}
			L : while(true) {
				for(int i=1;i<=5;i++) {
					int a=array.get(0)-i;
					if(a<=0) {
						a=0;
						array.remove(0);
						array.add(a);
						break L;
					}
					else {
						array.remove(0);
						array.add(a);
					}
				}
			}
			bw.write("#"+t);
			for(int i=0;i<array.size();i++) {
				bw.write(" "+array.get(i));
			}
			bw.write("\n");

		}
		bw.close();
	}
}
