package ru.nino.individual.controller

import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*
import ru.nino.individual.entity.Action
import ru.nino.individual.repository.ActionRepository

@RequestMapping("action")
@RestController
class ActionController(
    var actionRepository: ActionRepository
) {

    @GetMapping("all")
    fun getAllActions(): MutableIterable<Action> {
        return actionRepository.findAll()
    }

    @GetMapping("{id}")
    fun getById(@PathVariable(value = "id") id: Long): Action? {
        return actionRepository.findByIdOrNull(id)
    }

    @PostMapping
    fun createNewObject(@RequestBody action: Action): Action {
        return actionRepository.save(action)
    }

    @DeleteMapping("{id}")
    fun deleteById(@PathVariable(value = "id") id: Long): Boolean {
        return try {
            actionRepository.deleteById(id)
            true
        } catch (e: Exception) {
            false
        }
    }

}