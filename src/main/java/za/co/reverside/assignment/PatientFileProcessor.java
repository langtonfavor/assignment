package za.co.reverside.assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PatientFileProcessor {

    public void process(File source, File target) {
    	
    	System.out.println("source"+source.getAbsolutePath());
        System.out.println("target"+target.getAbsolutePath()); 
        
        try {
            writefile(target, filterbyAge(readfile(source)));
        } catch (Exception ex) {
            Logger.getLogger(PatientFileProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Patient> readfile(File source) throws Exception {
        List<Patient> patients = new ArrayList();
        BufferedReader bf = new BufferedReader(new FileReader(source));
        String s = bf.readLine();// ignore first line
        while ((s = bf.readLine()) != null) {
            String[] split = s.split("\\|");
            System.out.println(Arrays.toString(split));
            System.out.println(s+"       "+split[0]+"       "+split[1]+"       "+split[2]);
            Date d = new SimpleDateFormat("yyyy-dd-MM").parse(split[2]);
            patients.add(new Patient(split[0], split[1], d));
        }
        return patients;
    }

    public void writefile(File target, List<Patient> sorted) throws Exception {

        BufferedWriter pw = new BufferedWriter(new FileWriter(target));
        DateFormat df = new SimpleDateFormat("yyyy/dd/MM");
        for (Iterator<Patient> it = sorted.iterator(); it.hasNext();) {
            Patient p = it.next();
            pw.append(p.getName() + "|" + p.getGender() + "|" + df.format(p.getDob()));
            pw.newLine();
        }
        pw.flush();
    }

    public List<Patient> filterbyAge(List<Patient> ps) {
        List<Patient> sorted = new ArrayList();
        for (Iterator<Patient> it = ps.iterator(); it.hasNext();) {
            Patient s = it.next();
            if (calcAge(s.getDob()) > 18) {
                sorted.add(s);
            }
        }
        return sorted;
    }

    public int calcAge(Date d) {
        Date today = new Date();
        long m = today.getTime() - d.getTime();
        return (int) (m / (1000 * 60 * 60 * 24 * 365.25));
    }

}