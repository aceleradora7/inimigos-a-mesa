package br.com.aceleradora.comercomsaber.model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {

    private static final String HOST = "smtp.gmail.com";
    private static final String EMAIL_DESTINATARIO = "portalcomercomsaber@gmail.com";
    private static final String PORTA_HOST = "465";
    private static final String SENHA = "portalccs123";

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
                return new PasswordAuthentication(EMAIL_DESTINATARIO, SENHA);
            }

        });
        this.sessao.setDebug(true);
    }

    public void enviar(FormularioEmail formularioEmail){

        try {
            Message mensagemMime = new MimeMessage(sessao);
            mensagemMime.setFrom(new InternetAddress(EMAIL_DESTINATARIO));
            mensagemMime.setSubject("[Contato Comer com saber] - " + formularioEmail.getAssunto());

            Address[] destinatario = InternetAddress.parse(EMAIL_DESTINATARIO);

            mensagemMime.setRecipients(Message.RecipientType.TO, destinatario);

            mensagemMime.setText("Nome remetente: "+ formularioEmail.getNome() +
                    "\nE-mail rementente: "+ formularioEmail.getEmailRemetente()+
                    "\n\nMensagem: \n" + formularioEmail.getMensagem());

            Transport.send(mensagemMime);

        } catch (MessagingException e){
            throw new RuntimeException(e);
        }
    }

    public void enviar(Usuario usuario){

        try{
            Message mensagemMime = new MimeMessage(sessao);
            mensagemMime.setFrom(new InternetAddress(usuario.getEmail()));
            mensagemMime.setSubject("[RECUPERAÇÃO DE SENHA]");
            Address[] destinatario = InternetAddress.parse(usuario.getEmail());
            mensagemMime.setRecipients(Message.RecipientType.TO, destinatario);
            mensagemMime.setText("Olá "+usuario.getNome()+", segue abaixo seus dados: "+
                    "\nUsuário: "+ usuario.getEmail()+
                    "\nSenha: "+usuario.getSenha());

            Transport.send(mensagemMime);
        }catch (MessagingException e){
            throw  new RuntimeException(e);
        }
    }
}

