package com.jetpack.compose.presentation.mapper

import com.jetpack.compose.presentation.model.Animal
import com.jetpack.compose.domain.model.Animal as DomainAnimal

class AnimalUIMapper {
    fun toUI(list: List<DomainAnimal>): List<Animal> {
        return list.map { toDomain(it) }
    }

    private fun toDomain(animal: DomainAnimal): Animal {
        return Animal(
            id = animal.id,
            name = animal.name,
            breeds = animal.breeds,
            image = animal.image,
            description = animal.description
        )
    }
}