package org.example;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

    public class
    OrderTransactionTest {
        @org.junit.Test
        public void OrderTransaction() {
            OrderItem item = new OrderItem("Test Item", 10, 2);
            List<OrderItem> items = List.of(item);
            OrderTransaction transaction = new OrderTransaction(items, true,
                    20);
            assertNotNull(transaction);
            assertEquals(items, transaction.getItems());
            assertTrue(transaction.isPaid());
            assertEquals(20, transaction.getTotalPrice());
            assertEquals("Not Paid", transaction.getPaymentMethod());
        }

        @Test
        public void getTotalAmount() {
            OrderItem item = new OrderItem("Test Item", 10, 2);
            List<OrderItem> items = List.of(item);
            OrderTransaction transaction = new OrderTransaction(items, true,
                    20);
            assertEquals(20, transaction.getTotalAmount());
        }

   @Test
   public void setPaid() {
            OrderItem item = new OrderItem("Test Item", 10, 2);
            List<OrderItem> items = List.of(item);
            OrderTransaction transaction = new OrderTransaction(items, false, 20);
            assertFalse(transaction.isPaid());
            transaction.setPaid(true);
            assertTrue(transaction.isPaid());
        }
        @Test
        public void setPaymentMethod() {
            OrderItem item = new OrderItem("Test Item", 10, 2);
            List<OrderItem> items = List.of(item);
            OrderTransaction transaction = new OrderTransaction(items, true,
                    20);
            assertEquals("Not Paid", transaction.getPaymentMethod());
            transaction.setPaymentMethod("Cash");
            assertEquals("Cash", transaction.getPaymentMethod());

        }
        @Test
        public void testToString() {
            OrderItem item = new OrderItem("Test Item", 10, 2);
            List<OrderItem> items = List.of(item);
            OrderTransaction transaction = new OrderTransaction(items, true,
                    20);
            String expected = "OrderTransaction{items=[Test Item x2 (20 UGX)], isPaid=true, " +
                    "totalPrice=20, paymentMethod='Not Paid'}";
            assertEquals(expected, transaction.toString());
        }
    }
