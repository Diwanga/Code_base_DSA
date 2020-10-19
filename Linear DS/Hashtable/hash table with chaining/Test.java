import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test extends HashTableImp
{	
	public Test(int Buckets) 
	{
		super(Buckets);		
	} 

	public static void main(String[]args)
	{		
		
		int hashTableSize=0;		
		Test hashTable = null;
		String line="";
		
		 
		if(args.length == 2) // validating inputs
		{
			hashTableSize = Integer.valueOf(args[0]);
			hashTable = new Test(hashTableSize);
			
			
			String fileName = args[1]; // getting textfile name
			try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
			{
				while((line = br.readLine())!=null) // file reading
				{
					//make all non-alphanumberic characters to  whitespace						
					String text = line.replaceAll("[^A-Za-z0-9]"," ");
					//split lines between whitespaces
					String tokens[] = text.split("\\s+");
					for(String s:tokens)
					{
						
						hashTable.insert(s);	// insterting strings into hash table							
					}
				}			
			}		
			catch (FileNotFoundException e)
			{
				System.out.println("File does not exists");
				System.exit(0);
			}
			catch (IOException e) 
			{
				System.out.println("File reading failed");
				System.exit(0);
			}		
			
			//Printhash table distribution data
			System.out.println();
			hashTable.hashTableInfo(hashTableSize);
			System.out.println();
							
		}		
		else // wrong input parameters
		{
			usageMessage();
		}
	}
	
	// usage message for cmd
	private static void usageMessage()
	{
		System.out.println("\n======== Usage  ==========\n");
		System.out.println("TYPE     ==>  Java Test <number of buckets> <filename>");
		System.out.println("EXAMPLE  ==>  Java Test 40 sample-text1.txt");	
		
	}
}
