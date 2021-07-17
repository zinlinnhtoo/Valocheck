package com.kz.valocheck.mapper

import com.kz.valocheck.database.entity.RoleEntity
import com.kz.valocheck.domain.RoleDomain

fun RoleEntity.asDomain() : RoleDomain {
    return RoleDomain(
        id = roleId,
        name = name,
        description = description,
        icon = icon
    )
}