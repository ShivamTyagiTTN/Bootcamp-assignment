package demo.service;

import demo.domain.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;

class EmailServiceTest {

    Order order;
    EmailService emailService = new EmailService();

    @Test
    void ShouldReturnTrueIf_EmailServiceInstanceReturned() {
        assertInstanceOf(EmailService.class, emailService);
    }

    @Test
    void ShouldThrowRuntimeException() {

        //when
        Executable executable = () -> emailService.sendEmail(order);
        //then
        assertThrows(RuntimeException.class, executable);

    }

    @Test
    void ShouldReturnTrue_ifEmailSent() {

        //given
        String testString = "hello";
        //then
        assertTrue(emailService.sendEmail(order, testString));
    }
}