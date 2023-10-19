public class TableAndChairs {
   static public void main(String[] args) {
      // Displays the following pattern on the screen
   
      // System.out.println("X                      X");
      // System.out.println("X                      X");
      // System.out.println("X      XXXXXXXXXX      X");
      // System.out.println("XXXXX  X        X  XXXXX");
      // System.out.println("X   X  X        X  X   X");
      // System.out.println("X   X  X        X  X   X");
      
      // for (int i = 0; i < 2; i++) System.out.println("X                      X");
      // System.out.println("X      XXXXXXXXXX      X \nXXXXX  X        X  XXXXX");
      // for (int j = 0; j < 2; j++) System.out.println("X   X  X        X  X   X");
      
      String[] x = {"X                      X", "X                      X", "X      XXXXXXXXXX      X", "XXXXX  X        X  XXXXX", "X   X  X        X  X   X", "X   X  X        X  X   X"};
      for (String l : x) System.out.println(l);
   }
}