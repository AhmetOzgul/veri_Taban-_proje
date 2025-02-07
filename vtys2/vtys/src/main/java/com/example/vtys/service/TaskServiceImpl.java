package com.example.vtys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.vtys.entity.Task;
import com.example.vtys.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        super();
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public void updateTask(Long id, Task task) {
        if (taskRepository.existsById(id)) {
            task.setId(id);
            taskRepository.save(task);
        }
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getTasksByProjectId(Long id){
        return taskRepository.findByProjectId(id);
    }


}
