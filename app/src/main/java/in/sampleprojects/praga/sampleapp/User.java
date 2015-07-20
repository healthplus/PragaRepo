package in.sampleprojects.praga.sampleapp;

/**
 * Created by praga on 7/18/2015.
 */
public class User {

    private int _id;
    private String _useremail;
    private String _userpwd;

    public User(){}

    public User(String useremail, String userpwd) {
        this._useremail = useremail;
        this._userpwd = userpwd;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_useremail() {
        return _useremail;
    }

    public void set_useremail(String _useremail) {
        this._useremail = _useremail;
    }

    public String get_userpwd() {
        return _userpwd;
    }

    public void set_userpwd(String _userpwd) {
        this._userpwd = _userpwd;
    }
}
