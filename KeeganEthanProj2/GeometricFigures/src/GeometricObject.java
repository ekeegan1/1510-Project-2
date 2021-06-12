/*
 * This is the abstract super class to be used to create
 * Triangle2D and Rectangle2D
 */

//abstract class given in Dr. Hobbs' Demos
public abstract class GeometricObject
{
	//abstract methods go here
	public abstract boolean contains(double x, double y);
	
	public abstract double getPerimeter();
	
	public abstract double getArea();
	
}