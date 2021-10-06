public abstract class Network {
   private String serverName;
   private String opSystem;//operating system installed (must be: Windows, Linux, or OS X)
   private double capacity;
   private int lvlUsage;
   private static double hardCap;
   private static int totalServer;
   public static final int MAX_CAPACITY = 206;    //maximum capacity of 206 servers 
   
   public Network(String serverName, String opSystem, double capacity,int lvlUsage ) { //constructor taking name, system, capacity, lvl usage
   if (serverName.equals("") || serverName == null) {
            throw new IllegalArgumentException("Please enter a valid server name");
        }
        this.serverName = serverName;

        if ((!opSystem.equalsIgnoreCase("Windows")) && (!opSystem.equalsIgnoreCase("Linux")) && (!opSystem.equalsIgnoreCase("OS X"))) {
            throw new IllegalArgumentException("Please enter a valid Operating System");
        }
        this.opSystem = opSystem;
        
        if (capacity < 0 ) {
         throw new IllegalArgumentException("Please enter a valid Capacity");
        }
        this.capacity = capacity;

        if (lvlUsage < 0 || lvlUsage > 100 ) {
            throw new IllegalArgumentException("Please enter a number between 0-100");
        }
       this.lvlUsage = lvlUsage;
       
       totalServer++;
       
       hardCap += capacity;
       
   }
   
   //Accessors
   public String getServerName() { return this.serverName; }
   public String getOpSystem() { return opSystem; }
   public double getCapacity() { return this.capacity; }
   public int getLvlUsage() { return this.lvlUsage; }
   public static double getHardCap() {return hardCap;}
   public static int getTotalServer() {return totalServer;}
   
   //Mutators
   public void setServerName(String serverName) {
            if (serverName.equals("") || serverName == null) {
                throw new IllegalArgumentException("Please enter a valid server name");
            }
                    this.serverName = serverName;
    }

   public void setOpSystem(String opSystem){
            if ((!opSystem.equalsIgnoreCase("Windows")) || (!opSystem.equalsIgnoreCase("Linux")) || (!opSystem.equalsIgnoreCase("OS X"))) {
            
            throw new IllegalArgumentException("Please enter a valid Operating System");
        }
        this.opSystem = opSystem;
                
   }

   public void setCapacity(double capacity){
     if (capacity < 0 ) {
         throw new IllegalArgumentException("Please enter a valid Capacity");
     }
        this.capacity = capacity;
   }
   
   public void setLvlUsuage(int lvlUsage){
      if (lvlUsage < 0 || lvlUsage > 100 ) {
            throw new IllegalArgumentException("Please enter a number between 0-100");
      }
    this.lvlUsage = lvlUsage;
   }
   
   public abstract double totalLvlUsage();//template, every class that inherit this class, need this method

   //End of Accessors

   public String toString() {
            return "\nThe Server's Name:" + this.getServerName() + "\nThe Operating System: " + this.getOpSystem() + "\nHarddrive Capacity: " + this.getCapacity() +
             "\nLevel of Usuage (0-100): " + this.getLvlUsage();
        }
        
   }