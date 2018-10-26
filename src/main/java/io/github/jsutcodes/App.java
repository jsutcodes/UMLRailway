package io.github.jsutcodes;

/**
 * App.java is the main Entrypoint to UMLRailway Program
 * this file is the executable file that should be packaged and run
 * in the Excutable Jar
 *
 */
public class App
{
   private App(string[] args)
   {
      //parse args and perform basic App setup
   	  // logger.info("Starting project with Args: ({})", Arrays.toString(args));
   }

   //Reduce the ugliness to the absolute minimum
   public static void main(string[] args)
   {
      new App(args).Run();  
   }

   private void Run()
   {
      //kick off the driving O-O code for the app; i.e. Application.Run()
   		System.out.println("Hello World!");
   }    
}
