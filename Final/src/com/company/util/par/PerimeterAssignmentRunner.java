package com.company.util.par;

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int numPoints = 0;
        for(Point i:s.getPoints()){
            numPoints++;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        Point previous = null;
        double avg=0;
        int pts = getNumPoints(s);
        for(Point now: s.getPoints()){
            if(previous==null){
                avg += now.distance(s.getLastPoint());
            }
            else{
                avg += now.distance(previous);
            }
            previous = now;
        }
        avg = avg/pts;
        return avg;
    }

    public double getLargestSide(Shape s) {
        Point previous = null;
        double max = 0;
        double curSize = 0;
        for(Point now: s.getPoints()){
            if(previous==null){
                curSize = now.distance(s.getLastPoint());
            }
            else{
                curSize = now.distance(previous);
            }
            previous = now;
            if(curSize>max){max=curSize;}
        }

        return max;
    }

    public double getLargestX(Shape s) {
        double max = 0.0;
        for(Point now : s.getPoints()){
            if(now.getX()>max){max=now.getX();}
        }
        return max;
    }

    public double getLargestPerimeterMultipleFiles() {
        double maxPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if(getPerimeter(s)>maxPerimeter){maxPerimeter=getPerimeter(s);}


        }
        return maxPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        File temp = null;
        double max = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if(getPerimeter(s)>max){
                max = getPerimeter(s);
                temp = f;
                //System.out.println(f.getName());
            }

        }

        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("Number of points = " + getNumPoints(s));
        System.out.println("Average side length = " + getAverageLength(s));
        System.out.println("Max side length = " + getLargestSide(s));
        System.out.println("Max X = " + getLargestX(s));

    }

    public void testPerimeterMultipleFiles() {
        System.out.println("Max Perimeter is " + getLargestPerimeterMultipleFiles());
        System.out.println(" from the file " + getFileWithLargestPerimeter());
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
