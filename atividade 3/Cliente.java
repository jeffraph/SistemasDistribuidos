import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {

        String SERVER_IP = "127.0.0.1";
        int SERVER_PORT = 9090;


        Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        System.out.println("Conectado ao servidor");

        JFrame jFrame = new JFrame("CLIENTE");
        jFrame.setSize(500,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Jeffe\\OneDrive\\Área de Trabalho\\Exercicio\\cat.jpg");

        JLabel jLabelPic = new JLabel(imageIcon);
        JButton jButton = new JButton("Enviar imagem para o servidor");

        jFrame.add(jLabelPic, BorderLayout.CENTER);
        jFrame.add(jButton, BorderLayout.SOUTH);

        jFrame.setVisible(true);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                try {
                    OutputStream outputStream = socket.getOutputStream();
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

                    Image image = imageIcon.getImage();

                    BufferedImage bufferedImage = new BufferedImage(
                            image.getWidth(null),
                            image.getHeight(null),
                            BufferedImage.TYPE_INT_RGB);

                    Graphics graphics = bufferedImage.createGraphics();
                    graphics.drawImage(image,0,0,null);
                    graphics.dispose();

                    ImageIO.write(bufferedImage, "jpg", bufferedOutputStream);

                    bufferedOutputStream.close();
                    socket.close();

                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
