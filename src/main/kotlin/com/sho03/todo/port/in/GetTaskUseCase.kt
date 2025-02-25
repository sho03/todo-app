package com.sho03.todo.port.`in`

import dev.sho03.todo.application.domain.model.Task

interface GetTaskUseCase {
    fun getTask(id: Int): Task
}