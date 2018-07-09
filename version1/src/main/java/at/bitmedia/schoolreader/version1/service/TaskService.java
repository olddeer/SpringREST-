package at.bitmedia.schoolreader.version1.service;

import at.bitmedia.schoolreader.version1.entity.Task;

public interface TaskService extends TypicalService<Task> {
    Task insertTask(Task tp);
    Task findByDescription(String desk);
}
