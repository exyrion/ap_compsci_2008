import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D;


public class GeometryTester
{
       public static void main(String[] args)
       {
		   	Point2D.Double a = new Point2D.Double(1, 1);
			Point2D.Double b = new Point2D.Double(3,3);
			System.out.println("Angle: " + Geometry.angle(a, b));   //expected answer: 45 degrees

			a = new Point2D.Double(-1, 2);
			b = new Point2D.Double(-2, 5);
			System.out.println("Angle: " + Geometry.angle(a, b));   //expected answer: 71.56 degrees

			a = new Point2D.Double(3, 4);
			b = new Point2D.Double(3, -6);
			System.out.println("Slope: " + Geometry.slope(a, b));   //expected answer: NaN  (Not a Number)

			Ellipse2D.Double e = new Ellipse2D.Double(30, 40, 20, 20);
			System.out.println("Area: " + Geometry.area(e));		//expected answer: 314.16 square units

			e = new Ellipse2D.Double(30, 40, 40, 30);
			System.out.println("Perimeter: " + Geometry.perimeter(e));      //expected answer: 110.52 units
			
      }

}
