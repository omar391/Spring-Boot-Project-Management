package assignment.springboot.projectmanagement.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "projects")
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Invalid project name!")
    @NotEmpty(message = "Invalid project name!")
    @NotNull(message = "Invalid project name!")
    @Column(nullable = false)
    private String name;
    @NotBlank
    @NotEmpty
    @NotNull
    @Size(min = 10, message = "Enter at least 10 Characters...")
    private String intro;
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_fk", nullable = false, referencedColumnName = "id")
    private Users ownerObj;

    @Column(nullable = false)
    private long ownerFk;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    public long getOwnerFk() {
        return ownerFk;
    }

    public Projects() {
        super();
    }

    public Projects(String name, String desc, long owner) {
        super();
        this.name = name;
        this.intro = desc;
        this.ownerFk = owner;
        this.status = Status.PRE;
    }

    public Status getStatus() {
        return status;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwner() {
        return ownerObj.getNickName();
    }

    public String getIntro() {
        return intro;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public enum Status {
        PRE(0), START(1), END(3);
        private final int value;

        Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}