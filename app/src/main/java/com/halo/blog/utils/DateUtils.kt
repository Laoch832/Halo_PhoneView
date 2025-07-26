package com.halo.blog.utils

import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.minus
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime


fun formatDate(dateString: String): String {
    return try {
        val instant = Instant.parse(dateString)
        val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        
        val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        val today = now.date
        val yesterday = today.minus(1, DateTimeUnit.DAY)
        
        when (localDateTime.date) {
            today -> {
                val timeDiff = now.toInstant(TimeZone.currentSystemDefault()) - instant
                when {
                    timeDiff.inWholeMinutes < 1 -> "刚刚"
                    timeDiff.inWholeMinutes < 60 -> "${timeDiff.inWholeMinutes}分钟前"
                    timeDiff.inWholeHours < 24 -> "${timeDiff.inWholeHours}小时前"
                    else -> "今天 ${localDateTime.hour.toString().padStart(2, '0')}:${localDateTime.minute.toString().padStart(2, '0')}"
                }
            }
            yesterday -> "昨天 ${localDateTime.hour.toString().padStart(2, '0')}:${localDateTime.minute.toString().padStart(2, '0')}"
            else -> {
                val year = if (localDateTime.year == now.year) "" else "${localDateTime.year}年"
                "${year}${localDateTime.monthNumber}月${localDateTime.dayOfMonth}日"
            }
        }
    } catch (e: Exception) {
        // 如果解析失败，尝试其他格式或返回原始字符串
        try {
            // 尝试解析不同的日期格式
            val parts = dateString.split("T", "-", " ", ":")
            if (parts.size >= 3) {
                "${parts[0]}年${parts[1]}月${parts[2]}日"
            } else {
                dateString
            }
        } catch (e2: Exception) {
            dateString
        }
    }
}

fun formatRelativeTime(dateString: String): String {
    return try {
        val instant = Instant.parse(dateString)
        val now = Clock.System.now()
        val duration = now - instant

        when {
            duration.inWholeMinutes < 1 -> "刚刚"
            duration.inWholeHours < 1 -> "${duration.inWholeMinutes}分钟前"
            duration.inWholeDays < 1 -> "${duration.inWholeHours}小时前"
            duration.inWholeDays < 7 -> "${duration.inWholeDays}天前"
            else -> formatDate(dateString)
        }
    } catch (e: Exception) {
        ""
    }
}

fun formatFullDate(dateString: String): String {
    return try {
        val instant = Instant.parse(dateString)
        val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        
        "${localDateTime.year}年${localDateTime.monthNumber}月${localDateTime.dayOfMonth}日 " +
                "${localDateTime.hour.toString().padStart(2, '0')}:${localDateTime.minute.toString().padStart(2, '0')}"
    } catch (e: Exception) {
        dateString
    }
}