package br.com.aceleradora.inimigosamesa.model;

import java.util.Properties;


import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

public class Email {

    private static final String HOST = "smtp.gmail.com";
    private static final String EMAIL_ORIGEM = "inimigosamesa@gmail.com";
    private static final String PORTA_HOST = "465";
    private static final String SENHA = "inimigos123";

    private Session sessao;

    public Email(){

        Properties props = new Properties();

        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.socketFactory.port", PORTA_HOST);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", PORTA_HOST);



        this.sessao = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(EMAIL_ORIGEM, SENHA);
            }

        });

        this.sessao.setDebug(true);

    }

    public void enviar(Formulario formulario){
        try {
            Message mensagemMime = new MimeMessage(sessao);
            mensagemMime.setFrom(new InternetAddress(EMAIL_ORIGEM));
            mensagemMime.setSubject("[Contato] - " + formulario.getAssunto());

            Address[] destinatario = InternetAddress.parse(EMAIL_ORIGEM);

            mensagemMime.setRecipients(Message.RecipientType.TO, destinatario);

            mensagemMime.setText("Nome remetente: "+formulario.getNome() +
                    "\nE-mail rementente: "+formulario.getEmailRemetente()+
                    "\n\n"+formulario.getMensagem());

            Transport.send(mensagemMime);

        } catch (MessagingException e){
            throw new RuntimeException(e);
        }
    }
}

