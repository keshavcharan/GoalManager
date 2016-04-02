package taskman.handyapps.com.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Kesh on 3/2/2016.
 */
@Entity(name="goal")
public class Goal implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String about;
    @Column
    private String description;
    @Column
    private int priority;
    @Column(name="end_date", nullable = false)
    private int endDate;
    @ManyToOne
    @JoinColumn(name = "notification_type" )
    private NotificationType notificationType;

    public Goal(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public void setDescription(String description) { this.description = description; }

    public String getDescription(){ return description; }

    public void setPriority(int priority) { this.priority = priority; }

    public int getPriority() { return priority; }
}
