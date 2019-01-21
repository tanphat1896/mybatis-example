package com.example.mybatis

import com.example.mybatis.mapper.ProductMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MybatisApplication : CommandLineRunner {

    @Autowired
    lateinit var productMapper: ProductMapper

    override fun run(vararg args: String?) {
//        val products = productMapper.findAll()
//        println(products)


        val products2 = productMapper.findAll(1)
        println(products2)
    }
}

fun main(args: Array<String>) {
	runApplication<MybatisApplication>(*args)
}

