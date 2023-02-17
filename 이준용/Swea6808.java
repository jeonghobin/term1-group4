package day0216;

import java.io.*;
import java.util.*;

public class Swea6808 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[] map=new int[9];
	static int[] map2=new int[9];
	
	static int count1;
	static int count2;
	
	public static void main(String[] args) throws IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			ArrayList<Integer> array=new ArrayList<Integer>();
			for(int i=0;i<9;i++) {
				map[i]=Integer.parseInt(st.nextToken());
				array.add(map[i]);
			}
			int count=0;
			for(int i=1;i<=18;i++) {
				if(array.contains(i)==false) {
					map2[count]=i;
					count++;
				}
			}
			for(int i=0;i<362880;i++) {
				nextpermutation();

			}
			bw.write("#"+t+" "+count1+" "+count2+"\n");
			count1=0;
			count2=0;
		}
		bw.close();
	}

	private static void nextpermutation() {
		int sum1=0;
		int sum2=0;
		
		for(int i=0;i<9;i++) {
			if(map2[i]>map[i]) {
				sum2+=(map2[i]+map[i]);
			}
			else{
				sum1+=(map2[i]+map[i]);
			}
		}
		
		if(sum1>sum2) {
			count1++;
		}
		else if(sum1<sum2) {
			count2++;
		}
		
		
		int idx=8;
		while(idx>0&&map2[idx]<map2[idx-1]) {
			idx--;
		}
		if(idx==0) {
			return;
		}
		
		int bigidx=8;
		while(bigidx>idx&&map2[bigidx]<map2[idx-1]) {
			bigidx--;
		}
		int temp=map2[idx-1];
		map2[idx-1]=map2[bigidx];
		map2[bigidx]=temp;
		
		Arrays.sort(map2,idx,9);
	}

}
