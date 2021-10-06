public class FileServer extends Network {
   private int userAccount;
   
   public FileServer(String serverName, String opSystem, double capacity,int lvlUsage, int userAccount ){
      super (serverName, opSystem , capacity , lvlUsage);
         
       if (userAccount < 0) {
         throw new IllegalArgumentException("Please enter a valid user account");
       }else {
         this.userAccount = userAccount;
       }
   
   }
   
   public int getUserAccount() {return this.userAccount;}
   
   public void setUserAccount (int userAccount){
      if (userAccount < 0) {
         throw new IllegalArgumentException("Please enter a valid user account");
       }else {
         this.userAccount = userAccount;
       }
   }
   
   public double totalLvlUsage(){
   
    return userAccount * 0.05;
    
   }
   
   public String toString() {
            return super.toString() + "\nUser Account: " + this.getUserAccount() 
            + "\nTotal File Level Usage: " + this.totalLvlUsage();
   }

   }
   
   
   