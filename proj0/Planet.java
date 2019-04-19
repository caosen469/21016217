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

	public double calcNetForceExertedByX(Planet[] allBodys)
	{
		int i = 0;
		double netForce = 0;

		while(i < allBodys.length)
		{
			if(! this.equals(allBodys[i]))
			{
				netForce += this.calcForceExertedByX(allBodys[i]);
			}
			i++;		
		}
		return netForce;

	}

	public double calcNetForceExertedByY(Planet[] allBodys)
	{
		int i = 0;
		double netForce = 0;

		while(i < allBodys.length)
		{
			if(! this.equals(allBodys[i]))
			{
				netForce += this.calcForceExertedByY(allBodys[i]);
			}
			i++;		
		}
		return netForce;		
	}

	public void update(double dt,double fX,double fY)
	{
		double a_netx = fX/this.mass;
		double a_nety = fY/this.mass;
		
		double v_newx = this.xxVel + a_netx * dt;
		double v_newy = this.yyVel + a_nety * dt;

		double p_newx = this.xxPos + dt * v_newx;
		double p_newy = this.yyPos + dt * v_newy;

		this.xxVel = v_newx;
		this.yyVel = v_newy;
		this.xxPos = p_newx;
		this.yyPos = p_newy;
	}
}
