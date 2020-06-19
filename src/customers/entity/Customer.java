
package customers.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "customer")
public class Customer {
    
    @Id
    @Column(name = "customer_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name ="is_student", nullable = false)
    private boolean isStudent;
    
    @Column(name ="register_number", nullable = false)
    private long registerNumber;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date registerDate;
    
    @Column(nullable = false)
    @OneToMany(mappedBy = "customer")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<CustomerSession> sessionList = new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public List<CustomerSession> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<CustomerSession> sessionList) {
        this.sessionList = sessionList;
    }

    public int getCustomerId() {
        return customerId;
    }

    public long getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(long registerNumber) {
        this.registerNumber = registerNumber;
    }
    
    public Customer()
    {
        
    }

    public boolean isIsStudent() {
        return isStudent;
    }

    public void setIsStudent(boolean isStudent) {
        this.isStudent = isStudent;
    }
    
    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", name=" + name + ", lastName=" + lastName + ", registerDate=" + registerDate + '}';
    }
    
}
