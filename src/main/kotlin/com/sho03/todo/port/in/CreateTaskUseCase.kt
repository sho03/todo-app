package com.sho03.todo.port.`in`

import dev.sho03.todo.application.domain.model.Task
import java.time.LocalDate

interface CreateTaskUseCase {
    fun createTask(title: String, description: String, dueDate: LocalDate): Task
}