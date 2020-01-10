import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.lang.InterruptedException;

public class AlgoVisHelper {
    private AlgoVisHelper(){}
    public static final Color Red = new Color(0xF44336);
    public static final Color LightBlue = new Color(0x03A9F4);
    public static final Color Yellow = new Color(0xFFEB3B);
    public static final Color Grey = new Color(0x9E9E9E);
    public static final Color White = new Color(0xFFFFFF);
    public static void strokeCircle(Graphics2D g, int x, int y, int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g.draw(circle);
    }
    public static void fillCircle(Graphics2D g, int x, int y, int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g.fill(circle);
    }
    public static void strokeRectangle(Graphics2D g, int x, int y, int w, int h){

        Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
        g.draw(rectangle);
    }
    public static void fillRectangle(Graphics2D g, int x, int y, int w, int h){

        Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
        g.fill(rectangle);
    }
    public static void setColor(Graphics2D g, Color color){
        g.setColor(color);
    }
    public static void setStrokeWidth(Graphics2D g, int w){
        int strokeWidth = w;
        g.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }
    public static void pause(int t) {
        try {
            Thread.sleep(t);
        }
        catch (InterruptedException e) {
            System.out.println("Error sleeping");
        }
    }

}
