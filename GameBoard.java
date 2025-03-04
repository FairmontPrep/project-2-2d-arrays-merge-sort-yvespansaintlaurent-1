import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class GameBoard extends JFrame {
    public int SIZE = 8;
    private JPanel[][] squares = new JPanel[SIZE][SIZE]; // 2D array for board
    private String[][] piecesArray; //2D array = image::HP::board position

    public GameBoard() {
        setTitle("Poke Board");
        setSize(750, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(SIZE, SIZE)); // Use GridLayout for the board layout

        // Initialize the 2D array of panels
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                squares[row][col] = new JPanel();
                if ((row + col) % 2 == 0) {
                    squares[row][col].setBackground(new Color(255, 251, 240)); // Color black for even squares
                } else {
                    squares[row][col].setBackground(Color.LIGHT_GRAY); // Color dark gray for odd squares
                }
                add(squares[row][col]); // Add each square to the board
            }
        }

        // Initialize Pokémon pieces array
        piecesArray = new String[32][3];  //your array should be at least 2 columns
        loadPieces();
        for (int i = 0; i < piecesArray.length; i++) {
            for (int j = 0; j < piecesArray[i].length; j++) {
                System.out.println("piecesArray[" + i + "][" + j + "] = " + piecesArray[i][j]);
            }
        }

        // Initially populate the board with pieces
        populateBoard();
    }

    public JPanel[][] sortImages(JPanel[][] finalPositions) {
        Arrays.sort(piecesArray, new Comparator<String[]>() {
            @Override
           
            public int compare(String[] piece1, String[] piece2) {
                return Integer.compare(Integer.parseInt(piece1[2]), Integer.parseInt(piece2[2]));
            }
        });
       
        return finalPositions;
    }

    private void populateBoard() {
        int pieceRow = 0; //keeps track of number of images by row should be minimum of 32
        int squareName =0; //all squares are numbered 1-64 top left is 1, bottom right is 64
       
        squares=sortImages(squares);

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                int pokePosition = Integer.parseInt(piecesArray[pieceRow][2]);
           
                if(squareName == pokePosition){
                    String imagePath = piecesArray[pieceRow][0];  //save the file name to a string variable
                    String hpText = piecesArray[pieceRow][1]; //save the hp value to a string variable

                    ImageIcon icon = new ImageIcon(imagePath);
                    Image scaledImage = icon.getImage().getScaledInstance(40, 42, Image.SCALE_SMOOTH);

                    JLabel pieceLabel = new JLabel(new ImageIcon(scaledImage));
                    JLabel textLabel = new JLabel(hpText, SwingConstants.CENTER);
                    textLabel.setForeground(Color.BLACK); // Make text black and center bottom
                    System.out.println("adding 1 piece:" + hpText);
                    JPanel piecePanel = new JPanel(new BorderLayout());
                    piecePanel.setOpaque(false); // false sets img bg transparent, image must already be a transparent png
                    piecePanel.add(pieceLabel, BorderLayout.CENTER);
                    piecePanel.add(textLabel, BorderLayout.SOUTH);

                    squares[row][col].setLayout(new BorderLayout());
                    squares[row][col].add(piecePanel, BorderLayout.CENTER);
               
               
                    if (pieceRow < piecesArray.length - 1) {
                        pieceRow++;
                    }
                }
                squareName++;
            }
        }

        revalidate(); // Ensure layout updates
        repaint(); // Refresh view
    }

    private void loadPieces() {
        piecesArray[0][0]="arceus.png"; piecesArray[0][1]="HP:560"; piecesArray[0][2]="26";
        piecesArray[1][0]="bisharp.png"; piecesArray[1][1]="HP:193"; piecesArray[1][2]="14";
        piecesArray[2][0]="blastoise.png"; piecesArray[2][1]="HP:201"; piecesArray[2][2]="19";
        piecesArray[3][0]="blaziken.png"; piecesArray[3][1]="HP:177"; piecesArray[3][2]="31";
        piecesArray[4][0]="centiskorch.png"; piecesArray[4][1]="HP:275"; piecesArray[4][2]="22";
        piecesArray[5][0]="charizard.png"; piecesArray[5][1]="HP:185"; piecesArray[5][2]="8";
        piecesArray[6][0]="darkrai.png"; piecesArray[6][1]="HP:300"; piecesArray[6][2]="9";
        piecesArray[7][0]="Electivire.png"; piecesArray[7][1]="HP:260"; piecesArray[7][2]="13";
        piecesArray[8][0]="gallade.png"; piecesArray[8][1]="HP:220"; piecesArray[8][2]="25";
        piecesArray[9][0]="Garchomp.png"; piecesArray[9][1]="HP:275"; piecesArray[9][2]="12";
        piecesArray[10][0]="Gastrodon.png"; piecesArray[10][1]="HP:156"; piecesArray[10][2]="5";
        piecesArray[11][0]="gengar.png"; piecesArray[11][1]="HP:198"; piecesArray[11][2]="2";
        piecesArray[12][0]="greninja.png"; piecesArray[12][1]="HP:175"; piecesArray[12][2]="4";
        piecesArray[13][0]="gyrados.png"; piecesArray[13][1]="HP:213"; piecesArray[13][2]="17";
        piecesArray[14][0]="Infernape.png"; piecesArray[14][1]="HP:185"; piecesArray[14][2]="20";
        piecesArray[15][0]="krookodile.png"; piecesArray[15][1]="HP:183"; piecesArray[15][2]="15";
        piecesArray[16][0]="lucario.png"; piecesArray[16][1]="HP:200"; piecesArray[16][2]="1";
        piecesArray[17][0]="Luxray.png"; piecesArray[17][1]="HP:145"; piecesArray[17][2]="11";
        piecesArray[18][0]="lycanroc.png"; piecesArray[18][1]="HP:290"; piecesArray[18][2]="27";
        piecesArray[19][0]="machamp.png"; piecesArray[19][1]="HP:145"; piecesArray[19][2]="28";
        piecesArray[20][0]="pikachu.png"; piecesArray[20][1]="HP:134"; piecesArray[20][2]="18";
        piecesArray[21][0]="piplup.png"; piecesArray[21][1]="HP:45"; piecesArray[21][2]="0";
        piecesArray[22][0]="regigigas.png"; piecesArray[22][1]="HP:400"; piecesArray[22][2]="23";
        piecesArray[23][0]="sceptile.png"; piecesArray[23][1]="HP:168"; piecesArray[23][2]="29";
        piecesArray[24][0]="snorlax.png"; piecesArray[24][1]="HP:250"; piecesArray[24][2]="3";
        piecesArray[25][0]="swampert.png"; piecesArray[25][1]="HP:295"; piecesArray[25][2]="30";
        piecesArray[26][0]="Togekiss.png"; piecesArray[26][1]="HP:190"; piecesArray[26][2]="10";
        piecesArray[27][0]="torterra.png"; piecesArray[27][1]="HP:185"; piecesArray[27][2]="21";
        piecesArray[28][0]="Toxicroak.png"; piecesArray[28][1]="HP:160"; piecesArray[28][2]="16";
        piecesArray[29][0]="tyranitar.png"; piecesArray[29][1]="HP:225"; piecesArray[29][2]="7";
        piecesArray[30][0]="venusaur.png"; piecesArray[30][1]="HP:234"; piecesArray[30][2]="24";
        piecesArray[31][0]="zekrom.png"; piecesArray[31][1]="HP:430"; piecesArray[31][2]="6";
        
       
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameBoard board = new GameBoard();
            board.setVisible(true);
        });
    }
}

//resubmittion