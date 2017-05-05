package org.trangram.config;

import org.trangram.task.Task;
import org.trangram.types.Schema;

import java.util.List;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 17:17
 */
public class SchemaContext extends Schema {

    private List<TableContext> tables;
    private String destination="";
    private List<Task> tasks;

    public List<TableContext> getTables() {
        return tables;
    }

    public void setTables(List<TableContext> tables) {
        this.tables = tables;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
