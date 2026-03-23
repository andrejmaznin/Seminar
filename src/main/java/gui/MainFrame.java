package gui;

import logic.Engine;
import models.IStew;
import models.OrderInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MainFrame extends JFrame {
    private JButton insertButton;
    private JTable orderTable;
    private JPanel orderPanel;
    private JPanel header;
    private JPanel contentPane;

    private Engine engine;
    private DefaultTableModel tableModel;

    public MainFrame() {
        super("Нордское Рагу");
        this.engine = new Engine();
        this.setContentPane(contentPane);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        initTable();

        insertButton.addActionListener(e -> {
            engine.startOrder();
            OrderFrame orderFrame = new OrderFrame(this, engine);
            orderFrame.setSize(800, 400);
            orderFrame.setLocationRelativeTo(null);
            orderFrame.setVisible(true);
            if (orderFrame.isConfirmed()) {
                engine.commitOrder();
                refreshTable();
            }
        });
    }

    private void initTable() {
        String[] columns = {"Дата и время", "Полное наименование", "Полная цена"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        orderTable.setModel(tableModel);
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        List<OrderInfo> orders = engine.getOrders();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (OrderInfo info : orders) {
            tableModel.addRow(new Object[]{info.getDateTime().format(formatter), info.getOrder().toString(), info.getOrder().checkout()});
        }
    }
}
