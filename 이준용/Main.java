package backalgo;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int T=s.nextInt();
		for(int t=1;t<=T;t++) {
			int n=s.nextInt();
			int d=s.nextInt();
			int a=0;
			int b=0;
			for(int i=0;i<n;i++) {
				int c=s.nextInt();
				if(c==0) {
					b++;
					if(b==d) {
						a++;
						b=0;
					}
				}else {
					b=0;
				}
			}
			System.out.println("#"+t+" "+a);
		}
	}
}
