package fitlab.BussinessLogic.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.*;


class MailSenderServiceTest {
    @InjectMocks
    private MailSenderService mailSenderService;

    @Mock
    private JavaMailSender mailSender;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("send Should Send Email")
    void sendShouldSendEmail() {
        ReflectionTestUtils.setField(mailSenderService, "username", "username");
        mailSenderService.send("", "", "");
        verify(mailSender, times(1)).send((SimpleMailMessage) any());

    }
}