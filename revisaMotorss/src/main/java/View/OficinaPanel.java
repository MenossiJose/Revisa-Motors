package View;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ActionListener;

import Model.Revisao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class OficinaPanel extends JPanel {
    private MainView mainView;
    private JTable tableAgendamentos;
    private JTextArea textAreaDetalhesServico;
    private JButton buttonEmitirOrdemServico;
    private JButton buttonLogout;
    private JList<String> listRevisoes;
    private DefaultListModel<String> listModelRevisoes;
    private List<Revisao> revisoes;

    public OficinaPanel(MainView mainView) {
        this.mainView = mainView;
        setLayout(null);

        JLabel labelAgendamentos = new JLabel("Agendamentos:");
        labelAgendamentos.setBounds(10, 10, 100, 25);
        add(labelAgendamentos);

        listModelRevisoes = new DefaultListModel<>();
        listRevisoes = new JList<>(listModelRevisoes);
        JScrollPane scrollPane = new JScrollPane(listRevisoes);
        scrollPane.setBounds(10, 40, 300, 200);
        add(scrollPane);
        

        JLabel labelDetalhesServico = new JLabel("Detalhes do Serviço:");
        labelDetalhesServico.setBounds(10, 250, 150, 25);
        add(labelDetalhesServico);

        textAreaDetalhesServico = new JTextArea();
        textAreaDetalhesServico.setBounds(10, 280, 760, 100);
        add(textAreaDetalhesServico);

        buttonEmitirOrdemServico = new JButton("Emitir Ordem de Serviço");
        buttonEmitirOrdemServico.setBounds(10, 390, 200, 25);
        add(buttonEmitirOrdemServico);

        buttonLogout = new JButton("Logout");
        buttonLogout.setBounds(10, 430, 150, 25);
        add(buttonLogout);

        buttonLogout.addActionListener(e -> mainView.showPanel("LoginPanel"));
         // Adicionar o MouseAdapter para capturar os cliques na lista de revisões
        listRevisoes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = listRevisoes.locationToIndex(e.getPoint());
                if (index != -1) {
                    Revisao revisaoSelecionada = revisoes.get(index);
                    textAreaDetalhesServico.setText(revisaoSelecionada.getServico());
                }
            }
        });
        buttonEmitirOrdemServico.addActionListener(e -> emitirOrdemServico());

    }
    
    private void emitirOrdemServico() {
        int index = listRevisoes.getSelectedIndex();
        if (index != -1) {
            Revisao revisaoSelecionada = revisoes.get(index);
            // Aqui você pode adicionar a lógica para guardar a revisão
            // Por exemplo: revisaoCTRL.emitirOrdemServico(revisaoSelecionada);
            
            mainView.getHistoricoPanel().adicionarRevisao(revisaoSelecionada);
            // Remover a revisão da lista e atualizar a UI
            revisoes.remove(index);
            listModelRevisoes.remove(index);
            textAreaDetalhesServico.setText("");
        }
    }

    public void addEmitirOrdemServicoListener(ActionListener listener) {
        buttonEmitirOrdemServico.addActionListener(listener);
    }

    public String getDetalhesServico() {
        return textAreaDetalhesServico.getText();
    }
    
     public int getSelectedAgendamentoRow() {
        return tableAgendamentos.getSelectedRow();
    }

    public void setAgendamentos(Object[][] dados, String[] colunas) {
        tableAgendamentos.setModel(new DefaultTableModel(dados, colunas));
    }
    
    public void atualizarListaRevisoes(List<Revisao> revisoes) {
        listModelRevisoes.clear();
        this.revisoes = revisoes;
            for (Revisao revisao : revisoes) {
                listModelRevisoes.addElement(revisao.getCliente() + " " + revisao.getVeiculo());
            }
    } 
    
}