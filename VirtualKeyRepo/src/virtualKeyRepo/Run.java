package virtualKeyRepo;

import java.io.File;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisplayMenu obj=new DisplayMenu();
		obj.intro();
		obj.intro1();
		DisplayMenu.i=0;
		while(DisplayMenu.i==0) {
			File ob=new File(DisplayMenu.path); //giving a directory
			boolean search =ob.isDirectory();
			if (search==true) {
				obj.menu();
				DisplayMenu.i+=1;
			}
			else {
				System.out.println("   Path not Exists ");
				obj.backRun();
				}
		}
	}
}

			
			

