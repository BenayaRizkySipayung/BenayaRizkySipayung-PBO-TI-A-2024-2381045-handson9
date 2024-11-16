import config.Database;
import repositories.TodoListRepository;
import repositories.todoListRepositoryDbImpl; // Ensure the correct implementation class is imported
import services.TodoListService;
import services.TodoListServiceImpl;
import views.TodoListTerminalView;
import views.TodoListView;

public class Main {
    public static void main(String[] args) {
        Database database = new Database("my_database", "root", "", "localhost", "3306");
        database.setup();

        TodoListRepository todoListRepository = new todoListRepositoryDbImpl(database); // Corrected class name
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListTerminalView(todoListService);
        todoListView.run();
    }
}
