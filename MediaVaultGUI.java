import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The graphical user interface for the MediaVault tracker system.
 * This class shows the main window and basic buttons for the media library
 *
 * @author DIAMITAS_FLORES
 */
public class MediaVaultGUI extends JFrame
{
    private UserProfile user;
    private MediaFileManager fileManager;

    private JPanel contentPanel;
    private JTextArea displayArea;

    private JButton addAnimeButton;
    private JButton addMovieButton;
    private JButton addBoardGameButton;
    private JButton displayButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton clearButton;
    private JButton getStartedButton;

    private final Color BACKGROUND_COLOR = new Color(0x111111);
    private final Color SIDEBAR_COLOR = new Color(0x202020);
    private final Color CARD_COLOR = new Color(0x1A1A1A);
    private final Color MAIN_COLOR = new Color(0x1F7A4D);
    private final Color SECONDARY_COLOR = new Color(0x303030);
    private final Color DANGER_COLOR = new Color(0x6B1E1E);
    private final Color TEXT_COLOR = new Color(0xF2F2F2);
    private final Color SUBTEXT_COLOR = new Color(0xCFCFCF);



    /**
     * creates the MediaVault GUI window.
     */
    public MediaVaultGUI()
    {
        String username = JOptionPane.showInputDialog(null, "Enter username:");

        if (username == null || username.trim().equals(""))
        {
            username = "User";
        }

        user = new UserProfile(username);
        fileManager = new MediaFileManager();

        setTitle("MediaVault - " + user.getUsername());
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setupLayout();
        setupButtonActions();
    }

    /**
     * sets up the main layout and design of the GUI.
     */

    private void setupLayout()
    {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);

        JPanel sidebarPanel = new JPanel(new GridLayout(9, 1, 0, 10));
        sidebarPanel.setBackground(SIDEBAR_COLOR);
        sidebarPanel.setBorder(BorderFactory.createEmptyBorder(35, 15, 180, 15));
        sidebarPanel.setPreferredSize(new Dimension(230, 650));

        addAnimeButton = new RoundedButton("ADD ANIME", SECONDARY_COLOR);
        addMovieButton = new RoundedButton("ADD MOVIE", SECONDARY_COLOR);
        addBoardGameButton = new RoundedButton("ADD BOARD GAME", SECONDARY_COLOR);
        displayButton = new RoundedButton("DISPLAY ALL", SECONDARY_COLOR);
        saveButton = new RoundedButton("SAVE LIBRARY", MAIN_COLOR);
        loadButton = new RoundedButton("LOAD LIBRARY", SECONDARY_COLOR);
        clearButton = new RoundedButton("CLEAR DISPLAY", DANGER_COLOR);

        sidebarPanel.add(addAnimeButton);
        sidebarPanel.add(addMovieButton);
        sidebarPanel.add(addBoardGameButton);
        sidebarPanel.add(displayButton);
        sidebarPanel.add(saveButton);
        sidebarPanel.add(loadButton);
        sidebarPanel.add(clearButton);

        mainPanel.add(sidebarPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel(new BorderLayout(0, 20));
        rightPanel.setBackground(BACKGROUND_COLOR);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(35, 35, 35, 35));

