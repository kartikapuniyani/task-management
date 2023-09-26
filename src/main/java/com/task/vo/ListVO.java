package com.task.vo;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListVO {

    private int pageNo;
    private int size;
    private int totalPages;
    private long totalElements;
    private List<TaskVO> data;
}
