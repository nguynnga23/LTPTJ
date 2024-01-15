package Exercise06;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileSplitter extends JFrame {

    private JProgressBar progressBar;
    private JButton splitButton;

    public FileSplitter() {
        setTitle("File Splitter");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        progressBar = new JProgressBar(0, 100);
        splitButton = new JButton("Split File");

        splitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                splitFile();
            }
        });

        JPanel panel = new JPanel();
        panel.add(progressBar);
        panel.add(splitButton);

        add(panel);
    }

    private void splitFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select File to Split");
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            split(selectedFile);
        }
    }

    private void split(File file) {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {
            int partNumber = 2;
            int bytesRead;
            byte[] buffer = new byte[1024 * 1024]; // 1 MB buffer size
            long fileSize = file.length();
            long totalBytesRead = 0;

            while ((bytesRead = in.read(buffer)) != -1) {
                String partFileName = file.getName() + ".part" + partNumber;
                try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(partFileName))) {
                    out.write(buffer, 0, bytesRead);
                }

                totalBytesRead += bytesRead;
                int progress = (int) ((totalBytesRead * 100) / fileSize);
                progressBar.setValue(progress);

                partNumber++;
            }

            JOptionPane.showMessageDialog(this, "File split successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while splitting the file.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileSplitter().setVisible(true);
            }
        });
    }
}