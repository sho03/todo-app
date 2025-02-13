package dev.sho03.todo.service

import dev.sho03.todo.domain.Task
import dev.sho03.todo.domain.TaskRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import kotlin.random.Random

@Service
class TaskService(
    private val taskRepository: TaskRepository
) {

    fun getAllTasks(): List<Task> {
        return taskRepository.getAll()
    }

    fun getTask(id: Int): Task {
        return taskRepository.getById(id)
    }

    fun createTask(
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