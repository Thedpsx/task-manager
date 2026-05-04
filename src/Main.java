import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
            System.out.println("\n1 - Add Task");
            System.out.println("2 - Show Tasks");
            System.out.println("3 - Remove Task");
            System.out.println("4 - Mark as done");
            System.out.println("5 - Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                addTask(tasks, scanner);
            }
            else if (choice == 2) {
                printList(tasks);
            }
            else if (choice == 3) {
                printList(tasks);
                deleteTask(tasks, scanner);
            }
            else if (choice == 4) {
                markAsDone(tasks, scanner);
            }
            else if (choice == 5) {
                break;
            }
        }
    }
    public static void addTask(ArrayList<Task> tasks,Scanner scanner){
        System.out.print("Task: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        Task t = new Task(name);
        tasks.add(t);
    }

    public static void printList(ArrayList<Task> tasks){
        for(int i=1 ; i<=tasks.size() ;i++){
            System.out.println(i+". "+tasks.get(i-1));
        }
    }
    public static void markAsDone(ArrayList<Task> tasks, Scanner scanner){
        System.out.println("Which Task mark as 'Done'");
        int num = scanner.nextInt()-1;
        if(num < 0 || num >= tasks.size()){
            System.out.println("Input error");
            return;
        }
        tasks.get(num).isDone = true;
    }
    public static void deleteTask(ArrayList<Task> tasks, Scanner scanner){
        System.out.println("Which Task do you want to remove:");
        int num = scanner.nextInt()-1;
        if(num<0 || num >= tasks.size()){
            System.out.println("Input error");
            return;
        }
        tasks.remove(num);
    }

}
class Task{
    String name;
    boolean isDone;

    Task(String name) {
        this.name = name;
        this.isDone = false;
    }
    public String toString(){
        String status;
        if (isDone){
            status = "DONE";
        }else{
            status = "NOT DONE";
        }
        return name + " - " + status;
    }
}