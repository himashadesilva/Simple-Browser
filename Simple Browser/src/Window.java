import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Himasha De Silva on 12/31/2016.
 */
public class Window extends JFrame {

    private JTextField addressBar;
    private JEditorPane display;

    public Window(){
        super("RulzZ");

        addressBar = new JTextField("Enter URL");
        addressBar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        loadCrap(e.getActionCommand());
                    }
                }
        );
        add(addressBar, BorderLayout.NORTH);

        display = new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(
                new HyperlinkListener() {
                    @Override
                    public void hyperlinkUpdate(HyperlinkEvent e) {
                        if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
                            loadCrap(e.getURL().toString());
                        }
                    }
                }
        );
        add(new JScrollPane(display),BorderLayout.CENTER);
        setSize(500,300);
        setVisible(true);

    }

    private void loadCrap(String userText){
        try{
            display.setPage(userText);
            addressBar.setText(userText);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
