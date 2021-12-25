	import java.io.File;
	import java.io.IOException;
	import java.util.Scanner;

	public class DataCenter {
	    //DataCentreApplication dca=new DataCentreApplication();
			public void folderCreation(String input) throws IOException{
	        File file=new File(input);
	        DataCenter dca=new DataCenter();  //dca -- dataCenter object
	        if(file.mkdir()) {
	            System.out.println(file.getAbsolutePath() + " \nFolder is Created");
	        }else System.out.println("\nFolder already created with the same name ");
	        dca.secondaryMenu();
	    }
	    
	       public void mainFolderCheck(String input) throws IOException{
	        File file=new File(input);
	        if(file.mkdir()) {    //mkdir -make directory method from file class
	            System.out.println(file.getAbsolutePath() + " \nFolder is Created");
	        }else System.out.println("\nFolder name Main already exist");
	    }
	       
	    public void deleteFolder(String input) throws IOException{
	        File folder=new File(input);
	        DataCenter dca=new DataCenter();
	        if (folder.delete()){       //.delete -- to delete given folder name
	            System.out.println(input+" \nfolder deleted ");
	        }else System.out.println(input+" \nDoes not exist ");
	        dca.secondaryMenu();
	    }
	    
	    public void FileOrFolderOperation(int integer) throws IOException {
	        String path= "C:\\Users\\HP\\eclipse-workspace\\Project\\src\\main\\" ;
	        DataCenter dca=new DataCenter();
	        if(integer==1){
	        	 File file=new File(path);
	            if(file.isDirectory()) {     //isDirectory -- checking given input is directory or not
	            System.out.println("Please enter 1 for folder creation "
	            		+ "\n enter 2 for file creation");
	            Scanner sc=new Scanner(System.in);
	            int i=sc.nextInt();
	            switch(i) {
	            case 1:System.out.println("Kindly enter the name of the folder name you want to create");
	            Scanner sc1=new Scanner(System.in);  //sc1- object.
	            String input = path + sc1.next();
	            	dca.folderCreation(input);break;
	            case 2:	   System.out.println("Kindly enter the name of the  File name you want to create with extensions");
	            Scanner sc2=new Scanner(System.in); //sc2 - object.
	            String input1 = path + sc2.next();
	            	dca.createFile(input1); break;
	            default: System.out.println("please enter either 1 or 2");dca.secondaryMenu();break;
	            }
	            Scanner scanner1=new Scanner(System.in);
	            String input=path+scanner1.next();  
	            System.out.println("Redirected to Secondary Menu...........");
	            dca.secondaryMenu();  
	            }
	        }else {
	       	 File file=new File(path);
	            if(file.isDirectory()) {
	            System.out.println("Please enter 1 for folder Deletion "
	            		+ "\n enter 2 for file Deletion");
	            Scanner sc=new Scanner(System.in);
	            int i=sc.nextInt();
	            switch(i) {
	            case 1:System.out.println("Kindly enter the name of the folder name you want to delete");
	            Scanner sc1=new Scanner(System.in);
	            String input = path + sc1.next();
	            	dca.deleteFolder(input);break;
	            case 2:	   System.out.println("Kindly enter the name of the  File name you want to delete with extensions");
	            Scanner sc2=new Scanner(System.in);
	            String input1 = path + sc2.next();
	            	dca.deleteFile(input1); break;
	            default: System.out.println("please enter either 1 or 2");dca.secondaryMenu();break;
	            }
	            Scanner scanner1=new Scanner(System.in);
	            String input=path+scanner1.next();  
	            System.out.println("Redirected to Secondary Menu...........");
	            dca.secondaryMenu();
	        }
	        }
	    }
	    public void createFile(String input) throws IOException {
	        String fileName=input;
	        DataCenter dca=new DataCenter();
	        try {
	            File file = new File(fileName);
	            if (file.createNewFile()){
	                System.out.println(file.getAbsolutePath()+" \n file is created ");
	            }else { System.out.println(fileName+" \nalready exists");
	            }
	        } catch(IOException exception) {
	            System.out.println("An unexpected error is occurred.");
	            exception.printStackTrace();
	        }dca.secondaryMenu();
	    }
	    public void deleteFile(String input) throws IOException{
	        String fileName=input;
	        File file = new File(fileName);
	        DataCenter dca=new DataCenter();
	        if (file.delete()){
	            System.out.println(file.getAbsolutePath()+" \n file is Deleted ");
	        }else {
	            System.out.println(fileName+" \nNot available");
	        }dca.secondaryMenu();
	    }
	   
	    public void listFilesInsideMainFolder() throws IOException {
	    	DataCenter dca=new DataCenter();
	        String path= "C:\\Users\\HP\\eclipse-workspace\\Project\\src\\main\\";
	        File folder=new File(path);
	        if (folder.isDirectory()){
	            String[] list=folder.list();
	            for(int i=0;i<list.length;i++){
	                System.out.println(list[i]);
	            }
	        }System.out.println("Redirected to main Menu...........");
	        dca.mainMenuDisplay();
	    }
	    public void searchFilesInaFolder() throws IOException {
	    	DataCenter dca = new DataCenter();
	        String path = ("C:\\Users\\HP\\eclipse-workspace\\Project\\src\\main\\");
	        System.out.println("Kindly enter the file name you want search");
	        Scanner scanner = new Scanner(System.in);
	        String fileName = scanner.next();
	        File file = new File(path);
	        String[] list = file.list();
	        if (list == null) {
	            System.out.println("Folder is empty");
	        } else {
	            for (int i = 0; i < list.length; i++) {
	                String files = list[i];
	                if (files.equalsIgnoreCase(fileName)) {
	                    System.out.println(files);
	                }
	            }
	        }
	        System.out.println("Redirected to Secondary Menu...........");
	        dca.secondaryMenu();
	    }
	    
	    public void closeApplication(){   
	        System.out.println("Program Terminated successfully ");
	    }

	    public void mainMenuDisplay() throws IOException {
	    	
	    	System.out.println("Please select the operations on files and folders "+'\n'+
	                "Enter integer 1 for List all the files in the Folder "+'\n'+
	                "Enter integer 2 To Display the secondary menu "+'\n'+
	                "Enter integer 3 for exit or terminate the program");
	    	
	    		Scanner sc=new Scanner(System.in);
	    		
	        int integer=sc.nextInt();
	        DataCenter dca=new DataCenter();
	        switch(integer){   //switch case for main menu
	            case 1:dca.listFilesInsideMainFolder();break;
	            case 2:dca.secondaryMenu();break;
	            case 3:	dca.closeApplication();break;
	            default: System.out.println("Kindly enter the valid input and retry");dca.mainMenuDisplay();break;
	            }  
	    }
	 
	        public void secondaryMenu() throws IOException {
	        System.out.println("Please select the below operations on files/folders "+'\n'+
	                "Enter integer 1 for folder/file creation"+'\n'+
	                "Enter integer 2 for folder/file deletion"+'\n'+
	                "Enter integer 3 for to search files in a folder "+'\n'+
	                "Enter integer 4 for go back to Main Menu "+'\n'+
	                "Enter integer 5 for exit the application ");
	        Scanner input1=new Scanner(System.in);
	        int integer= input1.nextInt();
	        DataCenter dca=new DataCenter();
	        switch(integer){   //Switch case for secondary menu
	            case 1:dca.FileOrFolderOperation(integer);break;
	            case 2:dca.FileOrFolderOperation(integer);break;
	            case 3:dca.searchFilesInaFolder();break;
	            case 4:dca.mainMenuDisplay();break;
	            case 5:dca.closeApplication();break;
	        
	            default:System.out.println("You have entered the wrong input," +
	                    " kindly enter integers between 1 to 8");dca.secondaryMenu();break;
	        }
	    }
	    public static void main (String args[]) throws IOException {
	    	DataCenter dca=new DataCenter();
	        dca.mainFolderCheck("C:\\Users\\HP\\eclipse-workspace\\Project\\src\\main");
	    	System.out.println("Welcome to My project");
	        dca.mainMenuDisplay();
	    }
	}


