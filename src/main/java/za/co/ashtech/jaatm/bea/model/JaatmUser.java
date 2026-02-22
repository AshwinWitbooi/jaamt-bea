package za.co.ashtech.jaatm.bea.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(
    name = "jaatm_user",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "JUID")
    }
)
public class JaatmUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "juid", nullable = false, unique = true, length = 50)
    private String juid;

    @Column(name = "firstname", nullable = false, length = 100)
    private String firstName;

    @Column(name = "lastname", nullable = false, length = 100)
    private String lastName;
    
    @Column(name = "dob", nullable = false)
    private LocalDate dob;
    
    @OneToOne(
	            mappedBy = "user",
	            cascade = CascadeType.ALL,
	            orphanRemoval = true,
	            fetch = FetchType.LAZY
    		 )
    private JaatmAccount account;
    @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
		 )
    private JaatmAddress address;
    // ---------------- Constructors ----------------

    public JaatmUser() {
    }

    public JaatmUser(String juid, String firstName, String lastName, LocalDate dob) {
        this.juid = juid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
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
        
    public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
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

	public JaatmAddress getAddress() {
		return address;
	}

	public void setAddress(JaatmAddress address) {
		this.address = address;
	}
}

