import java.util.Scanner;

public class exercise64 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int month = -1;
        int year = -1;
        while (month == -1)
        {
            System.out.print("Enter month: ");
            String input = sc.nextLine().trim().toLowerCase();

            switch (input) {
                case "1": case "jan": case "january": month = 1; break;
                case "2": case "feb": case "february": month = 2; break;
                case "3": case "mar": case "march": month = 3; break;
                case "4": case "apr": case "april": month = 4; break;
                case "5": case "may": month = 5; break;
                case "6": case "jun": case "june": month = 6; break;
                case "7": case "jul": case "july": month = 7; break;
                case "8": case "aug": case "august": month = 8; break;
                case "9": case "sep": case "september": month = 9; break;
                case "10": case "oct": case "october": month = 10; break;
                case "11": case "nov": case "november": month = 11; break;
                case "12": case "dec": case "december": month = 12; break;
                default:
                    System.out.println("Invalid month, try again!");
            }
        }

        while (year < 0)
        {
            System.out.print("Enter year: ");
            if (sc.hasNextInt())
            {
                year = sc.nextInt();
                if (year < 0)
                {
                    System.out.println("Year must be non-negative!");
                }
            }
            else
            {
                System.out.println("Invalid year, try again!");
                sc.next(); // bỏ input sai
            }
        }

        boolean isLeap = false;
        if (year % 400 == 0)
        {
            isLeap = true;
        }
        else if (year % 100 == 0)
        {
            isLeap = false;
        }
        else if (year % 4 == 0)
        {
            isLeap = true;
        }
        int days;

        switch (month)
        {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31; break;
            case 4: case 6: case 9: case 11:
                days = 30; break;
            case 2:
                days = isLeap ? 29 : 28; break;
            default:
                days = 0;
        }

        System.out.println("Month " + month + " of year " + year + " has " + days + " days.");

        sc.close();
    }
}
