package exercise;

public class EmpCSVAdapter implements Employee{
    EmployeeCSV e;
    String[] tokens;
    public EmpCSVAdapter(EmployeeCSV e){
        this.e = e;
        this.tokens = e.tokens();
    }
   
    @Override
    public String getId(){
        return tokens[0];
    }
    @Override
    public String getFirstName(){
        return tokens[1];
    }
    @Override
    public String getLastName(){
        return tokens[2];
    }
    @Override
    public String getEmail(){
        return tokens[3];
    }
    
}
