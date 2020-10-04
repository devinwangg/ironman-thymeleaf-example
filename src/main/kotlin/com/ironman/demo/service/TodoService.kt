package com.ironman.demo.service

import com.ironman.demo.model.entity.Todo

/**
 *
 * @author wei-xiang
 * @version 1.0
 * @date 2020/10/3
 */
interface TodoService {

    /**
     * 取得所有 Todo 資料
     */
    fun getTodos(): Iterable<Todo>

    /**
     * 建立 Todo 資料
     */
    fun createTodo(todo: Todo): Todo

    /**
     * 更新 Todo 狀態
     */
    fun updateTodoStatus(id: String): Boolean

    /**
     * 刪除 Todo 資料
     */
    fun deleteTodo(id: String): Boolean
}