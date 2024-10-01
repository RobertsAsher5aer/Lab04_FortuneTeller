import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JTextArea fortuneDisplay;
    private ArrayList<String> fortunes;
    private String lastFortune = "";
    private Random random;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setFont(new Font("Serif", 0, 14));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        // Top panel
        JPanel topPanel = new JPanel();
        JLabel titleLabel = new JLabel("Fortune Teller", createImageIcon("/fTeller.jpg"), JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        // Middle panel
        JPanel middlePanel = new JPanel();
        fortuneDisplay = new JTextArea(10, 30);
        fortuneDisplay.setFont(new Font("Courier", Font.PLAIN, 24)); // Use Arial font
        fortuneDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneDisplay);
        middlePanel.add(scrollPane);
        add(middlePanel, BorderLayout.CENTER);



        // Bottom panel
        JPanel bottomPanel = new JPanel();
        JButton readFortuneButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");

        readFortuneButton.addActionListener((ActionEvent e) -> readFortune());
        quitButton.addActionListener((ActionEvent e) -> System.exit(0));

        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Initialize fortunes
        initializeFortunes();
        random = new Random();

        // Set frame size and center
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize((int) (screenSize.width * 0.75), (int) (screenSize.height * 0.75));
        setLocationRelativeTo(null);
    }

    private void initializeFortunes() {
        fortunes = new ArrayList<>();
        fortunes.add("You will find a great treasure.");
        fortunes.add("Something unfortunate will enter your life.");
        fortunes.add("Your shoes will be too loose today.");
        fortunes.add("You will become famous for something embarrassing.");
        fortunes.add("The universe is on your side.");
        fortunes.add("Beware of your dog.");
        fortunes.add("Your future is as bright as your smile.");
        fortunes.add("You will have an unexpected guest.");
        fortunes.add("Your computer will not explode.");
        fortunes.add("You will learn a valuable lesson soon.");
        fortunes.add("Happiness will find you.");
        fortunes.add("You will make a new friend today.");
        fortunes.add("You will fail your exam.");
        fortunes.add("You will ace your exam.");
        fortunes.add("It will snow on Halloween.");
        fortunes.add("You will lose your car keys.");
        fortunes.add("Gas prices will be lowered to $1.");
        fortunes.add("Your parents are keeping a secret from you.");
        fortunes.add("Your friends miss you.");
        fortunes.add("You will live to 100.");


    }

    private void readFortune() {
        String fortune;
        do {
            fortune = fortunes.get(random.nextInt(fortunes.size()));
        } while (fortune.equals(lastFortune));
        lastFortune = fortune;
        fortuneDisplay.append(fortune + "\n");
    }

    private ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            // Load the image
            ImageIcon icon = new ImageIcon(imgURL);
            // Resize the image
            Image scaledImage = icon.getImage().getScaledInstance(170, 140, Image.SCALE_SMOOTH); // Change width and height as needed
            return new ImageIcon(scaledImage);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }



    JLabel titleLabel = new JLabel("Fortune Teller", createImageIcon("/codeP.jpg"), JLabel.CENTER);

}
