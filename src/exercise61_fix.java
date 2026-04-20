import javax.swing.JOptionPane;

public class exercise61_fix {
    public static void main(String[] args)
    {

        Object[] options = {"I do", "I don't"};

        int choice = JOptionPane.showOptionDialog(
                null,
                "Do you want to change to the first class ticket?",
                "Confirm",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        String result;

        if (choice == 0)
        {
            result = "I do";
        }
        else if (choice == 1)
        {
            result = "I don't";
        }
        else
        {
            result = "Closed/Cancel";
        }

        JOptionPane.showMessageDialog(
                null,
                "You've chosen: " + result
        );

        System.exit(0);
    }
}