package defaults;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LanguageChangeClass implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String tmp = (String)preferenceWindow.languageBox.getSelectedItem();
        if(tmp.equals("한국어"))
            PingOutline.setWhichLanguage("Korean");
        else if(tmp.equals("English")) {
            PingOutline.setWhichLanguage("English");
        }else {
            new errorWindow(001);
        }
    }
}
