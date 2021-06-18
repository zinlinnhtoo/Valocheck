        package com.kz.valocheck.domain

data class AgentsDomain(
    val id: String,
    val name: String,
    val profile: String,
    val portrait: String,
    val description: String,
    val developerName: String,
    val abilities: List<AbilityDomain>,
    val role: RoleDomain
)

data class RoleDomain(
    val id: String,
    val name: String,
    val description: String,
    val icon: String
)



data class AbilityDomain(
    val slot: String,
    val name: String,
    val description: String,
    val icon: String
)
