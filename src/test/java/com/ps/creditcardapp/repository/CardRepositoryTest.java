package com.ps.creditcardapp.repository;

import com.ps.creditcardapp.entity.Card;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CardRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    CardRepository sut;

    @Test
    public void testToSaveNewCard() {
        Card newCard = new Card();
        newCard.setId(7L);
        newCard.setName("test blahblah");
        newCard.setNumber("12345678903555");
        newCard.setLimitoncard(1000L);
        newCard.setBalance(100);

        newCard = entityManager.persistAndFlush(newCard);

        assertThat(sut.findById(newCard.getId()).get()).isEqualTo(newCard);
    }
}