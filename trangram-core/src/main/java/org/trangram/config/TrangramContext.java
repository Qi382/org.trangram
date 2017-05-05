package org.trangram.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.trangram.factory.ColumnFactory;
import org.trangram.factory.ConnectionFactory;
import org.trangram.factory.TableFactory;
import org.trangram.task.Task;
import org.trangram.types.Column;
import org.trangram.types.DbTypes;

import java.util.List;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 14:34
 */
public class TrangramContext extends PropertyHolder implements Runnable {

    private final static Logger logger = LoggerFactory.getLogger(TrangramContext.class);

    private String project;
    private String targetPackage;
    private String destination = "";

    private List<SchemaContext> schemas;

    private ConnectionFactory connectionFactory;
    private ColumnFactory columnFactory;
    private TableFactory tableFactory;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getTargetPackage() {
        return targetPackage;
    }

    public void setTargetPackage(String targetPackage) {
        this.targetPackage = targetPackage;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    public void setConnectionFactory(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public ColumnFactory getColumnFactory() {
        return columnFactory;
    }

    public void setColumnFactory(ColumnFactory columnFactory) {
        this.columnFactory = columnFactory;
    }

    public List<SchemaContext> getSchemas() {
        return schemas;
    }

    public void setSchemas(List<SchemaContext> schemas) {
        this.schemas = schemas;
    }

    public TableFactory getTableFactory() {
        return tableFactory;
    }

    public void setTableFactory(TableFactory tableFactory) {
        this.tableFactory = tableFactory;
    }

    @Override
    public void run() {
        logger.info("开始生成代码|{}|{}", getProject(), getDestination());
        if (getSchemas() == null || getSchemas().isEmpty()) {
            logger.info("无需要生成的代码");
            return;
        }

        final ColumnFactory columnFactory = getColumnFactory();
        final TableFactory tableFactory = getTableFactory();
        for (SchemaContext context : schemas) {
            context.setType(DbTypes.TYPE_SCHEMA);
            List<TableContext> tables = context.getTables();

            if (tables == null || tables.isEmpty()) {
                logger.info("无对象需要生成");
                continue;
            }

            for (TableContext table : tables) {
                table.setSchema(context.getSchema());
                //设置表格
                List<Column> columns = columnFactory.setColumns(this, table);
                table.setColumns(columns);
                //设置备注名
                tableFactory.setTable(this, table);

                //开始生成
                generate(context, table);
            }

            if (context.getTasks() == null || context.getTasks().isEmpty()) {
                continue;
            }

            for (Task task : context.getTasks()) {
                task.doTask(this, context, null);
            }
        }
    }

    private void generate(SchemaContext schemaContext, TableContext tableContext) {
        List<Task> tasks = tableContext.getTasks();
        if (tasks != null && tasks.size() > 0) {
            for (Task task : tasks) {
                task.doTask(this, schemaContext, tableContext);
            }
        }
    }
}
