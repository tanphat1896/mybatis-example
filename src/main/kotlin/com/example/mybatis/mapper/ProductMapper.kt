package com.example.mybatis.mapper

import com.example.mybatis.domain.Product
import com.example.mybatis.domain.ProductPrice
import com.example.mybatis.provider.ProductProvider
import org.apache.ibatis.annotations.*
import org.apache.ibatis.mapping.FetchType
import org.apache.ibatis.type.BooleanTypeHandler
import org.apache.ibatis.type.JdbcType

@Mapper
interface ProductMapper {

    @SelectProvider(type = ProductProvider::class, method = "findAllBy")
//    @Results(
//        Result(property = "id", column = "id", javaType = Int::class),
//        Result(property = "name", column = "name", javaType = String::class),
//        Result(property = "qty", column = "qty", javaType = Int::class),
//        Result(property = "status", column = "status", javaType = Boolean::class, typeHandler = BooleanTypeHandler::class)
////            ,
////        Result(property = "prices", column = "id", javaType = MutableList::class,
////            many = Many(select = "findPricesByProductId", fetchType = FetchType.LAZY)
////        )
//    )
//    @ConstructorArgs(
//        Arg(column = "id", javaType = Int::class),
//        Arg(column = "name", javaType = String::class),
//        Arg(column = "qty", javaType = Int::class),
//        Arg(column = "status", javaType = Boolean::class)
//    )
    @ResultMap("RS")
    fun findAll(type: Int? = null, brandId: Int? = null): List<Product>


    @Select("select id, gia as value, active from gia_san_phams where san_pham_id = #{pId}")
    @ConstructorArgs(
        Arg(column = "id", javaType = Int::class),
        Arg(column = "value", javaType = Long::class),
        Arg(column = "active", javaType = Int::class)
    )
    fun findPricesByProductId(pId: Int): MutableList<ProductPrice>
}
