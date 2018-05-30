package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Controller {

    @FXML
    private TextField localIp, localPort, remoteIp, remotePort, message;

    @FXML
    private Button btnLocalConnection, btnRemoteConnection, btnSend;

    @FXML
    private TextArea display;

    private Socket socket;

    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    @FXML
    private void initialize() {

        // Send
        btnSend.setOnAction(event -> {
            try {
                dataOutputStream.writeUTF(message.getText().trim());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        EventQueue.invokeLater(() -> {
            try {
                socket = new Socket(localIp.getText(), Integer.parseInt(localPort.getText()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
