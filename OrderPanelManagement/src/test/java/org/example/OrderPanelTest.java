package org.example;

import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.junit.Assert.assertEquals;


public class OrderPanelTest {
   @Test
   public void refreshTable() {
        OrderController controller = new OrderController(new ActivityLogger());
        OrderPanel panel = new OrderPanel(controller);
        OrderItem item = new OrderItem("Test Item", 10000, 2);
        controller.addOrderItem(item);
        panel.refreshTable();
        JTable table = panel.getOrderTable();
        assertEquals(1, table.getRowCount());
        assertEquals(item.getName(), table.getValueAt(0, 0));
        assertEquals(item.getPrice(), table.getValueAt(0, 1));
        assertEquals(item.getQuantity(), table.getValueAt(0, 2));
        assertEquals(item.getTotalPrice(), table.getValueAt(0, 3));

    }

    @Test
    public void testDeleteOrder() {
        OrderController controller = new OrderController(new ActivityLogger());
        OrderPanel panel = new OrderPanel(controller);
        OrderItem item = new OrderItem("Test Item", 10000, 2);
        controller.addOrderItem(item);
        panel.refreshTable();
        JTable table = panel.getOrderTable();
        assertEquals(1, table.getRowCount());
        table.setRowSelectionInterval(0, 0); // Select the row to be deleted
        panel.deleteOrder(new ActionEvent(panel, 0, ""));
        assertEquals(0, table.getRowCount());

    }
}