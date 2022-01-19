package TEDUpolly;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class Player extends JPanel {
	
	int OyuncuNumarasi;
	public String Isim;
	String IlkHarf;
	int Para=30000;
	double GPA;
	ArrayList<Square> MalVarligi = new ArrayList<Square>();
	int KonumNo=0;
	Square Konum;
	double NotToplami=0;
	public int oyuncutursayisi=1;
	Boolean DonduMu=false;
	private int playerNumber;
	JLabel lblPlayerNumber;
	private int currentSquareNumber = 0;
	
	public Player(int xCoord, int yCoord, int width, int height) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(xCoord, yCoord, 20, 20);
		this.setLayout(null);

	}

	public Player(String isim, int oyuncuNumarasiA, Color color) {
		this.Isim = isim;
		this.playerNumber = oyuncuNumarasiA;
		this.IlkHarf = isim.substring(0,1);

		
		this.setBackground(color);
		lblPlayerNumber = new JLabel(""+IlkHarf); //bunun yerine ilk harf gelcek
		lblPlayerNumber.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblPlayerNumber.setForeground(Color.WHITE);
		this.add(lblPlayerNumber); 
		
		if(oyuncuNumarasiA==1) {
			this.setBounds(30, 33, 20, 28);
			
		}
		else {//oyuncuNumaras�A==2
			this.setBounds(60, 33, 20, 28);
			
		}
		
	}
		//Oyuncunun konum sira sayisini arttirarak ilerlemek.
		public void Ilerle(int dicesTotal) {
			
			if(this.KonumNo + dicesTotal > 20) {
				int maas = (int)750 * (int)this.GPA;
				this.ArtiIslem(maas, this);
			}
			
			this.KonumNo = (this.KonumNo + dicesTotal)%20;
			
			int targetSquare = (currentSquareNumber + dicesTotal) % 20;
			currentSquareNumber = targetSquare;
			
			if(MonopolyMainTEDUpolly.OynayanOyuncu == 0) {
				this.setLocation(xLocationsOfPlayer1[targetSquare], yLocationsOfPlayer1[targetSquare]);
			} else {
				this.setLocation(xLocationsOfPlayer2[targetSquare], yLocationsOfPlayer2[targetSquare]);
			}
		}
		
		//Para kazanan oyuncu
		public void ArtiIslem(int miktarA, Player odenen) {
			odenen.Para += miktarA;
			
		}
		
		//Odeme yapan oyuncu INF LOOP
		public void EksiIslem(int miktarA, Player odeyen) {

			if(odeyen.Para < miktarA) {
				if(odeyen.MalVarligi.size() == 0) {
					//OYUN BITER
					System.out.println(odeyen.Isim + " went bankrupt!");
					MonopolyMainTEDUpolly.KazananiBul();
				}
				else {
					new EvSatimi(odeyen).setVisible(true);
					if(odeyen.Para > miktarA){
						odeyen.Para -= miktarA;
					}
					MonopolyMainTEDUpolly.updatePanelPlayer1TextArea();
					MonopolyMainTEDUpolly.updatePanelPlayer2TextArea();

				}
			}
			else 
				odeyen.Para -= miktarA;
			
		}
		
		//Yer alan oyuncu
		public void YerSatinAlma(Square yerA, Player alan) {
			alan.MalVarligiEkle(yerA);
			alan.Para -= yerA.Fiyat;
			yerA.SatinAlindi(yerA, alan);
			System.out.println(alan.Isim + ", bought the " + yerA.Isim + " square with paying " + yerA.Fiyat + "$");
			
		}
		
		//Yer kaybeden oyuncu
		public void YerSat(Square yerA, Player veren) {
			veren.MalVarligiCikar(yerA);
			veren.Para += yerA.Fiyat/2;
			veren.Para += ((yerA.EvSayisi+yerA.OtelSayisi) * yerA.InsaatUcreti)/2;
			yerA.Satildi(yerA);


			
		}
		
		//Kira �deme
		public void Kiraodeme(Square yerA, Player odeyen) {
			odeyen.EksiIslem(yerA.Kira, odeyen);
			yerA.Sahibi.Para += yerA.Kira;
			System.out.println(odeyen.Isim + ", paid " +  yerA.Kira + "$ to the " + yerA.Sahibi.Isim + ".");
			
		}
		
		//ev yapma
		public void InsaatYapma(Square yerA, Player yapan) {
			yerA.InsaatYapildi(yerA);
			yapan.Para -= yerA.InsaatUcreti;
			System.out.println(yapan.Isim + ", made a building to " + yerA.Isim + " square with the cost of " + yerA.InsaatUcreti + "$.");
			
		}
		
		//Oyuncuya mal var eklemek.
		public void MalVarligiEkle(Square yerA) {
			this.MalVarligi.add(yerA);
			
		}
		
		//Oyuncunun yer satmas
		public void MalVarligiCikar(Square yerA) {
			this.MalVarligi.remove(yerA);
			
		}
		
		public Square KonumBul(int konumnoA) {
			Square Bulundu = null;
			for(int i=0; i<Board.allSquares.size(); i++) {
				Square Konum = Board.allSquares.get(i);
				int No = Konum.Sira;
				
				if(No == konumnoA) {
					Bulundu = Konum;
				}
			}
			return Bulundu;
			
		}
		
		//Tur bitince oyuncularin parasini ve malvarliklarini gostermek icin.
		public String Bilgilendirme() {
			String print = "";
			print += "Current balance: " + this.Para + "$ \n";
			print += "Wealth: \n";
			
			for(Square yer : MalVarligi) {
				print += yer.Isim + " (" + yer.EvSayisi + " House)" + " (" + yer.OtelSayisi + " Hotel)" + "\n";
			}
			
			print += "GPA: " + GPA;
			return print;
			
		}
	
	//Malvarl hesaplama
	public double DegerHesaplama() {
		double deger=0;
		for(int i=0; i<this.MalVarligi.size(); i++) {
			deger = deger + this.MalVarligi.get(i).Fiyat;

		}
		deger = deger + this.Para;
		deger = deger * this.GPA;

		return deger;

	}
	
	//Gpa lar� special karelerde g�ncelleme
	public void SpecialGPA(int x) {
		
		this.NotToplami += x*4.0;
		this.oyuncutursayisi += x;
		this.GPA = this.NotToplami/this.oyuncutursayisi;
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	int[] xLocationsOfPlayer1 = {31, 131, 231, 331, 431, 531,
			531, 531, 531, 531, 531,
			431, 331, 231, 131, 31,
			31, 31, 31, 31};

	int[] yLocationsOfPlayer1 = {33, 33, 33, 33, 33, 33,
			133, 233, 333, 433, 533,
			533, 533, 533, 533, 533,
			433, 333, 233, 133};
	
	int[] xLocationsOfPlayer2 = {61, 191, 291, 361, 461, 561,
			561, 561, 561, 561, 561,
			461, 361, 261, 161, 61,
			61, 61, 61, 61};

	int[] yLocationsOfPlayer2 = {33, 33, 33, 33, 33, 33,
			133, 233, 333, 433, 533,
			533, 533, 533, 533, 533,
			433, 333, 233, 133};

	public int getOyuncuNumarasi() {
		return OyuncuNumarasi;
	}

	public void setOyuncuNumarasi(int oyuncuNumarasi) {
		OyuncuNumarasi = oyuncuNumarasi;
	}

	public String getIsim() {
		return Isim;
	}

	public void setIsim(String isim) {
		Isim = isim;
	}

	public String getIlkHarf() {
		return IlkHarf;
	}

	public void setIlkHarf(String ilkHarf) {
		IlkHarf = ilkHarf;
	}

	public int getPara() {
		return Para;
	}

	public void setPara(int para) {
		Para = para;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	public ArrayList<Square> getMalVarligi() {
		return MalVarligi;
	}

	public void setMalVarligi(ArrayList<Square> malVarligi) {
		MalVarligi = malVarligi;
	}

	public int getKonumNo() {
		return KonumNo;
	}

	public void setKonumNo(int konumNo) {
		KonumNo = konumNo;
	}

	public Square getKonum() {
		return Konum;
	}

	public void setKonum(Square konum) {
		Konum = konum;
	}

	public double getNotToplami() {
		return NotToplami;
	}

	public void setNotToplami(double notToplami) {
		NotToplami = notToplami;
	}

	public int getOyuncutursayisi() {
		return oyuncutursayisi;
	}

	public void setOyuncutursayisi(int oyuncutursayisi) {
		this.oyuncutursayisi = oyuncutursayisi;
	}

	public Boolean getDonduMu() {
		return DonduMu;
	}

	public void setDonduMu(Boolean donduMu) {
		DonduMu = donduMu;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public JLabel getLblPlayerNumber() {
		return lblPlayerNumber;
	}

	public void setLblPlayerNumber(JLabel lblPlayerNumber) {
		this.lblPlayerNumber = lblPlayerNumber;
	}

	public int getCurrentSquareNumber() {
		return currentSquareNumber;
	}

	public void setCurrentSquareNumber(int currentSquareNumber) {
		this.currentSquareNumber = currentSquareNumber;
	}

	public int[] getxLocationsOfPlayer1() {
		return xLocationsOfPlayer1;
	}

	public void setxLocationsOfPlayer1(int[] xLocationsOfPlayer1) {
		this.xLocationsOfPlayer1 = xLocationsOfPlayer1;
	}

	public int[] getyLocationsOfPlayer1() {
		return yLocationsOfPlayer1;
	}

	public void setyLocationsOfPlayer1(int[] yLocationsOfPlayer1) {
		this.yLocationsOfPlayer1 = yLocationsOfPlayer1;
	}

	public int[] getxLocationsOfPlayer2() {
		return xLocationsOfPlayer2;
	}

	public void setxLocationsOfPlayer2(int[] xLocationsOfPlayer2) {
		this.xLocationsOfPlayer2 = xLocationsOfPlayer2;
	}

	public int[] getyLocationsOfPlayer2() {
		return yLocationsOfPlayer2;
	}

	public void setyLocationsOfPlayer2(int[] yLocationsOfPlayer2) {
		this.yLocationsOfPlayer2 = yLocationsOfPlayer2;
	}
	
}
