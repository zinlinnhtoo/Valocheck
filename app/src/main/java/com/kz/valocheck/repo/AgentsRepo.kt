package com.kz.valocheck.repo

import com.kz.valocheck.R
import com.kz.valocheck.domain.AbilityDomain
import com.kz.valocheck.domain.AgentsDomain
import com.kz.valocheck.domain.RoleDomain
import javax.inject.Inject

class AgentsRepo @Inject constructor() {

    private val mockAgentList = listOf(
        AgentsDomain(
            "1",
            "Jett1",
            R.drawable.agent_profile_display_icon,
            R.drawable.agent_fullportrait,
            "Description description",
            "Wushu",
            listOf(
                AbilityDomain(
                    "Ability1",
                    "Updraft",
                    "INSTANTLY propel Jett high into the air.",
                    R.drawable.spell_ability1_displayicon
                ),
                AbilityDomain(
                    "Ability2",
                    "Tailwind",
                    "INSTANTLY propel Jett in the direction she is moving. If Jett is standing still, she will propel forward.",
                    R.drawable.spell_ability2_displayicon
                ),
                AbilityDomain(
                    "Grenade",
                    "Cloudburst",
                    "INSTANTLY throw a projectile that expands into a brief vision-blocking cloud on impact with a surface. HOLD the ability key to curve the smoke in the direction of your crosshair.",
                    R.drawable.spell_grenade_displayicon
                ),
                AbilityDomain(
                    "Passive",
                    "Drift",
                    "Holding the jump button while falling allows you to glide through the air.",
                    R.drawable.spell_passive_displayicon
                ),
                AbilityDomain(
                    "Ultimate",
                    "Blade Storm",
                    "EQUIP a set of highly accurate throwing knives that recharge on killing an opponent. FIRE to throw a single knife at your target. ALTERNATE FIRE to throw all remaining daggers at your target.",
                    R.drawable.spell_ultimate_displayicon
                )
            ),
            RoleDomain(
                "1",
                "Duelist",
                "Duelists are self-sufficient fraggers who their team expects, through abilities and skills, to get high frags and seek out engagements first.",
                R.drawable.agent_role_displayicon
            )
        ),
        AgentsDomain(
            "2",
            "Jett2",
            R.drawable.agent_profile_display_icon,
            R.drawable.agent_fullportrait,
            "Description description",
            "Wushu",
            listOf(
                AbilityDomain(
                    "Ability1",
                    "Updraft2",
                    "INSTANTLY propel Jett high into the air.",
                    R.drawable.spell_ability1_displayicon
                ),
                AbilityDomain(
                    "Ability2",
                    "Tailwind2",
                    "INSTANTLY propel Jett in the direction she is moving. If Jett is standing still, she will propel forward.",
                    R.drawable.spell_ability2_displayicon
                ),
                AbilityDomain(
                    "Grenade",
                    "Cloudburst2",
                    "INSTANTLY throw a projectile that expands into a brief vision-blocking cloud on impact with a surface. HOLD the ability key to curve the smoke in the direction of your crosshair.",
                    R.drawable.spell_grenade_displayicon
                ),
                AbilityDomain(
                    "Passive",
                    "Drift2",
                    "Holding the jump button while falling allows you to glide through the air.",
                    R.drawable.spell_passive_displayicon
                ),
                AbilityDomain(
                    "Ultimate",
                    "Blade Storm2",
                    "EQUIP a set of highly accurate throwing knives that recharge on killing an opponent. FIRE to throw a single knife at your target. ALTERNATE FIRE to throw all remaining daggers at your target.",
                    R.drawable.spell_ultimate_displayicon
                )
            ),
            RoleDomain(
                "1",
                "Duelist2",
                "Duelists are self-sufficient fraggers who their team expects, through abilities and skills, to get high frags and seek out engagements first.",
                R.drawable.agent_role_displayicon
            )
        ),
        AgentsDomain(
            "3",
            "Jett3",
            R.drawable.agent_profile_display_icon,
            R.drawable.agent_fullportrait,
            "Description description",
            "Wushu",
            listOf(
                AbilityDomain(
                    "Ability1",
                    "Updraft3",
                    "INSTANTLY propel Jett high into the air.",
                    R.drawable.spell_ability1_displayicon
                ),
                AbilityDomain(
                    "Ability2",
                    "Tailwind3",
                    "INSTANTLY propel Jett in the direction she is moving. If Jett is standing still, she will propel forward.",
                    R.drawable.spell_ability2_displayicon
                ),
                AbilityDomain(
                    "Grenade",
                    "Cloudburst3",
                    "INSTANTLY throw a projectile that expands into a brief vision-blocking cloud on impact with a surface. HOLD the ability key to curve the smoke in the direction of your crosshair.",
                    R.drawable.spell_grenade_displayicon
                ),
                AbilityDomain(
                    "Passive",
                    "Drift3",
                    "Holding the jump button while falling allows you to glide through the air.",
                    R.drawable.spell_passive_displayicon
                ),
                AbilityDomain(
                    "Ultimate",
                    "Blade Storm3",
                    "EQUIP a set of highly accurate throwing knives that recharge on killing an opponent. FIRE to throw a single knife at your target. ALTERNATE FIRE to throw all remaining daggers at your target.",
                    R.drawable.spell_ultimate_displayicon
                )
            ),
            RoleDomain(
                "1",
                "Duelist3",
                "Duelists are self-sufficient fraggers who their team expects, through abilities and skills, to get high frags and seek out engagements first.",
                R.drawable.agent_role_displayicon
            )
        ),
        AgentsDomain(
            "4",
            "Jett4",
            R.drawable.agent_profile_display_icon,
            R.drawable.agent_fullportrait,
            "Description description",
            "Wushu",
            listOf(
                AbilityDomain(
                    "Ability1",
                    "Updraft4",
                    "INSTANTLY propel Jett high into the air.",
                    R.drawable.spell_ability1_displayicon
                ),
                AbilityDomain(
                    "Ability2",
                    "Tailwind4",
                    "INSTANTLY propel Jett in the direction she is moving. If Jett is standing still, she will propel forward.",
                    R.drawable.spell_ability2_displayicon
                ),
                AbilityDomain(
                    "Grenade",
                    "Cloudburst4",
                    "INSTANTLY throw a projectile that expands into a brief vision-blocking cloud on impact with a surface. HOLD the ability key to curve the smoke in the direction of your crosshair.",
                    R.drawable.spell_grenade_displayicon
                ),
                AbilityDomain(
                    "Passive",
                    "Drift4",
                    "Holding the jump button while falling allows you to glide through the air.",
                    R.drawable.spell_passive_displayicon
                ),
                AbilityDomain(
                    "Ultimate",
                    "Blade Storm4",
                    "EQUIP a set of highly accurate throwing knives that recharge on killing an opponent. FIRE to throw a single knife at your target. ALTERNATE FIRE to throw all remaining daggers at your target.",
                    R.drawable.spell_ultimate_displayicon
                )
            ),
            RoleDomain(
                "1",
                "Duelist4",
                "Duelists are self-sufficient fraggers who their team expects, through abilities and skills, to get high frags and seek out engagements first.",
                R.drawable.agent_role_displayicon
            )
        ),
        AgentsDomain(
            "5",
            "Jett5",
            R.drawable.agent_profile_display_icon,
            R.drawable.agent_fullportrait,
            "Description description",
            "Wushu",
            listOf(
                AbilityDomain(
                    "Ability1",
                    "Updraft5",
                    "INSTANTLY propel Jett high into the air.",
                    R.drawable.spell_ability1_displayicon
                ),
                AbilityDomain(
                    "Ability2",
                    "Tailwind5",
                    "INSTANTLY propel Jett in the direction she is moving. If Jett is standing still, she will propel forward.",
                    R.drawable.spell_ability2_displayicon
                ),
                AbilityDomain(
                    "Grenade",
                    "Cloudburst5",
                    "INSTANTLY throw a projectile that expands into a brief vision-blocking cloud on impact with a surface. HOLD the ability key to curve the smoke in the direction of your crosshair.",
                    R.drawable.spell_grenade_displayicon
                ),
                AbilityDomain(
                    "Passive",
                    "Drift5",
                    "Holding the jump button while falling allows you to glide through the air.",
                    R.drawable.spell_passive_displayicon
                ),
                AbilityDomain(
                    "Ultimate",
                    "Blade Storm5",
                    "EQUIP a set of highly accurate throwing knives that recharge on killing an opponent. FIRE to throw a single knife at your target. ALTERNATE FIRE to throw all remaining daggers at your target.",
                    R.drawable.spell_ultimate_displayicon
                )
            ),
            RoleDomain(
                "1",
                "Duelist5",
                "Duelists are self-sufficient fraggers who their team expects, through abilities and skills, to get high frags and seek out engagements first.",
                R.drawable.agent_role_displayicon
            )
        ),
        AgentsDomain(
            "6",
            "Jett6",
            R.drawable.agent_profile_display_icon,
            R.drawable.agent_fullportrait,
            "Description description",
            "Wushu",
            listOf(
                AbilityDomain(
                    "Ability1",
                    "Updraft6",
                    "INSTANTLY propel Jett high into the air.",
                    R.drawable.spell_ability1_displayicon
                ),
                AbilityDomain(
                    "Ability2",
                    "Tailwind6",
                    "INSTANTLY propel Jett in the direction she is moving. If Jett is standing still, she will propel forward.",
                    R.drawable.spell_ability2_displayicon
                ),
                AbilityDomain(
                    "Grenade",
                    "Cloudburst6",
                    "INSTANTLY throw a projectile that expands into a brief vision-blocking cloud on impact with a surface. HOLD the ability key to curve the smoke in the direction of your crosshair.",
                    R.drawable.spell_grenade_displayicon
                ),
                AbilityDomain(
                    "Passive",
                    "Drift6",
                    "Holding the jump button while falling allows you to glide through the air.",
                    R.drawable.spell_passive_displayicon
                ),
                AbilityDomain(
                    "Ultimate",
                    "Blade Storm6",
                    "EQUIP a set of highly accurate throwing knives that recharge on killing an opponent. FIRE to throw a single knife at your target. ALTERNATE FIRE to throw all remaining daggers at your target.",
                    R.drawable.spell_ultimate_displayicon
                )
            ),
            RoleDomain(
                "1",
                "Duelist6",
                "Duelists are self-sufficient fraggers who their team expects, through abilities and skills, to get high frags and seek out engagements first.",
                R.drawable.agent_role_displayicon
            )
        ),
        AgentsDomain(
            "7",
            "Jett7",
            R.drawable.agent_profile_display_icon,
            R.drawable.agent_fullportrait,
            "Description description",
            "Wushu",
            listOf(
                AbilityDomain(
                    "Ability1",
                    "Updraft7",
                    "INSTANTLY propel Jett high into the air.",
                    R.drawable.spell_ability1_displayicon
                ),
                AbilityDomain(
                    "Ability2",
                    "Tailwind7",
                    "INSTANTLY propel Jett in the direction she is moving. If Jett is standing still, she will propel forward.",
                    R.drawable.spell_ability2_displayicon
                ),
                AbilityDomain(
                    "Grenade",
                    "Cloudburst7",
                    "INSTANTLY throw a projectile that expands into a brief vision-blocking cloud on impact with a surface. HOLD the ability key to curve the smoke in the direction of your crosshair.",
                    R.drawable.spell_grenade_displayicon
                ),
                AbilityDomain(
                    "Passive",
                    "Drift7",
                    "Holding the jump button while falling allows you to glide through the air.",
                    R.drawable.spell_passive_displayicon
                ),
                AbilityDomain(
                    "Ultimate",
                    "Blade Storm7",
                    "EQUIP a set of highly accurate throwing knives that recharge on killing an opponent. FIRE to throw a single knife at your target. ALTERNATE FIRE to throw all remaining daggers at your target.",
                    R.drawable.spell_ultimate_displayicon
                )
            ),
            RoleDomain(
                "1",
                "Duelist7",
                "Duelists are self-sufficient fraggers who their team expects, through abilities and skills, to get high frags and seek out engagements first.",
                R.drawable.agent_role_displayicon
            )
        )
    )

    //get agents
    fun getAgentsList(): List<AgentsDomain> {
        return mockAgentList
    }

    fun getAgentDetails(id: String): AgentsDomain {
        return mockAgentList.find { it.id == id }!!
    }
}