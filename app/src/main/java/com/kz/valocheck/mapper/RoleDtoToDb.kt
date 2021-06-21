package com.kz.valocheck.mapper

import com.kz.valocheck.database.entity.RoleEntity
import com.kz.valocheck.network.RoleDto

fun RoleDto?.asEntity() : RoleEntity {
    return this.run {
        RoleEntity(
            roleId = this?.id.orEmpty(),
            name = this?.name.orEmpty(),
            description = this?.description.orEmpty(),
            icon = this?.icon.orEmpty()
        )
    }
}