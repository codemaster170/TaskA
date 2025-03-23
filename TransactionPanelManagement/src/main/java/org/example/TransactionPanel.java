package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class TransactionPanel extends JPanel {

    JTable transactionTable;
    private DefaultTableModel tableModel;
    JButton payButton;
    private JButton refreshButton;
    private final OrderController orderController;

    public TransactionPanel(OrderController controller) {
        this.orderController = controller;
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Transactions & Payments", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

        // Define columns to show transaction summary
        String[] columns = {"Order No.", "Items", "Total (UGX)", "Paid?"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table non-editable
            }
        };

        transactionTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(transactionTable);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        payButton = new JButton("Pay for Selected Order");
        refreshButton = new JButton("Refresh Transactions");

        payButton.addActionListener(this::handlePayment);
        refreshButton.addActionListener(e -> refreshTransactionTable());

        buttonPanel.add(payButton);
        buttonPanel.add(refreshButton);

        add(buttonPanel, BorderLayout.SOUTH);

        refreshTransactionTable();
    }


    public void refreshTransactionTable() {
        tableModel.setRowCount(0); // Clear existing data
        List<OrderTransaction> transactions = orderController.getTransactions();

        for (int i = 0; i < transactions.size(); i++) {
            OrderTransaction transaction = transactions.get(i);
            String itemSummary = transaction.getItems().size() + " item(s)";
            tableModel.addRow(new Object[]{
                    "Order " + (i + 1),
                    itemSummary,
                    transaction.getTotalPrice(),
                    transaction.isPaid() ? "Paid" : "Pending"
            });
        }
    }


    private void handlePayment(ActionEvent e) {
        int selectedRow = transactionTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select an order to pay.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Get corresponding transaction
        OrderTransaction transaction = orderController.getTransactions().get(selectedRow);

        if (transaction.isPaid()) {
            JOptionPane.showMessageDialog(this, "This order is already paid.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

      
        String[] options = {"Cash", "Mobile Money", "Cancel"};
        int choice = JOptionPane.showOptionDialog(
                this,
                "Choose payment method for " + transaction.getTotalPrice() + " UGX:",
                "Payment Method",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );


    }
}

