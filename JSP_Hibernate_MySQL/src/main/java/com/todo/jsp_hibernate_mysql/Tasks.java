package com.todo.jsp_hibernate_mysql;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks", schema = "to_do_list")
public class Tasks {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "task_name")
    private String taskName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String toString() {
        return "Task ID: " + id +". " + taskName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tasks that = (Tasks) o;

        if (id != that.id) return false;
        if (taskName != null ? !taskName.equals(that.taskName) : that.taskName != null) return false;

        return true;
    }

}
