package za.co.reverside.assignment;


import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PatientFileProcessorTest {

    @Test
    public void test() throws ParseException {
        File source = new File("data/UnsortedPatients.txt");
        File target = new File("target/sortedPatients.txt");
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2018"); // change the value as per test case
        PatientFileProcessor processor = new PatientFileProcessor();
<<<<<<< HEAD
        processor.process(source, target);
=======
       processor.process(source, target);
>>>>>>> e87b4f3b64f4ed25b8e7dec510d8ee3a40f133d3
        // Check the content of output file with the expected result in output file
    }
}
