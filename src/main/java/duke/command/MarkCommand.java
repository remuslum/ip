package duke.command;

import duke.DukeException;
import duke.TaskList;
import duke.Ui;
import duke.messages.ErrorMessages;
import duke.task.Task;

/**
 * A command that marks a specified task as Completed
 */

public class MarkCommand extends Command {
    protected int taskNumber;

    public MarkCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    /**
     * Marks the specific task provided by the user.
     * @param taskList the existing task list
     * @param ui the ui that handles successful/unsuccessful messages
     * @throws DukeException If the task has already been marked, an error is thrown
     */
    public String execute(TaskList taskList, Ui ui) throws DukeException {
        try {
            Task taskToBeMarked = taskList.getTask(this.taskNumber - 1);
            if (taskToBeMarked.getTaskStatus()) {
                throw new DukeException("Task has already been marked as completed.");
            } else {
                taskToBeMarked.markTaskCompleted();
                return ui.showMarkMessage(taskToBeMarked);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(ErrorMessages.INVALID_TASK_NUMBER.getMessage());
        }
    }
}
