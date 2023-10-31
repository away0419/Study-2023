package com.example.kotlin.member

enum class Role(
    val key: String,
    val title: String
) {
    ROLE_ADMIN("ROLE_ADMIN", "관리자"),
    ROLE_USER("ROLE_USER", "사용자")
}