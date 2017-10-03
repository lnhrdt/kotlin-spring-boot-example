package io.leonhardt.kotlinspringbootexample.friend

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Friend(
        @Id
        val id: UUID = UUID(0, 0),
        val name: String
)
