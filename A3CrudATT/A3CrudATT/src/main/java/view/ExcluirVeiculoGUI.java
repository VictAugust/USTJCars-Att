package view;

import dao.VeiculoDAO;
import dao.ConexaoBD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import static view.AtualizarVeiculoGUI.aparenciaJLabel;
import static view.LoginGUI.aparenciaButton;
import static view.LoginGUI.aparenciaTextField;

public class ExcluirVeiculoGUI extends JFrame {
    private JButton botaoExcluir, btnVoltar;

    public ExcluirVeiculoGUI() {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        this.setTitle("Excluir Veículo");
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3,3,3,3);
        gbc.weighty = 0; gbc.weightx = 0; //inicializar zerado
        
        //Jlabel
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel JPExcluir = new JLabel("Digite a placa do veículo:");
        this.add(JPExcluir, gbc);
        aparenciaJLabel(JPExcluir);

        gbc.gridx = 0; gbc.gridy = 1;
        JTextField txtExcluir = new JTextField();
        txtExcluir.setPreferredSize(new Dimension(150, 30));
        aparenciaTextField(txtExcluir);
        add(txtExcluir, gbc);
        
        //botoes
        gbc.gridx = 1; gbc.gridy = 0;
        botaoExcluir = new JButton("Excluir");
        add(botaoExcluir,gbc);
        aparenciaButton(botaoExcluir);
        
        gbc.gridx = 1; gbc.gridy = 1;
        btnVoltar = new JButton ("Voltar");
        add(btnVoltar,gbc);
        aparenciaButton(btnVoltar);

        
        // Botão Voltar
        btnVoltar.addActionListener(new ActionListener() {
          @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        add(new JLabel()); 

        botaoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection conn = ConexaoBD.getCon()) { // Obtendo a conexão com o banco
                    String placa = txtExcluir.getText();    
                    if(placa != null && !placa.isEmpty()){
                    
                    veiculoDAO.excluirVeiculo(conn, placa);
                    JOptionPane.showMessageDialog(null, "Veículo excluído com sucesso!");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Insira uma placa");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir veículo: " + ex.getMessage());
                }
            }
        });        
        this.pack();
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
    }
}
