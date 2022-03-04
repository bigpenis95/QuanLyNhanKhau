package Connect;
import java.awt.*;
import javax.swing.*; 
public class MessageDialogHelper {
    public static void showMassageDialog(Component parent, String content, String title) {
        JOptionPane.showMessageDialog(parent, title, content, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showErrorDialog(Component parent, String content, String title) {
        JOptionPane.showMessageDialog(parent, title, content, JOptionPane.ERROR_MESSAGE);
    }
    
    public static int showConfirmDialog(Component parent, String content, String title) {
        int choose = JOptionPane.showConfirmDialog(parent, title,content,
                JOptionPane.YES_NO_OPTION ,JOptionPane.QUESTION_MESSAGE);
        return choose;
    }
}

