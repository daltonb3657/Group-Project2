/*
 * Brandon
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_2_daltonbrandon;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class Project_2_DaltonBrandon {

    
    public static void main(String[] args) throws IOException {
        
        int counter = 0;
        String[] titleArray, headerArray = {}, descriptionArray = {};
        while(goAgain() == true)
        {
            String title = getTitle(), header = getHeader(), description = getDescription(); 
            
            titleArray.add(title);
            headerArray = header;
            descriptionArray = description; 
            counter += 1;
            System.out.println(counter);
        }
        System.out.println(Arrays.toString(titleArray) + "\n" + Arrays.toString(headerArray) + "\n" + Arrays.toString(descriptionArray));
        //pageWriter(filename, title, header, description);
       
    }
    
    public static void pageWriter(String filename, String title, String header, String description) throws IOException{
        
        PrintWriter outputfile = new PrintWriter(filename);
        outputfile.println("<html>");
        outputfile.println("<head>");
        outputfile.println("\t<title>" + title + "</title>");
        outputfile.println("</head>");
        outputfile.println("<body>");
        outputfile.println("\t<center>");
        outputfile.println("\t\t<h1>"+header+"</h1>");
        outputfile.println("\t</center>");
        outputfile.println("\t<hr />");
        outputfile.println("\t"+description);
        outputfile.println("\t<hr />");
        outputfile.println("</body>");
        outputfile.println("</html>");
        outputfile.close();
    }
    
    public static String getTitle()
    {
        Scanner k = new Scanner(System.in);
        String title;
        System.out.print("Give me your title: ");
        title = k.nextLine();
        return title;
    }
    public static String getHeader()
    {
        Scanner k = new Scanner(System.in);
        String header;
        System.out.print("Give me your header: ");
        header = k.nextLine();
        return header;
    }
    public static String getDescription()
    {
        Scanner k = new Scanner(System.in);
        String description;
        System.out.print("Give me your description: ");
        description = k.nextLine();
        return description;
    }
    public static boolean goAgain(){
        String input;
        Scanner k = new Scanner(System.in);
        System.out.print("Do you want to make a web page? ");
        input = k.nextLine();
        while(!(input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("No")))
        {
            System.out.print("Do you want to make a web page? You must enter yes or no. ");
            input = k.nextLine();
        }
        if(input.equalsIgnoreCase("Yes"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
   
    
}
