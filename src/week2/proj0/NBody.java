package week2.proj0;

import week2.examples.*;

public class NBody {

    public static double readRadius(String file) {

        In in = new In(file);

        String numOfPlanets = in.readLine();
        double radius = in.readDouble();

        return radius;
    }

    public static Planet[] readPlanets(String file) {
        In in = new In(file);
        int numOfPlanets = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[numOfPlanets];
        for (int i = 0; i < numOfPlanets; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double mass = in.readDouble();
            String imageName = in.readString();
            planets[i] = new Planet(xP, yP, xV, yV, mass, imageName);
        }

        return planets;
    }

    public static void main(String[] args) {

        Planet[] planets = readPlanets(args[2]);
        double radius = readRadius(args[2]);

        double time = 0.0;
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        double[] xForces = new double[planets.length];
        double[] yForces = new double[planets.length];

        for (time = 0.0; time < T; time = time + dt) {

            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            drawBackground(radius);

            for (Planet planet : planets) {
                planet.draw();
            }

            StdDraw.show(5);

        }

        System.out.println("The end!");
        StdAudio.play("src/week2/audio/2001.mid");
        System.out.println("music end!");

        //print out the final state
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }

    public static void drawBackground(double radius) {
        /** Sets up the universe so it goes from
         * -100, -100 up to 100, 100 */
        StdDraw.setScale(-radius, radius);

		/* Clears the drawing window. */
        StdDraw.clear();

        StdDraw.picture(0, 0, "src/week2/images/starfield.jpg");
    }
}
