public class Colors {
    public static final String RED = "\u001b[31m";  // These are colors to use with text in UI.
    static  final String GREEN = "\u001b[32m"; // to use color:
    static  final String BLUE = "\u001b[34m"; // do print({Colors.color you want from these} + "String");
    static    final String YELLOW = "\u001b[33m"; // Example: System.out.print(Colors.RED + "Hello world"); will be red.
  static  final String MAGENTA = "\u001b[35m";
  static  final String CYAN = "\u001b[36m";
  static  final String WHITE = "\u001b[37m";
   static final String RESET = "\u001b[0m"; // Resets formatting <-- use after using any other color.

}
