/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author Hanif
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    private static final int minBusinessPoints = 25000;
    private static double fareMultiplier = 0.0;
    private static int bonusPoints = 0;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter passenger class (F/B/E): ");
        String paxClass = reader.nextLine();
        String paxClassFirstChar = paxClass.substring(0, 1).toUpperCase();
        
        if (paxClassFirstChar.equals("F")) {
            // no calculation here
        }
        else if (paxClassFirstChar.equals("B")) {
            System.out.println("Enter business passenger bonus points:");
            String businessBonusPoints = reader.nextLine();
            int points = Integer.parseInt(businessBonusPoints);
            if (points >= minBusinessPoints) {
                fareMultiplier = 3.95;
                bonusPoints = 5000;
            }
            else {
                fareMultiplier = 4;
                bonusPoints = 3000;
            }
        }
        else if (paxClassFirstChar.equals("E")) {
            System.out.println("Emergency exit or Regular economy (X/R)?");
            String economyChoice = reader.nextLine();
            String economyChoiceFirstChar = economyChoice.substring(0, 1).toUpperCase();
            if (economyChoiceFirstChar.equals("X")) {
                fareMultiplier = 1.25;
            }
            else {
                System.out.println("Regular Economy, choose seat: Window, Center or Aisle (W/C/A)?");
                
                String seat = reader.nextLine();
                String seatFirstChar = seat.substring(0, 1).toUpperCase();

                if (seatFirstChar.equals("W")) {
                    fareMultiplier = 1;
                }
                else if (seatFirstChar.equals("C")) {
                    fareMultiplier = 0.98;
                }
                else if (seatFirstChar.equals("A")) {
                    fareMultiplier = 1.1;
                }
            }
        }
        
        
        if (paxClassFirstChar.equals("F")) {
            System.out.println("First class has a special fare, no calculation here.");
        }
        else if (paxClassFirstChar.equals("B") || paxClassFirstChar.equals("E")){
            System.out.println("Enter base fare: ");
            String baseFare = reader.nextLine();
            double baseFareDouble = Double.parseDouble(baseFare);

            System.out.print("Calculated price: "+ baseFareDouble * fareMultiplier);
            System.out.println();

        }
        
        if (paxClassFirstChar.equals("B")) {
            System.out.println("Business bonus points: "+ bonusPoints);
        }
        
        System.out.println("*** End of fare calculation ***");
    }    
    
}
