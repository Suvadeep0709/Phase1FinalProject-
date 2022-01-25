package mypackage;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe {

	static final String projectFilesPath="C:\\Users\\DEVRAJ\\Desktop\\LockedMeFiles";
	static final String errorMessage= "Some error occured , Please contact admin@lockedme.com";
	
	public static void main(String[] args) 
	{
		Scanner obj=new Scanner(System.in);
		int ch;
		try
		{
		do 
		{
			displayMenu();
			System.out.println("Enter your choice");
			ch=Integer.parseInt(obj.nextLine());
			
			switch(ch)
			{
				case 1:getAllFiles();
				break;
				case 2:createFiles();
				break;
				case 3:deleteFiles();
				break;
				case 4:searchFiles();
				break;
				case 5:System.exit(0);
				break;
				default:System.out.println("Invalid Option");
				break;
			}
		}
		while(ch>0 );
		
		}
		catch(Exception NumberFormatException)
		{
			System.out.println("Please enter only digits ");
		}
		
		finally
		{
			obj.close();
		}
		
	}
		
		
		

	
	
	public static void displayMenu()
	{
		System.out.println("=====================================================");
		System.out.println("\t\tWelcome to LockedMe.com");
		System.out.println("\t\tDesigned by Suvadeep Mukherjee");
		System.out.println("=====================================================");
		System.out.println("\t\t1.Display All The Files");
		System.out.println("\t\t2.Add a new File");
		System.out.println("\t\t3.Delete a File");
		System.out.println("\t\t4.Search a File");
		System.out.println("\t\t5.Exit");
	}
	
	/**
	 * This Function will return all the files from the project directory
	 */
	public static void getAllFiles()
	{
		try
		{
			File folder =new File (projectFilesPath);
			File[] listofFiles=folder.listFiles();
			
			if(listofFiles.length==0)
				System.out.println("No files Exist in the directory");
			else 
			{
				for(var l:listofFiles)
				{
					System.out.println(l.getName());
				}
			}
		}
		catch(Exception Ex) 
		{
			System.out.println("errorMessage");
		}
		
	}
	
	public static void createFiles()
	{
		try 
		{
			Scanner obj = new Scanner(System.in);
			String fileName;
			System.out.println("Enter file name :");
			fileName=obj.nextLine();
			
			int linesCount;
			System.out.println("Enter how many lines in the file:");
			linesCount=Integer.parseInt(obj.nextLine());
			
			FileWriter myWriter = new FileWriter(projectFilesPath+"\\"+fileName);
			
			for(int i=1;i<=linesCount;i++)
			{
				System.out.println("Enter the file line : ");
				myWriter.write(obj.nextLine()+"\n");
			}
			System.out.println("File created succesfully ");
			myWriter.close();
			
			
		}
		catch(Exception Ex)
		{
			System.out.println(errorMessage);
		}
		
	}
	
	/**
	 * This Method will delete files based on provided file name 
	 */
	public static void deleteFiles()
	{ 
		Scanner obj = new Scanner(System.in);
		try
		{
			String fileName;
			System.out.println("Enter the file name to be deleted :");
			fileName=obj.nextLine();
			
			File file =new File (projectFilesPath+"\\"+fileName);
			if (file.exists())
			{
				file.delete();
				System.out.println(fileName+" file deleted succesfully  ");
			}
			
			else
			 System.out.println("File do not exist ");
		}
		catch(Exception Ex)
		{
			System.out.println(errorMessage);
		}
		
	}
	
	/**
	 * This Method will search files from the directory
	 */
	public static void searchFiles()
	{
		Scanner obj = new Scanner(System.in);
		try
		{
			String fileName;
			System.out.println("Enter the file name to be searched :");
			fileName=obj.nextLine();
			
			File folder =new File (projectFilesPath);
			File[] listofFiles=folder.listFiles();
			
			LinkedList<String> filenames = new LinkedList<String>();
			for (var l : listofFiles)
			{
				filenames.add(l.getName());
			}
			if (filenames.contains(fileName))
				System.out.println("File is available");
			else 
				System.out.println("File is not available");
			
			
		}
		catch(Exception Ex)
		{
			System.out.println(errorMessage);
		}
		
	}
}
