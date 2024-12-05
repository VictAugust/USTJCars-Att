package view;

import dao.VeiculoDAO;
import model.Veiculo;
import dao.ConexaoBD; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import static view.LoginGUI.aparenciaButton;
import static view.LoginGUI.aparenciaTextField; //importei esses do view login para poder pegar a mesma aparencia

public class AtualizarVeiculoGUI extends JFrame {
    private JTextField campoMarca, campoModelo, campoAno, campoCor, campoPlaca, campoQuilometragem, campoDisponibilidade, campoPrecoDiaria, campoCategoria, campoDescricao;
    private JButton botaoBuscar, botaoAtualizar, btnVoltar;
    private VeiculoDAO veiculoDAO;
    
    public AtualizarVeiculoGUI() {
        veiculoDAO = new VeiculoDAO();
        this.setTitle("Atualizar Veículo");
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3,3,3,3);
        
       //marca
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel jMarca = new JLabel("Marca");
        this.add(jMarca, gbc);
        aparenciaJLabel(jMarca);
        
        gbc.gridx = 1; gbc.gridy = 0;
        this.add(campoMarca = new JTextField(), gbc);
        campoMarca.setPreferredSize(new Dimension(150, 30));
        aparenciaTextField(campoMarca);
     
        
        //modelo
        gbc.gridx = 0; gbc.gridy = 1;
        JLabel jModelo = new JLabel("Modelo");
        this.add(jModelo, gbc);
        aparenciaJLabel(jModelo);
      
        gbc.gridx = 1; gbc.gridy = 1;        
        this.add(campoModelo = new JTextField(),gbc);
        campoModelo.setPreferredSize(new Dimension(150, 30));
        aparenciaTextField(campoModelo);
        
        
        //ano
        gbc.gridx = 0; gbc.gridy = 2;
        JLabel jAno = new JLabel("Ano");
        this.add(jAno, gbc);
        aparenciaJLabel(jAno);
        
        gbc.gridx = 1; gbc.gridy = 2;
        this.add(campoAno = new JTextField(),gbc);
        campoAno.setPreferredSize(new Dimension(150, 30));
        aparenciaTextField(campoAno);

        
        //cor
        gbc.gridx = 0 ; gbc.gridy = 3;
        JLabel jCor = new JLabel("Cor");
        this.add(jCor, gbc);
        aparenciaJLabel(jCor);
        
        gbc.gridx = 1; gbc.gridy = 3;
        this.add(campoCor = new JTextField(), gbc);
        campoCor.setPreferredSize(new Dimension(150, 30));
        aparenciaTextField(campoCor);
        
        
        //placa
        gbc.gridx = 0; gbc.gridy = 4;
        JLabel jPlaca = new JLabel("Placa");
        this.add(jPlaca, gbc);
        aparenciaJLabel(jPlaca);
                
        gbc.gridx = 1; gbc.gridy = 4;
        this.add(campoPlaca = new JTextField(), gbc);
        campoPlaca.setPreferredSize(new Dimension(150, 30));
        
        aparenciaTextField(campoPlaca);{ //para mudar a cor do textfield -sobrescrita hehe
        campoPlaca.setBackground(new Color(220, 220, 220)); // Cor de fundo clara
        }
         
        
        //qulometragem
        gbc.gridx = 0; gbc.gridy = 5;
        JLabel jQuilometragem = new JLabel("Quilometragem");
        this.add(jQuilometragem, gbc);
        aparenciaJLabel(jQuilometragem);
        
        gbc.gridx = 1; gbc.gridy = 5;
        this.add(campoQuilometragem = new JTextField(), gbc);
        campoQuilometragem.setPreferredSize(new Dimension(150, 30));
        aparenciaTextField(campoQuilometragem);
        
        
        //disponivel
        gbc.gridx = 0; gbc.gridy = 6;
        JLabel jDisponibilidade = new JLabel("Está disponível?");
        this.add(jDisponibilidade, gbc);
        aparenciaJLabel(jDisponibilidade);
        
        gbc.gridx = 1; gbc.gridy = 6;
        this.add(campoDisponibilidade = new JTextField(), gbc); 
        campoDisponibilidade.setPreferredSize(new Dimension(150, 30));
        aparenciaTextField(campoDisponibilidade);
        
        
        //preco
        gbc.gridx = 0; gbc.gridy = 7;
        JLabel jPreco = new JLabel("Preço diária");
        this.add(jPreco, gbc);
        aparenciaJLabel(jPreco);
               
