/*
 * Brandon Dalton
 * 4/29/19
 * This program makes web pages with user input and includes navigation
 */
package project_2_daltonbrandon;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;


public class Project_2_DaltonBrandon {

    
    public static void main(String[] args) throws IOException {
        
        int counter = 0;
        List<String> titleArray = new ArrayList<String>();
        List<String> headerArray = new ArrayList<String>();
        List<String> descriptionArray = new ArrayList<String>();
        List<String> filenameArray = new ArrayList<String>();
        
        helloMessage();
        while(goAgain() == true)
        {
            String title = getTitle(), header = getHeader(), description = getDescription();
            counter += 1;
            //System.out.println(counter);
            titleArray.add(title);
            headerArray.add(header);
            descriptionArray.add(description);
            filenameArray.add(title.replaceAll("\\s","")+counter+".html");
        }
        //System.out.println(titleArray + "\n" + headerArray + "\n" + descriptionArray);
        byeMessage();

        pageWriter(titleArray, headerArray, descriptionArray, filenameArray);
       
    }
    
    public static void pageWriter(List<String> titleArray, List<String> headerArray, List<String> descriptionArray, List<String> filenameArray) throws IOException{
        
        String filename, dataLine;
        String[] dataLineArray = new String[filenameArray.size()];
        for (int i=0;i<titleArray.size();i++) {
           dataLine = "<a href=\"" + filenameArray.get(i) + "\">" + titleArray.get(i) + "</a>";
           dataLineArray[i]=dataLine;
        }
        dataLine = Arrays.toString(dataLineArray).replaceAll("[\\[\\]]","");
        dataLine = dataLine.replaceAll("\\,","*");
        for (int i=0;i<titleArray.size();i++) {            
            filename = filenameArray.get(i);
            PrintWriter outputfile = new PrintWriter(filename);
            outputfile.println("<html>");
            outputfile.println("<nav>");
            outputfile.println(dataLine);            
            outputfile.println("</nav>");
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
    public static void helloMessage(){
        System.out.println("Welcome to our web page maker program.");
    }
    public static void byeMessage(){
        System.out.println("Thank you for using our program.");
    }
   
    
}
