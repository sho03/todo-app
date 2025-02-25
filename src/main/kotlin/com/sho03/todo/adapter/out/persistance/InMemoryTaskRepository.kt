package com.sho03.todo.adapter.out.persistance

import dev.sho03.todo.application.domain.model.Task
import com.sho03.todo.port.out.TaskRepository
import org.springframework.stereotype.Repository

@Repository
class InMemoryTaskRepository : com.sho03.todo.port.out.TaskRepository {
    val map = mutableMapOf<Int, Task>()

    override fun getAll(): List<Task> {
        return map.values.toList()
    }

    override fun getById(id: Int): Task {
        val task = map[id] ?: throw IllegalArgumentException("task is not found.")
        return task
    }

    override fun create(task: Task) {
        map[task.id] = task
    }
}