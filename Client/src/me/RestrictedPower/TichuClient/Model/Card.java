package me.RestrictedPower.TichuClient.Model;
import javax.swing.ImageIcon;
import me.RestrictedPower.TichuClient.Util;

public enum Card implements Comparable<Card>{
			DOG(0,"Dog",Color.OTHER,Type.DOG,Util.loadImageIcon("cards/dog.png")),
			MAHJONG(1,"Mahjong",Color.OTHER,Type.MAHJONG,Util.loadImageIcon("cards/mahjong.png")),
			
			BLACK_2(2,"Black Two",Color.BLACK,Type.TWO,Util.loadImageIcon("cards/2_BLACK.png")),
			BLUE_2(3,"Blue Two",Color.BLUE,Type.TWO,Util.loadImageIcon("cards/2_BLUE.png")),
			RED_2(4,"Red Two",Color.RED,Type.TWO,Util.loadImageIcon("cards/2_RED.png")),
			GREEN_2(5,"Green Two",Color.GREEN,Type.TWO,Util.loadImageIcon("cards/2_GREEN.png")),
			
			BLACK_3(6,"Black Three",Color.BLACK,Type.THREE,Util.loadImageIcon("cards/3_BLACK.png")),
			BLUE_3(7,"Blue Three",Color.BLUE,Type.THREE,Util.loadImageIcon("cards/3_BLUE.png")),
			RED_3(8,"Red Three",Color.RED,Type.THREE,Util.loadImageIcon("cards/3_RED.png")),
			GREEN_3(9,"Green Three",Color.GREEN,Type.THREE,Util.loadImageIcon("cards/3_GREEN.png")),
			
			BLACK_4(10,"Black Four",Color.BLACK,Type.FOUR,Util.loadImageIcon("cards/4_BLACK.png")),
			BLUE_4(11,"Blue Four",Color.BLUE,Type.FOUR,Util.loadImageIcon("cards/4_BLUE.png")),
			RED_4(12,"Red Four",Color.RED,Type.FOUR,Util.loadImageIcon("cards/4_RED.png")),
			GREEN_4(13,"Green Four",Color.GREEN,Type.FOUR,Util.loadImageIcon("cards/4_GREEN.png")),
			
			
			BLACK_5(14,"Black Five",Color.BLACK,Type.FIVE,Util.loadImageIcon("cards/5_BLACK.png")),
			BLUE_5(15,"Blue Five",Color.BLUE,Type.FIVE,Util.loadImageIcon("cards/5_BLUE.png")),
			RED_5(16,"Red Five",Color.RED,Type.FIVE,Util.loadImageIcon("cards/5_RED.png")),
			GREEN_5(17,"Green Five",Color.GREEN,Type.FIVE,Util.loadImageIcon("cards/5_GREEN.png")),
			
			
			BLACK_6(18,"Black Six",Color.BLACK,Type.SIX,Util.loadImageIcon("cards/6_BLACK.png")),
			BLUE_6(19,"Blue Six",Color.BLUE,Type.SIX,Util.loadImageIcon("cards/6_BLUE.png")),
			RED_6(20,"Red Six",Color.RED,Type.SIX,Util.loadImageIcon("cards/6_RED.png")),
			GREEN_6(21,"Green Six",Color.GREEN,Type.SIX,Util.loadImageIcon("cards/6_GREEN.png")),
			
