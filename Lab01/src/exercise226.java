import java.util.Scanner;

public class exercise226 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Linear Equation ax + b = 0 ===");
        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();

        if (a == 0)
        {
            if (b == 0)
            {
                System.out.println("Infinite solutions");
            } else
            {
                System.out.println("No solution");
            }
        }
        else
        {
            double x = -b / a;
            System.out.println("Solution x = " + x);
        }

        System.out.println("\n=== System of equations ===");
        System.out.print("Enter a11, a12, b1: ");
        double a11 = sc.nextDouble();
        double a12 = sc.nextDouble();
        double b1 = sc.nextDouble();

        System.out.print("Enter a21, a22, b2: ");
        double a21 = sc.nextDouble();
        double a22 = sc.nextDouble();
        double b2 = sc.nextDouble();

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0)
        {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("Unique solution:");
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        }
        else
        {
            if (D1 == 0 && D2 == 0)
            {
                System.out.println("Infinite solutions");
            }
            else
            {
                System.out.println("No solution");
            }
        }

        System.out.println("\n=== Quadratic Equation ax^2 + bx + c = 0 ===");
        System.out.print("Enter a, b, c: ");
        double qa = sc.nextDouble();
        double qb = sc.nextDouble();
        double qc = sc.nextDouble();

        if (qa == 0)
        {
            if (qb == 0)
            {
                if (qc == 0)
                {
                    System.out.println("Infinite solutions");
                }
                else
                {
                    System.out.println("No solution");
                }
            }
            else
            {
                double xq = -qc / qb;
                System.out.println("Linear solution x = " + xq);
            }
        }
        else
        {
            double delta = qb * qb - 4 * qa * qc;

            if (delta > 0)
            {
                double x1 = (-qb + Math.sqrt(delta)) / (2 * qa);
                double x2 = (-qb - Math.sqrt(delta)) / (2 * qa);
                System.out.println("Two distinct roots:");
                System.out.println("x1 = " + x1 + ", x2 = " + x2);
            }
            else if (delta == 0)
            {
                double x = -qb / (2 * qa);
                System.out.println("Double root x = " + x);
            }
            else
            {
                System.out.println("No real roots");
            }
        }

        sc.close();
    }
}
