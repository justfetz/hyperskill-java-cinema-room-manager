package cinema;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    private static int income = 0;
    private static int totalIncome = 0;
    private static int seatsTaken = 0;
    private static int availableSeats = 0;
    private static double percentOccupied = 0.0;  //needs work


    public Cinema(int income, int totalIncome, int availableSeats, double percentOccupied) {
        this.income = income;
        this.totalIncome = totalIncome;
        this.availableSeats = availableSeats;
        this.percentOccupied = percentOccupied;
    }

    public static int calculatePrice(int rows, int seats) {
        int capacity = rows * seats;
        int cost = 0;
        int mod = rows % 2;
        if (capacity < 60) {
            cost = rows * seats * 10;
        } else {
            //System.out.println("9/2 = " + 9/2);
            if (mod == 0) {
                cost = (rows / 2) * seats * 10 + rows / 2 * 8 * seats;
            } else if (mod != 0) {
                cost = (rows / 2 * seats * 10) + ((rows / 2 + 1) * seats * 8);
            }
        }

        return cost;
    }

    public static boolean checkFull(String[][] cine, int rowNumber, int columnNumber) {

        String[][] cineToCheck = cine;
        int row = rowNumber;
        int col = columnNumber;


        if(checkSeatsOutOfBounds(cineToCheck, row, col)==false) {
            return false;
        }else {
            String bToCheck = cine[rowNumber - 1][columnNumber - 1];
            if (bToCheck.equals(Character.toString('B'))) {
                System.out.println("That ticket has already been purchased.");
                return false;
            } else {
                return true;
            }
        }
    }

    public static boolean checkExceedCapacity(int rows, int seats, int rowNumber, int columnNumber) {
        return rows * seats < rowNumber * columnNumber;
    }

    private static DecimalFormat df2 = new DecimalFormat("0.00");

    public static void printStats() {
        //System.out.println("Seats Taken Variable: " + seatsTaken);
        //System.out.println("\n");
        System.out.println("Number of purchased tickets: " + seatsTaken);
        System.out.println("Percentage: " + df2.format((double) seatsTaken / (double)availableSeats * 100.00) + "%");
        //System.out.println("Available Seats Variable: " + availableSeats);
        System.out.println("Current Income: " + " $" + income);
        System.out.println("Total Income: " + " $" + totalIncome);

    }

    public static void fillValues(String[][] cine) {

        for (int i = 0; i < cine.length; i++) {
            for (int j = 0; j < cine[i].length; j++) {
                cine[i][j] = "S";
            }
        }
    }

    public static void displaySeatingChart(String cine[][], int rows, int seats) {

        System.out.println("Cinema:");
        System.out.print("  ");

        for (int j = 0; j < cine[0].length; j++) {
            System.out.print(j + 1 + " ");
        }
        System.out.print("\n");

        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seats; j++) {
                System.out.print(cine[i][j] /*"S"*/ + " ");
            }
            System.out.println(); //for spacing
        }

    }

    public static int[] getDigits() {
        Scanner s = new Scanner(System.in);
        int[] seats = new int[2];
        System.out.println("Enter a row number:");
        seats[0] = s.nextInt();
        System.out.println("Enter a seat number in that row:");
        seats[1] = s.nextInt();
        return seats;
    }

    public static void assignB(String[][] cine, int rowNumber, int columnNumber) {

        /*
        if (cine[rowNumber - 1][columnNumber - 1].equals(Character.toString('B'))) {
            System.out.println("That ticket has already been purchased!");

        } else /*if(checkFull(cine, rowNumber, columnNumber) == false) */
            cine[rowNumber - 1][columnNumber - 1] = ("B");
            System.out.println(displayTicketPrice(cine, rowNumber));
            seatsTaken += 1;

    }

    public static void updateStats() {
        percentOccupied = income / totalIncome * 100;
    }

    public static void displayMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static String displayTicketPrice(String cine[][], int rowNumber) {
        int rows = cine[0].length;
        int seats = cine[1].length;
        int midPoint = (int) Math.ceil((rows / 2) + 1);
        if (rows * seats > 60) {
            if (rowNumber < midPoint) {
                income += 10;
                return "Ticket price: $" + 10;
            } else {
                income += 8;
                return "Ticket price: $" + 8/*calculatePrice(rows, seats, rowNumber, columnNumber)*/;
            }
        }
        income += 10;
        return "Ticket price: $" + 10;
    }

    public static boolean checkSeatsOutOfBounds(String[][] cine, int x, int y) {
        int rowSelect = x;
        int columnSelect = y;
        System.out.println(rowSelect);
        System.out.println(columnSelect);
        if ((rowSelect < 1 || rowSelect > cine.length || columnSelect < 1 || columnSelect > cine[0].length)) {
            System.out.println("Wrong Input!");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        /*****STARTING LOGIC*****/
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = s.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = s.nextInt();
        String[][] cine = new String[rows][seats];

        fillValues(cine);
        totalIncome = calculatePrice(rows, seats);
        availableSeats = rows * seats;
        /*****Menu Logic*****/

        displayMenu();
        while (s.hasNextInt()) {
            if (s.hasNextInt()) {
                int selection = s.nextInt();
                if (selection > 3 || selection < 0) {
                    System.out.println("Wrong input!");
                    displayMenu();
                }
                switch (selection) {
                    case 1:
                        displaySeatingChart(cine, rows, seats);
                        displayMenu();
                        break;
                    case 2:

                        while (true) {
                            System.out.println("Enter a row number:");
                            int x = s.nextInt();
                            System.out.println("Enter a seat number in that row:");
                            int y = s.nextInt();

                            if (checkFull(cine, x, y) != false && checkSeatsOutOfBounds(cine, x,y)!=false) {
                                assignB(cine, x, y);
                                updateStats();
                                break;
                            }
                        }
                        displayMenu();
                        break;

                    case 3:
                        printStats();
                        displayMenu();
                        break;
                    case 0:
                        return;
                    default:
                        break;


                }
            }

        }

    }
}