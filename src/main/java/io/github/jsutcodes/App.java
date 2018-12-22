package io.github.jsutcodes;

import io.github.jsutcodes.IO.CmdLineParser;

/**
 * App.java is the main Entrypoint to UMLRailway Program
 * this file is the executable file that should be packaged and run
 * in the Executable Jar
 *
 */
public class App
{
    private CmdLineParser console;

   private App(String[] args)
   {
      //parse args and perform basic App setup
   	  // logger.info("Starting project with Args: ({})", Arrays.toString(args));
       printASCIIArt();
      console = new CmdLineParser(args);
   }

   //Reduce the ugliness to the absolute minimum
   public static void main(String[] args)
   {
      new App(args).Run();  
   }

   private void Run()
   {
      //kick off the driving O-O code for the app; i.e. Application.Run()
       try {
           console.parse();

       } catch (Exception e) {
           console.usage(e);
       }
   }

   private void printASCIIArt() {
       System.out.println("  __  ____  _____   ___       _ ___      __         ");
       System.out.println(" / / / /  |/  / /  / _ \\___ _(_) / | /| / /__ ___ __");
       System.out.println("/ /_/ / /|_/ / /__/ , _/ _ `/ / /| |/ |/ / _ `/ // /");
       System.out.println("\\____/_/  /_/____/_/|_|\\_,_/_/_/ |__/|__/\\_,_/\\_, / "); // had to escape backslashes
       System.out.println("                                             /___/  ");

   }
}
