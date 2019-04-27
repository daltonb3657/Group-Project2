/*
 * Brandon
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_2_daltonbrandon;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;


public class Project_2_DaltonBrandon {

    
    public static void main(String[] args) throws IOException {
        
        int counter = 0;
        List<String> titleArray = new ArrayList<String>();
        List<String> headerArray = new ArrayList<String>();
        List<String> descriptionArray = new ArrayList<String>();

        while(goAgain() == true)
        {
            String title = getTitle(), header = getHeader(), description = getDescription();
            counter += 1;
            //System.out.println(counter);
            titleArray.add(title);
            headerArray.add(header);
            descriptionArray.add(description);
        }
        //System.out.println(titleArray + "\n" + headerArray + "\n" + descriptionArray);


        pageWriter(titleArray, headerArray, descriptionArray);
       
    }
    
    public static void pageWriter(List<String> titleArray, List<String> headerArray, List<String> descriptionArray) throws IOException{
        
        String filename;
        for (int i=0;i<titleArray.size();i++) {
            filename = titleArray.get(i).replaceAll("\\s","")+i + ".html";
            PrintWriter outputfile = new PrintWriter(filename);
            outputfile.println("<html>");
            outputfile.println("<head>");
            outputfile.println("\t<title>" + titleArray.get(i) + "</title>");
            outputfile.println("</head>");
            outputfile.println("<body>");
            outputfile.println("\t<center>");
            outputfile.println("\t\t<h1>" + headerArray.get(i) + "</h1>");
            outputfile.println("\t</center>");
            outputfile.println("\t<hr />");
            outputfile.println("\t" + descriptionArray.get(i));
            outputfile.println("\t<hr />");
            outputfile.println("</body>");
            outputfile.println("</html>");
            outputfile.close();
        }
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
