package at.bitmedia.schoolreader.service;

import at.bitmedia.schoolreader.entity.Task;

public interface TaskService extends GenericService<Task> {
    Task findByDescription(String desk);
}
