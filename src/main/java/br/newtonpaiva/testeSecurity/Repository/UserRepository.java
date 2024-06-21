package br.newtonpaiva.testeSecurity.Repository;

import br.newtonpaiva.testeSecurity.Model.UserRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserRequest, String>  {
    UserRequest findByUsername(String username);
}
