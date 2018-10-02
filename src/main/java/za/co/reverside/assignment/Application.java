package za.co.reverside.assignment;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Application {

    /* Command Line Argument :
        args[0] -> Source File Path
        args[1] -> Target File Path
        args[2] -> Date Filter(Format: dd/MM/yyyy, Example: 21/03/2018)
     */
    public static void main(String[] args) throws ParseException {
        System.out.println("started");
        File f = new File("./");
        f = new File(f.getAbsolutePath().replace(".", ""));
        while (!"assignment".equals(f.getName())) {
        System.out.println(f.getAbsolutePath());
            f=new File(f.getParent());
        }
        System.out.println("after a while");
        File unsorted = new File(f.toString()+"/data/UnsortedPatients.txt");
        File sorted = new File(f.toString()+"/data/sortedPatients.txt");
        new PatientFileProcessor().process(unsorted, sorted);
        System.out.println("done");
        /*File sourceFile = new File(args[0]);
        File targetFile = new File(args[1]);
        Date filterDate = new SimpleDateFormat("dd/MM/yyyy").parse(args[2]);
        PatientFileProcessor processor = new PatientFileProcessor();
        processor.process(sourceFile,  targetFile, filterDate);*/
    }
}