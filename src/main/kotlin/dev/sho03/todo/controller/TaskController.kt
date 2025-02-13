package dev.sho03.todo.controller

import dev.sho03.todo.domain.Task
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/tasks")
class TaskController {

    @GetMapping
    fun getAllTasks(): ResponseEntity<List<Task>> {
        val tasks = listOf(
            Task(1, "task1", "description1", LocalDate.now()),
            Task(2, "task2", "description2", LocalDate.now()),
            Task(3, "task3", "description3", LocalDate.now()),
            Task(4, "task4", "description4", LocalDate.now()),
        )

        return ResponseEntity.ok(tasks)
    }
}
