package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI extends JFrame {
    private JButton btnAdicionar, btnListar, btnAtualizar, btnExcluir, btnConfiguracoes;

    public MenuGUI() {
        setTitle("Menu - Locadora de Veículos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel painelLateral = new JPanel();
        painelLateral.setLayout(new BorderLayout());
        painelLateral.setBackground(new Color(245, 245, 245));
        painelLateral.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //textos
        JPanel painelTextos = new JPanel();
        painelTextos.setLayout(new BoxLayout(painelTextos, BoxLayout.Y_AXIS));
        painelTextos.setBackground(new Color(245, 245, 245));
        painelTextos.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        JLabel lblSaudacao = new JLabel("OLÁ, DUDUCHI", JLabel.CENTER);
        lblSaudacao.setFont(new Font("Segoe UI", Font.BOLD, 36));
        lblSaudacao.setForeground(new Color(30, 144, 255));
        lblSaudacao.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel lblPergunta = new JLabel("O QUE DESEJA FAZER?", JLabel.CENTER);
        lblPergunta.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblPergunta.setForeground(Color.DARK_GRAY);
        lblPergunta.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelTextos.add(lblSaudacao);
        painelTextos.add(Box.createRigidArea(new Dimension(0, 20)));
        painelTextos.add(lblPergunta);

        painelLateral.add(painelTextos, BorderLayout.NORTH);

        //creditos
        btnConfiguracoes = criarBotaoPeq("CRÉDITOS");
        btnConfiguracoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConfiguracoesGUI();
            }
        });
        painelLateral.add(btnConfiguracoes, BorderLayout.SOUTH);
 
        JPanel painelOpcoes = new JPanel();
        painelOpcoes.setLayout(new GridLayout(4, 1, 10, 10));
        painelOpcoes.setBackground(new Color(245, 245, 245));
        painelOpcoes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        btnAdicionar = criarBotao("Adicionar Veículo");
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdicionarVeiculoGUI();
            }
        });

        btnListar = criarBotao("Listar Veículos");
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListarVeiculosGUI();
            }
        });

        btnAtualizar = criarBotao("Atualizar Veículo");
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AtualizarVeiculoGUI().setVisible(true);
            }
        });

        btnExcluir = criarBotao("Excluir Veículo");
        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ExcluirVeiculoGUI().setVisible(true);
            }
        });

        painelOpcoes.add(btnAdicionar);
        painelOpcoes.add(btnListar);
        painelOpcoes.add(btnAtualizar);
        painelOpcoes.add(btnExcluir);

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.add(painelLateral, BorderLayout.WEST);
        painelPrincipal.add(painelOpcoes, BorderLayout.CENTER);

        add(painelPrincipal, BorderLayout.CENTER);

        // Configurações da janela
        setSize(700, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    // Função p criar botões
    private JButton criarBotao(String texto) {
        JButton button = new JButton(texto);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBackground(new Color(30, 144, 255));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFocusPainted(false);

        // Efeito do mouse
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(50, 160, 255));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(30, 144, 255));
            }
        });

        return button;
    }

    private JButton criarBotaoPeq(String texto) {
        JButton button = new JButton(texto);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBackground(new Color(211, 211, 211));
        button.setForeground(new Color(30, 144, 255));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        button.setFocusPainted(false);

        // Efeito quando o mouse passa sobre o botão
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(195, 195, 195));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(211, 211, 211));
            }
        });

        return button;
    }
}
