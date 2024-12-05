package view;

import dao.VeiculoDAO;
import dao.ConexaoBD;
import model.Veiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLIntegrityConstraintViolationException;

import static view.AtualizarVeiculoGUI.aparenciaJLabel;
import static view.LoginGUI.aparenciaButton;
import static view.LoginGUI.aparenciaTextField;

public class AdicionarVeiculoGUI extends JFrame {
    private JTextField txtMarca, txtModelo, txtAno, txtCor, txtPlaca, txtQuilometragem, txtPrecoDiaria, txtDisponibilidade, txtCategoria, txtDescricao;
    private JButton btnSalvar, btnVoltar;

    public AdicionarVeiculoGUI() {
        this.setTitle("Adicionar Veículo");
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.weighty = 0;
        gbc.weightx = 0;

        // Marca
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel jMarca = new JLabel("Marca");
        this.add(jMarca, gbc);
        aparenciaJLabel(jMarca);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(txtMarca = new JTextField(), gbc);
        txtMarca.setPreferredSize(new Dimension(150, 30));
        aparenciaTextField(txtMarca);

        // Modelo
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel jModelo = new JLabel("Modelo");
        this.add(jModelo, gbc);
        aparenciaJLabel(jModelo);

        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(txtModelo = new JTextField(), gbc);
        txtModelo.setPreferredSize(new Dimension(150, 30));
        aparenciaTextField(txtModelo);

        // Ano
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel jAno = new JLabel("Ano");
        this.add(jAno, gbc);
        aparenciaJLabel(jAno);

        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(txtAno = new JTextField(), gbc);
        txtAno.setPreferredSize(new Dimension(150, 30));
        aparenciaTextField(txtAno);

        // Cor
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel jCor = new JLabel("Cor");
        this.add(jCor, gbc);
        aparenciaJLabel(jCor);

        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(txtCor = new JTextField(), gbc);
        txtCor.setPreferredSize(new Dimension(150, 30));
        aparenciaTextField(txtCor);

        // Placa
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel jPlaca = new JLabel("Placa");
        this.add(jPlaca, gbc);
        aparenciaJLabel(jPlaca);

        gbc.gridx = 1;
        gbc.gridy = 4;
        this.add(txtPlaca = new JTextField(), gbc);
        txtPlaca.setPreferredSize(new Dimension(150, 30));
        aparenciaTextField(txtPlaca);
        txtPlaca.setBackground(new Color(220, 220, 220));

        // Quilometragem
        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel jQuilometragem = new JLabel("Quilometragem");
        this.add(jQuilometragem, gbc);
        aparenciaJLabel(jQuilometragem);

        gbc.gridx = 1;
        gbc.gridy = 5;
        this.add(txtQuilometragem = new JTextField(), gbc);
        txtQuilometragem.setPreferredSize(new Dimension(150, 30));
        aparenciaTextField(txtQuilometragem);

        // Disponibilidade
        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel jDisponibilidade = new JLabel("Está disponível?");
        this.add(jDisponibilidade, gbc);
        aparenciaJLabel(jDisponibilidade);

        gbc.gridx = 1;
        gbc.gridy = 6;
        this.add(txtDisponibilidade = new JTextField(), gbc);
        txtDisponibilidade.setPreferredSize(new Dimension(150, 30));
        aparenciaTextField(txtDisponibilidade);

        // Preço
        gbc.gridx = 0;
        gbc.gridy = 7;
        JLabel jPreco = new JLabel("Preço diária");
        this.add(jPreco, gbc);
        aparenciaJLabel(jPreco);

        gbc.gridx = 1;
        gbc.gridy = 7;
        this.add(txtPrecoDiaria = new JTextField(), gbc);
        txtPrecoDiaria.setPreferredSize(new Dimension(150, 30));
        aparenciaTextField(txtPrecoDiaria);

        // Categoria
        gbc.gridx = 0;
        gbc.gridy = 8;
        JLabel jCategoria = new JLabel("Categoria");
        this.add(jCategoria, gbc);
        aparenciaJLabel(jCategoria);

        gbc.gridx = 1;
        gbc.gridy = 8;
        this.add(txtCategoria = new JTextField(), gbc);
        txtCategoria.setPreferredSize(new Dimension(150, 30));
        aparenciaTextField(txtCategoria);

        // Descrição
        gbc.gridx = 0;
        gbc.gridy = 9;
        JLabel jDescricao = new JLabel("Descrição");
        this.add(jDescricao, gbc);
        aparenciaJLabel(jDescricao);

        gbc.gridx = 1;
        gbc.gridy = 9;
        this.add(txtDescricao = new JTextField(), gbc);
        txtDescricao.setPreferredSize(new Dimension(150, 30));
        aparenciaTextField(txtDescricao);

        // Botão Salvar
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        btnSalvar = new JButton("Salvar");
        this.add(btnSalvar, gbc);
        aparenciaButton(btnSalvar);

        // Botão Voltar
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        btnVoltar = new JButton("Voltar");
        this.add(btnVoltar, gbc);
        aparenciaButton(btnVoltar);

        //salvar
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtMarca.getText().isEmpty() || txtModelo.getText().isEmpty() || txtAno.getText().isEmpty() ||
                        txtPlaca.getText().isEmpty() || txtQuilometragem.getText().isEmpty() || txtPrecoDiaria.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Todos os campos obrigatórios devem ser preenchidos!");
                        return;
                    }

                    Veiculo veiculo = new Veiculo(
                            txtMarca.getText(),
                            txtModelo.getText(),
                            Integer.parseInt(txtAno.getText()),
                            txtCor.getText(),
                            txtPlaca.getText(),
                            Integer.parseInt(txtQuilometragem.getText()),
                            Double.parseDouble(txtPrecoDiaria.getText()),
                            txtDisponibilidade.getText(),
                            txtCategoria.getText(),
                            txtDescricao.getText()
                    );

                    try (Connection conn = ConexaoBD.getCon()) {
                        VeiculoDAO veiculoDAO = new VeiculoDAO();
                        veiculoDAO.adicionarVeiculo(conn, veiculo);

                        JOptionPane.showMessageDialog(null, "Veículo adicionado com sucesso!");
                        dispose();
                    } catch(SQLIntegrityConstraintViolationException eq){
                        JOptionPane.showMessageDialog(null, "Erro: Placa já cadastrada no sistema!", "Placa Duplicada", JOptionPane.WARNING_MESSAGE);
                    } 
                    catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados: " + ex.getMessage());
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro nos campos numéricos: " + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar veículo: " + ex.getMessage());
                }
            }
        });

        // p voltar
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        this.pack();
        setLocationRelativeTo(null);
        this.setResizable(false);
        setVisible(true);
    }
}
