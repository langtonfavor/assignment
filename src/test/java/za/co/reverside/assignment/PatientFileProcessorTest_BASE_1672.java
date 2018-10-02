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
        File target = new File("target/output.txt");
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2018"); // change the value as per test case
        PatientFileProcessor processor = new PatientFileProcessor();
       // processor.process(source, target, date);
        // Check the content of output file with the expected result in output file
    }
}
