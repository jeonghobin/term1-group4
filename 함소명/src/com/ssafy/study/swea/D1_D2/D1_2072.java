package com.ssafy.study.swea.D1_D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
 
//홀수만 더하기
public class D1_2072 {
//	3
//	3 17 1 39 8 41 2 32 99 2
//	22 8 5 123 7 2 63 7 3 46
//	6 63 2 3 58 76 21 33 8 1 
	
	public static int solution(int[] arr) {
		int answer = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%2 != 0) {
				answer += arr[i];
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] a=new int[10];
		for(int i=0; i<n; i++){
			for(int j=0; j<10; ++j){
				a[j]=kb.nextInt();
			}
			System.out.println("#"+(i+1)+" "+solution(a));
		}
	}

}
