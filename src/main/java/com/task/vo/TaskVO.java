package com.task.vo;

import com.task.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskVO implements Serializable {

    private Long id;
    private int inProgress;
    private int open;
    private int closed;
    private Date date;

    public TaskVO(Task task){
        this.id = task.getId();
        this.inProgress = task.getStatus().getValue();
        this.open = task.getStatus().getValue();
        this.closed = task.getStatus().getValue();
        this.date = task.getDate();
    }

}