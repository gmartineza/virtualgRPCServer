package defaultPackage;

import com.cursoGrpc.grpc.User;
import com.cursoGrpc.grpc.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel responseLabel;

    private GRPCClient cliente = new GRPCClient();
    private ManagedChannel channel = cliente.getChannel();

    public LoginGUI() {
        super("Login GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        responseLabel = new JLabel("Response: ");

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });

        // Create panel and add components
        JPanel panel = new JPanel();
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(responseLabel);

        // Set layout manager
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add panel to frame
        add(panel);

        // Set frame properties
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void performLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // TODO: Replace the following code with your gRPC client code
        // For now, we'll just print the values to the console
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        
        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        User.LoginRequest loginRequest = User.LoginRequest.newBuilder().
                setUsername(username).
                setPassword(password).
                build();

        User.APIResponse response = userStub.login(loginRequest);


        // You can replace this part with your gRPC client code
        // For now, we'll just display a message on the GUI
        responseLabel.setText(response.getResponsemessage() + " - Code: "+response.getResponseCode());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginGUI();
            }
        });
    }
}