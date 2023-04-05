import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextEditor extends JFrame implements ActionListener {

    JTextArea textarea;
    JScrollPane scrollpane;

    public TextEditor() {

        super("Text Editor");
        setSize(500, 500);

        textarea = new JTextArea();
        scrollpane = new JScrollPane(textarea);
        getContentPane().add(scrollpane, BorderLayout.CENTER);

        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem newfile = new JMenuItem("New");
        newfile.addActionListener(this);
        JMenuItem openfile = new JMenuItem("Open");
        openfile.addActionListener(this);
        JMenuItem savefile = new JMenuItem("Save");
        savefile.addActionListener(this);
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(this);

        JMenu edit = new JMenu("Edit");
        JMenuItem cut = new JMenuItem("Cut");
        cut.addActionListener(this);
        JMenuItem copy = new JMenuItem("Copy");
        copy.addActionListener(this);
        JMenuItem paste = new JMenuItem("Paste");
        paste.addActionListener(this);

        file.add(newfile);
        file.add(openfile);
        file.add(savefile);
        file.addSeparator();
        file.add(exit);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);

        menubar.add(file);
        menubar.add(edit);
        setJMenuBar(menubar);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String s = e.getActionCommand();

        if (s.equals("New")) {
            textarea.setText("");
        }

        else if (s.equals("Open")) {
            JFileChooser chooser = new JFileChooser();
            int option = chooser.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile().getPath()));
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        textarea.append(line + "\n");
                    }
                    reader.close();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        else if (s.equals("Save")) {
            JFileChooser chooser = new JFileChooser();
            int option = chooser.showSaveDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(chooser.getSelectedFile().getPath()));
                    textarea.write(writer);
                    writer.close();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        else if (s.equals("Exit")) {
            System.exit(0);
        }

        else if (s.equals("Cut")) {
            textarea.cut();
        }

        else if (s.equals("Copy")) {
            textarea.copy();
        }

        else if (s.equals("Paste")) {
            textarea.paste();
        }

    }

    public static void main(String[] args) {
        new TextEditor();
    }

}
