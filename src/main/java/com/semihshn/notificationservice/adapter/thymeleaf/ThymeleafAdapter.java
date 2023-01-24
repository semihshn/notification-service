package com.semihshn.notificationservice.adapter.thymeleaf;

import com.semihshn.notificationservice.domain.exception.ExceptionType;
import com.semihshn.notificationservice.domain.exception.SemMailException;
import com.semihshn.notificationservice.domain.notification.thymeleaf.EmailNotification;
import com.semihshn.notificationservice.domain.notification.thymeleaf.EmailResponse;
import com.semihshn.notificationservice.domain.port.EmailPort;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class ThymeleafAdapter implements EmailPort {

    public static final String MAIL_TEMPLATE_NAME = "mail";
    private final TemplateEngine templateEngine;

    private final JavaMailSender javaMailSender;

    private final ThymeleafProperties thymeleafProperties;

    @Override
    public EmailResponse send(EmailNotification notification) {

        try {
            Context context = new Context();
            context.setVariable("notification", notification);

            String process = templateEngine.process(MAIL_TEMPLATE_NAME, context);
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setSubject("Welcome " + notification.getFirstName());
            helper.setText(process, true);
            helper.setTo(notification.getMail());

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new SemMailException(ExceptionType.MAIL_ERROR, e.getMessage());
        }

        return EmailResponse.from(thymeleafProperties.getUsername(), notification.getMail());
    }
}

