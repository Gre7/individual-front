package ru.nino.individual.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import ru.nino.individual.entity.ImageEntity
import ru.nino.individual.repository.ImageRepository

@RequestMapping("image")
@RestController
class ImageController(
    val imageRepository: ImageRepository
) {

    @PostMapping
    fun saveImage(@RequestParam file: MultipartFile): ImageEntity {
        return imageRepository.save(ImageEntity(null, file.bytes))
    }

}