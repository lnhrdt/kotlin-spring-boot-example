package io.leonhardt.kotlinspringbootexample.friend

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FriendRepository : CrudRepository<Friend, UUID>
