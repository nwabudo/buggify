package com.neookpara.buggify.repository;

import com.neookpara.buggify.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    @Test
    void should_find_email_user_by_email(){
        User sampleUser = new User("Emmanuel", "Nwabudo", "emmanuel.nwabudo@ratepay.com");
        entityManager.persist(sampleUser);

        String email = "emmanuel.nwabudo@ratepay.com";
        User user = userRepository.findByEmail(email).orElse(null);

        assertThat(user).hasFieldOrPropertyWithValue("firstName", sampleUser.getFirstName());
        assertThat(user).hasFieldOrPropertyWithValue("lastName", sampleUser.getLastName());
        assertThat(user).hasFieldOrPropertyWithValue("email", sampleUser.getEmail());

        entityManager.remove(user);
    }
}