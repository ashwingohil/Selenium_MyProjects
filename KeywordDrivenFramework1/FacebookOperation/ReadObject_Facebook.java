package FacebookOperation;


import java.io.*;
import java.util.Properties;

//https://docs.oracle.com/javase/7/docs/api/java/util/Properties.html
//Properties class has a method load(InputStream s) which means a interface InputStream is to be used instantiated
//by FileInputStream


public class ReadObject_Facebook {

    Properties p = new Properties();

    public Properties getRepository(){

        String filepath = System.getProperty("user.dir");
        String filename = "objectFacebook.properties";
        String folder = "/KeywordDrivenFramework1";

        try{
            File file = new File(filepath + folder + "/" + filename);
            InputStream istream = new FileInputStream(file);

            //load all objects
            p.load(istream);

        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }

        return p;
    }


}
