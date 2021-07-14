package com.company;
import edu.duke.*;
import java.io.File;
import com.company.util.par.PerimeterAssignmentRunner;


public class Main {

    public static void main(String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
    }
}
