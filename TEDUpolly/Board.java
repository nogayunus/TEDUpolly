package TEDUpolly;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Board extends JPanel {

	public static ArrayList<Square> allSquares = new ArrayList<Square>();
	public static ArrayList<Square> unbuyableSquares = new ArrayList<Square>(); // squares like "Go", "Chances" etc...
	 public static BufferedImage start;
	 public static BufferedImage surprise;
	public static BufferedImage surprise1;
	 public static BufferedImage gym;
	 public static BufferedImage main;
	 public static BufferedImage pool;
	 public static BufferedImage erasmus;
	 public static BufferedImage logo;
	 public static BufferedImage summer;
	 public static BufferedImage freeze;

	
	public ArrayList<Square> getUnbuyableSquares(){
		return unbuyableSquares;
	}
	
	public ArrayList<Square> getAllSquares(){
		return allSquares;
	}
	
	public Square getSquareAtIndex(int location) {
		return allSquares.get(location);
	}

	public Board(int xCoord, int yCoord, int width, int height) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(xCoord, yCoord, 612, 612);
		this.setLayout(null);
		initializeSquares();

		//START
		try {
			start = ImageIO.read(new FileImageInputStream(new File("start1.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//SURPRISE
		try {
			surprise = ImageIO.read(new FileImageInputStream(new File("surprise.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//GYM
		try {
			gym = ImageIO.read(new FileImageInputStream(new File("gym.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//MAIN LOGO
		try {
			main = ImageIO.read(new FileImageInputStream(new File("main.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//POOL
		try {
			pool = ImageIO.read(new FileImageInputStream(new File("pool.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//ERASMUS
		try {
			erasmus = ImageIO.read(new FileImageInputStream(new File("erasmus.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//TEDUPOLLY
		try {
			logo = ImageIO.read(new FileImageInputStream(new File("tedupoly.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//SUPRISE2
		try {
			surprise1 = ImageIO.read(new FileImageInputStream(new File("surprise1.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//SUMMERSCHOOL
		try {
			summer = ImageIO.read(new FileImageInputStream(new File("summer.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//REGISTRATION FREEZE
		try {
			freeze = ImageIO.read(new FileImageInputStream(new File("freeze.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void paint(Graphics g) {
		super.paint(g);

		g.drawImage(start,0,12,start.getWidth()/7,start.getHeight()/7,this);
		g.drawImage(surprise,508,208,surprise.getWidth()/7,surprise.getHeight()/7,this);
		g.drawImage(gym,212,-5,gym.getWidth()/5,gym.getHeight()/5,this);
		g.drawImage(main,250,125,main.getWidth()/5,main.getHeight()/5,this);
		g.drawImage(pool,308,506,pool.getWidth()/6,pool.getHeight()/6,this);
		g.drawImage(erasmus,455,475,erasmus.getWidth()/5,erasmus.getHeight()/4,this);
		g.drawImage(logo,179,310,logo.getWidth()/3,logo.getHeight()/3,this);
		g.drawImage(surprise1,6,208,surprise1.getWidth()/7,surprise1.getHeight()/7,this);
		g.drawImage(summer,505,2,summer.getWidth()/12,summer.getHeight()/8,this);
		g.drawImage(freeze,-20,520,freeze.getWidth()/6,freeze.getHeight()/6,this);
	}


	private void initializeSquares() {
		// TODO Auto-generated method stub

		//(int xCoord, int yCoord, int width, int height, String labelString, int rotationDegrees, int s�raA, String isimA, int fiyatA, int kiraA, int in�a�cretiA, boolean sat�nal�nd�m�A, boolean specialsquareA, boolean sat�nal�nabilirA)
		// squares on the top
		Square square00 = new Square(6,6,100,100,135, 0, "Start", 0, 0, 0, false, true, false);
		this.add(square00);
		allSquares.add(square00);
		unbuyableSquares.add(square00);
		
		Square square01 = new Square(106,6,100,100,0, 1, "F Block 1", 1500, 150, 250, false, false, true);
		this.add(square01);
		allSquares.add(square01);
		
		Square square02 = new Square(206,6,100,100,0, 2, "TEDU GYM", 2000, 250, 340, false, false, true);
		this.add(square02);
		allSquares.add(square02);
		
		Square square03 = new Square(306,6,100,100,0, 3, "F Block 2", 1800, 210, 500, false, false, true);
		this.add(square03);
		allSquares.add(square03);
		
		Square square04 = new Square(406,6,100,100,0, 4, "F Block 3", 2000, 260, 410, false, false, true);
		this.add(square04);
		allSquares.add(square04);
		
		Square square05 = new Square(506,6,100,100,-135, 5, "Summer School", 2000, 250, 500, false, true, false);
		this.add(square05);
		allSquares.add(square05);
		unbuyableSquares.add(square05);

		// squares on the right
		Square square06 = new Square(506,106,100,100,-90, 6, "G Block 1", 2500, 315, 500, false, false, true);
		this.add(square06);
		allSquares.add(square06);
		
		Square square07 = new Square(506,206,100,100,-90, 7, "Surprise", 2000, 250, 500, false, true, false);
		this.add(square07);
		allSquares.add(square07);
		unbuyableSquares.add(square07);
		
		Square square08 = new Square(506,306,100,100,-90, 8, "G Block 2", 3000, 360, 570, false, false, true);
		this.add(square08);
		allSquares.add(square08);
		
		Square square09 = new Square(506,406,100,100,-90, 9, "G Block 3", 3300, 435, 700, false, false, true);
		this.add(square09);
		allSquares.add(square09);
		
		Square square10 = new Square(506,506,100,100,-45, 10, "Erasmus", 2000, 250, 500, false, true, false);
		this.add(square10);
		allSquares.add(square10);
		unbuyableSquares.add(square10);

		// squares on the bottom
		Square square11 = new Square(406,506,100,100,0, 11, "B Block 1", 3750, 470, 750, false, false, true);
		this.add(square11);
		allSquares.add(square11);
		
		Square square12 = new Square(306,506,100,100,0, 12, "Swimming Pool", 2000, 250, 500, false, false, true);
		this.add(square12);
		allSquares.add(square12);
		
		Square square13 = new Square(206,506,100,100,0, 13, "B Block 2", 4500, 540, 850, false, false, true);
		this.add(square13);
		allSquares.add(square13);
		
		Square square14 = new Square(106,506,100,100,0, 14, "B Block 3", 5000, 660, 1050, false, false, true);
		this.add(square14);
		allSquares.add(square14);
		
		Square square15 = new Square(6,506,100,100,45, 15, "Registration Freeze", 2000, 250, 500, false, true, false);
		this.add(square15);
		allSquares.add(square15);
		unbuyableSquares.add(square15);
		
		// squares on the left
		Square square16 = new Square(6,406,100,100,90, 16, "A Block 1", 6250, 780, 1250, false, false, true);
		this.add(square16);
		allSquares.add(square16);
		
		Square square17 = new Square(6,306,100,100,90, 17, "A Block 2", 7500, 900, 1400, false, false, true);
		this.add(square17);
		allSquares.add(square17);
		
		Square square18 = new Square(6,206,100,100,90, 18, "Surprise", 2000, 250, 500, false, true, false);
		this.add(square18);
		allSquares.add(square18);
		unbuyableSquares.add(square18);
		
		Square square19 = new Square(6,106,100,100,90, 19, "A Block 3", 8250, 1100, 1750, false, false, true);
		this.add(square19);
		allSquares.add(square19);
		
		JLabel lblMonopoly = new JLabel("TEDUpoly"){
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D)g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				AffineTransform aT = g2.getTransform();
				Shape oldshape = g2.getClip();
				double x = getWidth()/2.0;
				double y = getHeight()/2.0;
				//aT.rotate(Math.toRadians(-35), x, y);
				g2.setTransform(aT);
				g2.setClip(oldshape);
				super.paintComponent(g);
			}
		};
		lblMonopoly.setForeground(Color.WHITE);
		lblMonopoly.setBackground(Color.black);
		lblMonopoly.setOpaque(true);
		lblMonopoly.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonopoly.setFont(new Font("Century Gothic", Font.BOLD, 49));//47
		lblMonopoly.setBounds(179, 310, 268, 58);// 179 277 263 55
		this.add(lblMonopoly);
		
	}
	
	//Oyuncunun s�ra nosuna bakarak Square bulma
	public Square KonumBul(int konumnoA) {
		Square Bulundu = null;
		for(int i=0; i<this.allSquares.size(); i++) {
			Square Konum = allSquares.get(i);
			int No = Konum.Sira;
			
			if(No == konumnoA) {
				Bulundu = Konum;
			}
		}
		return Bulundu;
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}




}
