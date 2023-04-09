import edu.princeton.cs.stdlib.StdDraw;
import edu.princeton.cs.stdlib.StdOut;

import java.awt.*;

public class Taller1 {

    public static void main(String[] args) {

        double min = -1.0;
        double max = 1.0;

        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);
        StdDraw.enableDoubleBuffering();

        Color[] colores = {Color.BLUE, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.RED, Color.CYAN};

        double[] posX0 = new double[6];
        double[] posY0 = new double[6];
        double[] posX1 = new double[6];
        double[] posY1 = new double[6];

        posX0[0] = posicion(min,max);
        posY0[0] = posicion(min,max);
        posX1[0] = posicion(min,max);
        posY1[0] = posicion(min,max);

        double velocidadX0 = velocidades();
        double velocidadY0 = velocidades();
        double velocidadX1 = velocidades();
        double velocidadY1 = velocidades();

        while (true){

            velocidadX0 = cambioVelocidad(posX0[0],velocidadX0);
            velocidadY0 = cambioVelocidad(posY0[0],velocidadY0);
            velocidadX1 = cambioVelocidad(posX1[0],velocidadX1);
            velocidadY1 = cambioVelocidad(posY1[0],velocidadY1);

            posX0[0] += velocidadX0;
            posY0[0] += velocidadY0;
            posX1[0] += velocidadX1;
            posY1[0] += velocidadY1;

            for (int i=0; i<6; i++){

                if (i>0){

                    posX0[i] = posX0[0] - (velocidadX0*i*3);
                    posY0[i] = posY0[0] - (velocidadY0*i*3);
                    posX1[i] = posX1[0] - (velocidadX1*i*3);
                    posY1[i] = posY1[0] - (velocidadY1*i*3);
                }

                StdDraw.setPenColor(colores[i]);
                StdDraw.line(posX0[i],posY0[i],posX1[i],posY1[i]);
            }

            StdDraw.show();
            StdDraw.clear();
        }
    }

    public static double posicion(double min,double max){

        return min + (max - min) * Math.random();
    }

    public static double velocidades(){

        return 0.005 + Math.random()*0.007;
    }

    public static double cambioVelocidad(double posicion, double velocidadPos){

        if (Math.abs(posicion + velocidadPos) > 1.0){

            velocidadPos = -velocidadPos;
        }

        return velocidadPos;
    }
}
