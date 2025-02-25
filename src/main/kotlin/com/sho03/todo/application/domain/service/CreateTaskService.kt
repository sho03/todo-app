package com.sho03.todo.application.domain.service

import dev.sho03.todo.application.domain.model.Task
import com.sho03.todo.port.out.TaskRepository
import dev.sho03.todo.port.`in`.CreateTaskUseCase
import org.springframework.stereotype.Service
import java.time.LocalDate
import kotlin.random.Random

@Service
class CreateTaskService(
    private val taskRepository: com.sho03.todo.port.out.TaskRepository
) : CreateTaskUseCase {

    override fun createTask(
        title: String,
        description: String,
        dueDate: LocalDate,
    ): Task {
        val newTask = Task(
            Random.nextInt(),
            title,
            description,
            dueDate,
        )
        taskRepository.create(newTask)
        return newTask
    }
}