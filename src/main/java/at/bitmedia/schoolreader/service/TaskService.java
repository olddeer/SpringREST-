package at.bitmedia.schoolreader.service;

import at.bitmedia.schoolreader.entity.Task;

public interface TaskService extends TypicalService<Task> {
    Task insertTask(Task tp);
    Task findByDescription(String desk);
}
