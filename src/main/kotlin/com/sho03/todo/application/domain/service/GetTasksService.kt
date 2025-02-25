package com.sho03.todo.application.domain.service

import dev.sho03.todo.application.domain.model.Task
import com.sho03.todo.port.out.TaskRepository
import dev.sho03.todo.port.`in`.GetTasksUseCase
import org.springframework.stereotype.Service

@Service
class GetTasksService(
    private val taskRepository: com.sho03.todo.port.out.TaskRepository
) : GetTasksUseCase {
    override fun getAllTasks(): List<Task> {
        return taskRepository.getAll()
    }
}
