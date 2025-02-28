package br.com.phsaraiva.RoadMoney.service;

import br.com.phsaraiva.RoadMoney.model.User;
import br.com.phsaraiva.RoadMoney.model.dtos.DtoLogin;
import br.com.phsaraiva.RoadMoney.model.dtos.DtoUser;
import br.com.phsaraiva.RoadMoney.repository.UserRepository;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String registerUser(DtoUser user) throws Exception {
       var isUser = userRepository.findByEmail(user.email());
       if (isUser.isPresent()) {
           throw new Exception("Usuario já Cadastrado");
       }
       userRepository.save(user.convertDtoForUser());
        return "Usuario Cadastrado";
    }

    @Override
    public String loginUser(DtoLogin user) throws Exception {
        var isUser = userRepository.findByEmail(user.email());
        userValid(isUser);
        if(user.email() != isUser.get().getEmail()  || user.password() != isUser.get().getPassword()) {
            throw new Exception("Email e senha invalida");
        }
        return "Login efetuado";
    }

    private boolean userValid(Optional<User> user) throws Exception {
        if (user.isEmpty()) {
            throw new Exception("Usuaio não encontrado ");
        }
        return true;
    }
}
