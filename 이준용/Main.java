package backalgo;

//백준 2564 경비원
//그냥 구현했습니다ㅜ
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int t=1;t<=1;t++) {
			int n=sc.nextInt();
			String word=sc.next();
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
			System.out.println("#"+t+" "+check);
		}
	}
}
