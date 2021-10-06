public class WebServer extends Network {
   private int counterLang= 0;  
   String[] progLanguages = new String[5];
    
   
   public WebServer(String serverName, String opSystem, double capacity,int lvlUsage, String[] progLanguages ){
      
      super (serverName, opSystem , capacity , lvlUsage);
            
       for (int i = 0; i < progLanguages.length; ++i){
            if (!(progLanguages== null) ) {
               counterLang++;
            }
            
      }
      
      if (!(counterLang >= 2 || counterLang > 5)) {
          throw new IllegalArgumentException("Please enter at least two languages");
      }
      this.progLanguages = progLanguages;
   }
   public int getCounterLang() {return this.counterLang;}
   public String[] getProgLanguages() {return this.progLanguages;}

    public double totalLvlUsage(){
      
      return counterLang * 20;
    
   }
   
   public String toString() {
   String o =" ";                 
      for (int i = 0; i < progLanguages.length; i++){
             if((progLanguages[i]!= null)){
             o += i +" : " + progLanguages[i]+"\n";
              }
      }
                    
            return super.toString() + "\nProgramming Languages: " + o + "\nTotal Web Level Usage: " + this.totalLvlUsage();
   }
   
   
   }
   

