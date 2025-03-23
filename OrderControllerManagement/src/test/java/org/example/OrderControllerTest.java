package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderControllerTest {

    @Test
    void addOrderItem() {
        ActivityLogger logger = new ActivityLogger();
        OrderController controller = new OrderController(logger);
        OrderItem item = new OrderItem("Test Item", 10, 2);
        controller.addOrderItem(item);
        assertEquals(1, controller.getCurrentOrder().size());
        assertEquals(item, controller.getCurrentOrder().get(0));
    }

    @Test
        void removeOrderItem() {
        ActivityLogger logger = new ActivityLogger();
        OrderController controller = new OrderController(logger);
        OrderItem item1 = new OrderItem("Test Item 1", 10, 2);
        OrderItem item2 = new OrderItem("Test Item 2", 5, 1);
        controller.addOrderItem(item1);
        controller.addOrderItem(item2);
        controller.removeOrderItem(0);
        assertEquals(1, controller.getCurrentOrder().size());
        assertEquals(item2, controller.getCurrentOrder().get(0));
    }

    @Test
    void testClearOrder() {
        ActivityLogger logger = new ActivityLogger();
        OrderController controller = new OrderController(logger);
        OrderItem item1 = new OrderItem("Test Item 1", 10, 2);
        OrderItem item2 = new OrderItem("Test Item 2", 5, 1);
        controller.addOrderItem(item1);
        controller.addOrderItem(item2);
        controller.clearOrder();
        assertTrue(controller.getCurrentOrder().isEmpty());
    }

    @Test
    void finalizeOrder() {
        ActivityLogger logger = new ActivityLogger();
        OrderController controller = new OrderController(logger);
        OrderItem item1 = new OrderItem("Test Item 1", 10, 2);
        OrderItem item2 = new OrderItem("Test Item 2", 5, 1);
        controller.addOrderItem(item1);
        controller.addOrderItem(item2);
        controller.finalizeOrder(true);
        assertEquals(1, controller.getTransactions().size());
        assertTrue(controller.getCurrentOrder().isEmpty());

    }

    @Test
    void updateOrderItem() {
        ActivityLogger logger = new ActivityLogger();
        OrderController controller = new OrderController(logger);
        OrderItem item1 = new OrderItem("Test Item 1", 10, 2);
        OrderItem item2 = new OrderItem("Test Item 2", 5, 1);
        controller.addOrderItem(item1);
        controller.updateOrderItem(0, item2);
        assertEquals(1, controller.getCurrentOrder().size());
        assertEquals(item2, controller.getCurrentOrder().get(0));

    }
}
