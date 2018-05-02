package br.com.melao.corretora.service.seguranca;

import br.com.melao.corretora.model.comum.User;
import br.com.melao.corretora.service.comum.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class SpringSecUserDetailsServiceImpl implements UserDetailsService {
    private UserService userService;

    private Converter<User, UserDetails> userDetailsConverter;

    @Autowired
    public SpringSecUserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    @Qualifier(value = "userToUserDetails")
    public void setUserDetailsConverter(Converter<User, UserDetails> userDetailsConverter) {
        this.userDetailsConverter = userDetailsConverter;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDetailsConverter.convert(userService.findByUsername(username));
    }
}
