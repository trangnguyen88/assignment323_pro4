package homework2;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.lang.*;
import java.util.ArrayList;

public class Remover {

	public static void main(String[] args) {
		 String line;
		 ArrayList<String>arr0=new ArrayList<>();
		 ArrayList<String>arr=new ArrayList<String>();
		try{
			FileReader reader= new FileReader("data.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
				System.out.println("Reading file.");
				//print the original file
			    while ((line = bufferedReader.readLine()) != null) {
			    	System.out.print(line+System.getProperty("line.separator"));
			    	//adding each line to ArrayList
			    	arr0.add(line);
				}
			//after finish reading, close the file
			reader.close();
	             for(String l : arr0){
	             	String str="";
	             	//searching comment
	             	int i=l.indexOf("//");
	               if (-1 != i) {
	               		//if found , start printing from beginning of line to before index i
					   l = l.substring(0, i);
	            	}
	            	//to check if there is any empty line
	            	if(l.length() > 0){
						String newline= l.replaceAll("\\s+", "");//if there is space,remove space
						arr.addAll(Arrays.asList(checkForSemiColon(newline)));
					}
			    }
			List<String> formattedLines = formatLines(arr);
			print(formattedLines);
			writeToFile(formattedLines);
		}
		catch(IOException e){
			 e.printStackTrace();
		}
		
	}
	//writing file
	private static void writeToFile(List<String> lines){
		try {
			File file=new File("newdata.txt");
			if(file.createNewFile()){
				System.out.println("file created");
				BufferedWriter writer = new BufferedWriter(new FileWriter(file.getName()));
				for(String line : lines){
					writer.append(line + System.getProperty("line.separator"));
				}
				writer.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//adding space before and after each token
	private static List<String> formatLines(List<String> lines){
		List<String> formattedLines = new ArrayList<String>();
		String tokens = ",+-*/()=";
		for(String line:lines){
			String formattedLine = "";
			for(char c : line.toCharArray()){
				if(tokens.indexOf(c) == -1){
					formattedLine = formattedLine + c;
				}
				else{
					formattedLine = formattedLine + " " + c + " ";
				}
			}
			formattedLines.add(formattedLine);
		}
		return formattedLines;

	}

	public static void print(List<String>group){
		System.out.println(" After formatting");
		for (int j=0;j<group.size();j++){
			System.out.println(group.get(j));
		}
	}
	//check for each statement with semicolon. 1 line include 1 statement and 1 semicolon
	private static String[] checkForSemiColon(String line){
		String[] lines = line.split(";");
		for(int i=0; i < lines.length;i++){
			lines[i] = lines[i] + ";";
		}
		return lines;
	}
	
}
