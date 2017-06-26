import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * {@link https://code.google.com/codejam/contest/4344486/dashboard#s=p0&a=0}
 * @author johir
 *
 */
public class KickStart2017_Partc_Ambiguous_Cipher {
	public static String input = "A-large-practice.in";
	public static String output = "output.txt";
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc =new Scanner(new File(input));
		PrintStream ps =new PrintStream(new File(output));
		System.setOut(ps);
		int T = Integer.parseInt(sc.nextLine());
		int c =1;
		while(T-->0){
			String s = sc.nextLine();
			int [] E = new int[s.length()];
			if(s.length()%2==1){
				System.out.printf("Case #%d: %s\n",c++,"AMBIGUOUS");
			}
			else
			{
				for(int i=0;i<s.length();i++){
					E[i] = s.charAt(i) - 'A';
				}
				
				int [] D = new int[E.length];
				D[1] = E[0];
				D[E.length-2] = E[E.length-1];
				for(int i=3;i<E.length;i+=2){
					if(E[i-1]<D[i-2]){
						E[i-1]+=26;
					}
					D[i] = (E[i-1] - D[i-2])%26;
					E[i-1] = E[i-1]%26;
				}
				for(int i=E.length-4;i>=0;i-=2){
					if(E[i+1]<D[i+2]){
						E[i+1]+=26;
					}
					D[i] = (E[i+1] - D[i+2])%26;
					E[i+1]=E[i+1]%26;
				}
				//D[0] = (E[1]-D[2])%
				char [] d = new char[D.length];
				for(int i=0;i<D.length;i++){
					d[i] = (char) (D[i]+'A');
				}
				System.out.printf("Case #%d: %s\n",c++,String.valueOf(d));
			}
		}
		sc.close();
	}
}
