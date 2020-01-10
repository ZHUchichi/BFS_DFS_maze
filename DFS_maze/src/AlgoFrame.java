import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AlgoFrame extends JFrame{
    private int canvasWidth;
    private int canvasHeight;
    public AlgoFrame(String title, int canvasWidth, int canvasHeight){
        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    public AlgoFrame(String title){

        this(title, 1024, 768);
    }
    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}
    private MazeData data;
    public void render(MazeData data){
        this.data = data;
        repaint();
    }
    private class AlgoCanvas extends JPanel{

        public AlgoCanvas(){

            super(true);
        }
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;
            int w = canvasWidth/data.M();
            int h = canvasHeight/data.N();
            for(int i = 0 ; i < data.N() ; i ++ )
                for(int j = 0 ; j < data.M() ; j ++){
                    if (data.getMaze(i,j) == MazeData.WALL)
                        AlgoVisHelper.setColor(g2d, AlgoVisHelper.Grey);
                    else
                        AlgoVisHelper.setColor(g2d, AlgoVisHelper.White);
                    if(data.path[i][j])
                        AlgoVisHelper.setColor(g2d, AlgoVisHelper.Red);
                    AlgoVisHelper.fillRectangle(g2d, j * w, i * h, w, h);
                }
        }
        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
