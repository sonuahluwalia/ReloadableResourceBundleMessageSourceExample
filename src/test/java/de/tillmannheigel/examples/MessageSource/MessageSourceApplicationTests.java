package de.tillmannheigel.examples.MessageSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageSourceApplicationTests {

    @Autowired
    private ResourceBundleMessageSource resourceBundleMessageSource;

    @Test
    public void working() {
        String reversed = resourceBundleMessageSource.getMessage("hallo", null, Locale.GERMAN);
        assertThat(reversed).isEqualToIgnoringCase("ollah");
    }

    @Test
    public void notWorking() {
        String reversed = resourceBundleMessageSource.getMessage("invalidAdminPassword", null, Locale.US);
        assertThat(reversed).isEqualToIgnoringCase("Invalid password.");
    }
}
