package br.com.phsaraiva.RoadMoney.model.dtos;

import br.com.phsaraiva.RoadMoney.model.User;

public record DtoUser(String nome , String email , String telephone , String password ) {

   public User convertDtoForUser(){
       return new User(nome, email, telephone, password);
    }

}
