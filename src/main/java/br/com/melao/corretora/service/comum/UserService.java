package br.com.melao.corretora.service.comum;

import br.com.melao.corretora.model.comum.User;
import br.com.melao.corretora.repository.comum.UserRepository;
import br.com.melao.corretora.service.seguranca.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private EncryptionService encryptionService;
    private UserRepository repository;

    @Autowired
    public UserService(EncryptionService encryptionService, UserRepository repository) {
        this.encryptionService = encryptionService;
        this.repository = repository;
    }

    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public User save(User user) {
        if (user.getPassword() != null) {
            user.setEncryptedPassword(encryptionService.encryptString(user.getPassword()));
        }
        return repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }
}
