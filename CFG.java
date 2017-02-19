/*Program 1:
 * Checking if input is accepted or rejected
 * 
 */
package homework1;
import java.util.Scanner;

public class CFG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int table[][]=new int [][]{
			{0,1,2},{2,1,3},{0,3,3},{1,4,2},{4,4,4}};
		String answer="y";
		String exp;
		Scanner scan= new Scanner(System.in);
		while(answer.equals("y")){
			System.out.print("Enter a statement: ");
			exp = scan.nextLine();
			exp=exp.replaceAll("\\s", " ");
			boolean check=isValid(table,exp);
			if (check){
				System.out.println(exp+ " is accepted");
			}
			else{
				System.out.println(exp+ " is rejected");
			}
			System.out.print("Continue? ");
			answer=scan.nextLine();
		}
	}
/*	public static int checkState (int val){
		int newState =0;
		int table[][]=new int [][]{
			{0,1,2},{2,1,3},{0,3,3},{1,4,2},{4,4,4}};
		for(int row=0;row<5;row++){
			for (int col=0;col<3;col++){
				if(val==table[row][col]){
					newState=table[row][col];
					break;
				}
			}
		}
		return newState;	
	}
	*/
	public static boolean isValid(int[][] lang, String word)
	{
		int state = 0, col = 0;
		char[] letter_arr = word.toCharArray();
		for (char letter : letter_arr)
		{
			if (letter == '$'){break;}
			switch(letter)
			{
				case 'a' : col = 0; break;
				case 'b' : col = 1; break;
				case 'c' : col = 2; break;
			}
			
			state = lang[state][col];
		}

		if(state == 3 || state == 4)
			return false;

		return true;
	}
}
