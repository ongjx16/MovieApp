package Control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import Entity.Pricing;


public class PricingManager {

    public static void createPricing(float blockbuster, float premium, float studentStandard2D, float studentStandard3D, float seniorStandard2D, float adultMonWedStandard2D, float adultMonWedStandard3D, float adultThursStandard2D, float adultThursStandard3D, float adultFriStandard2D, float adultFriStandard3D, float adultWeekendStandard2D, float adultWeekendStandard3D) {
        try {
            //Creating the object
            ArrayList<Pricing> pricingList = new ArrayList<Pricing>(readAllPricing());
            //Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream(new File("DATFiles/AllPricing.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);

            Pricing pricing1 = new Pricing(blockbuster, premium, studentStandard2D, studentStandard3D, seniorStandard2D, adultMonWedStandard2D, adultMonWedStandard3D, adultThursStandard2D, adultThursStandard3D, adultFriStandard2D, adultFriStandard3D, adultWeekendStandard2D, adultWeekendStandard3D);

            pricingList.add(pricing1);
//            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(pricingList);
            out.flush();
            //closing the stream
            //out.reset();
            out.close();
            System.out.println("create pricing success");
        } catch (Exception e) {
            e.printStackTrace(
            );
        }
    }

    public static ArrayList<Pricing> readAllPricing() {
//        src.Entity.Movie[] movieOutput = new src.Entity.Movie[2];
        ArrayList<Pricing> pricingOutput = new ArrayList<Pricing>();
        try {
            //Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("DATFiles/AllPricing.dat"));
            pricingOutput = (ArrayList<Pricing>) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace(
            );
        }
        return (pricingOutput);
    }

    public static void deletePricing(int index) {
        try {

            //Creating the object
            ArrayList<Pricing> pricingList = new ArrayList<Pricing>(readAllPricing());

            //Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream(new File("DATFiles/AllPricing.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);
            pricingList.remove(index);

            out.writeObject(pricingList);
            out.flush();
            //closing the stream
            //out.reset();
            fout.close();
            out.close();
            System.out.println("price successfully removed");
        } catch (Exception e) {
        }
    }

    public static void editPricing(int index, String attribute) {
        try {

            //Creating the object
            ArrayList<Pricing> pricingList = new ArrayList<Pricing>(readAllPricing());

            //Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream(new File("DATFiles/AllPricing.dat"));
            ObjectOutputStream out = new ObjectOutputStream(fout);
            Scanner scan = new Scanner(System.in);

            if (Objects.equals(attribute, "blockbuster")) {
                System.out.println("Current: " + pricingList.get(index).getBlockbuster());
                System.out.println("Enter new price: ");
                float newBlockbuster = scan.nextFloat();
                pricingList.get(index).setBlockbuster(newBlockbuster);
            } else if (Objects.equals(attribute, "premium")) {
                System.out.println("Current: " + pricingList.get(index).getPremium());
                System.out.println("Enter new price: ");
                float newPremium = scan.nextFloat();
                pricingList.get(index).setPremium(newPremium);
            } else if (Objects.equals(attribute, "StudentStandard2D")) {
                System.out.println("Current: " + pricingList.get(index).getStudentStandard2D());
                System.out.println("Enter new price: ");
                float student2d = scan.nextFloat();
                pricingList.get(index).setStudentStandard2D(student2d);
            } else if (Objects.equals(attribute, "StudentStandard3D")) {
                System.out.println("Current: " + pricingList.get(index).getStudentStandard3D());
                System.out.println("Enter new price: ");
                float student3d = scan.nextFloat();
                pricingList.get(index).setStudentStandard3D(student3d);
            } else if (Objects.equals(attribute, "SeniorStandard2D")) {
                System.out.println("Current: " + pricingList.get(index).getSeniorStandard2D());
                System.out.println("Enter new price: ");
                float senior2d = scan.nextFloat();
                pricingList.get(index).setSeniorStandard2D(senior2d);
            } else if (Objects.equals(attribute, "AdultMonWedStandard2D")) {
                System.out.println("Current: " + pricingList.get(index).getAdultMonWedStandard2D());
                System.out.println("Enter new price: ");
                float adultmonwed2d = scan.nextFloat();
                pricingList.get(index).setAdultMonWedStandard2D(adultmonwed2d);
            } else if (Objects.equals(attribute, "AdultMonWedStandard3D")) {
                System.out.println("Current: " + pricingList.get(index).getAdultMonWedStandard3D());
                System.out.println("Enter new price: ");
                float adultmonwed3d = scan.nextFloat();
                pricingList.get(index).setAdultMonWedStandard3D(adultmonwed3d);
            } else if (Objects.equals(attribute, "AdultThuStandard2D")) {
                System.out.println("Current: " + pricingList.get(index).getAdultThursStandard2D());
                System.out.println("Enter new price: ");
                float adultthu2d = scan.nextFloat();
                pricingList.get(index).setAdultThursStandard2D(adultthu2d);
            } else if (Objects.equals(attribute, "AdultThuStandard3D")) {
                System.out.println("Current: " + pricingList.get(index).getAdultThursStandard3D());
                System.out.println("Enter new price: ");
                float adultthu3d = scan.nextFloat();
                pricingList.get(index).setAdultThursStandard3D(adultthu3d);
            } else if (Objects.equals(attribute, "AdultFriStandard2D")) {
                System.out.println("Current: " + pricingList.get(index).getAdultFriStandard2D());
                System.out.println("Enter new price: ");
                float adultfri2d = scan.nextFloat();
                pricingList.get(index).setAdultFriStandard2D(adultfri2d);
            } else if (Objects.equals(attribute, "AdultFriStandard3D")) {
                System.out.println("Current: " + pricingList.get(index).getAdultFriStandard3D());
                System.out.println("Enter new price: ");
                float adultfri3d = scan.nextFloat();
                pricingList.get(index).setAdultFriStandard3D(adultfri3d);
            } else if (Objects.equals(attribute, "AdultWeekendStandard2D")) {
                System.out.println("Current: " + pricingList.get(index).getAdultWeekendStandard2D());
                System.out.println("Enter new price: ");
                float adultweekend2d = scan.nextFloat();
                pricingList.get(index).setAdultWeekendStandard2D(adultweekend2d);
            } else if (Objects.equals(attribute, "AdultWeekendStandard3D")) {
                System.out.println("Current: " + pricingList.get(index).getAdultWeekendStandard3D());
                System.out.println("Enter new price: ");
                float adultweekend3d = scan.nextFloat();
                pricingList.get(index).setAdultWeekendStandard3D(adultweekend3d);
            }

            //then in main go and run and set all the fucking prices
            //then in main go and include all the fucking conditional statements that users go through before deciding
            //what price to quote them

            out.writeObject(pricingList);

            out.flush();
            //closing the stream
            //out.reset();
            fout.close();
            out.close();
            System.out.println("pricing successfully adjusted");
        } catch (Exception e) {
        }
    }
}
