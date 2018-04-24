package plumbusx.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by i1yas on 25.05.2017.
 */

@Entity
@Table(name = "meetings")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "mname")
    private String mname;

    @Column(name = "typeofmeeting")
    private String typeofmeeting;

    @Column(name = "description")
    private String description;

    @Column(name = "timedate")
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm")
    private Date timedate;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @ManyToMany(mappedBy = "meetings", fetch = FetchType.EAGER)
    private Set<User> users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getTypeofmeeting() {
        return typeofmeeting;
    }

    public void setTypeofmeeting(String typeofmeeting) {
        this.typeofmeeting = typeofmeeting;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
/*
    public Date getTimedate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd  HH:mm");
        String sdt = df.format(timedate);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd  HH:mm", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(sdt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public void setTimedate(Date timedate) {
        this.timedate = timedate;
    }
    */

    public Date getTimedate() {
        return timedate;
    }

    public void setTimedate(Date timedate) {
        this.timedate = timedate;
    }

    @PreRemove
    private void removeEducationFromUsersProfile() {
        for (User u : users) {
            u.getMeetings().remove(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meeting meeting = (Meeting) o;

        if (id != meeting.id) return false;
        if (mname != null ? !mname.equals(meeting.mname) : meeting.mname != null) return false;
        if (typeofmeeting != null ? !typeofmeeting.equals(meeting.typeofmeeting) : meeting.typeofmeeting != null)
            return false;
        if (description != null ? !description.equals(meeting.description) : meeting.description != null) return false;
        return timedate != null ? timedate.equals(meeting.timedate) : meeting.timedate == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mname != null ? mname.hashCode() : 0);
        result = 31 * result + (typeofmeeting != null ? typeofmeeting.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (timedate != null ? timedate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", mname='" + mname + '\'' +
                ", typeofmeeting='" + typeofmeeting + '\'' +
                ", description='" + description + '\'' +
                ", timedate=" + timedate +
                '}';
    }
}
