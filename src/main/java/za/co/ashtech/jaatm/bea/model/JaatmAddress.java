package za.co.ashtech.jaatm.bea.model;

import jakarta.persistence.*;

@Entity
@Table(name = "jaatm_address")
public class JaatmAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street_number", length = 20)
    private String streetNumber;

    @Column(name = "street_name", length = 150)
    private String streetName;

    @Column(name = "town", length = 100)
    private String town;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "province", length = 100)
    private String province;

    @Column(name = "postal_code", length = 20)
    private String postalCode;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "jaatm_user_id",
        nullable = false,
        unique = true,
        foreignKey = @ForeignKey(name = "fk_address_user")
    )
    private JaatmUser user;

    // Constructors
    public JaatmAddress() {
    }

    public JaatmAddress(String streetNumber, String streetName, String town,
                        String city, String province, String postalCode) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.town = town;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public JaatmUser getUser() {
        return user;
    }

    public void setUser(JaatmUser user) {
        this.user = user;
    }
}

