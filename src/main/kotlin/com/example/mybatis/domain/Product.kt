package com.example.mybatis.domain

data class Product(
        val id: Int? = 0,
        val name: String? = "",
        val qty: Int? = 0,
        val status: Int? = 0,
        val env: MutableSet<String> = mutableSetOf()
) {
    val prices: MutableSet<ProductPrice> = mutableSetOf()
}
