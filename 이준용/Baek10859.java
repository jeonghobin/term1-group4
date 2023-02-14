package day0214;

import java.io.*;

public class Baek10859 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuffer sb;
	static StringBuffer sb2;
	static boolean check;
	public static void main(String[] args) throws IOException {
		sb=new StringBuffer(br.readLine());
		method(Long.parseLong(sb.toString()));
		if(check==true) {
			sb.reverse();
			sb2=new StringBuffer("");
			for(int i=0;i<sb.length();i++) {
				char a=sb.charAt(i);
				if(a=='6') a='9';
				else if(a=='9') a='6';
				else if(a=='3'||a=='4'||a=='7') {
					check=false;
					break;
				}
				sb2.append(a);
			}
			if(sb2.length()==0) {
				check=false;
			}
			else {
				long sum=Long.parseLong(sb2.toString());
				method(sum);
			}
		}
		if(check==true) bw.write("yes");
		else bw.write("no");

		bw.close();
	}
	private static void method(long sum) {
		if(sum==1) {
			check=false;
		}
		else if(sum==2||sum==3) {
			check=true;
		}
		else {
			for(int i=2;i<=Math.sqrt(sum);i++) {
				if(sum%i==0) {
					check=false;
					return;
				}
			}
			check=true;
		}
		return;
	}
}
