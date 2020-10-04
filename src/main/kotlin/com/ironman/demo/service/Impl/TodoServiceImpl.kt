package com.ironman.demo.service.Impl

import com.ironman.demo.model.dao.TodoDao
import com.ironman.demo.model.entity.Todo
import com.ironman.demo.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

/**
 *
 * @author wei-xiang
 * @version 1.0
 * @date 2020/10/3
 */
@Service
class TodoServiceImpl(@Autowired val todoDao: TodoDao) : TodoService {
    override fun getTodos(): Iterable<Todo> = todoDao.findAll()

    override fun createTodo(todo: Todo): Todo = todoDao.save(todo)

    override fun updateTodoStatus(id: String): Boolean = todoDao.findById(UUID.fromString(id)).run {
        return try {
            this?.let {
                if (it.status == 1) it.status = 0 else it.status = 1
                todoDao.save(it)
            }
            true
        } catch (exception: Exception) {
            false
        }
    }

    override fun deleteTodo(id: String): Boolean = todoDao.findById(UUID.fromString(id)).run {
        return try {
            this?.let { todoDao.delete(it) }
            true
        } catch (exception: Exception) {
            false
        }
    }
}