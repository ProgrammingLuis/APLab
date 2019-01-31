import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Insets;

public class BoardDisplay extends JFrame{
	
	/**
	 * Don't know what this if for.
	 */
	private static final long serialVersionUID = 1L;

	ElevensBoard board = new ElevensBoard();
	
	private JPanel contentPane;
	private JTextField txtCardsLeft;
	private JTextField txtCurrentSelection;
	private JButton btnNewButton_2;
	
	JButton[] buttons = new JButton[9];

	/**
	 * Create the frame and play the game :).
	 */
	public BoardDisplay() {
		
		setTitle("                                                                                                                           Elevens");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 868, 316);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setForeground(new Color(51, 102, 51));
		panel.setBackground(new Color(0, 102, 51));
		panel.setBounds(10, 23, 832, 263);
		contentPane.add(panel);
		
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton();	
		btnNewButton.setIconTextGap(-20);
		btnNewButton.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton.setIcon(cardIcon(0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				board.selectedCards.add(0);
				btnNewButton.setIcon(highlightedCard(0));
				txtCurrentSelection.setText("Current Selection: " + board.displaySelectedCards());
				game();
				
			}
		});
		btnNewButton.setBounds(32, 36, 64, 84);
		panel.add(btnNewButton);
		
		JButton button = new JButton();
		button.setIconTextGap(-20);
		button.setMargin(new Insets(0, 0, 0, 0));
		button.setIcon(cardIcon(1));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				board.selectedCards.add(1);
				button.setIcon(highlightedCard(1));
				txtCurrentSelection.setText("Current Selection: " + board.displaySelectedCards());
				game();
				
			}
		});
		button.setBounds(106, 36, 64, 84);
		panel.add(button);
		
		JButton button_1 = new JButton();
		button_1.setIconTextGap(-20);
		button_1.setMargin(new Insets(0, 0, 0, 0));
		button_1.setIcon(cardIcon(2));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				board.selectedCards.add(2);
				button_1.setIcon(highlightedCard(2));
				txtCurrentSelection.setText("Current Selection: " + board.displaySelectedCards());
				game();
				
			}
		});
		button_1.setBounds(185, 36, 64, 84);
		panel.add(button_1);
		
		JButton button_2 = new JButton();
		button_2.setIconTextGap(-20);
		button_2.setMargin(new Insets(0, 0, 0, 0));
		button_2.setIcon(cardIcon(3));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				board.selectedCards.add(3);
				button_2.setIcon(highlightedCard(3));
				txtCurrentSelection.setText("Current Selection: " + board.displaySelectedCards());
				game();
				
			}
		});
		button_2.setBounds(261, 36, 64, 84);
		panel.add(button_2);
		
		JButton button_3 = new JButton();
		button_3.setIconTextGap(-20);
		button_3.setMargin(new Insets(0, 0, 0, 0));
		button_3.setIcon(cardIcon(4));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				board.selectedCards.add(4);
				button_3.setIcon(highlightedCard(4));
				txtCurrentSelection.setText("Current Selection: " + board.displaySelectedCards());
				game();
				
			}
		});
		button_3.setBounds(335, 36, 64, 84);
		panel.add(button_3);
		
		JButton button_4 = new JButton();
		button_4.setIconTextGap(-20);
		button_4.setMargin(new Insets(0, 0, 0, 0));
		button_4.setIcon(cardIcon(5));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				board.selectedCards.add(5);
				button_4.setIcon(highlightedCard(5));
				txtCurrentSelection.setText("Current Selection: " + board.displaySelectedCards());
				game();
				
			}
		});
		button_4.setBounds(408, 36, 64, 84);
		panel.add(button_4);
		
		JButton button_5 = new JButton();
		button_5.setIconTextGap(-20);
		button_5.setMargin(new Insets(0, 0, 0, 0));
		button_5.setIcon(cardIcon(6));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				board.selectedCards.add(6);
				button_5.setIcon(highlightedCard(6));
				txtCurrentSelection.setText("Current Selection: " + board.displaySelectedCards());
				game();
				
			}
		});
		button_5.setBounds(482, 36, 64, 84);
		panel.add(button_5);
		
		JButton button_6 = new JButton();
		button_6.setIconTextGap(-20);
		button_6.setMargin(new Insets(0, 0, 0, 0));
		button_6.setIcon(cardIcon(7));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				board.selectedCards.add(7);
				button_6.setIcon(highlightedCard(7));
				txtCurrentSelection.setText("Current Selection: " + board.displaySelectedCards());
				game();
				
			}
		});
		button_6.setBounds(556, 36, 64, 84);
		panel.add(button_6);
		
		JButton button_7 = new JButton();
		button_7.setIconTextGap(-20);
		button_7.setMargin(new Insets(0, 0, 0, 0));
		button_7.setIcon(cardIcon(8));
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				board.selectedCards.add(8);
				button_7.setIcon(highlightedCard(8));
				txtCurrentSelection.setText("Current Selection: " + board.displaySelectedCards());
				game();
				
			}
		});
		button_7.setBounds(630, 36, 64, 84);
		panel.add(button_7);
		
		txtCardsLeft = new JTextField();
		txtCardsLeft.setForeground(new Color(255, 255, 255));
		txtCardsLeft.setBackground(new Color(51, 102, 51));
		txtCardsLeft.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtCardsLeft.setText("Cards Left:" + board.deckSize());
		txtCardsLeft.setBounds(720, 124, 102, 42);
		panel.add(txtCardsLeft);
		txtCardsLeft.setColumns(10);
		txtCardsLeft.setEditable(false);
		
		txtCurrentSelection = new JTextField();
		txtCurrentSelection.setBackground(Color.WHITE);
		txtCurrentSelection.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		txtCurrentSelection.setText("Current Selection: ");
		txtCurrentSelection.setBounds(247, 131, 361, 31);
		panel.add(txtCurrentSelection);
		txtCurrentSelection.setColumns(10);
		txtCurrentSelection.setEditable(false);
		
		buttons[0] = btnNewButton;
		buttons[1] = button;
		buttons[2] = button_1;
		buttons[3] = button_2;
		buttons[4] = button_3;			// This makes it easier to edit the buttons with cards.
		buttons[5] = button_4;
		buttons[6] = button_5;
		buttons[7] = button_6;
		buttons[8] = button_7;
		
		JButton btnNewButton_1 = new JButton("New Game");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				board.selectedCards.clear();
				txtCurrentSelection.setText("Current Selection: ");
				board.newGame();
				
				btnNewButton_2.setVisible(true);
				txtCardsLeft.setText("Cards Left:" + board.deckSize());
				
				for(int x = 0; x < 9; x++) {
					
					buttons[x].setVisible(true);
					buttons[x].setIcon(cardIcon(x));
					
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnNewButton_1.setBounds(356, 173, 138, 68);
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton();
		btnNewButton_2.setIcon(new ImageIcon(BoardDisplay.class.getResource("/DeckOfCards/red_back.png")));
		btnNewButton_2.setIconTextGap(-20);
		btnNewButton_2.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton_2.setBounds(740, 36, 64, 84);
		panel.add(btnNewButton_2);
		
	}
	
	
	/**
	 *  game logic + functionality with board 
	 */
	
	public void game() {
		
		if(board.isLegal(board.selectedCards)) {
			
			if(board.containsPairSum11(board.selectedCards)) {
				
				board.replaceSelectedCards(board.selectedCards);
				
				for(int x = 0; x < board.selectedCards.size(); x++) {
					
					if(board.cardAt(board.selectedCards.get(x)) == null){
						
						buttons[board.selectedCards.get(x)].setVisible(false);									
						
						} else {
							
							buttons[board.selectedCards.get(x)].setIcon(cardIcon(board.selectedCards.get(x)));
							
							}
					
					
					
					}
	
				board.selectedCards.clear();
				txtCurrentSelection.setText("Sum is 11!");
				txtCardsLeft.setText("Cards Left:" + board.deckSize());
				
			}
		
			if(board.containsJQK(board.selectedCards)) {
			
				board.replaceSelectedCards(board.selectedCards);
				
				for(int x = 0; x < board.selectedCards.size(); x++) {
					
					if(board.cardAt(board.selectedCards.get(x)) == null){
						
						buttons[board.selectedCards.get(x)].setVisible(false);
						
						} else {
							
							buttons[board.selectedCards.get(x)].setIcon(cardIcon(board.selectedCards.get(x)));
							
							}
					
					}
				
				board.selectedCards.clear();
				txtCurrentSelection.setText("Contained JQK!");
				txtCardsLeft.setText("Cards Left:" + board.deckSize());
			
				} 
		
		}
		
			if(!board.isLegal(board.selectedCards)) {
			
			for(int x = 0; x < board.selectedCards.size(); x++) {
				
				buttons[board.selectedCards.get(x)].setIcon(cardIcon(board.selectedCards.get(x)));
				
			}
				
			board.selectedCards.clear();
			
			txtCurrentSelection.setText("No possible pairs or JQK.");
			
			}
			
			if(board.isEmpty()) {
				
				txtCurrentSelection.setText("You win!");
				
			}
			
			if(board.deckSize() > 0) {if(!board.anotherPlayIsPossible()) {
				
				txtCurrentSelection.setText("Game over! You had " + board.deckSize() + " cards left.");
				
			}}
			
			if(board.deckSize() == 0) {
				
				btnNewButton_2.setVisible(false);
				
				}
			
			}
			
		}
	
	/**
	 * 
	 * @param x is the position of the card in the dealt hand
	 * @return the image of the card in the xth position
	 */
	
	private ImageIcon cardIcon(int x) {
		
		ImageIcon icon;
		
		icon = new ImageIcon(BoardDisplay.class.getResource("/DeckOfCards/" + board.cardAt(x).toString() + ".png"));
		
		return icon;
		
	}
	
	private ImageIcon highlightedCard(int x) {
		
		ImageIcon icon;
		
		icon = new ImageIcon(BoardDisplay.class.getResource("/HighlightedDeck/" + board.cardAt(x).toString() + "H.png"));
		
		return icon;
		
	}
	
}

