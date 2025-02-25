package com.sho03.todo.application.domain.service

import dev.sho03.todo.application.domain.model.Task
import com.sho03.todo.port.out.TaskRepository
import dev.sho03.todo.port.`in`.GetTaskUseCase
import org.springframework.stereotype.Service

@Service
class GetTaskService(
    private val taskRepository: com.sho03.todo.port.out.TaskRepository
) : GetTaskUseCase {
    override fun getTask(id: Int): Task {
        return taskRepository.getById(id)
    }
}
