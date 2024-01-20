package com.example.vtys.entity;
import java.sql.Date;

import jakarta.persistence.*;


@Entity
@Table(name = "Tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "task_name", nullable = false)
	private String taskName;

    @Column(name = "start_date", nullable = false)
	private Date startDate;

    @Column(name = "end_date", nullable = false)
	private Date endDate;

    @Column(name = "state", nullable = false)
	private String state;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    
	
	public Task() {

    }

    

    public Task(String taskName, Date startDate, Date endDate, String state) {
        this.taskName = taskName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }



    public String getState() {
        return state;
    }



    public void setState(String state) {
        this.state = state;
    }



    public Project getProject() {
        return project;
    }



    public void setProject(Project project) {
        this.project = project;
    }



    public User getUser() {
        return user;
    }



    public void setUser(User user) {
        this.user = user;
    }

    
	
}
