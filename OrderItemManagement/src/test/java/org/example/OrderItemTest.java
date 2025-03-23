package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OrderItemTest {
@Test
    public void testConstructor() {
        OrderItem item = new OrderItem("Test Item", 10, 2);
        assertNotNull(item);
        assertEquals("Test Item", item.getName());
        assertEquals(10, item.getPrice());
        assertEquals(2, item.getQuantity());
    }

    @Test
    public void getQuantity() {
        OrderItem item = new OrderItem("Test Item", 10, 2);
        item.setQuantity(3);
        assertEquals(3, item.getQuantity());

    }

    @Test
    public void setQuantity() {
        OrderItem item = new OrderItem("Test Item", 10, 2);
        item.setQuantity(3);
        assertEquals(3, item.getQuantity());

    }

    @Test
    public void getTotalPrice() {
        OrderItem item = new OrderItem("Test Item", 10, 2);
        assertEquals(20, item.getTotalPrice());

    }

    @Test
    public void testToString() {
        OrderItem item = new OrderItem("Test Item", 10, 2);
        String expected = "Test Item x2 (20 UGX)";
        assertEquals(expected, item.toString());
    }
}