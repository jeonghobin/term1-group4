package backalgo;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st2=new StringTokenizer(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int num=Integer.parseInt(st2.nextToken())*Integer.parseInt(st2.nextToken());
		for(int i=0;i<5;i++) {
			System.out.print(Integer.parseInt(st.nextToken())-num+" ");
		}
		
	}
}
