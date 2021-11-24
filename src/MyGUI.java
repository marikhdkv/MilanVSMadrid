import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyGUI extends JFrame
{
    private JButton buttonMilan = new JButton("AC Milan");
    private JButton buttonMadrid = new JButton("Real Madrid");
    private JLabel result = new JLabel("Result: 0 X 0");
    private JLabel lastScorer = new JLabel("Last Scorer: N/A");
    private Label winner = new Label("Winner: DRAW");

    int milanScore = 0, madridScore = 0;

    public MyGUI()
    {
        super("Score Table");
        this.setBounds(650, 400, 750, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Закрытие формы

        Container container = this.getContentPane();            // Наша форма
        container.setLayout(new GridLayout(1, 5, 10, 2));
        container.add(result);
        container.add(lastScorer);
        container.add(winner);

        buttonMilan.addActionListener(new ButtonEventListener("AC Milan"));
        container.add(buttonMilan);
        buttonMadrid.addActionListener(new ButtonEventListener("Real Madrid"));
        container.add(buttonMadrid);
    }

    public class ButtonEventListener implements ActionListener
    {
        private String team;

        ButtonEventListener(String team)
        {
            this.team = team;
        }
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (team.equals("AC Milan"))
                ++milanScore;
            else if (team.equals("Real Madrid"))
                ++madridScore;
            else
                try
                {
                    throw new Exception("Error team name");
                } catch (Exception ex)
                {
                    ex.printStackTrace();
                }

            lastScorer.setText("Last Scorer: " + team);
            result.setText("Result: " + milanScore + " X " + madridScore);
            if (milanScore > madridScore)
                winner.setText("Winner: AC Milan");
            else if (milanScore < madridScore)
                winner.setText("Winner: Real Madrid");
            else
                winner.setText("Winner: DRAW");
        }
    }
}