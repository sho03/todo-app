package com.sho03.todo.port.out

import dev.sho03.todo.application.domain.model.Task

interface TaskRepository {
    fun getAll(): List<Task>
    fun getById(id: Int): Task
    fun create(task: Task)
}