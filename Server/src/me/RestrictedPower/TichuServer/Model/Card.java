package me.RestrictedPower.TichuServer.Model;
import javax.swing.ImageIcon;

public enum Card implements Comparable<Card>{
			DOG(0,"Dog",Color.OTHER,Type.DOG),
			MAHJONG(1,"Mahjong",Color.OTHER,Type.MAHJONG),
			
			BLACK_2(2,"Black Two",Color.BLACK,Type.TWO),
			BLUE_2(3,"Blue Two",Color.BLUE,Type.TWO),
			RED_2(4,"Red Two",Color.RED,Type.TWO),
			GREEN_2(5,"Green Two",Color.GREEN,Type.TWO),
			
			BLACK_3(6,"Black Three",Color.BLACK,Type.THREE),
			BLUE_3(7,"Blue Three",Color.BLUE,Type.THREE),
			RED_3(8,"Red Three",Color.RED,Type.THREE),
			GREEN_3(9,"Green Three",Color.GREEN,Type.THREE),
			
			BLACK_4(10,"Black Four",Color.BLACK,Type.FOUR),
			BLUE_4(11,"Blue Four",Color.BLUE,Type.FOUR),
			RED_4(12,"Red Four",Color.RED,Type.FOUR),
			GREEN_4(13,"Green Four",Color.GREEN,Type.FOUR),
			
			
			BLACK_5(14,"Black Five",Color.BLACK,Type.FIVE),
			BLUE_5(15,"Blue Five",Color.BLUE,Type.FIVE),
			RED_5(16,"Red Five",Color.RED,Type.FIVE),
			GREEN_5(17,"Green Five",Color.GREEN,Type.FIVE),
			
			
			BLACK_6(18,"Black Six",Color.BLACK,Type.SIX),
			BLUE_6(19,"Blue Six",Color.BLUE,Type.SIX),
			RED_6(20,"Red Six",Color.RED,Type.SIX),
			GREEN_6(21,"Green Six",Color.GREEN,Type.SIX),
			
			BLACK_7(22,"Black Seven",Color.BLACK,Type.SEVEN),
			BLUE_7(23,"Blue Seven",Color.BLUE,Type.SEVEN),
			RED_7(24,"Red Seven",Color.RED,Type.SEVEN),
			GREEN_7(25,"Green Seven",Color.GREEN,Type.SEVEN),
			
			
			BLACK_8(26,"Black Eight",Color.BLACK,Type.EIGHT),
			BLUE_8(27,"Blue Eight",Color.BLUE,Type.EIGHT),
			RED_8(28,"Red Eight",Color.RED,Type.EIGHT),
			GREEN_8(29,"Green Eight",Color.GREEN,Type.EIGHT),
			
			
			BLACK_9(30,"Black Nine",Color.BLACK,Type.NINE),
			BLUE_9(31,"Blue Nine",Color.BLUE,Type.NINE),
			RED_9(32,"Red Nine",Color.RED,Type.NINE),
			GREEN_9(33,"Green Nine",Color.GREEN,Type.NINE),
			
			
			BLACK_10(34,"Black Ten",Color.BLACK,Type.TEN),
			BLUE_10(35,"Blue Ten",Color.BLUE,Type.TEN),
			RED_10(36,"Red Ten",Color.RED,Type.TEN),
			GREEN_10(37,"Green Ten",Color.GREEN,Type.TEN),
			
			BLACK_J(38,"Black Jack",Color.BLACK,Type.JACK),
			BLUE_J(39,"Blue Jack",Color.BLUE,Type.JACK),
			RED_J(40,"Red Jack",Color.RED,Type.JACK),
			GREEN_J(41,"Green Jack",Color.GREEN,Type.JACK),
			
			BLACK_Q(42,"Black Queen",Color.BLACK,Type.QUEEN),
			BLUE_Q(43,"Blue Queen",Color.BLUE,Type.QUEEN),
			RED_Q(44,"Red Queen",Color.RED,Type.QUEEN),
			GREEN_Q(45,"Green Queen",Color.GREEN,Type.QUEEN),
			
			BLACK_K(46,"Black King",Color.BLACK,Type.KING),
			BLUE_K(47,"Blue King",Color.BLUE,Type.KING),
			RED_K(48,"Red King",Color.RED,Type.KING),
			GREEN_K(49,"Green King",Color.GREEN,Type.KING),
			
			BLACK_A(50,"Black Ace",Color.BLACK,Type.ACE),
			BLUE_A(51,"Blue Ace",Color.BLUE,Type.ACE),
			RED_A(52,"Red Ace",Color.RED,Type.ACE),
			GREEN_A(53,"Green Ace",Color.GREEN,Type.ACE),
			
			PHOENIX(54,"Phoenix",Color.OTHER,Type.PHOENIX),
			DRAGON(55,"Dragon",Color.OTHER,Type.DRAGON);
			
			public int id;
			public String name;
			public Color color;
			public Type type;
			Card(int id, String name,Color color,Type type){
				this.id = id;
				this.name = name;
				this.type = type;
				this.color = color;
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
