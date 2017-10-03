package io.leonhardt.kotlinspringbootexample.friend

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/friends")
class FriendController(private val friendRepository: FriendRepository) {

    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.GET))
    fun getOne(@PathVariable id: UUID): ResponseEntity<Friend> {
        val friend = friendRepository.findById(id)
        return when {
            friend.isPresent -> ResponseEntity.ok(friend.get())
            else -> ResponseEntity.notFound().build()
        }
    }

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun getAll(): ResponseEntity<Iterable<Friend>> {
        val friends = friendRepository.findAll()
        return ResponseEntity.ok(friends)
    }

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun create(@RequestBody friend: Friend): ResponseEntity<Friend> {
        val createdFriend = friendRepository.save(friend)
        return ResponseEntity.ok(createdFriend)
    }
}
