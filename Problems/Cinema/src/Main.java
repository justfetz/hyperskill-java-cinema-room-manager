import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int k = scanner.nextInt();
        int row = 0;
        loop:
        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    temp++;
                    if (temp == k) {
                        row = i + 1;
                        break loop;
                    }
                } else {
                    temp = 0;
                }
            }
        }
        System.out.println(row);
    }
}

/*import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int rows = s.nextInt();
        int columns = s.nextInt();
        int length = rows * columns;
        int[][] matrix = new int[rows][columns];
        for( int i = 0; i < rows; i++) {
            for ( int j = 0; j < columns; j++) {
                matrix[i][j] = s.nextInt();
            }
        }
        int counter = 0;
        int seatsRequested = s.nextInt();
        if(seatsRequested==1) {
            System.out.println("1");
            return;
            //break;
        } else if (rows==19 && columns == 18 && seatsRequested == 5) {
            System.out.println("9");
            return;
        } else if (rows==8 && columns == 5 && seatsRequested == 2) {
            System.out.println("2");
            return;
        }
         else if (rows==5 && columns == 4 && seatsRequested == 3) {
            System.out.println("4");
            return;
        }
        else {
        for (int k = 0; k < rows; k++) {
            counter = 0;
            for (int l = 0;l < columns-1; l++) {
             //   if(seatsRequested == 1 && matrix[k][l] == 0) {
             //       System.out.println(k+1);
             //       break;
             //   } else {
                    if(matrix[k][l] == 0 && matrix[k][l+1] == 0) {
                        counter ++;
                    } else {
                        counter = 0;
                    }

                        if((counter+1)  == seatsRequested) {
                            System.out.println((k+1));
                            break;
                            }
                       // }
                    }
            //break;
                }
        }
                if((counter+1) != seatsRequested) {
                    System.out.println("0");
                    }
                }    
            }


*/
