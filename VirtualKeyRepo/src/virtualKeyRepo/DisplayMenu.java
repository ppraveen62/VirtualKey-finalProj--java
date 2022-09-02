package virtualKeyRepo;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//display of welcome screen and first menu
public class DisplayMenu extends MainMethods {

	public void intro() {
		String outlineBorder="--------------------------------------------------------------------------------------------------";
		String appName="VIRTUAL KEY FOR YOUR REPOSIITORIES";
		String devName="-ppk";
		System.out.println();
		System.out.println(outlineBorder);
		System.out.println();
		System.out.println("        *****************************************************************");
		System.out.println("        |              "+appName+"               |");
		System.out.println("        *                                                               *");
		System.out.println("        |                               "+devName+"                            |");
		System.out.println();
		System.out.println("        *****************************************************************");
		System.out.println();
	}

	public void intro1() {

		Scanner sc =new Scanner(System.in);
		System.out.println();
		System.out.println("   Info:-");
		System.out.println("   Here you can Sort, Add, Delete and Search opreration of fIles in your given path Directory.");
		System.out.println();
		System.out.print("   Give the Path of Directory:- ");
		DisplayMenu.path=sc.next();
		System.out.println();
	}

	public void menu() { 
		Scanner sc =new Scanner(System.in);
		System.out.println();
		System.out.println("   >>>>>>>>>>>>>>>>>>>>");
		System.out.println();
		System.out.println("   File operations are : \n     1. Sort Files in Asscending Order\n     2. Add, Delete, Sreach a FILe\n     3. Quit");
		System.out.println();
		backMenu();

		switch(DisplayMenu.option) {
		case 1:
			sort();
			backADS();
			break;
		case 2:
			subMenu();
			break;
		case 3:
			System.out.print("   ***Exited Sucessfully*** ");
			i=1;
			break;	
		}	
	}

	public void sort() {
		File obj =new File(DisplayMenu.path); //giving a directory
		String [] file= obj.list();
		//Arrays.sort(file);
		//we are creating list array using list() method 
		System.out.println();
		System.out.println("   The files and folders in "+DisplayMenu.path+" are >");
		System.out.println();
		for (String x:file) {     //Accessing list from each.
			System.out.println("     "+x);
		}
	}

	public void subMenu() {
		Scanner sc =new Scanner(System.in);
		System.out.println();
		System.out.print("   Enter File Name for which you  want do operations in existing Directory,\n   (" +DisplayMenu.path+" ) :- ");
		DisplayMenu.fname=sc.nextLine();
		System.out.println();
		System.out.println("   >>>>>>>>>>>>>>>>>>>>");
		System.out.println();
		System.out.println("     1. Add file\n     2. Delete file\n     3. Search file\n     4. Return to Main Menu\n     5. Quit\n");
		System.out.println();
		backSubMenu();

		switch(DisplayMenu.option) {
		case 1:
			subAdd();
			backADS();
			break;
		case 2:
			subDelete();
			backADS();
			break;
		case 3:
			subSearch();
			backADS();
			break;	
		case 4:
			menu();
			break;	

		case 5:
			System.out.print("   ***Exited Sucessfully*** ");
			i=1;
			break;
			
		}	

	}


	public void subAdd() {
		File obj =new File(DisplayMenu.path+"//"+DisplayMenu.fname);
		try {
			if(obj.createNewFile()) {
				System.out.println("   File is Added");
			}
			else {
				System.out.println("   File already exists");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public void subDelete() {
		File obj =new File(DisplayMenu.path+"//"+DisplayMenu.fname);
		if(obj.delete()) {
			System.out.println("   File is deleted");
		}
		else {
			System.out.println("   File not found");
		}	
	}


	public void subSearch() {
		File obj =new File(DisplayMenu.path+"//"+DisplayMenu.fname); //giving a directory
		boolean sreach =obj.isFile();  //true since file exists
		if(sreach==true) {
			System.out.println("     "+obj.getAbsolutePath());
		}else {
			System.out.println("   File not Found");
		}
	}


public void backADS() {
	int j=0;

	while(j==0) {
		System.out.println();
		System.out.print("   Enter 0 for main menu or  1 to exit? ");
		Scanner sc=new Scanner(System.in);
		try {
			int k=sc.nextInt();	
			if(k==0) {
				menu();
				j+=1;	
			}
			if (k==1) {
				j+=1;
				System.out.print("   ***Exited Sucessfully*** ");
				DisplayMenu.i=1;
				}
			if(k!=0 &&k!=1) {
				System.out.println("    wrong input");
			}
			
		} catch (Exception e) {
			System.out.println();
			System.out.println("   Please check input ");
			System.out.println();
		}
	}

}

public void backRun() {
	int j=0;

	while(j==0) {
		System.out.println();
		System.out.print("   Enter 0 for main menu or  1 to exit? ");
		Scanner sc=new Scanner(System.in);
		try {
			int k=sc.nextInt();	
			if(k==0) {
				intro1();
				j+=1;	
			}
			if (k==1) {
				j+=1;
				System.out.print("   ***Exited Sucessfully*** ");
				DisplayMenu.i=1;
			}
			if(k!=0 &&k!=1) {
				System.out.println("    wrong input");
			}
		} catch (Exception e) {
			System.out.println();
			System.out.println("   Please check input ");
			System.out.println();
		}

	}
}
public void backMenu() {
	int j=0;

	while(j==0) {
		System.out.println();
		System.out.print("     Select one of the option (1/2/3):- ");
		Scanner sc=new Scanner(System.in);
		try {
			DisplayMenu.option=sc.nextInt();
			if(DisplayMenu.option==1||DisplayMenu.option==2||DisplayMenu.option==3) {
				j+=1;	
			}
			else {
				System.out.println("   wrong input");
			}
		} catch (Exception e) {
			System.out.println();
			System.out.println("   Please check input ");
			System.out.println();
		}
	}

}

public void backSubMenu() {
	int j=0;

	while(j==0) {
		System.out.println();
		System.out.print("     Select one of the option (1/2/3/4/5):- ");
		Scanner sc=new Scanner(System.in);
		try {
			DisplayMenu.option=sc.nextInt();
			if(DisplayMenu.option==1||DisplayMenu.option==2||DisplayMenu.option==3||DisplayMenu.option==4||DisplayMenu.option==5) {
				j+=1;	
			}
			else {
				System.out.println("   wrong input");
			}
		} catch (Exception e) {
			System.out.println();
			System.out.println("   Please check input ");
			System.out.println();
		}
	}

}
}
