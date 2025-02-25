package com.sho03.todo.adapter.`in`.controller

import dev.sho03.todo.application.domain.model.Task
import dev.sho03.todo.port.`in`.CreateTaskUseCase
import dev.sho03.todo.port.`in`.GetTaskUseCase
import dev.sho03.todo.port.`in`.GetTasksUseCase
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
    private val createTaskUseCase: CreateTaskUseCase,
    private val getTaskUseCase: GetTaskUseCase,
    private val getTasksUseCase: GetTasksUseCase,
) {

    @GetMapping
    fun getAllTasks(): ResponseEntity<List<Task>> {
        val tasks = getTasksUseCase.getAllTasks()
        return ResponseEntity.ok(tasks)
    }

    @GetMapping("/{id}")
    fun getTask(
        @PathVariable id: Int
    ): ResponseEntity<Task> {
        val task = getTaskUseCase.getTask(id)
        return ResponseEntity.ok(task)
    }

    @PostMapping
    fun createTask(
        @RequestBody request: CreateTaskRequest
    ): ResponseEntity<Task> {
        val createdTask = createTaskUseCase.createTask(request.title, request.description, request.dueDate)
        return ResponseEntity.ok(createdTask)
    }

    data class CreateTaskRequest(
        val title: String,
        val description: String,
        val dueDate: LocalDate,
    )
}
