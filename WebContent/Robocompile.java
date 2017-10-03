import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * 
 */

/**
 * @author ECSS-3.214-Nidhi
 *
 */
public class Robocompile {

	/**
	 * 
	 */
	public Robocompile() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			System.out.println("Caling command prompt commands");
  			System.out.println("--------------------------------");
			Runtime rt = Runtime.getRuntime();
			
			Process ps, ps1 = null;
			
			
			
				ps = rt.exec("cmd /c java -cp C:/robocode/libs/robocode.jar robocode.Robocode -nodisplay");
				ps1 = rt.exec("cmd /c java -cp C:/robocode/compilers/ecj.jar org.eclipse.jdt.internal.compiler.batch.Main -deprecation -g -source 1.6 -encoding UTF-8 -classpath \"C:/Program Files (x86)/Java/jre1.8.0_66/lib/rt.jar\";c:/robocode/libs/robocode.jar C:/robocode/robots/sample/Crazy.java");
				
																																								
			BufferedReader in = new BufferedReader(new InputStreamReader(ps.getInputStream()));  
            String line = null;  
            while ((line = in.readLine()) != null) {  
                System.out.println(line);
				

            }
            
            BufferedReader in1 = new BufferedReader(new InputStreamReader(ps1.getInputStream()));  
            String line1 = null;  
            while ((line1 = in1.readLine()) != null) {  
                System.out.println(line1);
            }
            
			
  			System.out.println("Completed command prompt commands");
  			System.out.println("--------------------------------");
  			
		}
		catch(Exception e)
		{
			System.out.println("Error Message : " + e.getMessage());
			e.printStackTrace();
		}

	}
	public void FileCompile()
	{
		try
		{
			System.out.println("Caling command prompt commands");
  			System.out.println("--------------------------------");
			Runtime rt = Runtime.getRuntime();
			
			Process ps, ps1 = null;
			
			
			
				ps = rt.exec("cmd /c java -cp C:/robocode/libs/robocode.jar robocode.Robocode -nodisplay");
				ps1 = rt.exec("cmd /c javac -classpath \"C:/Program Files (x86)/Java/jre1.8.0_66/lib/rt.jar\";\"C:/robocode/libs/robocode.jar\";\"C:/robocode/robots/Nidhi\" C:/robocode/robots/Nidhi/First.java");
				//-classpath "C:/Program Files (x86)/Java/jre1.8.0_66/lib/rt.jar";C:/robocode/libs/robocode.jar;C:/robocode/robots/Nidhi
																																								
			BufferedReader in = new BufferedReader(new InputStreamReader(ps.getInputStream()));  
            String line = null;  
            while ((line = in.readLine()) != null) {  
                System.out.println(line);
            }
            
            BufferedReader in1 = new BufferedReader(new InputStreamReader(ps1.getInputStream()));  
            String line1 = null;  
            while ((line1 = in1.readLine()) != null) {  
                System.out.println(line1);
            }
            
			
  			System.out.println("Completed command prompt commands");
  			System.out.println("--------------------------------");
  			
		}
		catch(Exception e)
		{
			System.out.println("Error Message : " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
