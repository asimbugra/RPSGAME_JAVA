import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RPSGameGUI extends JFrame implements ActionListener {
    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;
    private JLabel resultLabel;
    private JButton playAgainButton;

    public RPSGameGUI() {
        setTitle("Rock-Paper-Scissors Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700 , 900);

        // Oyunun düğmelerini oluştur
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");

        // Sonuç etiketini oluştur
        resultLabel = new JLabel("Make your choice!");

        // Tekrar oyna düğmesini oluştur
        playAgainButton = new JButton("Play again");

        // Pencereye bileşenleri ekle
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(rockButton);
        panel.add(playAgainButton);
        panel.add(scissorsButton);
        panel.add(resultLabel);
        panel.add(paperButton);




        add(panel);

        // Düğmeler için olay dinleyicileri ayarla
        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);
        playAgainButton.addActionListener(this);
    }

    // Olay dinleyicisi
    public void actionPerformed(ActionEvent e) {
        String userChoice = "";
        String computerChoice = "";
        String[] choices = {"rock", "paper", "scissors"};

        if (e.getSource() == rockButton) {
            userChoice = "rock";
        } else if (e.getSource() == paperButton) {
            userChoice = "paper";
        } else if (e.getSource() == scissorsButton) {
            userChoice = "scissors";
        } else if (e.getSource() == playAgainButton) {
            resultLabel.setText("Make your choice!");
            return;
        }

        Random random = new Random();
        computerChoice = choices[random.nextInt(choices.length)];

        // Oyun sonucunu hesapla
        if (userChoice.equals("rock")) {
            if (computerChoice.equals("paper")) {
                resultLabel.setText("Computer wins!");
            } else if (computerChoice.equals("scissors")) {
                resultLabel.setText("You win!");
            } else {
                resultLabel.setText("It's a tie!");
            }
        } else if (userChoice.equals("paper")) {
            if (computerChoice.equals("scissors")) {
                resultLabel.setText("Computer wins!");
            } else if (computerChoice.equals("rock")) {
                resultLabel.setText("You win!");
            } else {
                resultLabel.setText("It's a tie!");
            }
        } else if (userChoice.equals("scissors")) {
            if (computerChoice.equals("rock")) {
                resultLabel.setText("Computer wins!");
            } else if (computerChoice.equals("paper")) {
                resultLabel.setText("You win!");
            } else {
                resultLabel.setText("It's a tie!");
            }
        }

        // Sonuç etiketine kullanıcının ve bilgisayarın seçimini ekle
        resultLabel.setText(resultLabel.getText() + " You chose " + userChoice + " and the computer chose " + computerChoice);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RPSGameGUI game = new RPSGameGUI();
            game.setVisible(true);
        });
    }
}
