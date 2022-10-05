import static java.lang.Double.MAX_VALUE;
import static java.lang.Double.MIN_VALUE;

public class Main {
    public static void main(String[] args) {
        System.out.println("Курсовая работа № 1 *************************************"
        + "\n" + "Программа для бухгалтерии по расчету зарплаты сотрудников.");
        System.out.println();

        Employee[] employee = new Employee[10];

        employee[0] = new Employee ("Махно Нестр Иванович", 1, 35000, Employee.getId());
        employee[1] = new Employee ("Савинов Иван Силович", 1, 28000, Employee.getId());
        employee[2] = new Employee ("Лялина Ольга Ивановна", 2, 35000, Employee.getId());
        employee[3] = new Employee ("Смирнов Пётр Нилович", 2, 37000, Employee.getId());
        employee[4] = new Employee ("Волозин Вяча Кайнович", 1, 15000, Employee.getId());
        employee[5] = new Employee ("Гирина Яна Фёдоровна", 3, 52000, Employee.getId());
        employee[6] = new Employee ("Явин Максим Петрович", 1, 45000, Employee.getId());
        employee[7] = new Employee ("Иванов Пётр Иванович", 3, 35000, Employee.getId());
        employee[8] = new Employee ("Сурков Ефрем Олегович", 1, 41000, Employee.getId());
        employee[9] = new Employee ("Тупин Владим Иудович", 2, 15000, Employee.getId());

        printlistFull (employee);        System.out.println();
        sumSalary (employee);            System.out.println();
        employeeMaxSalary (employee);    System.out.println();
        employeeMinSalary (employee);    System.out.println();
        averageSalary (employee);        System.out.println();
        printFullNames (employee);

    } // main ********************************************************************************************************

    public static void employeeMaxSalary (Employee[] empl) {
        System.out.println("3. MAX зарплату в фирме получают: ");
        double maxEl = MIN_VALUE;
        for (int j = 0; j < empl.length; j++) {
            if (empl[j].getSalary() > maxEl) maxEl = empl[j].getSalary();
            }
        for (int i = 0; i < empl.length; i++) {
            if (maxEl == empl[i].getSalary())
                System.out.println("          " + empl[i].getFio() + "\t" + "( " + maxEl + " рублей. )");
            }
    }
    public static void employeeMinSalary (Employee[] empl) {
        System.out.println("4. MIN зарплату в фирме получают: ");
        double minEl = MAX_VALUE;
        for (int j = 0; j < empl.length; j++) {
            if (empl[j].getSalary() < minEl) minEl = empl[j].getSalary();
        }
        for (int i = 0; i < empl.length; i++) {
            if (minEl == empl[i].getSalary())
                System.out.println("          " + empl[i].getFio() + "\t" + "( " + minEl + " рублей. )");
            }
    }
    public static void printlistFull (Employee[] employee) {
            System.out.println("1. Табель сотрудников фирмы:" + "\n" +
                    "-----------------------------------------------------------------");
            for (Employee el : employee) {
                System.out.println(el);//System.out.println("id: " + Employee.getId() + '\t' +  el);
            }
    }
    public static void sumSalary (Employee[] empl) {
            double sum = 0;
            for (int i = 0; i < empl.length; i++) {
                 sum = sum + empl[i].getSalary();
            }
            System.out.println("2. Сумма зарплат сотрудников фирмы за месяц: " + sum + " руб.");
    }
    public static void averageSalary (Employee[] empl) {
            double sum = 0;
            for (int i = 0; i < empl.length; i++) {
                sum = sum + empl[i].getSalary();
            }
            System.out.println("5. Средняя зарплата сотрудников фирмы в месяц: " + (double) sum / empl.length + " руб.");
    }
    public static void printFullNames (Employee[] emp) {
        System.out.println("6. ФИО всех сотрудников фирмы:" + "\n" +
                                           "----------------------------------------------------");
        for (int i = 0; i < emp.length; i++) {
            System.out.println("                         " + emp[i].getFio());
        }
    }


} // Class ************************************************************************************************************