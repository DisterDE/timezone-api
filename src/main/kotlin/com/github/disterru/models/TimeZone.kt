package com.github.disterru.models

import com.github.disterru.plugins.ZonedDateTimeSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.ZonedDateTime

@Serializable
data class TimeZone(
    val abbreviation: String,
    @SerialName("client_ip")
    val clientIp: String,
    @SerialName("datetime")
    @Serializable(ZonedDateTimeSerializer::class)
    val dateTime: ZonedDateTime,
    @SerialName("day_of_week")
    val dayOfWeek: Int,
    @SerialName("day_of_year")
    val dayOfYear: Int,
    @SerialName("timezone")
    val timeZone: String,
    @SerialName("utc_offset")
    val utcOffset: String,
    @SerialName("utc_datetime")
    @Serializable(ZonedDateTimeSerializer::class)
    val utcDateTime: ZonedDateTime,
    @SerialName("unixtime")
    val unixTime: Long,
    @SerialName("week_number")
    val weekNumber: Int
)