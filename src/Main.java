import static java.lang.Double.MAX_VALUE;
import static java.lang.Double.MIN_VALUE;

public class Main {
    public static void main(String[] args) {
        System.out.println("Курсовая работа 1-го курса Java-разработчик SkyPro."
        + "\n" + "Программа для ОК и бухгалтерии по учету данных сотрудников.");
        System.out.println();

        Employee[] employee = new Employee[10];

        employee[0] = new Employee ("Махно Нестр Иванович", 1, 35000,1);
        employee[1] = new Employee ("Савинов Иван Силович", 1, 28000, 2);
        employee[2] = new Employee ("Лялина Ольга Ивановна", 2, 35000, 3);
        employee[3] = new Employee ("Смирнов Пётр Нилович", 2, 37000, 4);
        employee[4] = new Employee ("Волозин Вяча Кайнович", 1, 15000, 5);
        employee[5] = new Employee ("Гирина Яна Фёдоровна", 3, 52000, 6);
        employee[6] = new Employee ("Явин Максим Петрович", 1, 45000, 7);
        employee[7] = new Employee ("Иванов Пётр Иванович", 3, 35000, 8);
        employee[8] = new Employee ("Сурков Ефрем Олегович", 1, 41000, 9);
        employee[9] = new Employee ("Тупин Владим Иудович", 2, 15000, 10);

        System.out.println("Базовая сложность **********************************************" + "\n");

        printlistFull (employee);          System.out.println();   //8.1
        double ssf = sumSalary (employee); System.out.println();   //8.2
        employeeMaxSalary (employee);      System.out.println();   //8.3
        employeeMinSalary (employee);      System.out.println();   //8.4
        averageSalary (employee, ssf);     System.out.println();   //8.5
        printFullNames (employee);         System.out.println();   //8.6

        System.out.println("Повышенная сложность **********************************************" + "\n");

        indexSalary (employee);        System.out.println();  // Индексация        //1
        int depatment = 1;                                    // Номер отдела      //2
        double ssd;         //вспомогательная переменная - средняя з/п отдела

        employeeMaxSalaryDep (employee, depatment);    System.out.println();       //2.1
        employeeMinSalaryDep (employee, depatment);    System.out.println();       //2.2
        ssd = sumSalaryDep (employee, depatment);      System.out.println();       //2.3
        averageSalaryDep (employee, depatment, ssd);   System.out.println();       //2.4

        double indexDep = 1.05; // коэффициент индексации зарплат отдела на 5%
        indexSalaryDep (employee, depatment, indexDep);                             //2.5
        printlistDep (employee, depatment);               System.out.println();     //2.6

        double namber = 30000;  //параметр для сравнения с ним зарплат сотрудников  //3
        findEmployeeAfter (employee, namber);             System.out.println();     //3.1
        findEmployeeTo (employee, namber);                System.out.println();     //3.2

    } // end main -------------------------------------------------------------------------------------

