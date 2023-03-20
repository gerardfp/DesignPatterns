package builder.alertdialog;

import javax.swing.*;

public class AlertDialog {
    String title, text, yesButtonText, noButtonText;

    static class Builder {
        String title, text, yesButtonText, noButtonText;

        Builder(String title, String text) {
            this.title = title;
            this.text = text;
        }

        Builder setYes() { //fds
            this.yesButtonText = "Ok";
            return this;
        }

        Builder setYes(String yes) {
            this.yesButtonText = yes;
            return this;
        }

        Builder setNo() {
            this.noButtonText = "Cancel";
            return this;
        }

        Builder setNo(String no) {
            this.noButtonText = no;
            return this;
        }

        AlertDialog build(){
            AlertDialog alertDialog = new AlertDialog();
            alertDialog.title = this.title;
            alertDialog.text = this.text;
            alertDialog.yesButtonText = this.yesButtonText;
            alertDialog.noButtonText = this.noButtonText;

            return alertDialog;
        }

        void show(){
            AlertDialog alertDialog = build();
            JPanel jPanel = new JPanel();
            jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.PAGE_AXIS));
            jPanel.add(new JLabel(alertDialog.text));
            if (alertDialog.yesButtonText != null)
                jPanel.add(new JButton(alertDialog.yesButtonText));
            if (alertDialog.noButtonText != null)
                jPanel.add(new JButton(alertDialog.noButtonText));

            JFrame jFrame = new JFrame(title);
            jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jFrame.add(jPanel);
            jFrame.pack();
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);
        }
    }
}


class Main {
    public static void main(String[] args) {
        new AlertDialog.Builder("Suscribirse", "Desea suscribirse a mi canal?")
                .setYes("Sí, suscribeme ahora mismo")
                .setNo("No, otro día")
                .show();
    }
}

