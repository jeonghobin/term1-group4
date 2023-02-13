package backalgo;

import java.io.*;
import java.util.*;

public class Baek1969 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		ArrayList<Character> dnaarray=new ArrayList<>();
		dnaarray.add('A');
		dnaarray.add('C');
		dnaarray.add('G');
		dnaarray.add('T');
		
		int[][] map=new int[m][4];
		
		for(int i=0;i<n;i++) {
			String word=br.readLine();
			for(int j=0;j<m;j++) {
				map[j][dnaarray.indexOf(word.charAt(j))]++;
			}
		}
		char[] carray=new char[m];
		int count=0;
		for(int i=0;i<m;i++) {
			int max=0;
			for(int j=0;j<4;j++) {
				if(map[i][j]>max) {
					count+=max;
					max=map[i][j];
					carray[i]=dnaarray.get(j);
				}
				else {
					count+=map[i][j];
				}
			}
		}
		for(int i=0;i<m;i++) {
			bw.write(carray[i]);
		}
		bw.write("\n"+count);
		bw.close();
	}
}