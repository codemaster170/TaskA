package org.example;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ActivityPanelTest {
  @Test
    public void ActivityPanel() {
        ActivityLogger logger = new ActivityLogger();
        ActivityPanel panel = new ActivityPanel(logger);
        assertNotNull(panel);
        assertNotNull(panel.getLogger());
    }
    @Test
    public void refreshActivityLog() {
        ActivityLogger logger = new ActivityLogger();
        ActivityPanel panel = new ActivityPanel(logger);
        logger.log("Test log message 1");
        logger.log("Test log message 2");
        panel.refreshActivityLog();
        String expectedText = "Test log message 1\nTest log message 2\n";
        assertEquals(expectedText, panel.getactivityTextArea().getText());
    }

  }
  
