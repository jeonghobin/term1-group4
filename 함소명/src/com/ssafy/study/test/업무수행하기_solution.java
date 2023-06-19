package com.ssafy.study.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 업무수행하기_solution {
	static int[] time, memo;
	static ArrayList<Integer>[] pre;
	private static boolean[] v;
	private static boolean cycle;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());// 완료해야하는 업무의 수(1=<N=<50)
			time = new int[N + 1];// 업무소요시간, 0번은 안씀.
			pre = new ArrayList[N + 1];// 선행되어야하는 업무 번호
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				time[i] = Integer.parseInt(st.nextToken());// 업무별 소요시간은 2~1000
				int M = Integer.parseInt(st.nextToken());// 업무별 미리 완료해야하는 업무개수는 M은 0~N-1개이다.
				pre[i] = new ArrayList<>();
				for (int j = 0; j < M; j++) {
					pre[i].add(Integer.parseInt(st.nextToken()));
				}
			}

			 cycle = false; //순환관계, 일부분이라도 순환관계가 있다면 -1출력한다.
			int minTotalTime = Integer.MAX_VALUE;
			for (int help = 1; help <= N; help++) {
				memo = new int[N+1];//업무를 수행하는데 소요시간 저장
				v = new boolean[N+1];//순환관계 체크하기 위한 방문배열, 각 업무별, 선행 업무별 새로 객체 생성해야하는데 한번만 선언하고, 초기화 (원복)해서 재활용
				// 전체 업무 완료 소요시간= 각 업무 소요시간을 구해서 오래걸리는 최댓값 시간
				int totalTime = 0;
				for (int i = 1; i <= N; i++) {// i번째 업무 시간을 구함
					int iTime = check(i, help);// i번째 업무 시간
					
					if(iTime == -1) {
						minTotalTime = -1;
						break;
					}

					if (totalTime < iTime)
						totalTime = iTime;
				}

				if (minTotalTime > totalTime)
					minTotalTime = totalTime;
			}

			System.out.println("#" + tc + " " + minTotalTime);
		}
	}

	// 업무를 수행하는 소요시간 리턴, help 김수석이 도와줄 업무 번호
	private static int check(int index, int help) {
		if(cycle) return -1;
		if(memo[index]>0) return memo[index];//모메이제이션, 저장된 값을 리턴
		
		int maxPreWorkTime = 0;//index 번째 업무를 하기 위해 미리 완료해야 하는 업무 시간
		for (int i = 0; i < pre[index].size(); i++) {
			if(v[pre[index].get(i)]) {//이미 방문했다면 순환관계
				cycle = true;
				return 0;
			}
			
			v[pre[index].get(i)] = true;
			int workTime = check(pre[index].get(i), help);//각 선행되어야 하는 업무 호출
			v[pre[index].get(i)] = false;//원복
			if(maxPreWorkTime<workTime) maxPreWorkTime = workTime;
		}
		
		return memo[index] = maxPreWorkTime+(index==help?time[index]/2:time[index]);//선행 업무시간+내 업무시간
	}

}
