

/*
   Name: Etu Das
   Date: 07/11/2021
  
   Description:
   
   This program allows you to track all of the company's servers.  This object oriented program allows the user to enter server name, what kind of 
   operating system they use, hard drive capacity, and level of usages. The user must select f or w for which option they want to choose. If they choose
   f, it will lead to file server which asks for all the previous inputs, as well as, number of user account and level of usage * 0.05. If they choose w, 
   it will lead to web server which asks for programming langauges that need at least two. They can't add more than five languages and the level of usage * 20.
    It will then ask the user if they want to continue adding more servers. If they press n, the user will be prompted a display message that
    has all the information that was added and the calculated level of usages. The maximum number of servers are 206. And over 5000 user accounts 
    is the maximum.
   
  */
  import javax.swing.JOptionPane;

   public class NetworkImplement {
      public static void main (String[] args){
      //initializing important variables so that I can call them in the main do while loop
      String[] progLanguages = new String[5];
      String serverName;
      String opSystem;
      double capacity;
      char finalmsg = ' ';
      int lvlUsage;
      int userAccount = 0;
      char userInput = ' ';
      Network[] networka = new Network[206];
      //do while around another do while because this do while loop asks user if they want to continue entering more servers
       do{
            if(finalmsg == 'n' || finalmsg == 'N'){
               JOptionPane.showMessageDialog(null, "Thank You for using this program!");
             break;
            }
      do{
          userInput =  JOptionPane.showInputDialog(null, "Press 'F' for File Server or 'W' for Web Server" ).charAt(0);
                     //calling the methods
                    serverName = getServerName();
                    opSystem = getOpSystem();
                    capacity = getCapacity();
                    lvlUsage = getLvlUsage();
                    
                    
                    Network network1;
                    //This is all the displayed information if the user chooses f for file server. This calls back the file server subclass                           
                    if (userInput == 'f' || userInput == 'F'){
                        userAccount = getUserAccount();
                         network1 = new FileServer(serverName, opSystem , capacity , lvlUsage, userAccount); 
                              networka = addArr(networka, network1);          
                    }
                    //This is all the displayed information if the user chooses w for web server. This calls back the web server subclass
                    if (userInput == 'w' || userInput == 'W'){
                          progLanguages = getCreateProgArr();
                          network1 = new WebServer(serverName, opSystem , capacity , lvlUsage, progLanguages);
                          networka = addArr(networka, network1); 
                    }
                    //This basically lets the user know that they must enter f or w to continue the program
                    if (!(userInput == 'f' || userInput == 'F' || userInput == 'w' || userInput == 'W')){
                           JOptionPane.showMessageDialog(null,"You must enter F or W");
                    } 
            } while(!(userInput == 'f' || userInput == 'F' || userInput == 'w' || userInput == 'W'));
            
             finalmsg = JOptionPane.showInputDialog(null,"Would you like to Continue entering more servers? Press Y or N").charAt(0);
           }while(finalmsg != 'n' || finalmsg != 'N');
            
            //displays all the servers currently added on the server program.
           String o = "All Servers\n";
                    for (int i = 0; i < networka.length; i++){
                          if(!(networka[i]== null)){
                            o += i +" : " + networka[i]+"\n";
                        }
                    }
     
                    JOptionPane.showMessageDialog(null, o);
          
}

      //creating and looping through the  programing languages array and validating 
   public static String[] getCreateProgArr(){
    String[] p = new String[5];
    String u = "";
         // this for loop confirms that the user must enter at least two languages to continue.
    for (int i = 0; i < 5; i++){
        if (i > 1){
            u = JOptionPane.showInputDialog(null, "Min of 2 has been entered, would you like to enter more? (y/n)");
            if (!u.equalsIgnoreCase("y")){
                return p;
            }
        }
        String lang = JOptionPane.showInputDialog(null, "Enter a programming language:");
        p = addArr( p, lang);

    }
    return p;

}

//This method to add to an array uptype network

  public static Network[] addArr(Network[] network1, Network el){
         Network[] network2 = new Network[network1.length];
         //check to avoid adding el more than once
         boolean check = false;
         for (int i = 0; i < network1.length; ++i){
            network2[i] = network1[i];
         if (network1[i] == null && check == false){
            network2[i] = el;
            check = true;
         }
      }
      
      return network2;
      
   }
   //Adds String works for string
  public static String[] addArr(String[] network1, String el){
         String[] network2 = new String[network1.length];
         //check to avoid adding el more than once
         boolean check = false;
         //boolean because we can just set check to true if network1[i] == null
         for (int i = 0; i < network1.length; ++i){
            network2[i] = network1[i];
         if (network1[i] == null && check == false){
            network2[i] = el;
            check = true;
         }
      }
      
      return network2;
      
   }

   

//validating server name which also prompts the user to enter server name
public static String getServerName() {
        String serverName;
        do {
            try {
                serverName = JOptionPane.showInputDialog(null,"Please Enter Server Name: ");
            }
            catch (IllegalArgumentException e) {
                serverName = "";
            }
            //catches error if they put nothing or empty
            if (serverName.equals("") || serverName == null) {
              JOptionPane.showMessageDialog(null,"Please enter a valid server name");               
            }
        }while (serverName.equals("") || serverName == null);
        return serverName;
   }
   
   //validating operating system and asks the user for operating system to enter
   
   public static String getOpSystem() {
        String opSystem;
        do {
            try {
                opSystem = JOptionPane.showInputDialog(null,"Please Enter Your Operating System: ");
            }
            catch (IllegalArgumentException e) {
                opSystem = "";
            }
          
            if (opSystem.equals("") || opSystem == null) {
              JOptionPane.showMessageDialog(null,"Please enter a valid operating system");               
            }
        }while (opSystem.equals("") || opSystem == null);
        return opSystem;
   }
   
  //validating capacity and asks the user for capacity in terabytes
  
  public static double getCapacity() {
        double capacity;
     do {
            try {
                capacity = Double.parseDouble(JOptionPane.showInputDialog(null,"Please Enter Your Capacity in Terabytes: "));
            }
            catch (IllegalArgumentException e) {
                capacity = 0;
            }
            //making sure that capcity can't be a negative number
            if (capacity < 0 ) {
              JOptionPane.showMessageDialog(null,"Please enter a valid capacity");               
            }
        }while (capacity < 0);
        return capacity;
   }
   
   //validating level usage and asking the user for level of usages
   
  public static int getLvlUsage() {
        int lvlUsage;
     do {
            try {
                lvlUsage = Integer.parseInt(JOptionPane.showInputDialog(null,"Please Enter Your Level of Usages: "));
            }
            catch (IllegalArgumentException e) {
                lvlUsage = 0;
            }
            //making sure they can't exceed 100 or have anything less than 0
            if (lvlUsage < 0 || lvlUsage > 100 )  {
              JOptionPane.showMessageDialog(null,"Please enter a level usage between 0-100");               
            }
        }while (lvlUsage < 0 || lvlUsage > 100);
        return lvlUsage;
   }
   //asking the user for number of user account if they press file server option
   public static int getUserAccount() {
        int userAccount = 0;
        do {
            userAccount = Integer.parseInt(JOptionPane.showInputDialog(null,"Please Enter User Account: "));  
          
            if (userAccount < 0) {
                  JOptionPane.showMessageDialog(null,"Please enter a valid user account");
       }
        }while (userAccount < 0);
        return userAccount;
   }
   
  

 
    

  }
