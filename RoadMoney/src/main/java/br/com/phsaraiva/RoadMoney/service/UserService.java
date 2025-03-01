package br.com.phsaraiva.RoadMoney.service;

import br.com.phsaraiva.RoadMoney.model.dtos.DtoLogin;
import br.com.phsaraiva.RoadMoney.model.dtos.DtoUser;

public interface UserService {
    String registerUser(DtoUser user) throws Exception;
    String loginUser(DtoLogin user) throws Exception;

}
