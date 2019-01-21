package com.example.mybatis.provider

class ProductProvider {

    fun findAllBy(type: Int? = null, brandId: Int? = null): String {
        var select = "SELECT s.id, ten_san_pham as name, so_luong as qty, tinh_trang as status, env, " +
                " g.id as g_id, gia as value, active"

        select = "$select from san_phams s"
        select = "$select join gia_san_phams g on g.san_pham_id = s.id"
        type?.let {
            select = "$select where loai_san_pham_id = #{type}"
        }
        return select
    }
}
