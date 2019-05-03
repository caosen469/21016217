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
		Double T = java.lang.Double.pareseDouble(args[0]);
		Double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		double radius = NBody.readRadius(filename);
		Planet planets[] = NBody.readPlanets(filename); 

		/*draw the background which is starfield.jpg**/
		StdDraw.setScale(-radius, radius);

		/*Clears the drawing window**/
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");

	}
}