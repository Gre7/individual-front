package ru.nino.individual.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.nino.individual.entity.Action
import ru.nino.individual.entity.Company

@Repository
interface CompanyRepository : CrudRepository<Company, Long> {
}