package com.ssafy.study.beakjoon.게리맨더링_17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int V;
	static ArrayList<Integer>[] adj;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		int[] Node = new int[V];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < V; i++) {
//			adj[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());//그 구역과 인접한 구역 수.
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			
		}
	

	}

}
