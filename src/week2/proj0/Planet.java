package week2.proj0;

/**
 * Created by Katsura on 2017/2/24.
 */
public class Planet {
    public final double CONSTANT_G = 6.67e-11;

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xxPos, double yyPos, double xxVel,
                  double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcForceExertedByX(Planet planet) {

        double dx = planet.xxPos - this.xxPos;
        double dis = this.calcDistance(planet);
        double forceCompo = CONSTANT_G * this.mass * planet.mass / Math.pow(dis, 2);
        double forceX = forceCompo * dx / dis;

        return forceX;
    }

    public double calcForceExertedByY(Planet planet) {

        double dis = this.calcDistance(planet);
        double dy = planet.yyPos - this.yyPos;
        double forceCompo = CONSTANT_G * this.mass * planet.mass / Math.pow(dis, 2);
        double forceY = forceCompo * dy / dis;

        return forceY;
    }

    public double calcDistance(Planet planet) {
        double dx = planet.xxPos - this.xxPos;
        double dy = planet.yyPos - this.yyPos;
        double dis = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

        return dis;
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double forceXSum = 0.0;
        for (Planet planet : planets) {
            if (!this.equals(planet)) {
                forceXSum += this.calcForceExertedByX(planet);
            }
        }

        return forceXSum;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double forceYSum = 0.0;
        for (Planet planet : planets) {
            if (!this.equals(planet)) {
                forceYSum += this.calcForceExertedByY(planet);
            }
        }

        return forceYSum;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / mass;
        double aY = fY / mass;
        xxVel += aX * dt;
        yyVel += aY * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "src/week2/images/" + this.imgFileName);
    }
}
