package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginGUI extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnLogin;

    public LoginGUI() {
        setTitle("Login - Locadora de Veículos - USJT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // primeiro painel (pricipal)
        JPanel painelCentro = new JPanel(new GridBagLayout()); 
        painelCentro.setBackground(Color.white);
        add(painelCentro, BorderLayout.CENTER);

        GridBagConstraints confInter = new GridBagConstraints();
        confInter.fill = GridBagConstraints.HORIZONTAL;
        confInter.insets = new Insets(10, 10, 10, 10); 

        // usuario
        confInter.gridx = 0; confInter.gridy = 0; //eixo x e y igual no plano cartesiano
        painelCentro.add(new JLabel("Usuário:"), confInter);

        txtUsuario = new JTextField();
        aparenciaTextField(txtUsuario);
        confInter.gridx = 1; confInter.gridy = 0;
        confInter.weightx = 1;
        painelCentro.add(txtUsuario, confInter);

        // senha
        confInter.gridx = 0; confInter.gridy = 1;
        painelCentro.add(new JLabel("Senha:"), confInter);

        txtSenha = new JPasswordField();
        aparenciaTextField(txtSenha); 
        confInter.gridx = 1; confInter.gridy = 1;
        painelCentro.add(txtSenha, confInter);

        // botão de Login
        btnLogin = new JButton("Entrar");
        aparenciaButton(btnLogin); // Personaliza o botão
        confInter.gridx = 0; confInter.gridy = 2;
        confInter.gridwidth = 2; 
        confInter.anchor = GridBagConstraints.CENTER; 
        painelCentro.add(btnLogin, confInter);

        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String usuario = txtUsuario.getText();
                String senha = new String(txtSenha.getPassword());

                if ("Duduchi".equals(usuario) && "nota100".equals(senha)) {
                    dispose();
                    new MenuGUI(); 
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // KeyListener para acionar o login ao pressionar o Enter
        txtSenha.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnLogin.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        setSize(400, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void aparenciaTextField(JTextField textField) {
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setForeground(Color.DARK_GRAY);
        textField.setBackground(new Color(240, 240, 240)); // Cor de fundo clara
        textField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1)); // Borda leve
        textField.setPreferredSize(new Dimension(250, 30)); // Tamanho do campo de texto
        textField.setCaretColor(Color.DARK_GRAY); // Cor do cursor
    }

    // função p personalizar o JButton
    public static void aparenciaButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(30, 144, 255)); // cor de fundo
        button.setForeground(Color.WHITE); // Cor do texto branco
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // interno
        button.setFocusPainted(false); // remove o foco ao clicar
        button.setPreferredSize(new Dimension(150, 40)); // tamanho

        // Efeitos tops do mouse
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(50, 160, 255)); 
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(30, 144, 255));
            }
        });
    }
}
