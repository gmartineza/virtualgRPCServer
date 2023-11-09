package GUI;

import java.awt.*;
import java.awt.event.*;

public class TheGUI extends Frame implements ActionListener {
    Button button;
    Label title;
    Label labelUser;
    Label labelPass;
    TextField usuario;
    TextField pass;



    public TheGUI(){
        super("PRECIOS");

        setLayout(new FlowLayout());

        title = new Label("PRECIOS - GRPC");
        add(title);

        labelUser = new Label("Usuario");
        add(labelUser);

        usuario = new TextField();
        add(usuario);

        labelPass = new Label("Contrasenia");
        add(labelPass);

        pass = new TextField();
        add(pass);

        button = new Button("Click me");
        button.addActionListener(this);
        add(button);

        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        title.setText("Button clicked");
    }

    public static void main(String[] args) {
        new TheGUI();
    }
}
