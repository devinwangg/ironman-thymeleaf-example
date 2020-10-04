package com.ironman.demo.controller

import com.ironman.demo.model.entity.Todo
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

/**
 *
 * @author wei-xiang
 * @version 1.0
 * @date 2020/10/2
 */
interface HomeController {

    @GetMapping("/todos")
    fun getTodos(model: Model) : String

    @PostMapping("/todos")
    fun createTodo(@ModelAttribute todo: Todo) : String

    @PutMapping("/todos/{id}")
    @ResponseBody
    fun updateTodoStatus(@PathVariable id: String)

    @DeleteMapping("/todos/{id}")
    @ResponseBody
    fun deleteTodo(@PathVariable id: String)
}