package com.kz.valocheck.database.entity

import androidx.room.*

@Entity(tableName = "weapons")
data class WeaponEntity(
    @PrimaryKey val id: String,
    val name: String,
    val category: String,
    @ColumnInfo(name = "weapon_img") val weaponImg: String,
    @Embedded val weaponStats: WeaponStatsEntity,
    @Embedded val shopData: ShopDataEntity,
)

data class WeaponStatsEntity(
    @ColumnInfo(name = "fire_rate") val fireRate: String,
    @ColumnInfo(name = "magazine_size") val magazineSize: String,
    @ColumnInfo(name = "run_speed_multiplier") val runSpeedMultiplier: String,
    @ColumnInfo(name = "equip_time_second") val equipTimeSeconds: String,
    @ColumnInfo(name = "reload_time_second") val reloadTimeSeconds: String,
    @ColumnInfo(name = "wall_penetration")val wallPenetration: String,
    @ColumnInfo(name = "fire_mode") val fireMode: String
)

data class ShopDataEntity(
    val cost: String,
    @ColumnInfo(name = "shop_data_category") val category: String,
    @ColumnInfo(name = "category_text") val categoryText: String
)

@Entity(tableName = "damage_range")
data class DamageRangeEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "weapon_id") val weaponId: String,
    @ColumnInfo(name = "start_range") val startRange: String,
    @ColumnInfo(name = "end_range") val endRange: String,
    @ColumnInfo(name = "head_dmg") val headDmg: String,
    @ColumnInfo(name = "body_dmg") val bodyDmg: String,
    @ColumnInfo(name = "leg_dmg") val legDmg: String
)

data class WeaponInfo (
    @Embedded val weapon: WeaponEntity,

    @Relation (parentColumn = "id", entityColumn = "weapon_id")
    val dmgRange: List<DamageRangeEntity>
)