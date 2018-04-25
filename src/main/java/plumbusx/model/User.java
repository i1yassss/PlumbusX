package plumbusx.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

/**
 * @author i1yas
 * @version 1.0
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "`group`")
    private String group;

    @Column(name = "course")
    private Integer course;

    @Column(name = "post")
    private String post;

    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToMany
    @LazyCollection(value = LazyCollectionOption.FALSE)
    @JoinColumn(name = "user_id")
    private Set<Competence> competences;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_meeting", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "meeting_id", referencedColumnName = "id"))
    private Set<Meeting> meetings;

    public Set<Meeting> getMeetings() {
        return meetings;
    }


    public void setMeetings(Set<Meeting> meetings) {
        this.meetings = meetings;
    }

    public Set<Meeting> getMyMeetings() {
        return myMeetings;
    }

    public void setMyMeetings(Set<Meeting> myMeetings) {
        this.myMeetings = myMeetings;
    }

    @OneToMany
    @LazyCollection(value = LazyCollectionOption.FALSE)
    @JoinColumn(name = "author_id")
    private Set<Meeting> myMeetings;

    @OneToMany
    @LazyCollection(value = LazyCollectionOption.FALSE)
    @JoinColumn(name = "author_id")
    private Set<Project> myProjects;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_projects", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
    private Set<Project> projects;

    public Set<Project> getMyProjects() {
        return myProjects;
    }

    public void setMyProjects(Set<Project> myProjects) {
        this.myProjects = myProjects;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(Set<Competence> competences) {
        this.competences = competences;
    }
    //=================================================================
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}