package dev.sho03.todo.controller

import dev.sho03.todo.domain.Task
import dev.sho03.todo.service.TaskService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/tasks")
class TaskController(
    private val taskService: TaskService,
) {

    @GetMapping
    fun getAllTasks(): ResponseEntity<List<Task>> {
        val tasks = taskService.getAllTasks()
        return ResponseEntity.ok(tasks)
    }

    @GetMapping("/{id}")
    fun getTask(
        @PathVariable id: Int
    ): ResponseEntity<Task> {
        val task = taskService.getTask(id)
        return ResponseEntity.ok(task)
    }

    @PostMapping
    fun createTask(
        @RequestBody request: CreateTaskRequest
    ): ResponseEntity<Task> {
        val createdTask = taskService.createTask(request.title, request.description, request.dueDate)
        return ResponseEntity.ok(createdTask)
    }

    data class CreateTaskRequest(
        val title: String,
        val description: String,
        val dueDate: LocalDate,
    )
}