        gbc.gridx = 1; gbc.gridy = 7;
        this.add(campoPrecoDiaria = new JTextField(), gbc);
        campoPrecoDiaria.setPreferredSize(new Dimension(150, 30));   
        aparenciaTextField(campoPrecoDiaria);
        
        
        //categoria
        gbc.gridx = 0; gbc.gridy = 8;
        JLabel jCategoria = new JLabel("Categoria");
        this.add(jCategoria, gbc);
        aparenciaJLabel(jCategoria);
          
        gbc.gridx = 1; gbc.gridy = 8;
        this.add(campoCategoria = new JTextField(), gbc);
        campoCategoria.setPreferredSize(new Dimension(150, 30));
        aparenciaTextField(campoCategoria);
        
        
        //descricao
        gbc.gridx = 0; gbc.gridy = 9;
        JLabel jDescricao = new JLabel("Descrição");
        this.add(jDescricao, gbc);
        aparenciaJLabel(jDescricao);
        
        
        gbc.gridx = 1; gbc.gridy = 9;
        this.add(campoDescricao = new JTextField(), gbc);
        campoDescricao.setPreferredSize(new Dimension(150, 30));
        aparenciaTextField(campoDescricao);
        
        
        gbc.gridx = 0; gbc.gridy = 11; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        botaoBuscar = new JButton("Buscar");
        this.add(botaoBuscar, gbc);
        aparenciaButton(botaoBuscar);
        gbc.gridwidth = 1;//redefinir senao da merda
        
        
        gbc.gridx = 0; gbc.gridy = 12;
        btnVoltar = new JButton ("Voltar");
        aparenciaButton(btnVoltar);
        this.add(btnVoltar, gbc);
                
        gbc.gridx = 1; gbc.gridy = 12;
        botaoAtualizar = new JButton("Atualizar");
        this.add(botaoAtualizar, gbc);
        aparenciaButton(botaoAtualizar);
        
        // Botão Voltar
        btnVoltar.addActionListener(new ActionListener() {
         @Override
            public void actionPerformed(ActionEvent e) {
                     dispose();
            }
        });

        //lembrete
        gbc.gridx= 0; gbc.gridy = 13; gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        JLabel lembrete = new JLabel("DIGITE A PLACA PARA CONSULTAR");
        lembrete.setFont(new Font("Segoe UI", Font.ROMAN_BASELINE, 12));      
        lembrete.setForeground(Color.DARK_GRAY);
        this.add(lembrete,gbc);
                
        // Ação do botão Buscar
        botaoBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection conn = ConexaoBD.getCon()) {
                    String placa = campoPlaca.getText();
                    Veiculo veiculo = veiculoDAO.buscarVeiculos(conn).stream()
                            .filter(v -> v.getPlaca().equals(placa)) // usando equals para comparar a placa
                            .findFirst()
                            .orElse(null);

                    if (veiculo != null) {
                        // preenche os campos com os dados do veículo
                        campoMarca.setText(veiculo.getMarca());
                        campoModelo.setText(veiculo.getModelo());
                        campoAno.setText(String.valueOf(veiculo.getAno()));
                        campoCor.setText(veiculo.getCor());
                        campoPlaca.setText(veiculo.getPlaca());
                        campoQuilometragem.setText(String.valueOf(veiculo.getQuilometragem()));
                        campoPrecoDiaria.setText(String.valueOf(veiculo.getPrecoDiaria()));
                        campoDisponibilidade.setText(String.valueOf(veiculo.getDisponivel()));
                        campoCategoria.setText(veiculo.getCategoria());
                        campoDescricao.setText(veiculo.getDescricao());
                    } else {
                        JOptionPane.showMessageDialog(null, "Veículo não encontrado!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao buscar veículo: " + ex.getMessage());
                }
            }
        });

        // Ação do botão Atualizar
        botaoAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection conn = ConexaoBD.getCon()) { // usando a conexão com o banco de dados
                    Veiculo veiculo = new Veiculo(
                            campoMarca.getText(),
                            campoModelo.getText(),
                            Integer.parseInt(campoAno.getText()),
                            campoCor.getText(),
                            campoPlaca.getText(),
                            Integer.parseInt(campoQuilometragem.getText()),
                            Double.parseDouble(campoPrecoDiaria.getText()),
                            campoDisponibilidade.getText(),
                            campoCategoria.getText(),
                            campoDescricao.getText()
                    );
                    veiculoDAO.atualizarVeiculo(conn, veiculo);
                    JOptionPane.showMessageDialog(null, "Veículo atualizado com sucesso!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar veículo: " + ex.getMessage());
                }
            }
        });          
        this.pack();
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
    }
    public static void aparenciaJLabel(JLabel rotulo){
            //aparencia jlabels
        rotulo.setFont(new Font("Segoe UI", Font.BOLD, 15)); 
        rotulo.setForeground(Color.DARK_GRAY);
    }
}
