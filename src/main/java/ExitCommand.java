public class ExitCommand extends Command{

    public void execute(TaskList taskList, Ui ui){
        System.out.println(Messages.GOODBYE_MESSAGE.getMessage());
    }
}