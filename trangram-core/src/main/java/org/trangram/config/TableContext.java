package org.trangram.config;

import org.trangram.task.Task;
import org.trangram.types.Column;
import org.trangram.types.Table;

import java.util.List;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 18:14
 */
public class TableContext extends Table {

    private List<Column> columns;

    private List<Task> tasks;

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }


    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
