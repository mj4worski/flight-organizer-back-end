package infrastructure.security;

import client.Client;
import client.ClientRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
class SpringDataJpaUserDetailsService implements UserDetailsService {

    private final ClientRepository repository;

    public SpringDataJpaUserDetailsService(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Client client = repository.findByLogin(login);
        return new User(client.getLogin(), client.getPassword(), AuthorityUtils.createAuthorityList(client.getRole()));
    }
}
