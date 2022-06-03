import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import entity.Scores;
import entity.Student;
import entity.Subject;

public class BinaryIO {
	
	//Students
	public static boolean writeToFile(Student[] students, String fileName) {
        try {
            FileOutputStream fout = new FileOutputStream(fileName);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(students);
            oout.close();
            fout.close();
            return true;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
	
    public static Student[] readFromFile(Student[] students, String fileName) {
        try{
            FileInputStream finp = new FileInputStream(fileName);
            ObjectInputStream oinp = new ObjectInputStream(finp);
            students = (Student[]) oinp.readObject();
            oinp.close();
            finp.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BinaryIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    
    //Subjects
    public static boolean writeToFile(Subject[] subjects, String fileName) {
        try {
            FileOutputStream fout = new FileOutputStream(fileName);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(subjects);
            oout.close();
            fout.close();
            return true;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static Subject[] readFromFile(Subject[] subjects, String fileName) {
        try{
            FileInputStream finp = new FileInputStream(fileName);
            ObjectInputStream oinp = new ObjectInputStream(finp);
            subjects = (Subject[]) oinp.readObject();
            oinp.close();
            finp.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BinaryIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subjects;
    }
    
    //Scores
    public static boolean writeToFile(Scores[] scores, String fileName) {
        try {
            FileOutputStream fout = new FileOutputStream(fileName);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(scores);
            oout.close();
            fout.close();
            return true;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static Scores[] readFromFile(Scores[] scores, String fileName) {
        try{
            FileInputStream finp = new FileInputStream(fileName);
            ObjectInputStream oinp = new ObjectInputStream(finp);
            scores = (Scores[]) oinp.readObject();
            oinp.close();
            finp.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BinaryIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return scores;
    }
    
}
