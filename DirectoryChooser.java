import javax.swing.*;
import java.awt.event.*;

public class DirectoryChooser extends JFrame implements ActionListener {

    private JLabel selectedFilesLabel;

    public DirectoryChooser() {
        // Set up the JFrame
        setTitle("Directory Chooser Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        // Set up the GUI components
        JButton chooseButton = new JButton("Choose Directory");
        chooseButton.addActionListener(this);
        selectedFilesLabel = new JLabel("No directory selected");

        // Add the components to the JFrame
        JPanel panel = new JPanel();
        panel.add(chooseButton);
        panel.add(selectedFilesLabel);
        add(panel);
    }

    public void actionPerformed(ActionEvent evt) {
        // Handle the button click
        if (evt.getActionCommand().equals("Choose Directory")) {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Choose Directory");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                selectedFilesLabel.setText("Selected directory: " + chooser.getSelectedFile().getAbsolutePath());
            } else {
                selectedFilesLabel.setText("No directory selected");
            }
        }
    }

    public static void main(String[] args) {
        DirectoryChooser example = new DirectoryChooser();
        example.setVisible(true);
    }
}

