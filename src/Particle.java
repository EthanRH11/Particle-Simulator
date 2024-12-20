public class Particle{
    private double rx, ry; //Position of Particle
    private double vx, vy; //Velocity of Particle
    private double mass; //Mass of Particle
    private double radius; //Radius of Particle
    private int collisionCount; //Number of Collisions of particle

    public Particle(double rx, double ry, double vx, double vy, double mass, double radius){
        //Constructor to initialize the particle's properties.
        this.rx = rx;
        this.ry = ry;
        this.vx = vx;
        this.vy = vy;
        this.radius = radius;
        this.mass = mass;
        this.collisionCount = 0;
    }

    public double collidesX(){
        //Compute the time until the particle hits a vertical wall
        if(vx > 0) return (1.0 - rx - radius) / vx;
        else if (vx < 0) return (x - radius) / -vx;
        else return Double.POSITIVE_INFINITY;
    }
    public double collidesY(){
        //Compute the time until the particle hits a horizontal wall
        if(vy > 0) return (1.0 - ry - radius) / vy;
        else if(vy < 0) return (y - radius) / - vy;
        else return Double.POSITIVE_INFINITY;
    }
    public double collides(Particle B){
        //Compute the time until this particle collides with another (b)
        if (this == B) return Double.POSITIVE_INFINITY;
        double dx = b.x - this.x;
        double dy = b.y - this.y;
        double dvx = b.vx - this.vx;
        double dvy = b.vy - this.vy;
        double dvdr = ((dx * dvx) + (dy * dvy));

        if(dvdr > 0) return Double.POSITIVE_INFINITY;

        double dvdv = ((dvx * dvx) + (dvy * dvy));
        double drdr = ((dx * dx) + (dy * dy));
        double sigma = this.radius + b.radius;
        double d = (dvdr * dvdr) - dvdv * (drdr - sigma * sigma);
        if(d < 0) return Double.POSITIVE_INFINITY;

        return -(dvdr + Math.sqrt(d)) / dvdv;
    }
    public void bounceX(){
        //Update velocity after a collision with a vertical wall
        vx = -vx;
        collisionCount++;
    }
    public void bounceY(){
        //Update velocity after a collision with a horizontal wall
        vy = -vy;
        collisionCount++;
    }
    public void bounce(Particle B){
        //Update velocity for both particles after a collision
                double dx = that.x - this.x;
        double dy = that.y - this.y;
        double dvx = that.vx - this.vx;
        double dvy = that.vy - this.vy;
        double dvdr = dx * dvx + dy * dvy;
        double dist = this.radius + that.radius;

        double magnitude = 2 * this.mass * that.mass * dvdr / ((this.mass + that.mass) * dist);
        double fx = magnitude * dx / dist;
        double fy = magnitude * dy / dist;

        this.vx += fx / this.mass;
        this.vy += fy / this.mass;
        that.vx -= fx / that.mass;
        that.vy -= fy / that.mass;

        this.collisions++;
        that.collisions++;
    }
    public int getCollisionCount(){
        //Return the total number of collisions involving this particle
        return collisionCount;
    }
}