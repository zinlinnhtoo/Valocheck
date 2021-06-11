package com.kz.valocheck.domain

data class AgentsDomain(
    val id: String,
    val name: String,
    val profile: Int,
    val portrait: Int,
    val description: String,
    val developerName: String,
    val abilities: List<AbilityDomain>,
    val role: RoleDomain
)

data class RoleDomain(
    val id: String,
    val name: String,
    val description: String,
    val icon: Int
)



data class AbilityDomain(
    val slot: String,
    val name: String,
    val description: String,
    val icon: Int
)
