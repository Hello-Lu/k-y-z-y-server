package com.server.model;


import lombok.Data;

@Data
public class UserJwt{
    private String id;
    private String name;
    private String userpic;
    private String utype;
    private String companyId;
}
