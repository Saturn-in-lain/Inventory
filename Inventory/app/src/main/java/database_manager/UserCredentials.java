package database_manager;

/**
 * Created by saturn on 07.11.2016.
 * http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
 */

public class UserCredentials
{
    private int _id;
    private String _name;
    private String _password;
    private String _role;

    /**
     * Constructor
     * @param
     */
    public UserCredentials()
    {
        // do nothing
    }

    /**
     * Constructor full data
     * @param  id
     * @param  name
     * @param  password
     * @param  role
     */
    public UserCredentials(int id, String name, String password, String role)
    {
        this._id = id;
        this._name = name;
        this._password = password;
        this._role = role;
    }

    /**
     * Constructor small data
     * @param  name
     * @param  password
     */
    public UserCredentials(String name, String password, String role)
    {
        this._name = name;
        this._password = password;
        this._role = role;
    }
    // getting ID
    public int getID()
    {
        return this._id;
    }

    // setting id
    public void setID(int id)
    {
        this._id = id;
    }

    // getting name
    public String getName()
    {
        return this._name;
    }

    public String getPassword()
    {
        return this._password;
    }

    // setting name
    public void setName(String name, String password)
    {
        this._name = name;
        this._password = password;
    }


    // getting phone number
    public String getRole()
    {
        return this._role;
    }

    // setting phone number
    public void setRole(String role){
        this._role = role;
    }
}
