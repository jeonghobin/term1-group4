package day0210;
import java.util.*;
import java.io.*;
public class Swea1218 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		for(int t=1;t<=10;t++) {
			int n=Integer.parseInt(br.readLine());
			String word=br.readLine();
			ArrayList<Character> list=new ArrayList<>();
			ArrayList<Integer> count=new ArrayList<>();
			list.add('(');
			list.add(')');
			list.add('[');
			list.add(']');
			list.add('{');
			list.add('}');
			list.add('<');
			list.add('>');
			for(int i=0;i<8;i++) {
				count.add(0);
			}
			int check=1;
			for(int i=0;i<n;i++) {
				char a=word.charAt(i);
				int index=list.indexOf(a);
				count.set(index, count.get(index)+1);
				if(index%2==1&&count.get(index)-count.get(index-1)>0) {
					check=0;
					break;
				}
			}
			for(int i=0;i<=6;i=i+2) {
				if(count.get(i)!=count.get(i+1)) {
					check=0;
				}
			}
			bw.write("#"+t+" "+check+"\n");
		}
		bw.close();
	}
}