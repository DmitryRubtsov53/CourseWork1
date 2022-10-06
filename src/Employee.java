public class Employee {

    private final String fio;
    private int department;
    private double salary;
    private static int counter = 1;
    private final int id ;

    // Class constructor ***********************************************************************************************
    public Employee(String fio, int department, double salary) {
        this.id = counter;
        counter++;
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

    public int getCounter() { return counter;  }

    public int getId() { return id ;  }

    // Setters *********************************************************************************************************
    public void setDepartment(int department) {
        this.department = department;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    //******************************************************************************************************************
    @Override
    public String toString() {
        return "id: " + this.id + '\t' + this.fio + '\t' + "отдел: " + this.department +
                '\t' + "зарплата: " + this.salary + " руб." ;
    }
}
