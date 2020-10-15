package me.RestrictedPower.TichuClient.View;
 
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import me.RestrictedPower.TichuClient.Util;
import me.RestrictedPower.TichuClient.Controller.Main;
import me.RestrictedPower.TichuClient.Model.Card;
import me.RestrictedPower.TichuClient.Model.Hand;
import me.RestrictedPower.TichuClient.View.ViewModels.DisplayPlayer;
import me.RestrictedPower.TichuClient.View.ViewModels.ExchangePanel;

public class GameView {
	final static int HEIGHT = 1025, WIDTH = 1505, CARD_HEIGHT = Card.BLACK_10.image.getIconHeight(), CARD_WIDTH = Card.BLACK_10.image.getIconWidth();
	private JFrame frame;
	private JButton grandTichu, tichu, fold, playCards, sendCards;
	private JLabel yourTurn, grandLabel, tichuLabel;
	public DisplayPlayer[] players = new DisplayPlayer[3];
	private ArrayList<JButton> cardButtons = new ArrayList<JButton>();
	private ExchangePanel exchangePanel;
	public GameView(String bef, String next, String team) {
		initialize(bef,next,team);
		frame.setVisible(true);
	}
	private void initialize(String bef, String next, String team) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame = new JFrame();
		frame.setContentPane(new JLayeredPane());
		frame.setBounds((int) (dim.getWidth()-WIDTH)/2,(int) (dim.getHeight()-HEIGHT)/2, WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		JLabel backgroundImg = new JLabel(Util.loadImageIcon("background.png"));
		backgroundImg.setBounds(0, 0, 1500, 1000);
		frame.getContentPane().add(backgroundImg,20);
		
		
		// Grand button -------------------------------------------------------------------------------------------------
		grandTichu = new JButton(Util.loadImageIcon("buttons/grand.png"));
		grandTichu.setBounds(100, 700, grandTichu.getIcon().getIconWidth(), grandTichu.getIcon().getIconHeight());
		grandTichu.setOpaque(false);
		grandTichu.setContentAreaFilled(false);
		grandTichu.setBorderPainted(false);
		grandTichu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.gameHandler.grandPressEvent();
			}
		});
		grandTichu.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				grandTichu.setIcon(Util.loadImageIcon("buttons/grand_hover.png"));
			}
		});
		grandTichu.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				grandTichu.setIcon(Util.loadImageIcon("buttons/grand.png"));
			}
		});
		grandTichu.show(true);
		
		
		// Tichu button -------------------------------------------------------------------------------------------------
		tichu = new JButton(Util.loadImageIcon("buttons/tichu.png"));
		tichu.setBounds(150, 700, tichu.getIcon().getIconWidth(), tichu.getIcon().getIconHeight());
		tichu.setOpaque(false);
		tichu.setContentAreaFilled(false);
		tichu.setBorderPainted(false);
		tichu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.gameHandler.tichuPressEvent();
			}
		});
		tichu.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				tichu.setIcon(Util.loadImageIcon("buttons/tichu_hover.png"));
			}
		});
		tichu.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				tichu.setIcon(Util.loadImageIcon("buttons/tichu.png"));
			}
		});
		tichu.show(false);
		
		
		// Fold button -------------------------------------------------------------------------------------------------
		fold = new JButton(Util.loadImageIcon("buttons/fold.png"));
		fold.setBounds(1200, 700, fold.getIcon().getIconWidth(), fold.getIcon().getIconHeight());
		fold.setOpaque(false);
		fold.setContentAreaFilled(false);
		fold.setBorderPainted(false);
		fold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.gameHandler.foldPressEvent();
			}
		});
		fold.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				fold.setIcon(Util.loadImageIcon("buttons/fold_hover.png"));
			}
		});
		fold.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				fold.setIcon(Util.loadImageIcon("buttons/fold.png"));
			}
		});
		fold.show(false);
		
		// Play button -------------------------------------------------------------------------------------------------
		playCards = new JButton(Util.loadImageIcon("buttons/play.png"));
		playCards.setBounds(950, 700, playCards.getIcon().getIconWidth(), playCards.getIcon().getIconHeight());
		playCards.setOpaque(false);
		playCards.setContentAreaFilled(false);
		playCards.setBorderPainted(false);
		playCards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.gameHandler.playCardsEvent();
			}
		});
		playCards.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				playCards.setIcon(Util.loadImageIcon("buttons/play_hover.png"));
			}
		});
		playCards.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				playCards.setIcon(Util.loadImageIcon("buttons/play.png"));
			}
		});
		playCards.show(false);
		
		
		// send button -------------------------------------------------------------------------------------------------
		sendCards = new JButton(Util.loadImageIcon("buttons/send.png"));
		sendCards.setBounds(950, 700, playCards.getIcon().getIconWidth(), playCards.getIcon().getIconHeight());
		sendCards.setOpaque(false);
		sendCards.setContentAreaFilled(false);
		sendCards.setBorderPainted(false);
		sendCards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.gameHandler.sendCardsEvent();
			}
		});
		sendCards.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				sendCards.setIcon(Util.loadImageIcon("buttons/send_hover.png"));
			}
		});
		sendCards.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				sendCards.setIcon(Util.loadImageIcon("buttons/send.png"));
			}
		});
		sendCards.show(false);
		
		// Grand label -------------------------------------------------------------------------------------------------
		grandLabel = new JLabel(Util.loadImageIcon("informative/grand_tichu.png"));
		grandLabel.setBounds(100, 725, grandLabel.getIcon().getIconWidth(), grandLabel.getIcon().getIconHeight());
		grandLabel.show(false);
		
		// Tichu label -------------------------------------------------------------------------------------------------
		tichuLabel = new JLabel(Util.loadImageIcon("informative/tichu.png"));
		tichuLabel.setBounds(100+(grandLabel.getIcon().getIconWidth()-tichuLabel.getIcon().getIconWidth())/2, 725, tichuLabel.getIcon().getIconWidth(), tichuLabel.getIcon().getIconHeight());
		tichuLabel.show(false);
		
		// Your turn label -------------------------------------------------------------------------------------------------
		yourTurn = new JLabel(Util.loadImageIcon("informative/it_is_your_turn.png"));
		yourTurn.setBounds(320, 725, yourTurn.getIcon().getIconWidth(), yourTurn.getIcon().getIconHeight());
		yourTurn.show(false);
		
		
		// Player displays -------------------------------------------------------------------------------------------------
		players[0] = new DisplayPlayer(bef,frame, 200, HEIGHT/2-100);
		players[1] = new DisplayPlayer(team,frame, WIDTH/2, 100);
		players[2] = new DisplayPlayer(next,frame, WIDTH-200, HEIGHT/2-100);
		
		frame.add(yourTurn,0);
		frame.add(grandLabel,0);
		frame.add(tichuLabel,0);
		
		frame.getContentPane().add(sendCards,0);
		frame.getContentPane().add(playCards,0);
		frame.getContentPane().add(fold,0);
		frame.getContentPane().add(tichu,0);
		frame.getContentPane().add(grandTichu,0);
		exchangePanel = new ExchangePanel(frame,WIDTH,HEIGHT);
		showExchange(false);
		//exchangePanel.setLeftCard(Card.BLACK_10);
		//exchangePanel.setMiddleCard(Card.DOG);
		//exchangePanel.setRightCard(Card.DRAGON);
		
		
		/*
		for(int i = 0; i<14; i++) {
			Main.gameHandler.getHand().addCard(Card.getByID(i+1));
		}
		Main.gameHandler.setState(GameState.EXCHANGE_PHASE);
		drawCards(Main.gameHandler.getHand());
		//h.setSelected(h.getCards().get(0));
		//*/
	}
	public void showSendCards(boolean show) {
		sendCards.show(show);
	}
	public void showExchange(boolean show) {
		exchangePanel.show(show);
	}
	public void showTichuButton(boolean show) {
		tichu.show(show);
	}
	public void showGrandTichuButton(boolean show) {
		grandTichu.show(show);
	}
	public void showFoldButton(boolean show) {
		fold.show(show);
	}
	public void showPlayCardsButton(boolean show) {
		playCards.show(show);
	}
	public void showTichuLabel(boolean show) {
		tichuLabel.show(show);
	}
	public void showGrandTichuLabel(boolean show) {
		grandLabel.show(show);
	}
	public void showYourTurnLabel(boolean show) {
		yourTurn.show(show);
	}
	public void drawCards(Hand hand) {
		for(JButton cb : cardButtons) {
			cb.show(false);
			frame.getContentPane().remove(cb);
		}
		cardButtons.clear();
		int pxInc = (WIDTH-((hand.size()-1)*(CARD_WIDTH-30)+CARD_WIDTH))/2;
		int idx = 15;
		for(Card c : hand.getCards()) {
			JButton ci = hand.getButon(c);
			ci.setBounds(pxInc, 830, CARD_WIDTH, CARD_HEIGHT);
			ci.setOpaque(false);
			ci.setFocusable(false);
			ci.setContentAreaFilled(false);
			ci.setBorderPainted(false);
			ci.show(true);
			
			pxInc+=CARD_WIDTH-30;
			cardButtons.add(ci);
			frame.getContentPane().add(ci,idx--);
		}
	}
	public Card[] getExchangeCards() {
		return exchangePanel.getSubmitedCards();
	}
	public  void exchanged() {
		exchangePanel.exchanged();
	}
}
