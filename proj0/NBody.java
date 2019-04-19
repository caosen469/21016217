public class NBody
{
	public static double readRadius(String args)
	{
		In in = new In(args);

		int firstItem = in.readInt();
		double secondItem = in.readDouble();
		return secondItem;
	}

	public static Planet[] readPlanets(String args)
	{
		
		In in = new In(args);
		int numbers = in.readInt();

/**mind that how we intialize a array of a class we defined by ourself*/
		Planet[] planets = new Planet[numbers];
		
		
		double meaningless = in.readDouble();
		for(int i = 0; i < numbers; i++)
		{
			planets[i] = new Planet(in.readDouble(), in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
		}

		return planets;
	}
	public static void main()
	{
		
	}
}