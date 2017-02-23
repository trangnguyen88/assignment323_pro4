/*Program 1:
 * Checking if input is accepted or rejected
 * 
 */
package homework1;
import java.util.Scanner;

public class CFG {

	public static void main(String[] args) {
		//create the table size 5*3 (state/input)
		int table[][]=new int [][]{
			{0,1,2},{2,1,3},{0,3,3},{1,3,2}};
		String answer="y";
		String exp;
		Scanner scan= new Scanner(System.in);
		while(answer.equals("y")){
			System.out.print("Enter a statement: ");
			exp = scan.nextLine();
			exp=exp.replaceAll("\\s", " ");
			boolean check=isValid(table,exp);
			if (check){//printing result
				System.out.println(exp+ " is accepted");
			}
			else{
				System.out.println(exp+ " is rejected");
			}
			System.out.print("Continue? ");
			answer=scan.nextLine();
		}
	}
	//check if input is valid
	//parsing string input and the 2-D table
	public static boolean isValid(int[][] lang, String word)
	{
		int state = 0, col = 0;
		//put string input to character array
		char[] letter_arr = word.toCharArray();
		for (char letter : letter_arr)
		{
			if (letter == '$'){break;}
			switch(letter)
			{
				//if character letter is a, check in col 0
				case 'a' : col = 0; break;
				//if character letter is b, check in col 1
				case 'b' : col = 1; break;
				//if character letter is c, check in col 2
				case 'c' : col = 2; break;
			}
			
			state = lang[state][col];
		}
		//state is 2 or 1 , return true
		if(state == 2 || state == 1)
			return true;

		return false;
	}
}
