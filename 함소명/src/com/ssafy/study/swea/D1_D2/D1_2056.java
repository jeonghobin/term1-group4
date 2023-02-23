package com.ssafy.study.swea.D1_D2;

import java.util.Scanner;

//연월일 달력
public class D1_2056 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		String st1 = sc.nextLine();
		for(int i=0; i<a; i++) {
			String st = sc.nextLine();
			String yy = st.substring(0,4);
			String mm = st.substring(4,6);
			String dd = st.substring(6,8);

				int mm2 = Integer.parseInt(mm);
				int dd2 = Integer.parseInt(dd);
				if(0<mm2 && mm2<=12) {
					if(mm2 == 2) {
						if(0<dd2 && dd2<=28)System.out.println("#"+(i+1)+" "+yy+"/"+mm+"/"+dd);
						else System.out.println("#"+(i+1)+" "+(-1));
					}else if(mm2 == 4 || mm2 == 6 || mm2 == 9 || mm2 == 11) {
						if(0<dd2 && dd2<=30)System.out.println("#"+(i+1)+" "+yy+"/"+mm+"/"+dd);
						else System.out.println("#"+(i+1)+" "+(-1));
					}else {
						if(0<dd2 && dd2<=31)System.out.println("#"+(i+1)+" "+yy+"/"+mm+"/"+dd);
						else System.out.println("#"+(i+1)+" "+(-1));
					}
				}else {
					System.out.println("#"+(i+1)+" "+(-1));
				}
//			System.out.println("#"+(i+1)+" "+yy+"/"+mm+"/"+dd);
		}
		
	}

}
