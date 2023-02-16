package day0216;

import java.io.*;
import java.util.*;

public class Swea4012 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int[][]map;
	static int[] food;
	static int cnt;

	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int n=Integer.parseInt(br.readLine());
			map=new int[n][n];
			food=new int[n];
			cnt=n/2;

			for(int i=0;i<n;i++) {
				food[i]=i;
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			recursive(new int[cnt],0,0);
			minarray.sort(Comparator.naturalOrder());
			bw.write("#"+t+" "+minarray.get(0)+"\n");
			minarray.clear();
		}
		bw.close();

	}

	static ArrayList<Integer> minarray=new ArrayList<Integer>();

	private static void recursive(int[] sel, int idx, int k) {
		if(k==cnt) {
			int[] sel2=new int[cnt];
			int k2=0;
			for(int i=0;i<food.length;i++) {
				for(int j=0;j<cnt;j++) {
					if(food[i]==sel[j]) {
						break;
					}
					if(j==cnt-1) {
						sel2[k2]=food[i];
						k2++;
					}
				}
			}
			int sum1=0;
			int sum2=0;
			for(int i=0;i<cnt;i++) {
				for(int j=0;j<cnt;j++){
					sum1+=map[sel[i]][sel[j]];
					sum2+=map[sel2[i]][sel2[j]];
				}
			}
			minarray.add(Math.abs(sum1-sum2));
			return;
		}
		if(idx==food.length) {
			return;
		}
		
		sel[k]=food[idx];
		recursive(sel, idx+1, k+1);
		recursive(sel, idx+1, k);	
	}
}
