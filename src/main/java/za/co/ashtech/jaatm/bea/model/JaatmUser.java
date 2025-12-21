package za.co.ashtech.jaatm.bea.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "JAAT_USER",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "JUID")
    }
)
public class JaatmUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "JUID", nullable = false, unique = true, length = 50)
    private String juid;

    @Column(name = "FIRSTNAME", nullable = false, length = 100)
    private String firstName;

    @Column(name = "LASTNAME", nullable = false, length = 100)
    private String lastName;
    
    @OneToOne(
	            mappedBy = "user",
	            cascade = CascadeType.ALL,
	            orphanRemoval = true,
	            fetch = FetchType.LAZY
    		 )
    private JaatmAccount account;

    // ---------------- Constructors ----------------

    public JaatmUser() {
    }

    public JaatmUser(String juid, String firstName, String lastName) {
        this.juid = juid;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // ---------------- Getters & Setters ----------------

    public Long getId() {
        return id;
    }

    public String getJuid() {
        return juid;
    }

    public void setJuid(String juid) {
        this.juid = juid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public JaatmAccount getAccount() {
        return account;
    }

    public void setAccount(JaatmAccount account) {
        this.account = account;
        if (account != null) {
            account.setUser(this);
        }
    }
}

