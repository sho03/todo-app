package dev.sho03.todo.domain

interface TaskRepository {
    fun getAll(): List<Task>
    fun getById(id: Int): Task
    fun create(task: Task)
}