public class Employee {

    private String fio;
    private int department;
    private double salary;
    private static int counter = 1;
    private static int id;

    // Class constructor ***********************************************************************************************
    public Employee(String fio, int department, double salary, int counter) {
        this.id = counter++;
        this.fio = fio;
        this.department = department;
        this.salary = salary;
    }

    // Getters *********************************************************************************************************

    public String getFio() {
        return fio;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() { return salary;  }

    public static int getCounter() { return counter;  }

    public static int getId() { return id;  }

    // Setters *********************************************************************************************************
    public void setDepartment(int department) {
        this.department = department;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }



    @Override
    public String toString() {
        return "id: " + (this.id = counter++) + '\t' + this.fio + '\t' + "отдел: " + this.department +
                '\t' + "зарплата: " + this.salary + " руб." ;
    }  // "id: " + this.id + '\t' +
}
