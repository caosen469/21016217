public class NBody
{
	/*读取像 planets.txt 这种文件里的第二个数据：整个宇宙的直径**/
	public static double readRadius(String args)
	{
		In in = new In(args);

		int firstItem = in.readInt();
		double secondItem = in.readDouble();
		return secondItem;
	}
	
	/*read all the planets' information in file**/
	public static Planet[] readPlanets(String args)
	{
		
		In in = new In(args);
		int numbers = in.readInt();

/**mind that how we intialize a array of a class we defined by ourself*/
		Planet[] planets = new Planet[numbers];
		
		
		double meaningless = in.readDouble(); /*just escape the radius of universe**/
		for(int i = 0; i < numbers; i++)
		{
			planets[i] = new Planet(in.readDouble(), in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
		}

		return planets;
	}
	public static void main(String[] args)
	{
		Double T = java.lang.Double.parseDouble(args[0]);
		Double dt = java.lang.Double.parseDouble(args[1]);
		String filename = args[2];

		double radius = NBody.readRadius(filename);
		Planet planets[] = NBody.readPlanets(filename); 

		/*draw the background which is starfield.jpg**/
		StdDraw.setScale(-radius, radius);

		/*Clears the drawing window**/
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");

		int numberOfPlanets = planets.length;
		for(int i = 0; i < numberOfPlanets; i++ )
		{
			planets[i].draw();
		}

		StdDraw.enableDoubleBuffering();
/**---------------------------------------------------------------------------------*/
/*start the animation**/

	   	int timeRecord = 0; /**just represents the time*/

	   	while(timeRecord < T)
	   	{
	   		/**store the forces exerted on each planet*/
	   		Double xForces[] = new Double[numberOfPlanets]; 
			Double yForces[] = new Double[numberOfPlanets];

	   		for(int i=0; i<numberOfPlanets; i++)
	   		{
	   			xForces[i] = planets[i].calcNetForceExertedByX(planets);
	   			yForces[i] = planets[i].calcNetForceExertedByY(planets);
	   		}
	   		for(int i=0;i<numberOfPlanets;i++)
	   		{
	   			planets[i].update(dt, xForces[i],yForces[i]);
	   		}

	   		StdDraw.picture(0, 0, "images/starfield.jpg");

	   		for(int i =0; i<numberOfPlanets; i++)
	   		{
	   			planets[i].draw();
	   		}

	   		StdDraw.show();
	   		StdDraw.pause(10);

	   		timeRecord += dt;
	   	}

	   	StdOut.printf("%d\n", planets.length);
	   	StdOut.printf("%.2e\n", radius);
	   	for(int i=0; i<planets.length; i++)
	   	{
	   		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
	   			planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
	   			planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
	   	}
	}
}