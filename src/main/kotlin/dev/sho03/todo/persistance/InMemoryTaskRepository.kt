package dev.sho03.todo.persistance

import dev.sho03.todo.domain.Task
import dev.sho03.todo.domain.TaskRepository
import org.springframework.stereotype.Repository

@Repository
class InMemoryTaskRepository : TaskRepository {
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