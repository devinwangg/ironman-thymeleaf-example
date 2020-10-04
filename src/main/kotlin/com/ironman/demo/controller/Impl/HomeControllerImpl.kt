package com.ironman.demo.controller.Impl

import com.ironman.demo.controller.HomeController
import com.ironman.demo.model.entity.Todo
import com.ironman.demo.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

/**
 *
 * @author wei-xiang
 * @version 1.0
 * @date 2020/10/4
 */
@Controller
class HomeControllerImpl(@Autowired val todoService: TodoService): HomeController {
    override fun getTodos(model: Model): String {
        model.addAttribute("todolist", todoService.getTodos());
        model.addAttribute("todoObject", Todo())
        return "home"
    }

    override fun createTodo(todo: Todo): String {
        todoService.createTodo(todo)

        return "redirect:/todos"
    }

    override fun updateTodoStatus(id: String) {
        todoService.updateTodoStatus(id)
    }

    override fun deleteTodo(id: String) {
       todoService.deleteTodo(id)
    }

}