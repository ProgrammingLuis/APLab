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
	
	/**
	 * Card button constants.
	 */
	
	private final int WIDTH = 64;
	private final int HEIGHT = 84;
	private final int Y = 36;
	
	private final Font TIMES_NEW_ROMAN_17 = new Font("Times New Roman", Font.PLAIN, 17);
	private final Font TIMES_NEW_ROMAN_19 = new Font("Times New Roman", Font.PLAIN, 19);
	
	private final Color WHITE = Color.WHITE;
	private final Color DARK_GREEN = new Color(0, 102, 51);
	
	private JButton cardButton_0 = new JButton();
	private JButton cardButton_1 = new JButton();
	private JButton cardButton_2 = new JButton();
	private JButton cardButton_3 = new JButton();
	private JButton cardButton_4 = new JButton();
	private JButton cardButton_5 = new JButton(); 			// card buttons
	private JButton cardButton_6 = new JButton();
	private JButton cardButton_7 = new JButton();
	private JButton cardButton_8 = new JButton();

	private JButton deckButton;
	
	/**
	 *  This makes it easier to use the buttons.
	 */
	
	JButton[] cardButtons = {cardButton_0, cardButton_1, cardButton_2, cardButton_3, cardButton_4, cardButton_5, cardButton_6, cardButton_7, cardButton_8};

	/**
	 * Create the frame and play the game :).
	 */
	public BoardDisplay() {
		
		setTitle("Elevens");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 868, 316);
		contentPane = new JPanel();
		contentPane.setBackground(DARK_GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setForeground(DARK_GREEN);
		panel.setBackground(DARK_GREEN);
		panel.setBounds(10, 23, 832, 263);
		panel.setLayout(null);
		contentPane.add(panel);
		
		
		createCardButton(cardButton_0, 32, 0);
		
		panel.add(cardButton_0);
		
		createCardButton(cardButton_1, 106, 1);
		
		panel.add(cardButton_1);
		
		createCardButton(cardButton_2, 185, 2);
		
		panel.add(cardButton_2);
		
		createCardButton(cardButton_3, 261, 3);
		
		panel.add(cardButton_3);
		
		createCardButton(cardButton_4, 335, 4);
		
		panel.add(cardButton_4);
		
		createCardButton(cardButton_5, 408, 5);
		
		panel.add(cardButton_5);
		
		createCardButton(cardButton_6, 482, 6);
		
		panel.add(cardButton_6);
		
		createCardButton(cardButton_7, 556, 7);
		
		panel.add(cardButton_7);
		
		createCardButton(cardButton_8, 630, 8);
		
		panel.add(cardButton_8);
		
		txtCardsLeft = new JTextField();
		txtCardsLeft.setForeground(WHITE);
		txtCardsLeft.setBackground(DARK_GREEN);
		txtCardsLeft.setFont(TIMES_NEW_ROMAN_17);
		txtCardsLeft.setText("Cards Left:" + board.deckSize());
		txtCardsLeft.setBounds(720, 124, 102, 42);
		panel.add(txtCardsLeft);
		txtCardsLeft.setColumns(10);
		txtCardsLeft.setEditable(false);
		
		txtCurrentSelection = new JTextField();
		txtCurrentSelection.setBackground(WHITE);
		txtCurrentSelection.setFont(TIMES_NEW_ROMAN_17);

		txtCurrentSelection.setText("Current Selection: ");
		txtCurrentSelection.setBounds(247, 131, 361, 31);
		panel.add(txtCurrentSelection);
		txtCurrentSelection.setColumns(10);
		txtCurrentSelection.setEditable(false);
		
		
		JButton newGameButton = new JButton("New Game");
		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				board.selectedCards.clear();
				txtCurrentSelection.setText("Current Selection: ");
				board.newGame();
				
				deckButton.setVisible(true);
				txtCardsLeft.setText("Cards Left:" + board.deckSize());
				
				for(int x = 0; x < 9; x++) {
					
					cardButtons[x].setVisible(true);
					cardButtons[x].setIcon(cardIcon(x));
					
				}
				
			}
		});
		newGameButton.setFont(TIMES_NEW_ROMAN_19);
		newGameButton.setBounds(356, 173, 138, 68);
		panel.add(newGameButton);
		
		deckButton = new JButton();
		deckButton.setIcon(new ImageIcon(BoardDisplay.class.getResource("/DeckOfCards/red_back.png")));
		deckButton.setIconTextGap(-20);
		deckButton.setMargin(new Insets(0, 0, 0, 0));
		deckButton.setBounds(740, 36, 64, 84);
		panel.add(deckButton);
		
	}
	
	/**
	 * 
	 * @param cardButton is the JButton for the card you want to create/edit
	 * @param x the xPos on the screen where you want the card JButton to appear.
	 * @param cardIndex Look at cardButtons[] to know cardIndex. This is important for the game. 
	 */
	
	private void createCardButton(JButton cardButton, int x, int cardIndex) {
		
		cardButton.setIconTextGap(-20);
		cardButton.setMargin(new Insets(0, 0, 0, 0));
		cardButton.setIcon(cardIcon(cardIndex));
		
		cardButton.setBounds(x, Y, WIDTH, HEIGHT);
		
		cardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				board.selectedCards.add(cardIndex);
				cardButton.setIcon(highlightedCard(cardIndex));
				txtCurrentSelection.setText("Current Selection: " + board.displaySelectedCards());
				game();
				
			}
		});
		
		
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
	
	/**
	 *  game logic + functionality with board 
	 */
	
	private void game() {
		
		if(board.isLegal(board.selectedCards)) {
			
			if(board.containsPairSum11(board.selectedCards)) {
				
				board.replaceSelectedCards(board.selectedCards);
				
				for(int x = 0; x < board.selectedCards.size(); x++) {
					
					if(board.cardAt(board.selectedCards.get(x)) == null){
						
						cardButtons[board.selectedCards.get(x)].setVisible(false);									
						
						} else {
							
							cardButtons[board.selectedCards.get(x)].setIcon(cardIcon(board.selectedCards.get(x)));
							
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
						
						cardButtons[board.selectedCards.get(x)].setVisible(false);
						
						} else {
							
							cardButtons[board.selectedCards.get(x)].setIcon(cardIcon(board.selectedCards.get(x)));
							
							}
					
					}
				
				board.selectedCards.clear();
				txtCurrentSelection.setText("Contained JQK!");
				txtCardsLeft.setText("Cards Left:" + board.deckSize());
			
				} 
		
		}
		
			if(!board.isLegal(board.selectedCards)) {
			
			for(int x = 0; x < board.selectedCards.size(); x++) {
				
				cardButtons[board.selectedCards.get(x)].setIcon(cardIcon(board.selectedCards.get(x)));
				
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
				
				deckButton.setVisible(false);
				
				}
			
		}
}

