package nfwya.alterg.domain;


import javax.validation.constraints.NotNull;

import static java.util.Objects.requireNonNull;


public class User
{
    private final Long id;

    private final UserType userType;


    private User(final Long id, final UserType userType)
    {
        this.id = id;
        this.userType = userType;
    }


    public static User createCustomer(final Long id)
    {
        return new User(requireNonNull(id), UserType.CUSTOMER);
    }


    public static User createStaff(final Long id)
    {
        return new User(requireNonNull(id), UserType.STAFF);
    }


    public static User createBusiness(final Long id)
    {
        return new User(requireNonNull(id), UserType.BUSINESS);
    }


    public Long getId()
    {
        return id;
    }


    public UserType getUserType()
    {
        return userType;
    }


    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", userType=" + userType +
                '}';
    }
}
