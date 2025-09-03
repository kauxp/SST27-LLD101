package exercise;

public class EmpDBAdapter implements Employee{
    EmployeeDB e;
    public EmpDBAdapter(EmployeeDB e){
        this.e = e;
    }
    @Override
    public String getId(){
        return Integer.toString(e.getId());
    }
    @Override
    public String getFirstName(){
        return e.getFirstName();
    }
    @Override
    public String getLastName(){
        return e.getSurname();
    }
    @Override
    public String getEmail(){
        return e.getEmailAddress();
    }
}
