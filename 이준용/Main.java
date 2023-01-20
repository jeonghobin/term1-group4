package backalgo;
import java.util.*;
public class Main {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int t = sc.nextInt();
		ArrayList<Character> list1=new ArrayList<>();
		list1.add('A');
		list1.add('D');
		list1.add('O');
		list1.add('P');
		list1.add('Q');
		list1.add('R');
		for(int i=0;i<t;i++) {
			String a=sc.next();
			String b=sc.next();
			boolean check=false;
			if(a.length()==b.length()) {
				for(int j=0;j<a.length();j++) {
					if(a.charAt(j)==b.charAt(j)) {
						check=true;
						continue;
					}
					else {
						if(list1.contains(a.charAt(j))&&list1.contains(b.charAt(j))) {
							check=true;
							continue;
						}
						
						if(a.charAt(j)=='B'&&b.charAt(j)=='B') {
							check=true;
							continue;
						}
						else if(a.charAt(j)!='B'&&b.charAt(j)!='B'&&list1.contains(a.charAt(j))==false&&false==list1.contains(b.charAt(j))) {
							check=true;
						}
						else {
							check=false;
							break;
						}
					}
				}
			}		
			if(check==false) {
				System.out.println("#"+(i+1)+" DIFF");
			}
			else {
				System.out.println("#"+(i+1)+" SAME");
			}
		}
	}
}
