package OS2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Filee {
	final String currentDirectory = System.getProperty("user.dir");
	private File output;
	public FileWriter myWriter;

	Filee(String content) throws IOException 
        {
            output = new File(currentDirectory + "\\" + "output.txt");
            myWriter = new FileWriter(output, true);
            if (!output.exists()) 
            {
                output.createNewFile();
            }
            myWriter.write(content);
            myWriter.write(System.getProperty("line.separator"));
            myWriter.close();
	}

}
