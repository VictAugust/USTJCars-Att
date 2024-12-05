package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.LoginGUI.aparenciaButton;
import static view.AtualizarVeiculoGUI.aparenciaJLabel;

public class ConfiguracoesGUI extends JFrame {

    public ConfiguracoesGUI() {
        this.setTitle("Créditos");
        this.setLayout(new FlowLayout());
        JLabel nomesRA1 =  new JLabel("Anderson da Silva Abreu - 82420319");
        this.add(nomesRA1); aparenciaJLabel(nomesRA1);
        
        JLabel nomesRA2 =  new JLabel("Leandro Oliveira da Silva Melo - 82426469");
        this.add(nomesRA2); aparenciaJLabel(nomesRA2);
        
        JLabel nomesRA3 =  new JLabel("Matheus Meneghette - 824211801");
        this.add(nomesRA3); aparenciaJLabel(nomesRA3);
        
        JLabel nomesRA4 =  new JLabel("Pedro Henrique Ferreira Lopes - 822137721");
        this.add(nomesRA4); aparenciaJLabel(nomesRA4);
        
        JLabel nomesRA5 =  new JLabel("Raul Ramos Fantazia - 824216012");
        this.add(nomesRA5); aparenciaJLabel(nomesRA5);
        
        JLabel nomesRA6 =  new JLabel("Victor Augusto da Silva Araujo - 824215371");
        this.add(nomesRA6); aparenciaJLabel(nomesRA6);
        
        JButton btnVoltar = new JButton("Voltar");
        this.add(btnVoltar); aparenciaButton(btnVoltar);
               // p voltar
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        setSize(400,250);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
        
        
    
    }

}


