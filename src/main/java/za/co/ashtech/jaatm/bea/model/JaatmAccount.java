package za.co.ashtech.jaatm.bea.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "jaatm_account",
    uniqueConstraints = {
        @UniqueConstraint(
            columnNames = "JAATM_USER_ID"
        )
    }
)
public class JaatmAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "balance", length = 50)
    private Long balance;

    @Column(name = "status", length = 20)
    private String status;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "jaatm_user_id",
        nullable = false,
        unique = true,
        foreignKey = @ForeignKey(name = "fk_account_user")
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

