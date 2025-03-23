package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityLoggerTest {
    @org.junit.jupiter.api.Test
    public void testConstructor() {
        ActivityLogger logger = new ActivityLogger();
        assertNotNull(logger);
        assertTrue(logger.getActivityLog().isEmpty());
    }

    @Test
    void getActivityLog() {
        ActivityLogger logger = new ActivityLogger();
        String message1 = "Test message 1";
        String message2 = "Test message 2";
        logger.log(message1);
        logger.log(message2);
        List<String> activityLog = logger.getActivityLog();
        assertEquals(2, activityLog.size());
        assertEquals(message1, activityLog.get(0));
        assertEquals(message2, activityLog.get(1));
    }

    @Test
    void clearLog() {
        ActivityLogger logger = new ActivityLogger();
        String message1 = "Test message 1";
        String message2 = "Test message 2";
        logger.log(message1);
        logger.log(message2);
        logger.clearLog();
        assertTrue(logger.getActivityLog().isEmpty());
    }

}