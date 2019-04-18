public class Planet
{
	public double xxPos; /** Its current x position*/
	public double yyPos; /** Its current y position*/
	public double xxVel; /** Its current velocity in the x direction*/
	public double yyVel; /** Its current velocity in the y direction*/
	public double mass;  /** Its mass*/
	public String imgFileName; /**The name of the file that corresponds to the image that depicts the body, for example ,jupiter,gif*/
	public static double G =  6.67E-11; 
	public Planet(double xP, double yP, double xV, double yV, double m, String img)
	{
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}
	public Planet(Planet b)
	{
		this.xxPos = b.xxPos;
		this.yyPos = b.yyPos;
		this.xxVel = b.xxVel;
		this.yyVel = b.yyVel;
		this.mass = b.mass;
		this.imgFileName = b.imgFileName;
	}

	public double calacDistance(Planet a)
	{
		double distance;
		double squaredistance = Math.pow(this.xxPos - a.xxPos,2) + Math.pow(this.yyPos-a.yyPos,2);
		distance = Math.sqrt(squaredistance);
		return distance;		
	}
				  
	public double calcForceExertedBy(Planet a)
	{
		double force;
		
		force = (this.mass * a.mass)*G / Math.pow(this.calacDistance(a),2);
		return force;
	}

	public double calcForceExertedByX(Planet a)
	{
		double forceX = this.calcForceExertedBy(a)*(a.xxPos-this.xxPos)/calacDistance(a);
		return forceX;
	}

	public double calcForceExertedByY(Planet a)
	{
		double forceY = this.calcForceExertedBy(a)*(a.yyPos-this.yyPos)/calacDistance(a);
		return forceY;
	}
}