			BLACK_7(22,"Black Seven",Color.BLACK,Type.SEVEN,Util.loadImageIcon("cards/7_BLACK.png")),
			BLUE_7(23,"Blue Seven",Color.BLUE,Type.SEVEN,Util.loadImageIcon("cards/7_BLUE.png")),
			RED_7(24,"Red Seven",Color.RED,Type.SEVEN,Util.loadImageIcon("cards/7_RED.png")),
			GREEN_7(25,"Green Seven",Color.GREEN,Type.SEVEN,Util.loadImageIcon("cards/7_GREEN.png")),
			
			
			BLACK_8(26,"Black Eight",Color.BLACK,Type.EIGHT,Util.loadImageIcon("cards/8_BLACK.png")),
			BLUE_8(27,"Blue Eight",Color.BLUE,Type.EIGHT,Util.loadImageIcon("cards/8_BLUE.png")),
			RED_8(28,"Red Eight",Color.RED,Type.EIGHT,Util.loadImageIcon("cards/8_RED.png")),
			GREEN_8(29,"Green Eight",Color.GREEN,Type.EIGHT,Util.loadImageIcon("cards/8_GREEN.png")),
			
			
			BLACK_9(30,"Black Nine",Color.BLACK,Type.NINE,Util.loadImageIcon("cards/9_BLACK.png")),
			BLUE_9(31,"Blue Nine",Color.BLUE,Type.NINE,Util.loadImageIcon("cards/9_BLUE.png")),
			RED_9(32,"Red Nine",Color.RED,Type.NINE,Util.loadImageIcon("cards/9_RED.png")),
			GREEN_9(33,"Green Nine",Color.GREEN,Type.NINE,Util.loadImageIcon("cards/9_GREEN.png")),
			
			
			BLACK_10(34,"Black Ten",Color.BLACK,Type.TEN,Util.loadImageIcon("cards/10_BLACK.png")),
			BLUE_10(35,"Blue Ten",Color.BLUE,Type.TEN,Util.loadImageIcon("cards/10_BLUE.png")),
			RED_10(36,"Red Ten",Color.RED,Type.TEN,Util.loadImageIcon("cards/10_RED.png")),
			GREEN_10(37,"Green Ten",Color.GREEN,Type.TEN,Util.loadImageIcon("cards/10_GREEN.png")),
			
			BLACK_J(38,"Black Jack",Color.BLACK,Type.JACK,Util.loadImageIcon("cards/J_BLACK.png")),
			BLUE_J(39,"Blue Jack",Color.BLUE,Type.JACK,Util.loadImageIcon("cards/J_BLUE.png")),
			RED_J(40,"Red Jack",Color.RED,Type.JACK,Util.loadImageIcon("cards/J_RED.png")),
			GREEN_J(41,"Green Jack",Color.GREEN,Type.JACK,Util.loadImageIcon("cards/J_GREEN.png")),
			
			BLACK_Q(42,"Black Queen",Color.BLACK,Type.QUEEN,Util.loadImageIcon("cards/Q_BLACK.png")),
			BLUE_Q(43,"Blue Queen",Color.BLUE,Type.QUEEN,Util.loadImageIcon("cards/Q_BLUE.png")),
			RED_Q(44,"Red Queen",Color.RED,Type.QUEEN,Util.loadImageIcon("cards/Q_RED.png")),
			GREEN_Q(45,"Green Queen",Color.GREEN,Type.QUEEN,Util.loadImageIcon("cards/Q_GREEN.png")),
			
			BLACK_K(46,"Black King",Color.BLACK,Type.KING,Util.loadImageIcon("cards/K_BLACK.png")),
			BLUE_K(47,"Blue King",Color.BLUE,Type.KING,Util.loadImageIcon("cards/K_BLUE.png")),
			RED_K(48,"Red King",Color.RED,Type.KING,Util.loadImageIcon("cards/K_RED.png")),
			GREEN_K(49,"Green King",Color.GREEN,Type.KING,Util.loadImageIcon("cards/K_GREEN.png")),
			
			BLACK_A(50,"Black Ace",Color.BLACK,Type.ACE,Util.loadImageIcon("cards/A_BLACK.png")),
			BLUE_A(51,"Blue Ace",Color.BLUE,Type.ACE,Util.loadImageIcon("cards/A_BLUE.png")),
			RED_A(52,"Red Ace",Color.RED,Type.ACE,Util.loadImageIcon("cards/A_RED.png")),
			GREEN_A(53,"Green Ace",Color.GREEN,Type.ACE,Util.loadImageIcon("cards/A_GREEN.png")),
			
			PHOENIX(54,"Phoenix",Color.OTHER,Type.PHOENIX,Util.loadImageIcon("cards/phoenix.png")),
			DRAGON(55,"Dragon",Color.OTHER,Type.DRAGON,Util.loadImageIcon("cards/dragon.png"));
			
			public int id;
			public String name;
			public Color color;
			public Type type;
			public ImageIcon image;
			Card(int id, String name,Color color,Type type, ImageIcon image){
				this.id = id;
				this.name = name;
				this.type = type;
				this.color = color;
				this.image = image;
			}
			public static Card getByName(String name){
				for(Card card : Card.values()) if(card.name==name) return card;
				return null;
			}
			public static Card getByID(int id){
				for(Card card : Card.values()) if(card.id==id) return card;
				return null;
			}
}
