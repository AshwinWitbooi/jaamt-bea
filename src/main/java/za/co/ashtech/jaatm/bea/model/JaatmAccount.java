package za.co.ashtech.jaatm.bea.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "JAATM_ACCOUNT",
    uniqueConstraints = {
        @UniqueConstraint(
            columnNames = "JAATM_USER_ID"
        )
    }
)
public class JaatmAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "BALANCE", length = 50)
    private Long balance;

    @Column(name = "STATUS", length = 20)
    private String status;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "JAATM_USER_ID",
        nullable = false,
        unique = true,
        foreignKey = @ForeignKey(name = "FK_ACCOUNT_USER")
    )
    private JaatmUser user;

    // Constructors
    public JaatmAccount() {}

    public JaatmAccount(Long balance, String status) {
        this.balance = balance;
        this.status = status;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public Long getBalance() {
        return balance;
    }
 
    public void setBalance(Long balance) {
        this.balance = balance;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }

    public JaatmUser getUser() {
        return user;
    }

    public void setUser(JaatmUser user) {
        this.user = user;
    }
}

