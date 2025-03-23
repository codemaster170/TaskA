package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static org.junit.jupiter.api.Assertions.*;

class MenuPanelTest {

    @Test
    public void testConfirmOrder() {
        OrderController controller = new OrderController(new ActivityLogger());
        MenuPanel panel = new MenuPanel(controller);

        DefaultTableModel tableModel = (DefaultTableModel) panel.getMenuTable().getModel();
        tableModel.setValueAt(true, 0, 0);

        JButton confirmOrderButton = (JButton) panel.getComponent(2);
        confirmOrderButton.doClick();

        assertEquals(1, controller.getCurrentOrder().size());
        OrderItem item = controller.getCurrentOrder().get(0);
        assertEquals("Rice + Sauce Chicken", item.getName());
        assertEquals(10000, item.getPrice());
        assertEquals(1, item.getQuantity());

    }

    @Test
    public void testResetMenuSelections() {
        OrderController controller = new OrderController(new ActivityLogger());
        MenuPanel panel = new MenuPanel(controller);

        JTable menuTable = panel.getMenuTable();
        DefaultTableModel tableModel = (DefaultTableModel) menuTable.getModel();
        tableModel.setValueAt(true, 0, 0);

        assertTrue((Boolean) tableModel.getValueAt(0, 0));

        panel.resetMenuSelections();

        assertFalse((Boolean) tableModel.getValueAt(0, 0));
    }
}
