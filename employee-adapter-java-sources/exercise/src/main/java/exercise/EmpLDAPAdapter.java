package exercise;

public class EmpLDAPAdapter implements Employee{
    EmployeeLDAP e;
    public EmpLDAPAdapter(EmployeeLDAP e){
        this.e = e;
    }
    @Override
    public String getId(){
        return e.get("uid");
    }
    @Override
    public String getFirstName(){
        return e.get("givenName");
    }
    @Override
    public String getLastName(){
        return e.get("sn");
    }
    @Override
    public String getEmail(){
        return e.get("mail");
    }
}
