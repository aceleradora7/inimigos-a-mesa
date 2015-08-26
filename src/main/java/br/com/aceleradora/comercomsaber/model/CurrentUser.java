package br.com.aceleradora.comercomsaber.model;

import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private Usuario user;

    public CurrentUser(Usuario user) {
        super(user.getEmail(), user.getSenha(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public Usuario getUser() {
        return user;
    }

    public int getId() {
        return user.getCodigo();
    }

    public Role getRole() {
        return user.getRole();
    }

}