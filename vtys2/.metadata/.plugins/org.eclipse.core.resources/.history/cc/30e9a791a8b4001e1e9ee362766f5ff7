package com.example.vtys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.vtys.entity.Task;
import com.example.vtys.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository TaskRepository;

    public TaskServiceImpl(TaskRepository TaskRepository){
        super();
        this.TaskRepository = TaskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return TaskRepository.findAll();
    }

    @Override
    public Task saveTask(Task Task) {
        return TaskRepository.save(Task);
    }

    @Override
    public Task getTaskById(Long id) {
        return TaskRepository.findById(id).get();
    }

    @Override
    public void updateTask(Long id,Task Task) {
        if(TaskRepository.existsById(id)){
            Task.setId(id);
            TaskRepository.save(Task);
        }

    }

    @Override
    public void deleteTask(Long id){
        TaskRepository.deleteById(id);
    }
    
}
