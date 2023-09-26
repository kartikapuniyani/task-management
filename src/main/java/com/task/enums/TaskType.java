package com.task.enums;

public enum TaskType {

    IN_PROGRESS("In Progress",0),
    OPEN("Open", 1),
    COMPLETED("Completed", 2);

    private final String displayName;
    private final int value;

    TaskType(String displayName, int i) {
        this.displayName = displayName;
        this.value = i;
    }

    public String getName() {
        return this.name();
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public  int getValue() { return this.value; }
}
