package ru.nino.individual.controller

import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*
import ru.nino.individual.entity.Action
import ru.nino.individual.entity.Company
import ru.nino.individual.entity.ImageEntity
import ru.nino.individual.repository.ActionRepository
import ru.nino.individual.repository.CompanyRepository
import ru.nino.individual.repository.ImageRepository
import java.util.function.Consumer

@RequestMapping("company")
@RestController
class CompanyController(
    val repository: CompanyRepository,
    val repositoryAction: ActionRepository,
    val imageRepository: ImageRepository
) {

    @GetMapping("all")
    fun getAllActions(): MutableIterable<Company> {
        return repository.findAll()
    }

    @GetMapping("{id}")
    fun getById(@PathVariable(value = "id") id: Long): Company? {
        return repository.findByIdOrNull(id)
    }

    @PostMapping
    fun createNewObject(@RequestBody entity: Company): Company {
        return repository.save(entity)
    }

    @DeleteMapping("{id}")
    fun deleteById(@PathVariable(value = "id") id: Long): Boolean {
        return try {
            repository.deleteById(id)
            true
        } catch (e: Exception) {
            false
        }
    }

    @PutMapping("{id}")
    fun addedAction(@PathVariable id: Long, @RequestBody actions: List<Long>): Company? {
        val findAllById = repositoryAction.findAllById(actions)
        val companyOptional = repository.findById(id)
        if (companyOptional.isPresent) {
            val get = companyOptional.get()
            get.actions = findAllById as MutableList<Action>
            return get;
        }
        return null;
    }

    @PutMapping("{id}/addedImage")
    fun addedImage(@PathVariable id: Long, @RequestBody images: List<Long>): Company {
        val findAllById = imageRepository.findAllById(images)
        var company = repository.findByIdOrNull(id)
        company?.imageEntity = findAllById as MutableList<ImageEntity>

        if (company != null) {
            return repository.save(company)
        }
        return Company.EMPTY;
    }

}