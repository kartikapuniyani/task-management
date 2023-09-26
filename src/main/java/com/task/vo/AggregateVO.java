package com.task.vo;

import com.task.entity.Task;
import com.task.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AggregateVO {

    private long inProgress;
    private long open;
    private long closed;

    public AggregateVO(List<Task> list){
        this.closed = list.stream().filter(c -> TaskType.COMPLETED.equals(c.getStatus())).count();
        this.open = list.stream().filter(c -> TaskType.OPEN.equals(c.getStatus())).count();
        this.inProgress = list.stream().filter(c -> TaskType.IN_PROGRESS.equals(c.getStatus())).count();
    }
}