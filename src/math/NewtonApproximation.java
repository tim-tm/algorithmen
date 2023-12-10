package math;

public class NewtonApproximation {
    static double f(double x) {
        return -(x*x*x)-(4*x)+10;
    }

    static double df(double x) {
        return -3*(x*x)-4;
    }

    static double f2(double x) {
        return (x*x*x)-(2*x)+2;
    }

    static double df2(double x) {
        return 3*(x*x)-2;
    }

    static double f3(double x) {
        return Math.exp(-(x*x))-1;
    }

    static double df3(double x) {
        return -2*x*Math.exp(-(x*x));
    }

    public static void main(String[] args) {
        System.out.println("Beispiel 1:");
        System.out.println("f(x)=-x³+4x+10");
        System.out.println("f'(x)=-3x²-4");
        System.out.println();
        System.out.println("x:");
        for (int x = -4; x <= 4; x++) {
            System.out.printf("%d         ", x);
        }
        System.out.println();
        System.out.println("y:");
        for (int x = -4; x <= 4; x++) {
            System.out.printf("%f ", f(x));
        }
        System.out.println();
        System.out.println();

        double x = 5;
        for (int i = 0; i < 10; i++) {
            System.out.printf("x%d = %f\n", i, x);
            x = (x - (f(x)/df(x)));
        }

        System.out.println();
        System.out.println("Beispiel 2 (Oszillation):");
        System.out.println("f(x)=x³-2x+2");
        System.out.println("f'(x)=3x²-2");
        System.out.println();

        x = 0;
        for (int i = 0; i < 8; i++) {
            System.out.printf("x%d = %f\n", i, x);
            x = (x - (f2(x)/df2(x)));
        }

        System.out.println();
        System.out.println("Beispiel 3 (Divergenz):");
        System.out.println("f(x)=e^(-x²)-1");
        System.out.println("f'(x)=-2xe^(-x²)");
        System.out.println();

        x = 2;
        for (int i = 0; i < 5; i++) {
            System.out.printf("x%d = %f\n", i, x);
            x = (x - (f3(x)/df3(x)));
        }
    }
}
