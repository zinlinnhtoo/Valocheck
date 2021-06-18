package com.kz.valocheck.network

import com.kz.valocheck.domain.AbilityDomain
import com.kz.valocheck.domain.AgentsDomain
import com.kz.valocheck.domain.RoleDomain
import com.squareup.moshi.Json

data class AgentResponse(
    val status: Int?,
    val data: List<AgentDto>?
)

data class AgentDto (
    @Json(name = "uuid") val id : String?,
    @Json(name = "displayName") val name: String?,
    @Json(name = "displayIcon")val profile: String?,
    @Json(name = "fullPortrait")val portrait: String?,
    val description: String?,
    val developerName: String?,
    val abilities: List<AbilityDto>?,
    val role: RoleDto?
)

data class AbilityDto(
    val slot : String?,
    @Json(name = "displayName") val name: String?,
    val description: String?,
    @Json(name = "displayIcon") val icon : String?
)

data class RoleDto(
    @Json(name = "uuid") val id: String?,
    @Json(name = "displayName") val name: String?,
    val description: String?,
    @Json(name = "displayIcon") val icon: String?
)

data class  AgentDetailResponse(
    val status: Int?,
    val data: AgentDto?
)

