package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TransactionPanelTest {

    private TransactionPanel transactionPanel;
    private OrderController orderController;

    @BeforeEach
    void setUp() {
        ActivityLogger logger = new ActivityLogger();
        orderController = new OrderController(logger);
        transactionPanel = new TransactionPanel(orderController);
    }

          @Test
           void testRefreshTransactionTable() {
            OrderItem item1 = new OrderItem("Phone", 500000, 1);
            OrderTransaction transaction1 = new OrderTransaction(Arrays.asList(item1),
                false, item1.getTotalPrice());
              orderController.getTransactions().add(transaction1);

             SwingUtilities.invokeLater(transactionPanel::refreshTransactionTable);


            DefaultTableModel model = (DefaultTableModel) transactionPanel.transactionTable.getModel();
            assertEquals(0, model.getRowCount());
            assertEquals("Order 1", model.getValueAt(0, 0));
            assertEquals("Pending", model.getValueAt(0, 3));
            }

           }
