
    package org.example;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import org.junit.platform.commons.annotation.Testable;

import javax.swing.table.DefaultTableModel;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

   public class RevenuePanelTest {

        private RevenuePanel revenuePanel;
        private OrderController orderController;

        @Testable
        void setUp() {
            ActivityLogger logger = new ActivityLogger();
            orderController = new OrderController(logger);
            revenuePanel = new RevenuePanel(orderController);
        }


        @Test
        public void testRefreshRevenueData() {

            OrderItem item1 = new OrderItem("Phone", 500000, 1);
            OrderItem item2 = new OrderItem("Charger", 50000, 2);

            OrderTransaction transaction1 = new OrderTransaction(List.of(item1),
                    true, item1.getTotalPrice());
            OrderTransaction transaction2 = new OrderTransaction(List.of(item2),
                    false, item2.getTotalPrice());

            orderController.getTransactions().add(transaction1);
            orderController.getTransactions().add(transaction2);

            revenuePanel.refreshRevenueData();

            DefaultTableModel model = (DefaultTableModel) revenuePanel.revenueTable.getModel();
            assertEquals(String.valueOf(2), model.getRowCount(), "Table should contain two transactions.");

            assertEquals("Total Revenue: 500000 UGX", revenuePanel.totalRevenueLabel.getText());
            assertEquals("Unpaid Amount: 100000 UGX", revenuePanel.unpaidLabel.getText());


              }

               }