    //  методы Повышенной сложности *******************************************************************
    public static Employee[] indexSalary (Employee[] empl) {   // индексируем зарплату всех сотрудников
        System.out.println("1. Табель сотрудников фирмы после индексации зарплаты:" + "\n" +
                                       "-------------------------------------------------------------------");
        double index = 1.10;  // индекс повышения зарплаты всех сотрудников фирмы на 10%
        for (int i = 0; i < empl.length; i++) {
            empl[i].setSalary(Math.ceil(empl[i].getSalary() * index));
            System.out.println(empl[i]);
            }
        return empl;
    }
    public static void employeeMaxSalaryDep (Employee[] empl, int dep) {
        System.out.println("2.1. Сотрудники с MAX зарплатой в отделе " + dep + " :");
        double maxEl = MIN_VALUE;
        for (int j = 0; j < empl.length; j++) {
            if (empl[j].getDepartment() == dep && empl[j].getSalary() > maxEl)
                maxEl = empl[j].getSalary();
        }
        for (int i = 0; i < empl.length; i++) {
            if (maxEl == empl[i].getSalary())
                System.out.println("          " + empl[i].getFio() + "\t" + "( " + Math.ceil(maxEl) + " рублей. )");
        }
    }
    public static void employeeMinSalaryDep (Employee[] empl, int dep) {
        System.out.println("2.2. Сотрудники с MIN зарплатой в отделе " + dep + " :");
        double minEl = MAX_VALUE;
        for (int j = 0; j < empl.length; j++) {
            if (empl[j].getDepartment() == dep && empl[j].getSalary() < minEl)
                minEl = empl[j].getSalary();
        }
        for (int i = 0; i < empl.length; i++) {
            if (minEl == empl[i].getSalary() && empl[i].getDepartment() == dep)
                System.out.println("          " + empl[i].getFio() + "\t" + "( " + minEl + " рублей. )");
        }
    }
    public static double sumSalaryDep (Employee[] empl, int dep) {
        double sum = 0;
        for (int i = 0; i < empl.length; i++) {
            if (empl[i].getDepartment() == dep)
                sum += empl[i].getSalary();
        }
        System.out.println("2.3. Сумма зарплат сотрудников отдела " + dep + " за месяц: " + sum + " руб.");
        return sum;
    }
    public static void averageSalaryDep (Employee[] empl, int dep, double ssd) {
        //double sum = ssd;
        int memberDep = 0;
        for (int i = 0; i < empl.length; i++) {
            if (empl[i].getDepartment() == dep) {
                //sum += empl[i].getSalary();
                memberDep++;
            }
        }
            System.out.println("2.4. Средняя зарплата сотрудников отдела " + dep + " в месяц: "
                                                                 +  Math.ceil(ssd / memberDep) + " руб.");
    }
    public static Employee[] indexSalaryDep (Employee[] empl, int dep, double index) { // индексируем зарплату сотрудников отдела
        for (int i = 0; i < empl.length; i++) {
            if (empl[i].getDepartment() == dep) {
                empl[i].setSalary(empl[i].getSalary() * index);  //System.out.println(empl[i]);
            }
        }
        return empl;
    }
    public static void printlistDep (Employee[] empl, int dep) {
        System.out.println("2.6. Табель сотрудников отдела " + dep + " после индексации зарплат отдела:" + "\n" +
                "--------------------------------------------------------------------");
        for (Employee el : empl) {
            if (el.getDepartment() == dep) {
                System.out.println("id: " + el.getId() + "\t" + el.getFio() + "\t" + Math.ceil(el.getSalary()) + " руб.");
            }
        }
    }
    public static void findEmployeeAfter (Employee[] empl, double namber) {
        System.out.println("3.1. Сотрудники фирмы с зарплатой больше " + namber + " рублей:" + "\n");
        for (Employee el : empl) {
            if (el.getSalary() >= namber ) {
                System.out.println("id: " + el.getId() + "\t" + el.getFio() + "\t" + "отдел: "
                        + el.getDepartment() + "\t" + "зарплата: " + Math.ceil(el.getSalary()) + " руб.");
            }
        }
    }
    public static void findEmployeeTo (Employee[] empl, double namber) {
        System.out.println("3.2. Сотрудники фирмы с зарплатой меньше " + namber + " рублей:" + "\n");
        for (Employee el : empl) {
            if (el.getSalary() < namber ) {
                System.out.println("id: " + el.getId() + "\t" + el.getFio() + "\t" + "отдел: "
                        + el.getDepartment() + "\t" + "зарплата: " + Math.ceil(el.getSalary()) + " руб.");
            }
        }
    }
    //  методы Базовой сложности ***********************************************************************
    public static void printlistFull (Employee[] empl) {
        System.out.println("8.1. Табель сотрудников фирмы:" + "\n" +
                "-----------------------------------------------------------------");
        for (Employee el : empl) {
            System.out.println(el);
        }
    }
    public static double sumSalary (Employee[] empl) {
        double sum = 0;
        for (int i = 0; i < empl.length; i++) {
            sum += empl[i].getSalary();
        }
        System.out.println("8.2. Сумма зарплат сотрудников фирмы за месяц: " + sum + " руб.");
        return sum;
    }
    public static void employeeMaxSalary (Employee[] empl) {
        System.out.println("8.3. MAX зарплату в фирме получают: ");
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
        System.out.println("8.4. MIN зарплату в фирме получают: ");
        double minEl = MAX_VALUE;
        for (int j = 0; j < empl.length; j++) {
            if (empl[j].getSalary() < minEl) minEl = empl[j].getSalary();
        }
        for (int i = 0; i < empl.length; i++) {
            if (minEl == empl[i].getSalary())
                System.out.println("          " + empl[i].getFio() + "\t" + "( " + minEl + " рублей. )");
            }
    }
    public static void averageSalary (Employee[] empl, double ssf) {
            System.out.println("8.5. Средняя зарплата сотрудников фирмы в месяц: "
                                                          + Math.ceil(ssf / empl.length) + " руб.");
    }
    public static void printFullNames (Employee[] emp) {
        System.out.println("8.6. ФИО всех сотрудников фирмы:" + "\n" +
                           "--------------------------------------------------------------------");
        for (int i = 0; i < emp.length; i++) {
            System.out.println("                         " + emp[i].getFio());
        }
    }
} // end Class ------------------------------------------------------------------------------------------------