package mosque;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Mosque {
    public static void main(String[] args) {
        // Create JFrame
        JFrame frame = new JFrame("مواعيد الأذان");
        frame.setSize(400, 290);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout()); // Use BorderLayout for proper positioning
        frame.setLocationRelativeTo(null);
        //MY EDIT

        // Load images
        ImageIcon icon1 = new ImageIcon("mosque1.jpg");

        // Create JLabel for the image
        JLabel label = new JLabel(icon1);
        label.setHorizontalAlignment(JLabel.CENTER); // Center the image
        frame.add(label, BorderLayout.CENTER); // Place it in the center

        // Create a JPanel for the moving news bar
        JPanel newsPanel = new JPanel(null); // Null layout for manual positioning
        newsPanel.setBackground(Color.BLACK);
        newsPanel.setPreferredSize(new Dimension(frame.getWidth(), 40)); // Set panel height

        // Create JLabel for the news text
        JLabel newsLabel = new JLabel("اشهد ان لا اله الا الله وان محمد عبده ورسوله   . اشهد ان لا اله الا الله وان محمد عبده ورسوله.   اشهد ان لا اله الا الله وان محمد عبده ورسوله.");
        newsLabel.setForeground(Color.WHITE);
        newsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        newsPanel.add(newsLabel);
        frame.add(newsPanel, BorderLayout.SOUTH); // Place at the bottom

        JLabel name = new JLabel("جامع ال عمران");
        name.setForeground(Color.orange);
        name.setFont(new Font("san",Font.BOLD, 16));
        name.setBounds(145, 5, 100, 30);
        label.add(name);
        
        JLabel aya = new JLabel("(إِنَّ الصَّلاةَ كَانَتْ عَلَى الْمُؤْمِنِينَ كِتَاباً مَوْقُوتاً).");
        aya.setForeground(Color.orange);
        aya.setFont(new Font("san",Font.BOLD, 18));
        aya.setBounds(60, 100, 300, 30);
        label.add(aya);
        
        JLabel dateLabel = new JLabel();
        dateLabel.setForeground(Color.white);
        dateLabel.setBounds(0, -40, 100, 100);
        dateLabel.setFont(new Font("Arial", Font.BOLD, 14));
        label.add(dateLabel);

        // Array of verses to cycle through
        String[] verses = {
            "(إِنَّ الصَّلاةَ كَانَتْ عَلَى الْمُؤْمِنِينَ كِتَاباً مَوْقُوتاً).",
            "(وَأَقِمِ الصَّلَاةَ لِذِكْرِي).             ",
            "(إِنَّمَا يَعْمُرُ مَسَاجِدَ اللَّهِ مَنْ آمَنَ بِاللَّهِ وَالْيَوْمِ الْآخِرِ).",
            "(قَدْ أَفْلَحَ مَن تَزَكَّىٰ * وَذَكَرَ ٱسْمَ رَبِّهِۦ فَصَلَّىٰ)."
        };

        // Index to track the current verse
        final int[] verseIndex = {0};

        // Timer to update the date and aya text every minute (60,000 ms)
        Timer timer = new Timer(6000, e -> {
            // Update date label
            String currentDate = new SimpleDateFormat("dd MMMM yyyy").format(new Date());
            dateLabel.setText(currentDate);

            // Update the aya text
            aya.setText(verses[verseIndex[0]]);

            // Cycle through verses
            verseIndex[0] = (verseIndex[0] + 1) % verses.length;
        });

        // Run once immediately before starting the timer
        String initialDate = new SimpleDateFormat("dd MMMM yyyy").format(new Date());
        dateLabel.setText(initialDate);

        // Set the initial aya text
        aya.setText(verses[0]);

        timer.start();

        JLabel time = new JLabel();
        time.setFont(new Font("Arial", Font.BOLD, 40));
        time.setBounds(110, 40, 250, 50);
        time.setForeground(Color.white);
        label.add(time);

        // Timer to update time every second
        Timer t = new Timer(1000, e -> {
            // Get current time
            String currentTime = new SimpleDateFormat("hh:mm:ss").format(new Date());
            time.setText(currentTime);
        });
        t.start(); // Start the timer
        
        JLabel fajr = new JLabel("فجر");
        JLabel fajrtime = new JLabel("6:01");
        fajr.setForeground(Color.white);
        fajr.setFont(new Font("san",Font.BOLD, 18));
        fajr.setBounds(330, 140, 100, 30);
        fajrtime.setForeground(Color.white);
        fajrtime.setFont(new Font("san",Font.BOLD, 18));
        fajrtime.setBounds(325, 165, 100, 30);
        label.add(fajr);
        label.add(fajrtime);
        
        JLabel shrouq = new JLabel("شروق");
        JLabel shrouqtime = new JLabel("7:25");
        shrouq.setForeground(Color.white);
        shrouq.setFont(new Font("san",Font.BOLD, 18));
        shrouq.setBounds(270, 140, 100, 30);
        shrouqtime.setForeground(Color.white);
        shrouqtime.setFont(new Font("san",Font.BOLD, 18));
        shrouqtime.setBounds(270, 165, 100, 30);
        label.add(shrouq);
        label.add(shrouqtime);
        
        JLabel duhr = new JLabel("ظهر");
        JLabel duhrtime = new JLabel("1:21");
        duhr.setForeground(Color.white);
        duhr.setFont(new Font("san",Font.BOLD, 18));
        duhr.setBounds(215, 140, 100, 30);
        duhrtime.setForeground(Color.white);
        duhrtime.setFont(new Font("san",Font.BOLD, 18));
        duhrtime.setBounds(210, 165, 100, 30);
        label.add(duhr);
        label.add(duhrtime);
        
        JLabel asr = new JLabel("عصر");
        JLabel asrtime = new JLabel("4:38");
        asr.setForeground(Color.white);
        asr.setFont(new Font("san",Font.BOLD, 18));
        asr.setBounds(150, 140, 100, 30);
        asrtime.setForeground(Color.white);
        asrtime.setFont(new Font("san",Font.BOLD, 18));
        asrtime.setBounds(150, 165, 100, 30);
        label.add(asr);
        label.add(asrtime);
        
        JLabel maghreb = new JLabel("مغرب");
        JLabel maghrebtime = new JLabel("7:14");
        maghreb.setForeground(Color.white);
        maghreb.setFont(new Font("san",Font.BOLD, 18));
        maghreb.setBounds(90, 140, 100, 30);
        maghrebtime.setForeground(Color.white);
        maghrebtime.setFont(new Font("san",Font.BOLD, 18));
        maghrebtime.setBounds(90, 165, 100, 30);
        label.add(maghreb);
        label.add(maghrebtime);
        
        JLabel isha = new JLabel("عشاء");
        JLabel ishatime = new JLabel("8:33");
        isha.setForeground(Color.white);
        isha.setFont(new Font("san",Font.BOLD, 18));
        isha.setBounds(30, 140, 100, 30);
        ishatime.setForeground(Color.white);
        ishatime.setFont(new Font("san",Font.BOLD, 18));
        ishatime.setBounds(30, 165, 100, 30);
        label.add(isha);
        label.add(ishatime);

        // Animation variables
        int frameWidth = frame.getWidth();
        int labelWidth = newsLabel.getPreferredSize().width;
        final int[] xPos = {frameWidth};

        // Timer for smooth scrolling effect
        new Timer(20, e -> {
            xPos[0] -= 2; // Move left
            if (xPos[0] + labelWidth < 0) xPos[0] = frameWidth; // Reset position
            newsLabel.setBounds(xPos[0], 10, labelWidth, 30);
        }).start();
        
        frame.setVisible(true);
    }
}
