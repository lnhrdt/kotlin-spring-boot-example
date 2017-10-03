package io.leonhardt.kotlinspringbootexample.friend

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension::class)
@DataJpaTest
class FriendRepositoryTest {

    @Autowired
    lateinit var friendRepository: FriendRepository

    @Test
    fun `save should persist a new Friend`() {
        val newFriend = Friend(name = "abc123")

        val savedFriend = friendRepository.save(newFriend)

        assertThat(savedFriend.name).isEqualTo("abc123")
    }

    @Test
    fun `save should assign a new UUID id to new Friends`() {
        val newFriend = Friend(name = "abc123")

        val savedFriend = friendRepository.save(newFriend)

        assertThat(savedFriend.id).isNotEqualTo(UUID(0, 0))
    }
}