        JLabel titleLabel = new JLabel("MediaVault");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 42));
        titleLabel.setForeground(TEXT_COLOR);

        JLabel subtitleLabel = new JLabel("Welcome, " + user.getUsername()
                + "! Track your anime, movies, and board games.");

        subtitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        subtitleLabel.setForeground(SUBTEXT_COLOR);

        JPanel headerPanel = new JPanel(new GridLayout(2, 1));
        headerPanel.setBackground(BACKGROUND_COLOR);
        headerPanel.add(titleLabel);
        headerPanel.add(subtitleLabel);

        rightPanel.add(headerPanel, BorderLayout.NORTH);

        contentPanel = new RoundedPanel(new BorderLayout());
        contentPanel.setBackground(CARD_COLOR);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        showWelcomeScreen();

        rightPanel.add(contentPanel, BorderLayout.CENTER);
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    /**
     * connects the buttons to their actions.
     */

    private void setupButtonActions()
    {
        addAnimeButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                addAnime();
            }
        });

        addMovieButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                addMovie();
            }
        });

        addBoardGameButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                addBoardGame();
            }
        });

        displayButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                displayAllEntries();
            }
        });

        saveButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                saveLibraryToFile();
            }
        });

        loadButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                loadLibraryFromFile();
            }
        });

        clearButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                showWelcomeScreen();
            }
        });
    }


    /**
     * shows the welcome screen in the main content panel
     */

    private void showWelcomeScreen()
    {
        contentPanel.removeAll();

        JPanel welcomePanel = new JPanel(new GridBagLayout());
        welcomePanel.setOpaque(false);

        JLabel welcomeLabel = new JLabel("<html><center>Welcome to MediaVault!<br>Click a button to start.</center></html>");
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
        welcomeLabel.setForeground(TEXT_COLOR);

        getStartedButton = new RoundedButton("Get Started", SECONDARY_COLOR);

        getStartedButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                displayAllEntries();
            }
        });

        JPanel welcomeContent = new JPanel(new GridLayout(2, 1, 0, 20));
        welcomeContent.setOpaque(false);
        welcomeContent.add(welcomeLabel);
        welcomeContent.add(getStartedButton);

        welcomePanel.add(welcomeContent);
        contentPanel.add(welcomePanel, BorderLayout.CENTER);

        contentPanel.revalidate();
        contentPanel.repaint();
    }


    /**
     * adds an anime entry using input boxes
     */
    private void addAnime()
    {
        String title = askTextInput("Enter anime title:");
        if (title == null)
        {
            return;
        }

        String genre = askTextInput("Enter genre:");
        if (genre == null)
        {
            return;
        }

        String status = askTextInput("Enter status (Planned/In Progress):");
        if (status == null)
        {
            return;
        }

        int totalEpisodes = askIntInput("Enter total episodes:");
        if (totalEpisodes == -1)
        {
            return;
        }

        int currentEpisode = askIntInput("Enter current episode:");
        if (currentEpisode == -1)
        {
            return;
        }

        int seasonNumber = askIntInput("Enter season number:");
        if (seasonNumber == -1)
        {
            return;
        }

        String studio = askTextInput("Enter studio:");
        if (studio == null)
        {
            return;
        }

        int entryId = user.getLibrary().generateEntryId();

        MediaEntry entry = new Anime(entryId, title, genre, status,
                totalEpisodes, currentEpisode, seasonNumber, studio);

        user.getLibrary().addEntry(entry);

        JOptionPane.showMessageDialog(this, "Anime entry added successfully.");
        displayAllEntries();
    }

    /**
     * adds a movie entry using input boxes.
     */

    private void addMovie()
    {
        String title = askTextInput("Enter movie title:");
        if (title == null)
        {
            return;
        }

        String genre = askTextInput("Enter genre:");
        if (genre == null)
        {
            return;
        }

        String status = askTextInput("Enter status (Planned/In Progress):");
        if (status == null)
        {
            return;
        }

        int durationMinutes = askIntInput("Enter duration in minutes:");
        if (durationMinutes == -1)
        {
            return;
        }

        String director = askTextInput("Enter director:");
        if (director == null)
        {
            return;
        }

        int releaseYear = askIntInput("Enter release year:");
        if (releaseYear == -1)
        {
            return;
        }

        int entryId = user.getLibrary().generateEntryId();

        MediaEntry entry = new Movie(entryId, title, genre, status,
                durationMinutes, director, releaseYear);

        user.getLibrary().addEntry(entry);

        JOptionPane.showMessageDialog(this, "Movie entry added successfully.");
        displayAllEntries();
    }

    /**
     * adds a board game entry using input boxes.
     */
    private void addBoardGame()
    {
        String title = askTextInput("Enter board game title:");
        if (title == null)
        {
            return;
        }

        String genre = askTextInput("Enter genre/category:");
        if (genre == null)
        {
            return;
        }

        String status = askTextInput("Enter status (Planned/In Progress):");
        if (status == null)
        {
            return;
        }

        int minPlayers = askIntInput("Enter minimum players:");
        if (minPlayers == -1)
        {
            return;
        }

        int maxPlayers = askIntInput("Enter maximum players:");
        if (maxPlayers == -1)
        {
            return;
        }

        int playTimeMinutes = askIntInput("Enter play time in minutes:");
        if (playTimeMinutes == -1)
        {
            return;
        }

        String difficultyLevel = askTextInput("Enter difficulty level:");
        if (difficultyLevel == null)
        {
            return;
        }

        int entryId = user.getLibrary().generateEntryId();

        MediaEntry entry = new BoardGame(entryId, title, genre, status,
                minPlayers, maxPlayers, playTimeMinutes, difficultyLevel);

        user.getLibrary().addEntry(entry);

        JOptionPane.showMessageDialog(this, "Board game entry added successfully.");
        displayAllEntries();
    }

    /**
     * displays all media entries in the content area
     */

    private void displayAllEntries()
    {
        ArrayList<MediaEntry> entries = user.getLibrary().getAllEntries();

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        displayArea.setForeground(TEXT_COLOR);
        displayArea.setBackground(CARD_COLOR);
        displayArea.setMargin(new Insets(15, 15, 15, 15));
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);


        if (entries.size() == 0)
        {
            displayArea.setText("No entries in the library.");
        }
        else
        {
            String output = "===== All Media Entries =====\n\n";

            for (int i = 0; i < entries.size(); i++)
            {
                output += entries.get(i).toString() + "\n\n";
            }

            displayArea.setText(output);
        }

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(CARD_COLOR);

        contentPanel.removeAll();
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    /**
     * saves the current media library to a file
     */

    private void saveLibraryToFile()
    {
        String fileName = JOptionPane.showInputDialog(this, "Enter file name to save:");

        if (fileName == null || fileName.trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Save cancelled.");
        }
        else
        {
            boolean savedFile = fileManager.saveLibrary(user.getLibrary(), fileName);

            if (savedFile)
            {
                JOptionPane.showMessageDialog(this, "Library saved successfully.");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Library was not saved.");
            }
        }
    }

    /**
     * loads a media library from a file.
     */

    private void loadLibraryFromFile()
    {
        String fileName = JOptionPane.showInputDialog(this, "Enter file name to load:");

        if (fileName == null || fileName.trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Load cancelled.");
        }
        else
        {
            MediaLibrary loadedLibrary = fileManager.loadLibrary(fileName);

            if (loadedLibrary != null)
            {
                user.setLibrary(loadedLibrary);
                JOptionPane.showMessageDialog(this, "Library loaded successfully.");
                displayAllEntries();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Library was not loaded.");
            }
        }
    }

    /**
     * asks the user for a text input.
     *
     * @param message The message shown in the input dialog.
     * @return The input text, or null if cancelled.
     */
    private String askTextInput(String message)
    {
        String input = JOptionPane.showInputDialog(this, message);

        if (input == null || input.trim().equals(""))
        {
            return null;
        }

        return input;
    }

    /**
     * asks the user for a number input.
     *
     * @param message The message shown in the input dialog.
     * @return The integer input, or -1 if cancelled.
     */
    private int askIntInput(String message)
    {
        String input = JOptionPane.showInputDialog(this, message);

        if (input == null || input.trim().equals(""))
        {
            return -1;
        }

        while (!isNumber(input))
        {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
            input = JOptionPane.showInputDialog(this, message);

            if (input == null || input.trim().equals(""))
            {
                return -1;
            }
        }

        return Integer.parseInt(input);
    }

    /**
     * checks if a string can be converted to a number.
     *
     * @param text The text to check.
     * @return true if the text is a number, false otherwise.
     */
    private boolean isNumber(String text)
    {
        try
        {
            Integer.parseInt(text);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    /**
     * starts the GUI program.
     *
     * @param args Standard command-line arguments.
     */
    public static void main(String[] args)
    {
        MediaVaultGUI gui = new MediaVaultGUI();
        gui.setVisible(true);
    }

    /**
     * A simple rounded panel used for the main content.
     */
    private class RoundedPanel extends JPanel
    {
        /**
         * Creates a rounded panel with a layout.
         *
         * @param layout The layout used by the panel.
         */
        public RoundedPanel(LayoutManager layout)
        {
            super(layout);
            setOpaque(false);
        }

        /**
         * paints the rounded panel background.
         *
         * @param g The graphics object.
         */
        protected void paintComponent(Graphics g)
        {
            Graphics2D g2 = (Graphics2D) g.create();

            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);

            g2.dispose();
            super.paintComponent(g);
        }
    }

    /**
     * A simple rounded button used for the GUI design.
     */
    private class RoundedButton extends JButton
    {
        private Color buttonColor;

        /**
         * Creates a rounded button with text and color.
         *
         * @param text The button text.
         * @param buttonColor The button background color.
         */
        public RoundedButton(String text, Color buttonColor)
        {
            super(text);
            this.buttonColor = buttonColor;

            setForeground(TEXT_COLOR);
            setFont(new Font("SansSerif", Font.BOLD, 13));
            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(false);
            setOpaque(false);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        /**
         * Paints the rounded button shape.
         *
         * @param g The graphics object.
         */
        protected void paintComponent(Graphics g)
        {
            Graphics2D g2 = (Graphics2D) g.create();

            g2.setColor(buttonColor);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

            g2.dispose();
            super.paintComponent(g);
        }
    }
}
