package com.jetpack.compose.data.mapper

import com.jetpack.compose.data.model.Animal as DataAnimal
import com.jetpack.compose.domain.model.Animal as DomainAnimal

class AnimalDomainMapper {
    fun toDomain(list: List<DataAnimal>): List<DomainAnimal> {
        return list.map { toDomain(it) }
    }

    private fun toDomain(animal: DataAnimal): DomainAnimal {
        return DomainAnimal(
            id = animal.id,
            name = animal.name,
            breeds = animal.breeds,
            image = animal.image,
            description = animal.description
        )
    }
}