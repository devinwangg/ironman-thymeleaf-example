package com.ironman.demo.model.dao

import com.ironman.demo.model.entity.Todo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository
import java.util.*

/**
 *
 * @author wei-xiang
 * @version 1.0
 * @date 2020/10/3
 */
interface TodoDao :  JpaRepository<Todo, Long>, JpaSpecificationExecutor<Todo> {

    /**
     * 查詢符合 Id 條件的資料
     */
    fun findById(id: UUID): Todo?
}